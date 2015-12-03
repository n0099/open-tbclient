package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgList.GetBgListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class BackgroundListSocketResponseMessage extends SocketResponsedMessage {
    private boolean hasMore;
    private List<DressItemData> mBackgroundList;
    private int mIsDefault;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;

    public BackgroundListSocketResponseMessage() {
        super(309021);
        this.hasMore = true;
        this.mIsDefault = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetBgListResIdl getBgListResIdl = (GetBgListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgListResIdl.class);
        if (getBgListResIdl != null) {
            if (getBgListResIdl.error != null) {
                setError(getBgListResIdl.error.errorno.intValue());
                setErrorString(getBgListResIdl.error.usermsg);
            }
            if (getBgListResIdl.data != null) {
                if (getBgListResIdl.data.recommend != null) {
                    this.mRecommand = new com.baidu.tieba.themeCenter.dressCenter.k();
                    this.mRecommand.a(getBgListResIdl.data.recommend);
                }
                this.mIsDefault = getBgListResIdl.data.is_default.intValue();
                if (getBgListResIdl.data.bgs != null) {
                    this.mBackgroundList = new ArrayList();
                    for (ThemeBgProp themeBgProp : getBgListResIdl.data.bgs) {
                        if (themeBgProp != null && !StringUtils.isNull(themeBgProp.title)) {
                            this.mBackgroundList.add(new DressItemData(themeBgProp));
                        }
                    }
                }
                this.hasMore = getBgListResIdl.data.hasmore.intValue() == 1;
            }
        }
    }

    public com.baidu.tieba.themeCenter.dressCenter.k getRecommand() {
        return this.mRecommand;
    }

    public List<DressItemData> getBackgroundList() {
        return this.mBackgroundList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setIsDefault(boolean z) {
        this.mIsDefault = z ? 1 : 0;
    }

    public boolean getIsDefault() {
        return this.mIsDefault == 1;
    }
}
