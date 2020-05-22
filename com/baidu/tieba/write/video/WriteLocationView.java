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
    private BaseActivity<?> lVp;
    private final CustomMessageListener lnq;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emM = 0;
        this.emT = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bdN() {
                WriteLocationView.this.lVp.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.lVp;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.lVp.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dea())) {
                    WriteLocationView.this.b(2, true, aVar.dea());
                } else {
                    onFail(null);
                }
            }
        };
        this.lnq = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
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
        this.lVp = baseActivity;
        this.lVp.registerListener(this.lnq);
        this.emG = new LocationModel(this.lVp.getPageContext());
        this.emG.a(this.emT);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.emM) {
                    case 0:
                        WriteLocationView.this.bdy();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bdx();
                        return;
                }
            }
        });
        bdB();
    }

    public boolean bHm() {
        if (this.emG == null) {
            return false;
        }
        return this.emG.bHm();
    }

    public void bdy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.lVp.getPageContext().getPageActivity())) {
            this.lVp.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdA();
        } else if (this.emG.deh()) {
            bdx();
        } else {
            this.emG.uw(false);
            b(1, true, null);
            this.emG.def();
        }
    }

    private void bdB() {
        if (this.emG.bHm() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.emG.deh()) {
                b(2, true, c.dec().getLocationData().dea());
                return;
            }
            b(1, true, null);
            this.emG.def();
            return;
        }
        b(0, true, null);
    }

    private void bdA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lVp.getPageContext().getPageActivity());
        aVar.kD(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.emG.dej();
                } else {
                    WriteLocationView.this.emT.bdN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.lVp.getPageContext());
        aVar.aST();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cZN() {
        if (this.emG != null) {
            this.emG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.lVp.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.emM = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
