package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.setting.more.MsgRemindActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private MsgRemindActivity dIW;
    private a dIX;
    private com.baidu.adp.framework.listener.e dIY;
    private com.baidu.adp.framework.listener.e dIZ;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.dIY = new h(this, 104102);
        this.dIZ = new i(this, 104101);
        this.dIW = msgRemindActivity;
        registerListener(this.dIZ);
        registerListener(this.dIY);
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
            this.dIX = aVar;
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
            this.dIW.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.dIW.showToast(this.dIW.getResources().getString(t.j.success));
            if (this.dIX != null) {
                this.dIX.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zp() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zq() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zr() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zA() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zz() && !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zo()) {
                        this.dIX.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.dIX.a(2, true, z2);
                this.dIX.a(3, true, z2);
                this.dIX.a(4, true, z2);
                this.dIX.a(5, true, z2);
                this.dIX.a(1, true, z2);
                this.dIX.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.dIW.showToast(str);
        } else {
            this.dIW.showToast(t.j.bubble_setdefualt_error);
        }
        if (this.dIX != null) {
            this.dIX.a(i, false, z2);
        }
    }
}
