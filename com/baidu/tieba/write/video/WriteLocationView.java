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
    private com.baidu.tieba.tbadkCore.location.d asY;
    private int ath;
    private final d.a atn;
    private BaseActivity<?> bsn;
    private final CustomMessageListener fmN;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ath = 0;
        this.atn = new a(this);
        this.fmN = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.bsn = baseActivity;
        this.bsn.registerListener(this.fmN);
        this.asY = new com.baidu.tieba.tbadkCore.location.d(this.bsn);
        this.asY.a(this.atn);
        setOnClickListener(new c(this));
        BV();
    }

    public boolean bgo() {
        if (this.asY == null) {
            return false;
        }
        return this.asY.bgo();
    }

    public void BT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bsn.getPageContext().getPageActivity())) {
            this.bsn.showToast(u.j.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m10getInst().getLocationShared()) {
            BU();
        } else if (this.asY.bgm()) {
            BS();
        } else {
            this.asY.kz(false);
            c(1, true, null);
            this.asY.bgk();
        }
    }

    private void BV() {
        if (this.asY.bgo()) {
            if (this.asY.bgm()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.c.bgi().getLocationData().getFormatted_address());
                return;
            }
            c(1, true, null);
            this.asY.bgk();
            return;
        }
        c(0, true, null);
    }

    private void BU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bsn.getPageContext().getPageActivity());
        aVar.bM(u.j.location_app_permission_prompt).a(u.j.isopen, new d(this)).b(u.j.cancel, new e(this)).b(this.bsn.getPageContext());
        aVar.rS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbm() {
        if (this.asY != null) {
            this.asY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.bsn.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.ath = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
