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
/* loaded from: classes2.dex */
public class WriteLocationView extends LocationInfoView {
    private final LocationModel.a dYF;
    private LocationModel dYs;
    private int dYy;
    private final CustomMessageListener kUQ;
    private BaseActivity<?> lBX;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYy = 0;
        this.dYF = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aXG() {
                WriteLocationView.this.lBX.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.lBX;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.lBX.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cWV())) {
                    WriteLocationView.this.b(2, true, aVar.cWV());
                } else {
                    onFail(null);
                }
            }
        };
        this.kUQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.dYs.tY(false);
                        WriteLocationView.this.dYs.eT(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.dYs.tY(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.lBX = baseActivity;
        this.lBX.registerListener(this.kUQ);
        this.dYs = new LocationModel(this.lBX.getPageContext());
        this.dYs.a(this.dYF);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.dYy) {
                    case 0:
                        WriteLocationView.this.aXr();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aXq();
                        return;
                }
            }
        });
        aXu();
    }

    public boolean bAU() {
        if (this.dYs == null) {
            return false;
        }
        return this.dYs.bAU();
    }

    public void aXr() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.lBX.getPageContext().getPageActivity())) {
            this.lBX.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXt();
        } else if (this.dYs.cXc()) {
            aXq();
        } else {
            this.dYs.tY(false);
            b(1, true, null);
            this.dYs.cXa();
        }
    }

    private void aXu() {
        if (this.dYs.bAU() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.dYs.cXc()) {
                b(2, true, c.cWX().getLocationData().cWV());
                return;
            }
            b(1, true, null);
            this.dYs.cXa();
            return;
        }
        b(0, true, null);
    }

    private void aXt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lBX.getPageContext().getPageActivity());
        aVar.kd(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.dYs.cXe();
                } else {
                    WriteLocationView.this.dYF.aXG();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.lBX.getPageContext());
        aVar.aMU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cSL() {
        if (this.dYs != null) {
            this.dYs.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.lBX.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dYy = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
