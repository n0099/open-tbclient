package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetBackground.GetBackgroundResIdl;
/* loaded from: classes.dex */
public class BackgroundGetHttpResponseMessage extends TbHttpResponsedMessage {
    private DressItemData mBgItem;

    public BackgroundGetHttpResponseMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetBackgroundResIdl getBackgroundResIdl = (GetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBackgroundResIdl.class);
        if (getBackgroundResIdl != null) {
            if (getBackgroundResIdl.error != null) {
                setError(getBackgroundResIdl.error.errorno.intValue());
                setErrorString(getBackgroundResIdl.error.usermsg);
            }
            if (getBackgroundResIdl.data != null) {
                this.mBgItem = new DressItemData();
                this.mBgItem.setTitle(getBackgroundResIdl.data.title);
                this.mBgItem.setDescription(getBackgroundResIdl.data.description);
                this.mBgItem.setExampleImgUrl(getBackgroundResIdl.data.pic_url);
                this.mBgItem.setFreeUserLevel(getBackgroundResIdl.data.free_user_level.intValue());
                this.mBgItem.setPermissionImgUrl(getBackgroundResIdl.data.permission);
                this.mBgItem.setPropsStateImg(getBackgroundResIdl.data.props_state_img);
            }
        }
    }

    public DressItemData getBgItem() {
        return this.mBgItem;
    }
}
