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
    private com.baidu.tieba.tbadkCore.location.d avI;
    private int avR;
    private final d.a avX;
    private BaseActivity<?> bDL;
    private final CustomMessageListener fxo;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avR = 0;
        this.avX = new a(this);
        this.fxo = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.bDL = baseActivity;
        this.bDL.registerListener(this.fxo);
        this.avI = new com.baidu.tieba.tbadkCore.location.d(this.bDL);
        this.avI.a(this.avX);
        setOnClickListener(new c(this));
        Dq();
    }

    public boolean bkB() {
        if (this.avI == null) {
            return false;
        }
        return this.avI.bkB();
    }

    public void Do() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bDL.getPageContext().getPageActivity())) {
            this.bDL.showToast(r.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dp();
        } else if (this.avI.bkz()) {
            Dn();
        } else {
            this.avI.kO(false);
            c(1, true, null);
            this.avI.bkx();
        }
    }

    private void Dq() {
        if (this.avI.bkB()) {
            if (this.avI.bkz()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bkv().getLocationData().getFormatted_address());
                return;
            }
            c(1, true, null);
            this.avI.bkx();
            return;
        }
        c(0, true, null);
    }

    private void Dp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bDL.getPageContext().getPageActivity());
        aVar.bZ(r.j.location_app_permission_prompt).a(r.j.isopen, new d(this)).b(r.j.cancel, new e(this)).b(this.bDL.getPageContext());
        aVar.tm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bfC() {
        if (this.avI != null) {
            this.avI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.bDL.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.avR = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
