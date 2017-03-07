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
    private int aAG;
    private final LocationModel.a aAM;
    private LocationModel aAy;
    private final CustomMessageListener fwj;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAG = 0;
        this.aAM = new a(this);
        this.fwj = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.fwj);
        this.aAy = new LocationModel(this.mBaseActivity);
        this.aAy.a(this.aAM);
        setOnClickListener(new c(this));
        Dv();
    }

    public boolean PB() {
        if (this.aAy == null) {
            return false;
        }
        return this.aAy.PB();
    }

    public void Dt() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(w.l.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Du();
        } else if (this.aAy.bin()) {
            Ds();
        } else {
            this.aAy.lj(false);
            c(1, true, null);
            this.aAy.bil();
        }
    }

    private void Dv() {
        if (this.aAy.PB()) {
            if (this.aAy.bin()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bij().getLocationData().bif());
                return;
            }
            c(1, true, null);
            this.aAy.bil();
            return;
        }
        c(0, true, null);
    }

    private void Du() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.bW(w.l.location_app_permission_prompt).a(w.l.isopen, new d(this)).b(w.l.cancel, new e(this)).b(this.mBaseActivity.getPageContext());
        aVar.ts();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdk() {
        if (this.aAy != null) {
            this.aAy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.aAG = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
