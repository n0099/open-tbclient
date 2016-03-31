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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
public class WriteLocationView extends LocationInfoView {
    private int avD;
    private final d.a avJ;
    private com.baidu.tieba.tbadkCore.location.d avu;
    private BaseActivity<?> dEE;
    private final CustomMessageListener erL;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avD = 0;
        this.avJ = new a(this);
        this.erL = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.dEE = baseActivity;
        this.dEE.registerListener(this.erL);
        this.avu = new com.baidu.tieba.tbadkCore.location.d(this.dEE);
        this.avu.a(this.avJ);
        setOnClickListener(new c(this));
        DS();
    }

    public boolean aUk() {
        if (this.avu == null) {
            return false;
        }
        return this.avu.aUk();
    }

    public void DQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dEE.getPageContext().getPageActivity())) {
            this.dEE.showToast(t.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            DR();
        } else if (this.avu.aUi()) {
            DO();
        } else {
            this.avu.iL(false);
            b(1, true, null);
            this.avu.aUg();
        }
    }

    private void DS() {
        if (this.avu.aUk()) {
            if (this.avu.aUi()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.aUd().getLocationData().aTZ());
                return;
            }
            b(1, true, null);
            this.avu.aUg();
            return;
        }
        b(0, true, null);
    }

    private void DR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dEE.getPageContext().getPageActivity());
        aVar.ca(t.j.location_app_permission_prompt).a(t.j.isopen, new d(this)).b(t.j.cancel, new e(this)).b(this.dEE.getPageContext());
        aVar.up();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZP() {
        if (this.avu != null) {
            this.avu.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.dEE.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.avD = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
