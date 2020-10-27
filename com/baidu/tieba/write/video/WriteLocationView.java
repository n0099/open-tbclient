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
    private LocationModel fjP;
    private int fjV;
    private final LocationModel.a fkc;
    private final CustomMessageListener mTu;
    private BaseActivity<?> nDw;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjV = 0;
        this.fkc = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bxX() {
                WriteLocationView.this.nDw.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.nDw;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.nDw.getResources().getString(R.string.location_fail);
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
        this.mTu = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.fjP.xn(false);
                        WriteLocationView.this.fjP.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.fjP.xn(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void f(BaseActivity<?> baseActivity) {
        this.nDw = baseActivity;
        this.nDw.registerListener(this.mTu);
        this.fjP = new LocationModel(this.nDw.getPageContext());
        this.fjP.a(this.fkc);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.fjV) {
                    case 0:
                        WriteLocationView.this.bxI();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.bxG();
                        return;
                }
            }
        });
        bxL();
    }

    public boolean cfL() {
        if (this.fjP == null) {
            return false;
        }
        return this.fjP.cfL();
    }

    public void bxI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.nDw.getPageContext().getPageActivity())) {
            this.nDw.showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bxK();
        } else if (this.fjP.dIf()) {
            bxG();
        } else {
            this.fjP.xn(false);
            b(1, true, null);
            this.fjP.dId();
        }
    }

    private void bxL() {
        if (this.fjP.cfL() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.fjP.dIf()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dIa().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fjP.dId();
            return;
        }
        b(0, true, null);
    }

    private void bxK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nDw.getPageContext().getPageActivity());
        aVar.om(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.fjP.dIh();
                } else {
                    WriteLocationView.this.fkc.bxX();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.nDw.getPageContext());
        aVar.bmC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDQ() {
        if (this.fjP != null) {
            this.fjP.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.nDw.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fjV = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
