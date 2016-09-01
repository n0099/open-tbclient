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
    private com.baidu.tieba.tbadkCore.location.d awf;
    private int awo;
    private final d.a awu;
    private BaseActivity<?> bDA;
    private final CustomMessageListener fuH;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awo = 0;
        this.awu = new a(this);
        this.fuH = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.bDA = baseActivity;
        this.bDA.registerListener(this.fuH);
        this.awf = new com.baidu.tieba.tbadkCore.location.d(this.bDA);
        this.awf.a(this.awu);
        setOnClickListener(new c(this));
        Dq();
    }

    public boolean bjP() {
        if (this.awf == null) {
            return false;
        }
        return this.awf.bjP();
    }

    public void Do() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bDA.getPageContext().getPageActivity())) {
            this.bDA.showToast(t.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dp();
        } else if (this.awf.bjN()) {
            Dn();
        } else {
            this.awf.kL(false);
            c(1, true, null);
            this.awf.bjL();
        }
    }

    private void Dq() {
        if (this.awf.bjP()) {
            if (this.awf.bjN()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bjJ().getLocationData().getFormatted_address());
                return;
            }
            c(1, true, null);
            this.awf.bjL();
            return;
        }
        c(0, true, null);
    }

    private void Dp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bDA.getPageContext().getPageActivity());
        aVar.bZ(t.j.location_app_permission_prompt).a(t.j.isopen, new d(this)).b(t.j.cancel, new e(this)).b(this.bDA.getPageContext());
        aVar.sX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beR() {
        if (this.awf != null) {
            this.awf.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.bDA.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.awo = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
