package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetBackground.GetBackgroundResIdl;
/* loaded from: classes5.dex */
public class BackgroundGetHttpResponseMessage extends TbHttpResponsedMessage {
    public DressItemData mBgItem;

    public BackgroundGetHttpResponseMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET);
    }

    public DressItemData getBgItem() {
        return this.mBgItem;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetBackgroundResIdl getBackgroundResIdl = (GetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBackgroundResIdl.class);
        if (getBackgroundResIdl == null) {
            return;
        }
        Error error = getBackgroundResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBackgroundResIdl.error.usermsg);
        }
        if (getBackgroundResIdl.data != null) {
            DressItemData dressItemData = new DressItemData();
            this.mBgItem = dressItemData;
            dressItemData.setTitle(getBackgroundResIdl.data.title);
            this.mBgItem.setDescription(getBackgroundResIdl.data.description);
            this.mBgItem.setExampleImgUrl(getBackgroundResIdl.data.pic_url);
            this.mBgItem.setFreeUserLevel(getBackgroundResIdl.data.free_user_level.intValue());
            this.mBgItem.setPermissionImgUrl(getBackgroundResIdl.data.permission);
            this.mBgItem.setPropsStateImg(getBackgroundResIdl.data.props_state_img);
            this.mBgItem.setActivityFinish(getBackgroundResIdl.data.is_finished.intValue());
            this.mBgItem.setActivityUrl(getBackgroundResIdl.data.activity_url);
            this.mBgItem.setDailyPrevilegeStatus(getBackgroundResIdl.data.daily_previlege_status.intValue());
        }
    }
}
