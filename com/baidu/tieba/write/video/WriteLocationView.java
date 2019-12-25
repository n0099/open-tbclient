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
/* loaded from: classes10.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel dtT;
    private int dtZ;
    private final LocationModel.a dug;
    private BaseActivity<?> kLZ;
    private final CustomMessageListener kek;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtZ = 0;
        this.dug = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aMt() {
                WriteLocationView.this.kLZ.showToast(R.string.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.kLZ;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.kLZ.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cIY())) {
                    WriteLocationView.this.c(2, true, aVar.cIY());
                } else {
                    onFail(null);
                }
            }
        };
        this.kek = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.dtT.sA(false);
                        WriteLocationView.this.dtT.ev(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.dtT.sA(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.kLZ = baseActivity;
        this.kLZ.registerListener(this.kek);
        this.dtT = new LocationModel(this.kLZ.getPageContext());
        this.dtT.a(this.dug);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.dtZ) {
                    case 0:
                        WriteLocationView.this.aMe();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aMd();
                        return;
                }
            }
        });
        aMh();
    }

    public boolean boD() {
        if (this.dtT == null) {
            return false;
        }
        return this.dtT.boD();
    }

    public void aMe() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.kLZ.getPageContext().getPageActivity())) {
            this.kLZ.showToast((int) R.string.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMg();
        } else if (this.dtT.cJf()) {
            aMd();
        } else {
            this.dtT.sA(false);
            c(1, true, null);
            this.dtT.cJd();
        }
    }

    private void aMh() {
        if (this.dtT.boD() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.dtT.cJf()) {
                c(2, true, c.cJa().getLocationData().cIY());
                return;
            }
            c(1, true, null);
            this.dtT.cJd();
            return;
        }
        c(0, true, null);
    }

    private void aMg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kLZ.getPageContext().getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.c(1, true, null);
                    WriteLocationView.this.dtT.cJh();
                } else {
                    WriteLocationView.this.dug.aMt();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.c(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.kLZ.getPageContext());
        aVar.aBW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cFg() {
        if (this.dtT != null) {
            this.dtT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.kLZ.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.dtZ = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
