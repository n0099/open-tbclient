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
    private int arC;
    private final d.a arI;
    private com.baidu.tieba.tbadkCore.location.d art;
    private BaseActivity<?> boS;
    private final CustomMessageListener euU;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arC = 0;
        this.arI = new a(this);
        this.euU = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.boS = baseActivity;
        this.boS.registerListener(this.euU);
        this.art = new com.baidu.tieba.tbadkCore.location.d(this.boS);
        this.art.a(this.arI);
        setOnClickListener(new c(this));
        BM();
    }

    public boolean aUL() {
        if (this.art == null) {
            return false;
        }
        return this.art.aUL();
    }

    public void BK() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.boS.getPageContext().getPageActivity())) {
            this.boS.showToast(t.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m11getInst().getLocationShared()) {
            BL();
        } else if (this.art.aUJ()) {
            BJ();
        } else {
            this.art.jA(false);
            b(1, true, null);
            this.art.aUH();
        }
    }

    private void BM() {
        if (this.art.aUL()) {
            if (this.art.aUJ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.aUF().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.art.aUH();
            return;
        }
        b(0, true, null);
    }

    private void BL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.boS.getPageContext().getPageActivity());
        aVar.bL(t.j.location_app_permission_prompt).a(t.j.isopen, new d(this)).b(t.j.cancel, new e(this)).b(this.boS.getPageContext());
        aVar.rV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bci() {
        if (this.art != null) {
            this.art.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.boS.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.arC = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
