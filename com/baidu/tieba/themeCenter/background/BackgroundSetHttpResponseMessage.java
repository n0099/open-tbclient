package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetBackground.SetBackgroundResIdl;
/* loaded from: classes5.dex */
public class BackgroundSetHttpResponseMessage extends TbHttpResponsedMessage {
    public BackgroundSetHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        SetBackgroundResIdl setBackgroundResIdl = (SetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, SetBackgroundResIdl.class);
        if (setBackgroundResIdl == null || (error = setBackgroundResIdl.error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(setBackgroundResIdl.error.usermsg);
    }
}
