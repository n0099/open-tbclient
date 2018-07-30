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
    private LocationModel aNN;
    private int aNT;
    private final LocationModel.a aOa;
    private final CustomMessageListener gQj;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNT = 0;
        this.aOa = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Ij() {
                WriteLocationView.this.mBaseActivity.showToast(d.j.no_network_guide);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gP(String str) {
                BaseActivity baseActivity = WriteLocationView.this.mBaseActivity;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.mBaseActivity.getResources().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.d(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bwJ())) {
                    WriteLocationView.this.d(2, true, aVar.bwJ());
                } else {
                    gP(null);
                }
            }
        };
        this.gQj = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.aNN.mw(false);
                        WriteLocationView.this.aNN.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.d(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.aNN.mw(true);
                    WriteLocationView.this.d(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.gQj);
        this.aNN = new LocationModel(this.mBaseActivity);
        this.aNN.a(this.aOa);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.aNT) {
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

    public boolean afQ() {
        if (this.aNN == null) {
            return false;
        }
        return this.aNN.afQ();
    }

    public void HV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(d.j.location_system_permission_prompt);
            d(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HX();
        } else if (this.aNN.bwR()) {
            HU();
        } else {
            this.aNN.mw(false);
            d(1, true, null);
            this.aNN.bwP();
        }
    }

    private void HY() {
        if (this.aNN.afQ() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.aNN.bwR()) {
                d(2, true, c.bwN().getLocationData().bwJ());
                return;
            }
            d(1, true, null);
            this.aNN.bwP();
            return;
        }
        d(0, true, null);
    }

    private void HX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.cf(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.jE()) {
                    WriteLocationView.this.d(1, true, null);
                    WriteLocationView.this.aNN.afU();
                } else {
                    WriteLocationView.this.aOa.Ij();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.d(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mBaseActivity.getPageContext());
        aVar.xf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void brL() {
        if (this.aNN != null) {
            this.aNN.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, boolean z, String str) {
        this.aNT = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
