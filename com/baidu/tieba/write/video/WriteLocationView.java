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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class WriteLocationView extends LocationInfoView {
    private LocationModel avd;
    private int avl;
    private final LocationModel.a avr;
    private final CustomMessageListener frM;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avl = 0;
        this.avr = new a(this);
        this.frM = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.frM);
        this.avd = new LocationModel(this.mBaseActivity);
        this.avd.a(this.avr);
        setOnClickListener(new c(this));
        Dc();
    }

    public boolean OH() {
        if (this.avd == null) {
            return false;
        }
        return this.avd.OH();
    }

    public void Da() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(r.l.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Db();
        } else if (this.avd.bix()) {
            CZ();
        } else {
            this.avd.lk(false);
            c(1, true, null);
            this.avd.biv();
        }
    }

    private void Dc() {
        if (this.avd.OH()) {
            if (this.avd.bix()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bit().getLocationData().bip());
                return;
            }
            c(1, true, null);
            this.avd.biv();
            return;
        }
        c(0, true, null);
    }

    private void Db() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.ca(r.l.location_app_permission_prompt).a(r.l.isopen, new d(this)).b(r.l.cancel, new e(this)).b(this.mBaseActivity.getPageContext());
        aVar.sV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdz() {
        if (this.avd != null) {
            this.avd.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.avl = i;
        setVisibility(z ? 0 : 8);
        j(i, str);
    }
}
