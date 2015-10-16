package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private MsgRemindActivity cLY;
    private a cLZ;
    private com.baidu.adp.framework.listener.e cMa;
    private com.baidu.adp.framework.listener.e cMb;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cMa = new h(this, 104102);
        this.cMb = new i(this, 104101);
        this.cLY = msgRemindActivity;
        registerListener(this.cMb);
        registerListener(this.cMa);
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
            this.cLZ = aVar;
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
            this.cLY.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cLY.showToast(this.cLY.getResources().getString(i.h.success));
            if (this.cLZ != null) {
                this.cLZ.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw() && !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xl()) {
                        this.cLZ.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cLZ.a(2, true, z2);
                this.cLZ.a(3, true, z2);
                this.cLZ.a(4, true, z2);
                this.cLZ.a(5, true, z2);
                this.cLZ.a(1, true, z2);
                this.cLZ.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cLY.showToast(str);
        } else {
            this.cLY.showToast(i.h.bubble_setdefualt_error);
        }
        if (this.cLZ != null) {
            this.cLZ.a(i, false, z2);
        }
    }
}
