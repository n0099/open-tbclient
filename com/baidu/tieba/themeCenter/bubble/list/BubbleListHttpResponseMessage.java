package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.squareup.wire.Wire;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBubbleList.DataRes;
import tbclient.GetBubbleList.GetBubbleListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class BubbleListHttpResponseMessage extends TbHttpResponsedMessage {
    public boolean hasMore;
    public boolean isDefault;
    public List<DressItemData> mDressItemList;
    public e mRecommand;

    public BubbleListHttpResponseMessage(int i2) {
        super(i2);
        this.hasMore = true;
        this.isDefault = false;
    }

    public List<DressItemData> getBubbleList() {
        return this.mDressItemList;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetBubbleListResIdl getBubbleListResIdl = (GetBubbleListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleListResIdl.class);
        if (getBubbleListResIdl == null) {
            return;
        }
        Error error = getBubbleListResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBubbleListResIdl.error.usermsg);
        }
        DataRes dataRes = getBubbleListResIdl.data;
        if (dataRes != null) {
            if (dataRes.recommend != null) {
                e eVar = new e();
                this.mRecommand = eVar;
                eVar.d(getBubbleListResIdl.data.recommend);
            }
            if (getBubbleListResIdl.data.bubbles != null) {
                this.mDressItemList = new ArrayList();
                for (ThemeBgProp themeBgProp : getBubbleListResIdl.data.bubbles) {
                    if (themeBgProp != null && !StringUtils.isNull(themeBgProp.title)) {
                        this.mDressItemList.add(new DressItemData(themeBgProp));
                    }
                }
            }
            this.hasMore = getBubbleListResIdl.data.hasmore.intValue() == 1;
            this.isDefault = getBubbleListResIdl.data.is_default.intValue() == 1;
        }
    }
}
