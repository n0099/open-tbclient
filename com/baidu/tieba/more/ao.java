package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.f<MsgRemindActivity> {
    private ar bwr;
    private MsgRemindActivity bwx;
    private com.baidu.adp.framework.listener.e bwy;
    private com.baidu.adp.framework.listener.e bwz;

    public ao(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bwy = new ap(this, 104102);
        this.bwz = new aq(this, 104101);
        this.bwx = msgRemindActivity;
        registerListener(this.bwz);
        registerListener(this.bwy);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void a(int i, boolean z, ar arVar) {
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 23 || i == 6) {
            this.bwr = arVar;
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
            this.bwx.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.bwx.showToast(this.bwx.getResources().getString(com.baidu.tieba.z.success));
            if (this.bwr != null) {
                this.bwr.a(i, true, z2);
                if (i != 14) {
                    if (!TbadkCoreApplication.m255getInst().isMsgAtmeOn() && !TbadkCoreApplication.m255getInst().isMsgChatOn() && !TbadkCoreApplication.m255getInst().isMsgNewFansOn() && !TbadkCoreApplication.m255getInst().isMsgReplymeOn() && !TbadkCoreApplication.m255getInst().isMsgZanOn() && !TbadkCoreApplication.m255getInst().isGroupMsgOn() && !TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                        this.bwr.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.bwr.a(2, true, z2);
                this.bwr.a(3, true, z2);
                this.bwr.a(4, true, z2);
                this.bwr.a(5, true, z2);
                this.bwr.a(1, true, z2);
                this.bwr.a(23, true, z2);
                this.bwr.a(13, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.bwx.showToast(str);
        } else {
            this.bwx.showToast(com.baidu.tieba.z.bubble_setdefualt_error);
        }
        if (this.bwr != null) {
            this.bwr.a(i, false, z2);
        }
    }
}
