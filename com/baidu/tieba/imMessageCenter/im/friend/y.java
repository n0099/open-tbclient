package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<InviteFriendListActivity> {
    private int cVI;
    private RequestCommitInviteMessage dbg;
    private int dbh;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.cVI = intent.getIntExtra("gid", -1);
            this.dbh = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.cVI = bundle.getInt("gid", -1);
            this.dbh = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void l(Bundle bundle) {
        bundle.putInt("gid", this.cVI);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.dbh);
    }

    public void lh(String str) {
        this.dbg = c(this.cVI, this.dbh, str);
        super.sendMessage(this.dbg);
    }

    private RequestCommitInviteMessage c(int i, int i2, String str) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(i);
        builder.msgType = 5;
        builder.toUids = str;
        builder.content = "{\"type\":" + String.valueOf(1) + ",\"groupId\":" + String.valueOf(i2) + "}";
        RequestCommitInviteMessage requestCommitInviteMessage = new RequestCommitInviteMessage();
        requestCommitInviteMessage.setReqData(builder.build(false));
        return requestCommitInviteMessage;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return true;
    }
}
