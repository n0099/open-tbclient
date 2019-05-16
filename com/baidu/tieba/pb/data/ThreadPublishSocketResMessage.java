package com.baidu.tieba.pb.data;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ThreadPublish.ThreadPublishResIdl;
/* loaded from: classes4.dex */
public class ThreadPublishSocketResMessage extends TbSocketReponsedMessage {
    public ThreadPublishSocketResMessage() {
        super(309644);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ThreadPublishResIdl threadPublishResIdl = (ThreadPublishResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadPublishResIdl.class);
        if (threadPublishResIdl != null) {
            setError(threadPublishResIdl.error.errorno.intValue());
            setErrorString(threadPublishResIdl.error.usermsg);
        }
    }
}
