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
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
public class WriteLocationView extends LocationInfoView {
    private com.baidu.tieba.tbadkCore.location.d avY;
    private int awh;
    private final d.a awn;
    private BaseActivity<?> bFA;
    private final CustomMessageListener fiA;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awh = 0;
        this.awn = new a(this);
        this.fiA = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.bFA = baseActivity;
        this.bFA.registerListener(this.fiA);
        this.avY = new com.baidu.tieba.tbadkCore.location.d(this.bFA);
        this.avY.a(this.awn);
        setOnClickListener(new c(this));
        Dh();
    }

    public boolean bgL() {
        if (this.avY == null) {
            return false;
        }
        return this.avY.bgL();
    }

    public void Df() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bFA.getPageContext().getPageActivity())) {
            this.bFA.showToast(r.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dg();
        } else if (this.avY.bgJ()) {
            De();
        } else {
            this.avY.kY(false);
            c(1, true, null);
            this.avY.bgH();
        }
    }

    private void Dh() {
        if (this.avY.bgL()) {
            if (this.avY.bgJ()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bgE().getLocationData().bgA());
                return;
            }
            c(1, true, null);
            this.avY.bgH();
            return;
        }
        c(0, true, null);
    }

    private void Dg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bFA.getPageContext().getPageActivity());
        aVar.cb(r.j.location_app_permission_prompt).a(r.j.isopen, new d(this)).b(r.j.cancel, new e(this)).b(this.bFA.getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbL() {
        if (this.avY != null) {
            this.avY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.bFA.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.awh = i;
        setVisibility(z ? 0 : 8);
        j(i, str);
    }
}
