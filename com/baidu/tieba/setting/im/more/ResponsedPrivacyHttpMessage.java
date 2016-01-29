package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetPrivateInfo.GetPrivateInfoResIdl;
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
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetPrivateInfoResIdl getPrivateInfoResIdl = (GetPrivateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPrivateInfoResIdl.class);
        if (getPrivateInfoResIdl != null) {
            if (getPrivateInfoResIdl.error != null) {
                setError(getPrivateInfoResIdl.error.errorno.intValue());
                setErrorString(getPrivateInfoResIdl.error.errmsg);
            }
            if (getPrivateInfoResIdl.data != null) {
                if (getPrivateInfoResIdl.data.like != null) {
                    this.privacyData.nE(getPrivateInfoResIdl.data.like.intValue());
                }
                if (getPrivateInfoResIdl.data.group != null) {
                    this.privacyData.nF(getPrivateInfoResIdl.data.group.intValue());
                }
                if (getPrivateInfoResIdl.data.post != null) {
                    this.privacyData.nD(getPrivateInfoResIdl.data.post.intValue());
                }
                if (getPrivateInfoResIdl.data.location != null) {
                    this.privacyData.nG(getPrivateInfoResIdl.data.location.intValue());
                }
                if (getPrivateInfoResIdl.data.user != null) {
                    this.privacyData.a(getPrivateInfoResIdl.data.user);
                }
            }
        }
    }
}
