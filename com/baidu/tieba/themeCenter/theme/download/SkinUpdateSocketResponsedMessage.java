package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetUpdateInfo.GetUpdateInfoResIdl;
import tbclient.GetUpdateInfo.ThemeSkinUpdateInfo;
/* loaded from: classes.dex */
public class SkinUpdateSocketResponsedMessage extends SocketResponsedMessage {
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;

    public SkinUpdateSocketResponsedMessage() {
        super(309013);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
