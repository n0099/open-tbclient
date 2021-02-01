package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SetBackground.SetBackgroundResIdl;
/* loaded from: classes9.dex */
public class BackgroundSetHttpResponseMessage extends TbHttpResponsedMessage {
    public BackgroundSetHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SetBackgroundResIdl setBackgroundResIdl = (SetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, SetBackgroundResIdl.class);
        if (setBackgroundResIdl != null && setBackgroundResIdl.error != null) {
            setError(setBackgroundResIdl.error.errorno.intValue());
            setErrorString(setBackgroundResIdl.error.usermsg);
        }
    }
}
