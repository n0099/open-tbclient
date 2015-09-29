package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.squareup.wire.Wire;
import tbclient.GetBackground.GetBackgroundResIdl;
/* loaded from: classes.dex */
public class BackgroundGetSocketResponseMessage extends SocketResponsedMessage {
    private DressItemData mBgItem;

    public BackgroundGetSocketResponseMessage() {
        super(309023);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetBackgroundResIdl getBackgroundResIdl = (GetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBackgroundResIdl.class);
        if (getBackgroundResIdl != null) {
            if (getBackgroundResIdl.error != null) {
                setError(getBackgroundResIdl.error.errorno.intValue());
                setErrorString(getBackgroundResIdl.error.usermsg);
            }
            if (getBackgroundResIdl.data != null && !StringUtils.isNull(getBackgroundResIdl.data.title)) {
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
