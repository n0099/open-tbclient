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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes3.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel aNK;
    private int aNQ;
    private final LocationModel.a aNX;
    private final CustomMessageListener gQk;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNQ = 0;
        this.aNX = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Ij() {
                WriteLocationView.this.mBaseActivity.showToast(f.j.no_network_guide);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gP(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(f.j.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bwK())) {
                    WriteLocationView.this.d(2, true, aVar.bwK());
                } else {
                    gP(null);
                }
            }
        };
        this.gQk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aNK.mw(false);
                        WriteLocationView.this.aNK.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.d(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aNK.mw(true);
                    WriteLocationView.this.d(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.gQk);
        this.aNK = new LocationModel(this.mBaseActivity);
        this.aNK.a(this.aNX);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.aNQ) {
                    case 0:
                        WriteLocationView.this.HV();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.HU();
                        return;
                }
            }
        });
        HY();
    }

    public boolean afS() {
        if (this.aNK == null) {
            return false;
        }
        return this.aNK.afS();
    }

    public void HV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(f.j.location_system_permission_prompt);
            d(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HX();
        } else if (this.aNK.bwS()) {
            HU();
        } else {
            this.aNK.mw(false);
            d(1, true, null);
            this.aNK.bwQ();
        }
    }

    private void HY() {
        if (this.aNK.afS() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.aNK.bwS()) {
                d(2, true, c.bwO().getLocationData().bwK());
                return;
            }
            d(1, true, null);
            this.aNK.bwQ();
            return;
        }
        d(0, true, null);
    }

    private void HX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.cf(f.j.location_app_permission_prompt).a(f.j.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.jE()) {
                    WriteLocationView.this.d(1, true, null);
                    WriteLocationView.this.aNK.afW();
                } else {
                    WriteLocationView.this.aNX.Ij();
                }
                aVar2.dismiss();
            }
        }).b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.d(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mBaseActivity.getPageContext());
        aVar.xe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void brM() {
        if (this.aNK != null) {
            this.aNK.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, boolean z, String str) {
        this.aNQ = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
