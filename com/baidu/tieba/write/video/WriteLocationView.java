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
    private final LocationModel.a aBd;
    private final CustomMessageListener fws;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAW = 0;
        this.aBd = new a(this);
        this.fws = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void f(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.fws);
        this.aAO = new LocationModel(this.mBaseActivity);
        this.aAO.a(this.aBd);
        setOnClickListener(new c(this));
        CX();
    }

    public boolean Qu() {
        if (this.aAO == null) {
            return false;
        }
        return this.aAO.Qu();
    }

    public void CV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(w.l.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            CW();
        } else if (this.aAO.bhw()) {
            CU();
        } else {
            this.aAO.la(false);
            c(1, true, null);
            this.aAO.bhu();
        }
    }

    private void CX() {
        if (this.aAO.Qu()) {
            if (this.aAO.bhw()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.d.bhs().getLocationData().bho());
                return;
            }
            c(1, true, null);
            this.aAO.bhu();
            return;
        }
        c(0, true, null);
    }

    private void CW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.bX(w.l.location_app_permission_prompt).a(w.l.isopen, new d(this)).b(w.l.cancel, new e(this)).b(this.mBaseActivity.getPageContext());
        aVar.td();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcB() {
        if (this.aAO != null) {
            this.aAO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.aAW = i;
        setVisibility(z ? 0 : 8);
        l(i, str);
    }
}
