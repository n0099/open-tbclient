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
    private LocationModel aAQ;
    private int aAY;
    private final LocationModel.a aBe;
    private final CustomMessageListener fAj;
    private BaseActivity<?> mBaseActivity;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAY = 0;
        this.aBe = new a(this);
        this.fAj = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.mBaseActivity = baseActivity;
        this.mBaseActivity.registerListener(this.fAj);
        this.aAQ = new LocationModel(this.mBaseActivity);
        this.aAQ.a(this.aBe);
        setOnClickListener(new c(this));
        DT();
    }

    public boolean QZ() {
        if (this.aAQ == null) {
            return false;
        }
        return this.aAQ.QZ();
    }

    public void DR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mBaseActivity.getPageContext().getPageActivity())) {
            this.mBaseActivity.showToast(w.l.location_system_permission_prompt);
            c(0, true, null);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            DS();
        } else if (this.aAQ.bjZ()) {
            DQ();
        } else {
            this.aAQ.lw(false);
            c(1, true, null);
            this.aAQ.bjX();
        }
    }

    private void DT() {
        if (this.aAQ.QZ()) {
            if (this.aAQ.bjZ()) {
                c(2, true, com.baidu.tieba.tbadkCore.location.d.bjV().getLocationData().bjR());
                return;
            }
            c(1, true, null);
            this.aAQ.bjX();
            return;
        }
        c(0, true, null);
    }

    private void DS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mBaseActivity.getPageContext().getPageActivity());
        aVar.bZ(w.l.location_app_permission_prompt).a(w.l.isopen, new d(this)).b(w.l.cancel, new e(this)).b(this.mBaseActivity.getPageContext());
        aVar.tQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beY() {
        if (this.aAQ != null) {
            this.aAQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mBaseActivity.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, String str) {
        this.aAY = i;
        setVisibility(z ? 0 : 8);
        k(i, str);
    }
}
