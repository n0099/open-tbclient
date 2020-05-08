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
/* loaded from: classes2.dex */
public class WriteLocationView extends LocationInfoView {
    private int dYD;
    private final LocationModel.a dYK;
    private LocationModel dYx;
    private final CustomMessageListener kUU;
    private BaseActivity<?> lCb;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYD = 0;
        this.dYK = new LocationModel.a() { // from class: com.baidu.tieba.write.video.WriteLocationView.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aXE() {
                WriteLocationView.this.lCb.showToast(R.string.no_network_guide);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = WriteLocationView.this.lCb;
                if (StringUtils.isNull(str)) {
                    str = WriteLocationView.this.lCb.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                WriteLocationView.this.b(0, true, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cWS())) {
                    WriteLocationView.this.b(2, true, aVar.cWS());
                } else {
                    onFail(null);
                }
            }
        };
        this.kUU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.video.WriteLocationView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        WriteLocationView.this.dYx.tY(false);
                        WriteLocationView.this.dYx.eT(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        WriteLocationView.this.b(2, true, responsedSelectLocation.getName());
                        return;
                    }
                    WriteLocationView.this.dYx.tY(true);
                    WriteLocationView.this.b(0, true, null);
                }
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.lCb = baseActivity;
        this.lCb.registerListener(this.kUU);
        this.dYx = new LocationModel(this.lCb.getPageContext());
        this.dYx.a(this.dYK);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.WriteLocationView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (WriteLocationView.this.dYD) {
                    case 0:
                        WriteLocationView.this.aXp();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        WriteLocationView.this.aXo();
                        return;
                }
            }
        });
        aXs();
    }

    public boolean bAS() {
        if (this.dYx == null) {
            return false;
        }
        return this.dYx.bAS();
    }

    public void aXp() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.lCb.getPageContext().getPageActivity())) {
            this.lCb.showToast((int) R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXr();
        } else if (this.dYx.cWZ()) {
            aXo();
        } else {
            this.dYx.tY(false);
            b(1, true, null);
            this.dYx.cWX();
        }
    }

    private void aXs() {
        if (this.dYx.bAS() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
            if (this.dYx.cWZ()) {
                b(2, true, c.cWU().getLocationData().cWS());
                return;
            }
            b(1, true, null);
            this.dYx.cWX();
            return;
        }
        b(0, true, null);
    }

    private void aXr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lCb.getPageContext().getPageActivity());
        aVar.kd(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    WriteLocationView.this.b(1, true, null);
                    WriteLocationView.this.dYx.cXb();
                } else {
                    WriteLocationView.this.dYK.aXE();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteLocationView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteLocationView.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.lCb.getPageContext());
        aVar.aMS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cSI() {
        if (this.dYx != null) {
            this.dYx.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXo() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.lCb.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dYD = i;
        setVisibility(z ? 0 : 8);
        setState(i, str);
    }
}
