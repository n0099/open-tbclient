package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestCommitInviteMessage;
import protobuf.CommitInviteMsg.DataReq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends BdBaseModel<InviteFriendListActivity> {
    private RequestCommitInviteMessage eFD;
    private long eFE;
    private long ekS;

    public e(InviteFriendListActivity inviteFriendListActivity) {
        super(inviteFriendListActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.ekS = intent.getLongExtra("gid", -1L);
            this.eFE = intent.getLongExtra(InviteFriendListActivityConfig.GROUP_ID, -1L);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.ekS = bundle.getLong("gid", -1L);
            this.eFE = bundle.getLong(InviteFriendListActivityConfig.GROUP_ID, -1L);
        }
    }

    public void s(Bundle bundle) {
        bundle.putLong("gid", this.ekS);
        bundle.putLong(InviteFriendListActivityConfig.GROUP_ID, this.eFE);
    }

    public void oX(String str) {
        this.eFD = a(this.ekS, this.eFE, str);
        super.sendMessage(this.eFD);
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
