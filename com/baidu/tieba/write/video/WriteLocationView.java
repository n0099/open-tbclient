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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes3.dex */
public class WriteLocationView extends LocationInfoView {
    private final LocationModel.a aWG;
    private LocationModel aWt;
    private int aWz;
    private final CustomMessageListener hgG;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWz = 0;
        this.aWG = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void LJ() {
                WriteLocationView.this.mBaseActivity.showToast(e.j.no_network_guide);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void hA(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(e.j.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.c(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bBZ())) {
                    WriteLocationView.this.c(2, true, aVar.bBZ());
                } else {
                    hA(null);
                }
            }
        };
        this.hgG = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aWt.nv(false);
                        WriteLocationView.this.aWt.cJ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.c(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aWt.nv(true);
                    WriteLocationView.this.c(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.hgG);
        this.aWt = new LocationModel(this.mBaseActivity);
        this.aWt.a(this.aWG);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.aWz) {
                    case 0:
                        WriteLocationView.this.Lv();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.Lu();
                        return;
                }
            }
        });
        Ly();
    }

    public boolean akF() {
        if (this.aWt == null) {
            return false;
        }
        return this.aWt.akF();
    }

    public void Lv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(e.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Lx();
        } else if (this.aWt.bCg()) {
            Lu();
        } else {
            this.aWt.nv(false);
            c(1, true, null);
            this.aWt.bCe();
        }
    }

    private void Ly() {
        if (this.aWt.akF() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.aWt.bCg()) {
                c(2, true, c.bCc().getLocationData().bBZ());
                return;
            }
            c(1, true, null);
            this.aWt.bCe();
            return;
        }
        c(0, true, null);
    }

    private void Lx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.cN(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kV()) {
                    WriteLocationView.this.c(1, true, null);
                    WriteLocationView.this.aWt.akJ();
                } else {
                    WriteLocationView.this.aWG.LJ();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.c(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mBaseActivity.getPageContext());
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxc() {
        if (this.aWt != null) {
            this.aWt.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.aWz = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
