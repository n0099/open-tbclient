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
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes3.dex */
public class WriteLocationView extends LocationInfoView {
    private final LocationModel.a fbD;
    private LocationModel fbq;
    private int fbw;
    private final CustomMessageListener mGK;
    private BaseActivity<?> nqX;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbw = 0;
        this.fbD = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bwe() {
                WriteLocationView.this.nqX.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.nqX;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.nqX.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    WriteLocationView.this.b(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.mGK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.fbq.wW(false);
                        WriteLocationView.this.fbq.go(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.fbq.wW(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void f(BaseActivity<?> baseActivity) {
        this.nqX = baseActivity;
        this.nqX.registerListener(this.mGK);
        this.fbq = new LocationModel(this.nqX.getPageContext());
        this.fbq.a(this.fbD);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.fbw) {
                    case 0:
                        WriteLocationView.this.bvP();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bvN();
                        return;
                }
            }
        });
        bvS();
    }

    public boolean ccF() {
        if (this.fbq == null) {
            return false;
        }
        return this.fbq.ccF();
    }

    public void bvP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.nqX.getPageContext().getPageActivity())) {
            this.nqX.showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bvR();
        } else if (this.fbq.dEX()) {
            bvN();
        } else {
            this.fbq.wW(false);
            b(1, true, null);
            this.fbq.dEV();
        }
    }

    private void bvS() {
        if (this.fbq.ccF() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.fbq.dEX()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dES().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fbq.dEV();
            return;
        }
        b(0, true, null);
    }

    private void bvR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nqX.getPageContext().getPageActivity());
        aVar.ob(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.fbq.dEZ();
                } else {
                    WriteLocationView.this.fbD.bwe();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.nqX.getPageContext());
        aVar.bkJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAI() {
        if (this.fbq != null) {
            this.fbq.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.nqX.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fbw = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
