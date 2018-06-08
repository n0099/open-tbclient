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
    private LocationModel aMS;
    private int aMY;
    private final LocationModel.a aNf;
    private final CustomMessageListener gLk;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMY = 0;
        this.aNf = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void HW() {
                WriteLocationView.this.mBaseActivity.showToast(d.k.no_network_guide);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gP(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.k.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bxD())) {
                    WriteLocationView.this.d(2, true, aVar.bxD());
                } else {
                    gP(null);
                }
            }
        };
        this.gLk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aMS.mA(false);
                        WriteLocationView.this.aMS.cn(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.d(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aMS.mA(true);
                    WriteLocationView.this.d(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.gLk);
        this.aMS = new LocationModel(this.mBaseActivity);
        this.aMS.a(this.aNf);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.aMY) {
                    case 0:
                        WriteLocationView.this.HI();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.HH();
                        return;
                }
            }
        });
        HL();
    }

    public boolean aeO() {
        if (this.aMS == null) {
            return false;
        }
        return this.aMS.aeO();
    }

    public void HI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.k.location_system_permission_prompt);
            d(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HK();
        } else if (this.aMS.bxL()) {
            HH();
        } else {
            this.aMS.mA(false);
            d(1, true, null);
            this.aMS.bxJ();
        }
    }

    private void HL() {
        if (this.aMS.aeO() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.aMS.bxL()) {
                d(2, true, c.bxH().getLocationData().bxD());
                return;
            }
            d(1, true, null);
            this.aMS.bxJ();
            return;
        }
        d(0, true, null);
    }

    private void HK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.cc(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.jD()) {
                    WriteLocationView.this.d(1, true, null);
                    WriteLocationView.this.aMS.aeS();
                } else {
                    WriteLocationView.this.aNf.HW();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.d(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mBaseActivity.getPageContext());
        aVar.xa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsI() {
        if (this.aMS != null) {
            this.aMS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, boolean z, String str) {
        this.aMY = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
