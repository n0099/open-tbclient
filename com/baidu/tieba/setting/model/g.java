package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.more.MsgRemindActivity;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<MsgRemindActivity> {
    private MsgRemindActivity cNu;
    private a cNv;
    private com.baidu.adp.framework.listener.e cNw;
    private com.baidu.adp.framework.listener.e cNx;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, boolean z2);
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cNw = new h(this, 104102);
        this.cNx = new i(this, 104101);
        this.cNu = msgRemindActivity;
        registerListener(this.cNx);
        registerListener(this.cNw);
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
            this.cNv = aVar;
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
            this.cNu.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cNu.showToast(this.cNu.getResources().getString(i.h.success));
            if (this.cNv != null) {
                this.cNv.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xp() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xq() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xz() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy() && !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xn()) {
                        this.cNv.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cNv.a(2, true, z2);
                this.cNv.a(3, true, z2);
                this.cNv.a(4, true, z2);
                this.cNv.a(5, true, z2);
                this.cNv.a(1, true, z2);
                this.cNv.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cNu.showToast(str);
        } else {
            this.cNu.showToast(i.h.bubble_setdefualt_error);
        }
        if (this.cNv != null) {
            this.cNv.a(i, false, z2);
        }
    }
}
