package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f<MsgRemindActivity> {
    private am cbp;
    private MsgRemindActivity cbu;
    private com.baidu.adp.framework.listener.e cbv;
    private com.baidu.adp.framework.listener.e cbw;

    public aj(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cbv = new ak(this, 104102);
        this.cbw = new al(this, 104101);
        this.cbu = msgRemindActivity;
        registerListener(this.cbw);
        registerListener(this.cbv);
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
            this.cbp = amVar;
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
            this.cbu.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cbu.showToast(this.cbu.getResources().getString(com.baidu.tieba.y.success));
            if (this.cbp != null) {
                this.cbp.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vB() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vC() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vD() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vM() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vL() && !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vA()) {
                        this.cbp.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cbp.a(2, true, z2);
                this.cbp.a(3, true, z2);
                this.cbp.a(4, true, z2);
                this.cbp.a(5, true, z2);
                this.cbp.a(1, true, z2);
                this.cbp.a(23, true, z2);
                this.cbp.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cbu.showToast(str);
        } else {
            this.cbu.showToast(com.baidu.tieba.y.bubble_setdefualt_error);
        }
        if (this.cbp != null) {
            this.cbp.a(i, false, z2);
        }
    }
}
