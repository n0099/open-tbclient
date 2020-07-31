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
    private LocationModel eBP;
    private int eBV;
    private final LocationModel.a eCc;
    private final CustomMessageListener lPC;
    private BaseActivity<?> myW;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBV = 0;
        this.eCc = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bjD() {
                WriteLocationView.this.myW.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.myW;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.myW.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dlK())) {
                    WriteLocationView.this.b(2, true, aVar.dlK());
                } else {
                    onFail(null);
                }
            }
        };
        this.lPC = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.eBP.vp(false);
                        WriteLocationView.this.eBP.fD(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.eBP.vp(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void f(BaseActivity<?> baseActivity) {
        this.myW = baseActivity;
        this.myW.registerListener(this.lPC);
        this.eBP = new LocationModel(this.myW.getPageContext());
        this.eBP.a(this.eCc);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.eBV) {
                    case 0:
                        WriteLocationView.this.bjo();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bjm();
                        return;
                }
            }
        });
        bjr();
    }

    public boolean bNz() {
        if (this.eBP == null) {
            return false;
        }
        return this.eBP.bNz();
    }

    public void bjo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.myW.getPageContext().getPageActivity())) {
            this.myW.showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bjq();
        } else if (this.eBP.dlR()) {
            bjm();
        } else {
            this.eBP.vp(false);
            b(1, true, null);
            this.eBP.dlP();
        }
    }

    private void bjr() {
        if (this.eBP.bNz() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.eBP.dlR()) {
                b(2, true, c.dlM().getLocationData().dlK());
                return;
            }
            b(1, true, null);
            this.eBP.dlP();
            return;
        }
        b(0, true, null);
    }

    private void bjq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.myW.getPageContext().getPageActivity());
        aVar.ln(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.eBP.dlT();
                } else {
                    WriteLocationView.this.eCc.bjD();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.myW.getPageContext());
        aVar.aYL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dhD() {
        if (this.eBP != null) {
            this.eBP.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjm() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.myW.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.eBV = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
