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
    private LocationModel emG;
    private int emM;
    private final LocationModel.a emT;
    private BaseActivity<?> lWA;
    private final CustomMessageListener loD;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emM = 0;
        this.emT = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bdO() {
                WriteLocationView.this.lWA.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.lWA;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.lWA.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dep())) {
                    WriteLocationView.this.b(2, true, aVar.dep());
                } else {
                    onFail(null);
                }
            }
        };
        this.loD = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.emG.uw(false);
                        WriteLocationView.this.emG.fu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.emG.uw(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.lWA = baseActivity;
        this.lWA.registerListener(this.loD);
        this.emG = new LocationModel(this.lWA.getPageContext());
        this.emG.a(this.emT);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.emM) {
                    case 0:
                        WriteLocationView.this.bdz();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bdy();
                        return;
                }
            }
        });
        bdC();
    }

    public boolean bHo() {
        if (this.emG == null) {
            return false;
        }
        return this.emG.bHo();
    }

    public void bdz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.lWA.getPageContext().getPageActivity())) {
            this.lWA.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdB();
        } else if (this.emG.dew()) {
            bdy();
        } else {
            this.emG.uw(false);
            b(1, true, null);
            this.emG.deu();
        }
    }

    private void bdC() {
        if (this.emG.bHo() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.emG.dew()) {
                b(2, true, c.der().getLocationData().dep());
                return;
            }
            b(1, true, null);
            this.emG.deu();
            return;
        }
        b(0, true, null);
    }

    private void bdB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lWA.getPageContext().getPageActivity());
        aVar.kF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.emG.dey();
                } else {
                    WriteLocationView.this.emT.bdO();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.lWA.getPageContext());
        aVar.aST();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dad() {
        if (this.emG != null) {
            this.emG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.lWA.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.emM = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
