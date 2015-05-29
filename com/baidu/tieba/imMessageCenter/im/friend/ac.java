package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.im.message.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f<InviteFriendListActivity> {
    private RequestCommitInviteMessage bvW;
    private int bvX;
    private int bvY;

    public ac(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bvX = intent.getIntExtra("gid", -1);
            this.bvY = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bvX = bundle.getInt("gid", -1);
            this.bvY = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void i(Bundle bundle) {
        bundle.putInt("gid", this.bvX);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.bvY);
    }

    public void hT(String str) {
        this.bvW = b(this.bvX, this.bvY, str);
        super.sendMessage(this.bvW);
    }

    private RequestCommitInviteMessage b(int i, int i2, String str) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(i);
        builder.msgType = 5;
        builder.toUids = str;
        builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(i2) + "}";
        RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
        requestCommitInviteMessage.setReqData(builder.build(false));
        return requestCommitInviteMessage;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return true;
    }
}
