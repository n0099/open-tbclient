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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes2.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel brS;
    private int brY;
    private final LocationModel.a bsf;
    private final CustomMessageListener haP;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brY = 0;
        this.bsf = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Ll() {
                WriteLocationView.this.mBaseActivity.showToast(d.j.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gq(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bwn())) {
                    WriteLocationView.this.c(2, true, aVar.bwn());
                } else {
                    gq(null);
                }
            }
        };
        this.haP = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.brS.mF(false);
                        WriteLocationView.this.brS.ce(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.brS.mF(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.haP);
        this.brS = new LocationModel(this.mBaseActivity);
        this.brS.a(this.bsf);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.brY) {
                    case 0:
                        WriteLocationView.this.KX();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.KW();
                        return;
                }
            }
        });
        KZ();
    }

    public boolean agi() {
        if (this.brS == null) {
            return false;
        }
        return this.brS.agi();
    }

    public void KX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            KY();
        } else if (this.brS.bwv()) {
            KW();
        } else {
            this.brS.mF(false);
            c(1, true, null);
            this.brS.bwt();
        }
    }

    private void KZ() {
        if (this.brS.agi() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.brS.bwv()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bwr().getLocationData().bwn());
                return;
            }
            c(1, true, null);
            this.brS.bwt();
            return;
        }
        c(0, true, null);
    }

    private void KY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.oJ()) {
                    WriteLocationView.this.c(1, true, null);
                    WriteLocationView.this.brS.agm();
                } else {
                    WriteLocationView.this.bsf.Ll();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.c(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mBaseActivity.getPageContext());
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bro() {
        if (this.brS != null) {
            this.brS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.brY = i;
        setVisibility(z ? 0 : 8);
        j(i, str);
    }
}
