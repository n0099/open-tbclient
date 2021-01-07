package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.e;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleList.GetBubbleListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes9.dex */
public class BubbleListHttpResponseMessage extends TbHttpResponsedMessage {
    private boolean hasMore;
    private boolean isDefault;
    private List<DressItemData> mDressItemList;
    private e mRecommand;

    public BubbleListHttpResponseMessage(int i) {
        super(i);
        this.hasMore = true;
        this.isDefault = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBubbleListResIdl getBubbleListResIdl = (GetBubbleListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleListResIdl.class);
        if (getBubbleListResIdl != null) {
            if (getBubbleListResIdl.error != null) {
                setError(getBubbleListResIdl.error.errorno.intValue());
                setErrorString(getBubbleListResIdl.error.usermsg);
            }
            if (getBubbleListResIdl.data != null) {
                if (getBubbleListResIdl.data.recommend != null) {
                    this.mRecommand = new e();
                    this.mRecommand.a(getBubbleListResIdl.data.recommend);
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

    public e getRecommand() {
        return this.mRecommand;
    }

    public List<DressItemData> getBubbleList() {
        return this.mDressItemList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean isDefault() {
        return this.isDefault;
    }
}
