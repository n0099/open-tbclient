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
    private long eAc;
    private RequestCommitInviteMessage eUB;
    private long eUC;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.eAc = intent.getLongExtra("gid", -1L);
            this.eUC = intent.getLongExtra(InviteFriendListActivityConfig.GROUP_ID, -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.eAc = bundle.getLong("gid", -1L);
            this.eUC = bundle.getLong(InviteFriendListActivityConfig.GROUP_ID, -1L);
        }
    }

    public void t(Bundle bundle) {
        bundle.putLong("gid", this.eAc);
        bundle.putLong(InviteFriendListActivityConfig.GROUP_ID, this.eUC);
    }

    public void qe(String str) {
        this.eUB = a(this.eAc, this.eUC, str);
        super.sendMessage(this.eUB);
    }

    private RequestCommitInviteMessage a(long j, long j2, String str) {
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
