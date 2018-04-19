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
    private int aEB;
    private final LocationModel.a aEI;
    private LocationModel aEv;
    private final CustomMessageListener gyH;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEB = 0;
        this.aEI = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Eu() {
                WriteLocationView.this.mBaseActivity.showToast(d.k.no_network_guide);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gq(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.k.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bsA())) {
                    WriteLocationView.this.d(2, true, aVar.bsA());
                } else {
                    gq(null);
                }
            }
        };
        this.gyH = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aEv.mt(false);
                        WriteLocationView.this.aEv.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.d(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aEv.mt(true);
                    WriteLocationView.this.d(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.gyH);
        this.aEv = new LocationModel(this.mBaseActivity);
        this.aEv.a(this.aEI);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                switch (WriteLocationView.this.aEB) {
                    case 0:
                        WriteLocationView.this.Eh();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.Eg();
                        return;
                }
            }
        });
        Ej();
    }

    public boolean abo() {
        if (this.aEv == null) {
            return false;
        }
        return this.aEv.abo();
    }

    public void Eh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.k.location_system_permission_prompt);
            d(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ei();
        } else if (this.aEv.bsI()) {
            Eg();
        } else {
            this.aEv.mt(false);
            d(1, true, null);
            this.aEv.bsG();
        }
    }

    private void Ej() {
        if (this.aEv.abo() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.aEv.bsI()) {
                d(2, true, c.bsE().getLocationData().bsA());
                return;
            }
            d(1, true, null);
            this.aEv.bsG();
            return;
        }
        d(0, true, null);
    }

    private void Ei() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.bZ(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.gP()) {
                    WriteLocationView.this.d(1, true, null);
                    WriteLocationView.this.aEv.abs();
                } else {
                    WriteLocationView.this.aEI.Eu();
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
        aVar.tD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bnK() {
        if (this.aEv != null) {
            this.aEv.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eg() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, boolean z, String str) {
        this.aEB = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
