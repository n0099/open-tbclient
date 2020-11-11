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
    private LocationModel fpH;
    private int fpN;
    private final LocationModel.a fpU;
    private final CustomMessageListener mZs;
    private BaseActivity<?> nJq;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpN = 0;
        this.fpU = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bAw() {
                WriteLocationView.this.nJq.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.nJq;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.nJq.getResources().getString(R.string.location_fail);
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
        this.mZs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.fpH.xw(false);
                        WriteLocationView.this.fpH.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.fpH.xw(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void f(BaseActivity<?> baseActivity) {
        this.nJq = baseActivity;
        this.nJq.registerListener(this.mZs);
        this.fpH = new LocationModel(this.nJq.getPageContext());
        this.fpH.a(this.fpU);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.fpN) {
                    case 0:
                        WriteLocationView.this.bAh();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bAf();
                        return;
                }
            }
        });
        bAk();
    }

    public boolean cin() {
        if (this.fpH == null) {
            return false;
        }
        return this.fpH.cin();
    }

    public void bAh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.nJq.getPageContext().getPageActivity())) {
            this.nJq.showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bAj();
        } else if (this.fpH.dKH()) {
            bAf();
        } else {
            this.fpH.xw(false);
            b(1, true, null);
            this.fpH.dKF();
        }
    }

    private void bAk() {
        if (this.fpH.cin() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.fpH.dKH()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fpH.dKF();
            return;
        }
        b(0, true, null);
    }

    private void bAj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nJq.getPageContext().getPageActivity());
        aVar.ow(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.fpH.dKJ();
                } else {
                    WriteLocationView.this.fpU.bAw();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.nJq.getPageContext());
        aVar.bpc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dGs() {
        if (this.fpH != null) {
            this.fpH.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.nJq.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fpN = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
