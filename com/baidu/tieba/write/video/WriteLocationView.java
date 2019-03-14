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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes3.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel ckd;
    private int ckj;
    private final LocationModel.a ckq;
    private final CustomMessageListener iIv;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckj = 0;
        this.ckq = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void amJ() {
                WriteLocationView.this.mBaseActivity.showToast(d.j.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.ceW())) {
                    WriteLocationView.this.c(2, true, aVar.ceW());
                } else {
                    onFail(null);
                }
            }
        };
        this.iIv = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.ckd.qb(false);
                        WriteLocationView.this.ckd.dZ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.ckd.qb(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.iIv);
        this.ckd = new LocationModel(this.mBaseActivity);
        this.ckd.a(this.ckq);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.ckj) {
                    case 0:
                        WriteLocationView.this.amv();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.amu();
                        return;
                }
            }
        });
        amy();
    }

    public boolean aNF() {
        if (this.ckd == null) {
            return false;
        }
        return this.ckd.aNF();
    }

    public void amv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amx();
        } else if (this.ckd.cfd()) {
            amu();
        } else {
            this.ckd.qb(false);
            c(1, true, null);
            this.ckd.cfb();
        }
    }

    private void amy() {
        if (this.ckd.aNF() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.ckd.cfd()) {
                c(2, true, c.ceZ().getLocationData().ceW());
                return;
            }
            c(1, true, null);
            this.ckd.cfb();
            return;
        }
        c(0, true, null);
    }

    private void amx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.gD(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kY()) {
                    WriteLocationView.this.c(1, true, null);
                    WriteLocationView.this.ckd.aNJ();
                } else {
                    WriteLocationView.this.ckq.amJ();
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
        aVar.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbl() {
        if (this.ckd != null) {
            this.ckd.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.ckj = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
