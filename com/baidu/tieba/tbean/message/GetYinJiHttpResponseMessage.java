package com.baidu.tieba.tbean.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.GetIconListResIdl;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes8.dex */
public class GetYinJiHttpResponseMessage extends HttpResponsedMessage implements a {
    private List<Custom> customList;
    private List<IconInfo> iconInfoList;
    private Setting setting;
    private UserInfo userInfo;

    public GetYinJiHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetIconListResIdl getIconListResIdl = (GetIconListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetIconListResIdl.class);
        setError(getIconListResIdl.error.errorno.intValue());
        setErrorString(getIconListResIdl.error.usermsg);
        if (getError() == 0) {
            this.userInfo = getIconListResIdl.data.user_info;
            this.iconInfoList = getIconListResIdl.data.icon_info;
            this.customList = getIconListResIdl.data.custom;
            this.setting = getIconListResIdl.data.setting;
        }
    }

    @Override // com.baidu.tieba.tbean.message.a
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.baidu.tieba.tbean.message.a
    public List<IconInfo> getIconInfoList() {
        return this.iconInfoList;
    }

    @Override // com.baidu.tieba.tbean.message.a
    public Setting getSetting() {
        return this.setting;
    }

    @Override // com.baidu.tieba.tbean.message.a
    public List<Custom> getCustomList() {
        return this.customList;
    }
}
