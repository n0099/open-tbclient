package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.j0.v2.a.d;
import tbclient.Error;
import tbclient.GetDislikeList.GetDislikeListResIdl;
/* loaded from: classes5.dex */
public class ForbiddenForumHttpResMsg extends HttpResponsedMessage {
    public d pageData;

    public ForbiddenForumHttpResMsg() {
        super(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM);
    }

    public d getPageData() {
        return this.pageData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetDislikeListResIdl getDislikeListResIdl = (GetDislikeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetDislikeListResIdl.class);
        if (getDislikeListResIdl == null) {
            return;
        }
        Error error = getDislikeListResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getDislikeListResIdl.error.usermsg);
        }
        d dVar = new d();
        this.pageData = dVar;
        dVar.a(getDislikeListResIdl.data);
    }
}
