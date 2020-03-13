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
/* loaded from: classes13.dex */
public class WriteLocationView extends LocationInfoView {
    private int dyE;
    private final LocationModel.a dyL;
    private LocationModel dyy;
    private BaseActivity<?> kQz;
    private final CustomMessageListener kji;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyE = 0;
        this.dyL = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPl() {
                WriteLocationView.this.kQz.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.kQz;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.kQz.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLF())) {
                    WriteLocationView.this.b(2, true, aVar.cLF());
                } else {
                    onFail(null);
                }
            }
        };
        this.kji = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.dyy.sQ(false);
                        WriteLocationView.this.dyy.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.dyy.sQ(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.kQz = baseActivity;
        this.kQz.registerListener(this.kji);
        this.dyy = new LocationModel(this.kQz.getPageContext());
        this.dyy.a(this.dyL);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.dyE) {
                    case 0:
                        WriteLocationView.this.aOW();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aOV();
                        return;
                }
            }
        });
        aOZ();
    }

    public boolean brm() {
        if (this.dyy == null) {
            return false;
        }
        return this.dyy.brm();
    }

    public void aOW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.kQz.getPageContext().getPageActivity())) {
            this.kQz.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOY();
        } else if (this.dyy.cLM()) {
            aOV();
        } else {
            this.dyy.sQ(false);
            b(1, true, null);
            this.dyy.cLK();
        }
    }

    private void aOZ() {
        if (this.dyy.brm() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.dyy.cLM()) {
                b(2, true, c.cLH().getLocationData().cLF());
                return;
            }
            b(1, true, null);
            this.dyy.cLK();
            return;
        }
        b(0, true, null);
    }

    private void aOY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kQz.getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.dyy.cLO();
                } else {
                    WriteLocationView.this.dyL.aPl();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.kQz.getPageContext());
        aVar.aEC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cHT() {
        if (this.dyy != null) {
            this.dyy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.kQz.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dyE = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
