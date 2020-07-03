package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private long iKR;
    private RequestCommitInviteMessage jfn;
    private long jfo;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.iKR = intent.getLongExtra("gid", -1L);
            this.jfo = intent.getLongExtra("groupid", -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.iKR = bundle.getLong("gid", -1L);
            this.jfo = bundle.getLong("groupid", -1L);
        }
    }

    public void ax(Bundle bundle) {
        bundle.putLong("gid", this.iKR);
        bundle.putLong("groupid", this.jfo);
    }

    public void HD(String str) {
        this.jfn = c(this.iKR, this.jfo, str);
        super.sendMessage(this.jfn);
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
