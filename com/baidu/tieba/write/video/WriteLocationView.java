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
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class WriteLocationView extends LocationInfoView {
    private com.baidu.tieba.tbadkCore.location.d asj;
    private int ass;
    private final d.a asy;
    private BaseActivity<?> bJz;
    private final CustomMessageListener eZK;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ass = 0;
        this.asy = new a(this);
        this.eZK = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.bJz = baseActivity;
        this.bJz.registerListener(this.eZK);
        this.asj = new com.baidu.tieba.tbadkCore.location.d(this.bJz);
        this.asj.a(this.asy);
        setOnClickListener(new c(this));
        BV();
    }

    public boolean bcZ() {
        if (this.asj == null) {
            return false;
        }
        return this.asj.bcZ();
    }

    public void BT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bJz.getPageContext().getPageActivity())) {
            this.bJz.showToast(u.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BU();
        } else if (this.asj.bcX()) {
            BS();
        } else {
            this.asj.kl(false);
            b(1, true, null);
            this.asj.bcV();
        }
    }

    private void BV() {
        if (this.asj.bcZ()) {
            if (this.asj.bcX()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bcT().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.asj.bcV();
            return;
        }
        b(0, true, null);
    }

    private void BU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bJz.getPageContext().getPageActivity());
        aVar.bM(u.j.location_app_permission_prompt).a(u.j.isopen, new d(this)).b(u.j.cancel, new e(this)).b(this.bJz.getPageContext());
        aVar.rT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkD() {
        if (this.asj != null) {
            this.asj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.bJz.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ass = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
