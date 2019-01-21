package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private long eLP;
    private RequestCommitInviteMessage fgo;
    private long fgp;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.eLP = intent.getLongExtra("gid", -1L);
            this.fgp = intent.getLongExtra(InviteFriendListActivityConfig.GROUP_ID, -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.eLP = bundle.getLong("gid", -1L);
            this.fgp = bundle.getLong(InviteFriendListActivityConfig.GROUP_ID, -1L);
        }
    }

    public void z(Bundle bundle) {
        bundle.putLong("gid", this.eLP);
        bundle.putLong(InviteFriendListActivityConfig.GROUP_ID, this.fgp);
    }

    public void ra(String str) {
        this.fgo = b(this.eLP, this.fgp, str);
        super.sendMessage(this.fgo);
    }

    private RequestCommitInviteMessage b(long j, long j2, String str) {
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
