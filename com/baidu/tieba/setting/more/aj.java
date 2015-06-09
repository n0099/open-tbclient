package com.baidu.tieba.setting.more;

import android.text.TextUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f<MsgRemindActivity> {
    private am cfS;
    private MsgRemindActivity cfX;
    private com.baidu.adp.framework.listener.e cfY;
    private com.baidu.adp.framework.listener.e cfZ;

    public aj(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.cfY = new ak(this, 104102);
        this.cfZ = new al(this, 104101);
        this.cfX = msgRemindActivity;
        registerListener(this.cfZ);
        registerListener(this.cfY);
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
            this.cfS = amVar;
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
            this.cfX.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.cfX.showToast(this.cfX.getResources().getString(com.baidu.tieba.t.success));
            if (this.cfS != null) {
                this.cfS.a(i, true, z2);
                if (i != 14) {
                    if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv() && !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                        this.cfS.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.cfS.a(2, true, z2);
                this.cfS.a(3, true, z2);
                this.cfS.a(4, true, z2);
                this.cfS.a(5, true, z2);
                this.cfS.a(1, true, z2);
                this.cfS.a(23, true, z2);
                this.cfS.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.cfX.showToast(str);
        } else {
            this.cfX.showToast(com.baidu.tieba.t.bubble_setdefualt_error);
        }
        if (this.cfS != null) {
            this.cfS.a(i, false, z2);
        }
    }
}
