package com.baidu.tieba.tbean;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetIconList.GetIconListResIdl;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes.dex */
public class GetYinJiResponseMessage extends SocketResponsedMessage {
    private List<IconInfo> iconInfoList;
    private UserInfo userInfo;

    public GetYinJiResponseMessage() {
        super(306001);
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public List<IconInfo> getIconInfoList() {
        return this.iconInfoList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetIconListResIdl getIconListResIdl = (GetIconListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetIconListResIdl.class);
        setError(getIconListResIdl.error.errorno.intValue());
        setErrorString(getIconListResIdl.error.usermsg);
        if (getError() == 0) {
            this.userInfo = getIconListResIdl.data.user_info;
            this.iconInfoList = getIconListResIdl.data.icon_info;
        }
    }
}
