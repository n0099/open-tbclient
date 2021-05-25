package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBgList.DataRes;
import tbclient.GetBgList.GetBgListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class BackgroundListHttpResponseMessage extends TbHttpResponsedMessage {
    public boolean hasMore;
    public List<DressItemData> mBackgroundList;
    public int mIsDefault;
    public e mRecommand;

    public BackgroundListHttpResponseMessage(int i2) {
        super(i2);
        this.hasMore = true;
        this.mIsDefault = 0;
    }

    public List<DressItemData> getBackgroundList() {
        return this.mBackgroundList;
    }

    public boolean getIsDefault() {
        return this.mIsDefault == 1;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setIsDefault(boolean z) {
        this.mIsDefault = z ? 1 : 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetBgListResIdl getBgListResIdl = (GetBgListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgListResIdl.class);
        if (getBgListResIdl == null) {
            return;
        }
        Error error = getBgListResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBgListResIdl.error.usermsg);
        }
        DataRes dataRes = getBgListResIdl.data;
        if (dataRes != null) {
            if (dataRes.recommend != null) {
                e eVar = new e();
                this.mRecommand = eVar;
                eVar.d(getBgListResIdl.data.recommend);
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
