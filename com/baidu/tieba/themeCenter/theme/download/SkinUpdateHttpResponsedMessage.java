package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetUpdateInfo.GetUpdateInfoResIdl;
import tbclient.GetUpdateInfo.ThemeSkinUpdateInfo;
/* loaded from: classes.dex */
public class SkinUpdateHttpResponsedMessage extends TbHttpResponsedMessage {
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;

    public SkinUpdateHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetUpdateInfoResIdl getUpdateInfoResIdl = (GetUpdateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUpdateInfoResIdl.class);
        if (getUpdateInfoResIdl != null) {
            if (getUpdateInfoResIdl.error != null) {
                setError(getUpdateInfoResIdl.error.errorno.intValue());
                setErrorString(getUpdateInfoResIdl.error.usermsg);
            }
            if (getUpdateInfoResIdl.data != null && getUpdateInfoResIdl.data.props != null && getUpdateInfoResIdl.data.props.size() > 0) {
                this.mUpdateList = new ArrayList<>();
                this.mUpdateList.addAll(getUpdateInfoResIdl.data.props);
            }
        }
    }

    public ArrayList<ThemeSkinUpdateInfo> getUpdateList() {
        return this.mUpdateList;
    }
}
