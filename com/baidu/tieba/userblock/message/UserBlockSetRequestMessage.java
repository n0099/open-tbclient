package com.baidu.tieba.userblock.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.PermissionList;
import tbclient.SetUserBlack.DataReq;
import tbclient.SetUserBlack.SetUserBlackReqIdl;
/* loaded from: classes5.dex */
public class UserBlockSetRequestMessage extends NetMessage {
    public int chat;
    public int follow;
    public int interact;
    public long mBlockUserId;

    public UserBlockSetRequestMessage() {
        super(CmdConfigHttp.CMD_USER_BLOCK_SET, 309697);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.black_uid = Long.valueOf(this.mBlockUserId);
        PermissionList.Builder builder2 = new PermissionList.Builder();
        builder2.follow = Integer.valueOf(this.follow);
        builder2.interact = Integer.valueOf(this.interact);
        builder2.chat = Integer.valueOf(this.chat);
        builder.perm_list = builder2.build(true);
        if (z) {
            w.a(builder, true);
        }
        SetUserBlackReqIdl.Builder builder3 = new SetUserBlackReqIdl.Builder();
        builder3.data = builder.build(false);
        return builder3.build(false);
    }

    public long getBlockUserId() {
        return this.mBlockUserId;
    }

    public void setBlockUserId(long j) {
        this.mBlockUserId = j;
    }

    public void setChat(int i2) {
        this.chat = i2;
    }

    public void setFollow(int i2) {
        this.follow = i2;
    }

    public void setInteract(int i2) {
        this.interact = i2;
    }
}
