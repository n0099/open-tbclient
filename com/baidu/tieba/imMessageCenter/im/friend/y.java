package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<InviteFriendListActivity> {
    private int coQ;
    private RequestCommitInviteMessage cwn;
    private int cwo;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.coQ = intent.getIntExtra("gid", -1);
            this.cwo = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.coQ = bundle.getInt("gid", -1);
            this.cwo = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void m(Bundle bundle) {
        bundle.putInt("gid", this.coQ);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.cwo);
    }

    public void kg(String str) {
        this.cwn = c(this.coQ, this.cwo, str);
        super.sendMessage(this.cwn);
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
