package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdBaseModel<InviteFriendListActivity> {
    private int ddI;
    private RequestCommitInviteMessage djk;
    private int djl;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.ddI = intent.getIntExtra("gid", -1);
            this.djl = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.ddI = bundle.getInt("gid", -1);
            this.djl = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void n(Bundle bundle) {
        bundle.putInt("gid", this.ddI);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.djl);
    }

    public void lb(String str) {
        this.djk = c(this.ddI, this.djl, str);
        super.sendMessage(this.djk);
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
