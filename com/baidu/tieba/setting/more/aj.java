package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f<MsgRemindActivity> {
    private am cba;
    private MsgRemindActivity cbf;
    private com.baidu.adp.framework.listener.e cbg;
    private com.baidu.adp.framework.listener.e cbh;

    public aj(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cbg = new ak(this, 104102);
        this.cbh = new al(this, 104101);
        this.cbf = msgRemindActivity;
        registerListener(this.cbh);
        registerListener(this.cbg);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void a(int i, boolean z, am amVar) {
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 23 || i == 6) {
            this.cba = amVar;
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
            this.cbf.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cbf.showToast(this.cbf.getResources().getString(com.baidu.tieba.y.success));
            if (this.cba != null) {
                this.cba.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vw() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vG() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF() && !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
                        this.cba.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cba.a(2, true, z2);
                this.cba.a(3, true, z2);
                this.cba.a(4, true, z2);
                this.cba.a(5, true, z2);
                this.cba.a(1, true, z2);
                this.cba.a(23, true, z2);
                this.cba.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cbf.showToast(str);
        } else {
            this.cbf.showToast(com.baidu.tieba.y.bubble_setdefualt_error);
        }
        if (this.cba != null) {
            this.cba.a(i, false, z2);
        }
    }
}
