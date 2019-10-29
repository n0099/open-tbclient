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
/* loaded from: classes3.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel cGP;
    private int cGW;
    private final LocationModel.a cHd;
    private BaseActivity<?> jSe;
    private final CustomMessageListener jkQ;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGW = 0;
        this.cHd = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void auP() {
                WriteLocationView.this.jSe.showToast(R.string.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.jSe;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.jSe.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.coU())) {
                    WriteLocationView.this.c(2, true, aVar.coU());
                } else {
                    onFail(null);
                }
            }
        };
        this.jkQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.cGP.qT(false);
                        WriteLocationView.this.cGP.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.cGP.qT(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.jSe = baseActivity;
        this.jSe.registerListener(this.jkQ);
        this.cGP = new LocationModel(this.jSe);
        this.cGP.a(this.cHd);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.cGW) {
                    case 0:
                        WriteLocationView.this.auB();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.auA();
                        return;
                }
            }
        });
        auE();
    }

    public boolean aWR() {
        if (this.cGP == null) {
            return false;
        }
        return this.cGP.aWR();
    }

    public void auB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.jSe.getPageContext().getPageActivity())) {
            this.jSe.showToast((int) R.string.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auD();
        } else if (this.cGP.cpb()) {
            auA();
        } else {
            this.cGP.qT(false);
            c(1, true, null);
            this.cGP.coZ();
        }
    }

    private void auE() {
        if (this.cGP.aWR() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.cGP.cpb()) {
                c(2, true, c.coW().getLocationData().coU());
                return;
            }
            c(1, true, null);
            this.cGP.coZ();
            return;
        }
        c(0, true, null);
    }

    private void auD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jSe.getPageContext().getPageActivity());
        aVar.hU(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.c(1, true, null);
                    WriteLocationView.this.cGP.cpd();
                } else {
                    WriteLocationView.this.cHd.auP();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.c(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.jSe.getPageContext());
        aVar.akO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cla() {
        if (this.cGP != null) {
            this.cGP.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.jSe.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.cGW = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
