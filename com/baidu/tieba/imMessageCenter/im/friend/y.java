package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class y extends BdBaseModel<InviteFriendListActivity> {
    private int dfy;
    private RequestCommitInviteMessage dkZ;
    private int dla;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.dfy = intent.getIntExtra("gid", -1);
            this.dla = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.dfy = bundle.getInt("gid", -1);
            this.dla = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void n(Bundle bundle) {
        bundle.putInt("gid", this.dfy);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.dla);
    }

    public void lq(String str) {
        this.dkZ = c(this.dfy, this.dla, str);
        super.sendMessage(this.dkZ);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return true;
    }
}
