package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private long kCQ;
    private RequestCommitInviteMessage kRO;
    private long kRP;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.kCQ = intent.getLongExtra("gid", -1L);
            this.kRP = intent.getLongExtra("groupid", -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.kCQ = bundle.getLong("gid", -1L);
            this.kRP = bundle.getLong("groupid", -1L);
        }
    }

    public void ay(Bundle bundle) {
        bundle.putLong("gid", this.kCQ);
        bundle.putLong("groupid", this.kRP);
    }

    public void Nu(String str) {
        this.kRO = e(this.kCQ, this.kRP, str);
        super.sendMessage(this.kRO);
    }

    private RequestCommitInviteMessage e(long j, long j2, String str) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(j);
        builder.msgType = 5;
        builder.toUids = str;
        builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(j2) + "}";
        RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
        requestCommitInviteMessage.setReqData(builder.build(false));
        return requestCommitInviteMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return true;
    }
}
