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
    private LocationModel aAA;
    private int aAI;
    private final LocationModel.a aAP;
    private final CustomMessageListener fEk;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAI = 0;
        this.aAP = new a(this);
        this.fEk = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void f(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.fEk);
        this.aAA = new LocationModel(this.mBaseActivity);
        this.aAA.a(this.aAP);
        setOnClickListener(new c(this));
        CR();
    }

    public boolean QG() {
        if (this.aAA == null) {
            return false;
        }
        return this.aAA.QG();
    }

    public void CP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(w.l.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            CQ();
        } else if (this.aAA.biQ()) {
            CO();
        } else {
            this.aAA.lv(false);
            c(1, true, null);
            this.aAA.biO();
        }
    }

    private void CR() {
        if (this.aAA.QG()) {
            if (this.aAA.biQ()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.d.biM().getLocationData().biI());
                return;
            }
            c(1, true, null);
            this.aAA.biO();
            return;
        }
        c(0, true, null);
    }

    private void CQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.bY(w.l.location_app_permission_prompt).a(w.l.isopen, new d(this)).b(w.l.cancel, new e(this)).b(this.mBaseActivity.getPageContext());
        aVar.tc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdV() {
        if (this.aAA != null) {
            this.aAA.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.aAI = i;
        setVisibility(z ? 0 : 8);
        l(i, str);
    }
}
