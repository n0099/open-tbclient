package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.GetDislikeList.GetDislikeListResIdl;
/* loaded from: classes7.dex */
public class ForbiddenForumHttpResMsg extends HttpResponsedMessage {
    private d pageData;

    public d getPageData() {
        return this.pageData;
    }

    public ForbiddenForumHttpResMsg() {
        super(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetDislikeListResIdl getDislikeListResIdl = (GetDislikeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetDislikeListResIdl.class);
        if (getDislikeListResIdl != null) {
            if (getDislikeListResIdl.error != null) {
                if (getDislikeListResIdl.error.errorno != null) {
                    setError(getDislikeListResIdl.error.errorno.intValue());
                }
                setErrorString(getDislikeListResIdl.error.usermsg);
            }
            this.pageData = new d();
            this.pageData.a(getDislikeListResIdl.data);
        }
    }
}
