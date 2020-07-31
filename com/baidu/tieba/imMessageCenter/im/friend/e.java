package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private long iQW;
    private RequestCommitInviteMessage jnJ;
    private long jnK;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.iQW = intent.getLongExtra("gid", -1L);
            this.jnK = intent.getLongExtra("groupid", -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.iQW = bundle.getLong("gid", -1L);
            this.jnK = bundle.getLong("groupid", -1L);
        }
    }

    public void ay(Bundle bundle) {
        bundle.putLong("gid", this.iQW);
        bundle.putLong("groupid", this.jnK);
    }

    public void Is(String str) {
        this.jnJ = c(this.iQW, this.jnK, str);
        super.sendMessage(this.jnJ);
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
