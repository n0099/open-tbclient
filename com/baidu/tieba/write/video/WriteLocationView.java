package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes11.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel due;
    private int duk;
    private final LocationModel.a dur;
    private BaseActivity<?> kPF;
    private final CustomMessageListener khS;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duk = 0;
        this.dur = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aMM() {
                WriteLocationView.this.kPF.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.kPF;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.kPF.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cKe())) {
                    WriteLocationView.this.b(2, true, aVar.cKe());
                } else {
                    onFail(null);
                }
            }
        };
        this.khS = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.due.sM(false);
                        WriteLocationView.this.due.ex(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.due.sM(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.kPF = baseActivity;
        this.kPF.registerListener(this.khS);
        this.due = new LocationModel(this.kPF.getPageContext());
        this.due.a(this.dur);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.duk) {
                    case 0:
                        WriteLocationView.this.aMx();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aMw();
                        return;
                }
            }
        });
        aMA();
    }

    public boolean bpD() {
        if (this.due == null) {
            return false;
        }
        return this.due.bpD();
    }

    public void aMx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.kPF.getPageContext().getPageActivity())) {
            this.kPF.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMz();
        } else if (this.due.cKl()) {
            aMw();
        } else {
            this.due.sM(false);
            b(1, true, null);
            this.due.cKj();
        }
    }

    private void aMA() {
        if (this.due.bpD() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.due.cKl()) {
                b(2, true, c.cKg().getLocationData().cKe());
                return;
            }
            b(1, true, null);
            this.due.cKj();
            return;
        }
        b(0, true, null);
    }

    private void aMz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kPF.getPageContext().getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.due.cKn();
                } else {
                    WriteLocationView.this.dur.aMM();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.kPF.getPageContext());
        aVar.aCp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cGm() {
        if (this.due != null) {
            this.due.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.kPF.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.duk = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
