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
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetPrivateInfoResIdl getPrivateInfoResIdl = (GetPrivateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPrivateInfoResIdl.class);
        if (getPrivateInfoResIdl != null) {
            if (getPrivateInfoResIdl.error != null) {
                setError(getPrivateInfoResIdl.error.errorno.intValue());
                setErrorString(getPrivateInfoResIdl.error.errmsg);
            }
            if (getPrivateInfoResIdl.data != null) {
                if (getPrivateInfoResIdl.data.like != null) {
                    this.privacyData.Iy(getPrivateInfoResIdl.data.like.intValue());
                }
                if (getPrivateInfoResIdl.data.group != null) {
                    this.privacyData.IA(getPrivateInfoResIdl.data.group.intValue());
                }
                if (getPrivateInfoResIdl.data.post != null) {
                    this.privacyData.Ix(getPrivateInfoResIdl.data.post.intValue());
                }
                if (getPrivateInfoResIdl.data.location != null) {
                    this.privacyData.IB(getPrivateInfoResIdl.data.location.intValue());
                }
                if (getPrivateInfoResIdl.data.user != null) {
                    this.privacyData.b(getPrivateInfoResIdl.data.user);
                }
                if (getPrivateInfoResIdl.data.live != null) {
                    this.privacyData.Iz(getPrivateInfoResIdl.data.live.intValue());
                }
                if (getPrivateInfoResIdl.data.forum_num != null) {
                    this.privacyData.IC(getPrivateInfoResIdl.data.forum_num.intValue());
                }
                if (getPrivateInfoResIdl.data.reply != null) {
                    this.privacyData.ID(getPrivateInfoResIdl.data.reply.intValue());
                }
                if (getPrivateInfoResIdl.data.bazhu_show_inside != null) {
                    this.privacyData.IE(getPrivateInfoResIdl.data.bazhu_show_inside.intValue());
                }
                if (getPrivateInfoResIdl.data.bazhu_show_outside != null) {
                    this.privacyData.IF(getPrivateInfoResIdl.data.bazhu_show_outside.intValue());
                }
            }
        }
    }
}
