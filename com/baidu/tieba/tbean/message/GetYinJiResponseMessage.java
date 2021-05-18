package com.baidu.tieba.tbean.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.f3.f.a;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.DataRes;
import tbclient.GetIconList.GetIconListResIdl;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class GetYinJiResponseMessage extends SocketResponsedMessage implements a {
    public List<Custom> customList;
    public List<IconInfo> iconInfoList;
    public Setting setting;
    public UserInfo userInfo;

    public GetYinJiResponseMessage() {
        super(306001);
    }

    @Override // d.a.k0.f3.f.a
    public List<Custom> getCustomList() {
        return this.customList;
    }

    @Override // d.a.k0.f3.f.a
    public List<IconInfo> getIconInfoList() {
        return this.iconInfoList;
    }

    @Override // d.a.k0.f3.f.a
    public Setting getSetting() {
        return this.setting;
    }

    @Override // d.a.k0.f3.f.a
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetIconListResIdl getIconListResIdl = (GetIconListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetIconListResIdl.class);
        setError(getIconListResIdl.error.errorno.intValue());
        setErrorString(getIconListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        DataRes dataRes = getIconListResIdl.data;
        this.userInfo = dataRes.user_info;
        this.iconInfoList = dataRes.icon_info;
        this.customList = dataRes.custom;
        this.setting = dataRes.setting;
    }
}
