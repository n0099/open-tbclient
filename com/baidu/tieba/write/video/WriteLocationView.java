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
    private LocationModel aNO;
    private int aNU;
    private final LocationModel.a aOb;
    private final CustomMessageListener gPl;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNU = 0;
        this.aOb = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Io() {
                WriteLocationView.this.mBaseActivity.showToast(d.k.no_network_guide);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gT(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.k.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.byg())) {
                    WriteLocationView.this.d(2, true, aVar.byg());
                } else {
                    gT(null);
                }
            }
        };
        this.gPl = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aNO.mL(false);
                        WriteLocationView.this.aNO.cr(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.d(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aNO.mL(true);
                    WriteLocationView.this.d(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.gPl);
        this.aNO = new LocationModel(this.mBaseActivity);
        this.aNO.a(this.aOb);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.aNU) {
                    case 0:
                        WriteLocationView.this.Ia();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.HZ();
                        return;
                }
            }
        });
        Id();
    }

    public boolean afw() {
        if (this.aNO == null) {
            return false;
        }
        return this.aNO.afw();
    }

    public void Ia() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.k.location_system_permission_prompt);
            d(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ic();
        } else if (this.aNO.byo()) {
            HZ();
        } else {
            this.aNO.mL(false);
            d(1, true, null);
            this.aNO.bym();
        }
    }

    private void Id() {
        if (this.aNO.afw() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.aNO.byo()) {
                d(2, true, c.byk().getLocationData().byg());
                return;
            }
            d(1, true, null);
            this.aNO.bym();
            return;
        }
        d(0, true, null);
    }

    private void Ic() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.cd(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.jD()) {
                    WriteLocationView.this.d(1, true, null);
                    WriteLocationView.this.aNO.afA();
                } else {
                    WriteLocationView.this.aOb.Io();
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
        aVar.xn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bti() {
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, boolean z, String str) {
        this.aNU = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
