package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgList.GetBgListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class BackgroundListHttpResponseMessage extends TbHttpResponsedMessage {
    private boolean hasMore;
    private List<DressItemData> mBackgroundList;
    private int mIsDefault;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;

    public BackgroundListHttpResponseMessage(int i) {
        super(i);
        this.hasMore = true;
        this.mIsDefault = 0;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
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
