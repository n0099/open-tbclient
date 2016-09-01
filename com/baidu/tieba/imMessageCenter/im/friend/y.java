package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<InviteFriendListActivity> {
    private int djH;
    private RequestCommitInviteMessage drf;
    private int drg;

    public y(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.djH = intent.getIntExtra("gid", -1);
            this.drg = intent.getIntExtra(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.djH = bundle.getInt("gid", -1);
            this.drg = bundle.getInt(InviteFriendListActivityConfig.GROUP_ID, -1);
        }
    }

    public void l(Bundle bundle) {
        bundle.putInt("gid", this.djH);
        bundle.putInt(InviteFriendListActivityConfig.GROUP_ID, this.drg);
    }

    public void ms(String str) {
        this.drf = c(this.djH, this.drg, str);
        super.sendMessage(this.drf);
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
