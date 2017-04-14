package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel aAO;
    private int aAW;
    private final LocationModel.a aBc;
    private final CustomMessageListener fxT;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAW = 0;
        this.aBc = new a(this);
        this.fxT = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.fxT);
        this.aAO = new LocationModel(this.mBaseActivity);
        this.aAO.a(this.aBc);
        setOnClickListener(new c(this));
        DT();
    }

    public boolean PZ() {
        if (this.aAO == null) {
            return false;
        }
        return this.aAO.PZ();
    }

    public void DR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(w.l.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            DS();
        } else if (this.aAO.biY()) {
            DQ();
        } else {
            this.aAO.lm(false);
            c(1, true, null);
            this.aAO.biW();
        }
    }

    private void DT() {
        if (this.aAO.PZ()) {
            if (this.aAO.biY()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.d.biU().getLocationData().biQ());
                return;
            }
            c(1, true, null);
            this.aAO.biW();
            return;
        }
        c(0, true, null);
    }

    private void DS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.bZ(w.l.location_app_permission_prompt).a(w.l.isopen, new d(this)).b(w.l.cancel, new e(this)).b(this.mBaseActivity.getPageContext());
        aVar.tQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdW() {
        if (this.aAO != null) {
            this.aAO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.aAW = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
