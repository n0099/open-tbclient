package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.GetPrivateInfo.GetPrivateInfoResIdl;
/* loaded from: classes.dex */
public class ResponsedPrivacyHttpMessage extends HttpResponsedMessage {
    private a privacyData;

    public ResponsedPrivacyHttpMessage(int i) {
        super(i);
        this.privacyData = new a();
    }

    public a getPrivacyData() {
        return this.privacyData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetPrivateInfoResIdl getPrivateInfoResIdl = (GetPrivateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPrivateInfoResIdl.class);
        if (getPrivateInfoResIdl != null && getPrivateInfoResIdl.data != null) {
            if (getPrivateInfoResIdl.error != null) {
                setError(getPrivateInfoResIdl.error.errorno.intValue());
                setErrorString(getPrivateInfoResIdl.error.usermsg);
            }
            if (getPrivateInfoResIdl.data.like != null) {
                this.privacyData.hQ(getPrivateInfoResIdl.data.like.intValue());
            }
            if (getPrivateInfoResIdl.data.group != null) {
                this.privacyData.hR(getPrivateInfoResIdl.data.group.intValue());
            }
            if (getPrivateInfoResIdl.data.post != null) {
                this.privacyData.hP(getPrivateInfoResIdl.data.post.intValue());
            }
            if (getPrivateInfoResIdl.data.location != null) {
                this.privacyData.hS(getPrivateInfoResIdl.data.location.intValue());
            }
        }
    }
}
