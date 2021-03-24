package com.baidu.tieba.model.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CheckRealName.CheckRealNameResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class CheckRealNameHttpResponseMessage extends TbHttpResponsedMessage {
    public CheckRealNameHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        CheckRealNameResIdl checkRealNameResIdl = (CheckRealNameResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckRealNameResIdl.class);
        if (bArr == null) {
            return;
        }
        Error error = checkRealNameResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(checkRealNameResIdl.error.errmsg);
            return;
        }
        setError(-1000);
    }
}
