package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetBackground.GetBackgroundResIdl;
/* loaded from: classes8.dex */
public class BackgroundGetHttpResponseMessage extends TbHttpResponsedMessage {
    private DressItemData mBgItem;

    public BackgroundGetHttpResponseMessage() {
        super(1003035);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
                this.mBgItem.setActivityFinish(getBackgroundResIdl.data.is_finished.intValue());
                this.mBgItem.setActivityUrl(getBackgroundResIdl.data.activity_url);
                this.mBgItem.setDailyPrevilegeStatus(getBackgroundResIdl.data.daily_previlege_status.intValue());
            }
        }
    }

    public DressItemData getBgItem() {
        return this.mBgItem;
    }
}
