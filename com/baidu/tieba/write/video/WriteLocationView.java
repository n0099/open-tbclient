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
    private com.baidu.tieba.tbadkCore.location.d auU;
    private int avd;
    private final d.a avj;
    private final CustomMessageListener dYT;
    private BaseActivity<?> dke;

    public WriteLocationView(Context context) {
        this(context, null);
    }

    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avd = 0;
        this.avj = new a(this);
        this.dYT = new b(this, CmdConfigCustom.CMD_SELECT_LOCATION);
    }

    public void e(BaseActivity<?> baseActivity) {
        this.dke = baseActivity;
        this.dke.registerListener(this.dYT);
        this.auU = new com.baidu.tieba.tbadkCore.location.d(this.dke);
        this.auU.a(this.avj);
        setOnClickListener(new c(this));
        Dj();
    }

    public boolean aNi() {
        if (this.auU == null) {
            return false;
        }
        return this.auU.aNi();
    }

    public void Dh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dke.getPageContext().getPageActivity())) {
            this.dke.showToast(t.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Di();
        } else if (this.auU.aNg()) {
            Dg();
        } else {
            this.auU.hW(false);
            b(1, true, null);
            this.auU.aNe();
        }
    }

    private void Dj() {
        if (this.auU.aNi()) {
            if (this.auU.aNg()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.aNb().getLocationData().aMX());
                return;
            }
            b(1, true, null);
            this.auU.aNe();
            return;
        }
        b(0, true, null);
    }

    private void Di() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dke.getPageContext().getPageActivity());
        aVar.bY(t.j.location_app_permission_prompt).a(t.j.isopen, new d(this)).b(t.j.cancel, new e(this)).b(this.dke.getPageContext());
        aVar.uj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aTp() {
        if (this.auU != null) {
            this.auU.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.dke.getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.avd = i;
        setVisibility(z ? 0 : 8);
        s(i, str);
    }
}
