package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private a cLA;
    private com.baidu.adp.framework.listener.e cLB;
    private com.baidu.adp.framework.listener.e cLC;
    private MsgRemindActivity cLz;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cLB = new h(this, 104102);
        this.cLC = new i(this, 104101);
        this.cLz = msgRemindActivity;
        registerListener(this.cLC);
        registerListener(this.cLB);
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
            this.cLA = aVar;
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
            this.cLz.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cLz.showToast(this.cLz.getResources().getString(i.h.success));
            if (this.cLA != null) {
                this.cLA.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xl()) {
                        this.cLA.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cLA.a(2, true, z2);
                this.cLA.a(3, true, z2);
                this.cLA.a(4, true, z2);
                this.cLA.a(5, true, z2);
                this.cLA.a(1, true, z2);
                this.cLA.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cLz.showToast(str);
        } else {
            this.cLz.showToast(i.h.bubble_setdefualt_error);
        }
        if (this.cLA != null) {
            this.cLA.a(i, false, z2);
        }
    }
}
