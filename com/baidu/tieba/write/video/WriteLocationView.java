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
    private com.baidu.tieba.tbadkCore.location.d awB;
    private int awK;
    private final d.a awQ;
    private BaseActivity<?> bGF;
    private final CustomMessageListener fEt;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awK = 0;
        this.awQ = new a(this);
        this.fEt = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.bGF = baseActivity;
        this.bGF.registerListener(this.fEt);
        this.awB = new com.baidu.tieba.tbadkCore.location.d(this.bGF);
        this.awB.a(this.awQ);
        setOnClickListener(new c(this));
        Dy();
    }

    public boolean bmR() {
        if (this.awB == null) {
            return false;
        }
        return this.awB.bmR();
    }

    public void Dw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bGF.getPageContext().getPageActivity())) {
            this.bGF.showToast(r.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dx();
        } else if (this.awB.bmP()) {
            Dv();
        } else {
            this.awB.ln(false);
            c(1, true, null);
            this.awB.bmN();
        }
    }

    private void Dy() {
        if (this.awB.bmR()) {
            if (this.awB.bmP()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bmL().getLocationData().getFormatted_address());
                return;
            }
            c(1, true, null);
            this.awB.bmN();
            return;
        }
        c(0, true, null);
    }

    private void Dx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bGF.getPageContext().getPageActivity());
        aVar.ca(r.j.location_app_permission_prompt).a(r.j.isopen, new d(this)).b(r.j.cancel, new e(this)).b(this.bGF.getPageContext());
        aVar.tq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhY() {
        if (this.awB != null) {
            this.awB.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.bGF.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.awK = i;
        setVisibility(z ? 0 : 8);
        j(i, str);
    }
}
