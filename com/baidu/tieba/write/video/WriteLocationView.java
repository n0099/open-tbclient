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
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.c;
/* loaded from: classes13.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel dyL;
    private int dyR;
    private final LocationModel.a dyY;
    private BaseActivity<?> kRZ;
    private final CustomMessageListener kkK;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyR = 0;
        this.dyY = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPp() {
                WriteLocationView.this.kRZ.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.kRZ;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.kRZ.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLZ())) {
                    WriteLocationView.this.b(2, true, aVar.cLZ());
                } else {
                    onFail(null);
                }
            }
        };
        this.kkK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.dyL.sW(false);
                        WriteLocationView.this.dyL.eE(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.dyL.sW(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.kRZ = baseActivity;
        this.kRZ.registerListener(this.kkK);
        this.dyL = new LocationModel(this.kRZ.getPageContext());
        this.dyL.a(this.dyY);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.dyR) {
                    case 0:
                        WriteLocationView.this.aPa();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aOZ();
                        return;
                }
            }
        });
        aPd();
    }

    public boolean brr() {
        if (this.dyL == null) {
            return false;
        }
        return this.dyL.brr();
    }

    public void aPa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.kRZ.getPageContext().getPageActivity())) {
            this.kRZ.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aPc();
        } else if (this.dyL.cMg()) {
            aOZ();
        } else {
            this.dyL.sW(false);
            b(1, true, null);
            this.dyL.cMe();
        }
    }

    private void aPd() {
        if (this.dyL.brr() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.dyL.cMg()) {
                b(2, true, c.cMb().getLocationData().cLZ());
                return;
            }
            b(1, true, null);
            this.dyL.cMe();
            return;
        }
        b(0, true, null);
    }

    private void aPc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kRZ.getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.dyL.cMi();
                } else {
                    WriteLocationView.this.dyY.aPp();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.kRZ.getPageContext());
        aVar.aEG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cIn() {
        if (this.dyL != null) {
            this.dyL.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.kRZ.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dyR = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
