package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private long iQY;
    private RequestCommitInviteMessage jnL;
    private long jnM;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.iQY = intent.getLongExtra("gid", -1L);
            this.jnM = intent.getLongExtra("groupid", -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.iQY = bundle.getLong("gid", -1L);
            this.jnM = bundle.getLong("groupid", -1L);
        }
    }

    public void ay(Bundle bundle) {
        bundle.putLong("gid", this.iQY);
        bundle.putLong("groupid", this.jnM);
    }

    public void Is(String str) {
        this.jnL = c(this.iQY, this.jnM, str);
        super.sendMessage(this.jnL);
    }

    private RequestCommitInviteMessage c(long j, long j2, String str) {
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
