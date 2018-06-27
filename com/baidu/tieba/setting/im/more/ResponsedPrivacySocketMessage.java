package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetPrivateInfo.GetPrivateInfoResIdl;
/* loaded from: classes.dex */
public class ResponsedPrivacySocketMessage extends SocketResponsedMessage {
    private a privacyData;

    public ResponsedPrivacySocketMessage() {
        super(303016);
        this.privacyData = new a();
    }

    public a getPrivacyData() {
        return this.privacyData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetPrivateInfoResIdl getPrivateInfoResIdl = (GetPrivateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPrivateInfoResIdl.class);
        if (getPrivateInfoResIdl.error != null) {
            setError(getPrivateInfoResIdl.error.errorno.intValue());
            setErrorString(getPrivateInfoResIdl.error.errmsg);
        }
        if (getPrivateInfoResIdl.data != null) {
            if (getPrivateInfoResIdl.data.like != null) {
                this.privacyData.sE(getPrivateInfoResIdl.data.like.intValue());
            }
            if (getPrivateInfoResIdl.data.group != null) {
                this.privacyData.sG(getPrivateInfoResIdl.data.group.intValue());
            }
            if (getPrivateInfoResIdl.data.post != null) {
                this.privacyData.sD(getPrivateInfoResIdl.data.post.intValue());
            }
            if (getPrivateInfoResIdl.data.location != null) {
                this.privacyData.sH(getPrivateInfoResIdl.data.location.intValue());
            }
            if (getPrivateInfoResIdl.data.user != null) {
                this.privacyData.b(getPrivateInfoResIdl.data.user);
            }
            if (getPrivateInfoResIdl.data.live != null) {
                this.privacyData.sF(getPrivateInfoResIdl.data.live.intValue());
            }
            if (getPrivateInfoResIdl.data.forum_num != null) {
                this.privacyData.sI(getPrivateInfoResIdl.data.forum_num.intValue());
            }
            if (getPrivateInfoResIdl.data.reply != null) {
                this.privacyData.sJ(getPrivateInfoResIdl.data.reply.intValue());
            }
        }
    }
}
