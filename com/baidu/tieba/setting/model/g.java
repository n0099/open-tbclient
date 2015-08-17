package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private MsgRemindActivity cwc;
    private a cwd;
    private com.baidu.adp.framework.listener.e cwe;
    private com.baidu.adp.framework.listener.e cwf;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cwe = new h(this, 104102);
        this.cwf = new i(this, 104101);
        this.cwc = msgRemindActivity;
        registerListener(this.cwf);
        registerListener(this.cwe);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(int i, boolean z, a aVar) {
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 6) {
            this.cwd = aVar;
            if (i == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskMessage);
            } else {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setMaskType(i);
                requestUpdateMaskInfoMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage);
            }
            this.cwc.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cwc.showToast(this.cwc.getResources().getString(i.C0057i.success));
            if (this.cwd != null) {
                this.cwd.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xw() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xx() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xG() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xF() && !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xu()) {
                        this.cwd.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cwd.a(2, true, z2);
                this.cwd.a(3, true, z2);
                this.cwd.a(4, true, z2);
                this.cwd.a(5, true, z2);
                this.cwd.a(1, true, z2);
                this.cwd.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cwc.showToast(str);
        } else {
            this.cwc.showToast(i.C0057i.bubble_setdefualt_error);
        }
        if (this.cwd != null) {
            this.cwd.a(i, false, z2);
        }
    }
}
