package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private RequestCommitInviteMessage gTC;
    private long gTD;
    private long gyY;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.gyY = intent.getLongExtra("gid", -1L);
            this.gTD = intent.getLongExtra("groupid", -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.gyY = bundle.getLong("gid", -1L);
            this.gTD = bundle.getLong("groupid", -1L);
        }
    }

    public void X(Bundle bundle) {
        bundle.putLong("gid", this.gyY);
        bundle.putLong("groupid", this.gTD);
    }

    public void yx(String str) {
        this.gTC = b(this.gyY, this.gTD, str);
        super.sendMessage(this.gTC);
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
