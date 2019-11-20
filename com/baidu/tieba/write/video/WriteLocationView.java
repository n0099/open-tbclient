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
    private LocationModel cFY;
    private int cGf;
    private final LocationModel.a cGm;
    private BaseActivity<?> jRn;
    private final CustomMessageListener jjZ;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGf = 0;
        this.cGm = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void auN() {
                WriteLocationView.this.jRn.showToast(R.string.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.jRn;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.jRn.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.coS())) {
                    WriteLocationView.this.c(2, true, aVar.coS());
                } else {
                    onFail(null);
                }
            }
        };
        this.jjZ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.cFY.qT(false);
                        WriteLocationView.this.cFY.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.cFY.qT(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.jRn = baseActivity;
        this.jRn.registerListener(this.jjZ);
        this.cFY = new LocationModel(this.jRn);
        this.cFY.a(this.cGm);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.cGf) {
                    case 0:
                        WriteLocationView.this.auz();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.auy();
                        return;
                }
            }
        });
        auC();
    }

    public boolean aWP() {
        if (this.cFY == null) {
            return false;
        }
        return this.cFY.aWP();
    }

    public void auz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.jRn.getPageContext().getPageActivity())) {
            this.jRn.showToast((int) R.string.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auB();
        } else if (this.cFY.coZ()) {
            auy();
        } else {
            this.cFY.qT(false);
            c(1, true, null);
            this.cFY.coX();
        }
    }

    private void auC() {
        if (this.cFY.aWP() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.cFY.coZ()) {
                c(2, true, c.coU().getLocationData().coS());
                return;
            }
            c(1, true, null);
            this.cFY.coX();
            return;
        }
        c(0, true, null);
    }

    private void auB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jRn.getPageContext().getPageActivity());
        aVar.hT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.c(1, true, null);
                    WriteLocationView.this.cFY.cpb();
                } else {
                    WriteLocationView.this.cGm.auN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.c(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.jRn.getPageContext());
        aVar.akM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckY() {
        if (this.cFY != null) {
            this.cFY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.jRn.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.cGf = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
