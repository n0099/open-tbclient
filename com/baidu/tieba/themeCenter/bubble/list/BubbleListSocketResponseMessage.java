package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleList.GetBubbleListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class BubbleListSocketResponseMessage extends SocketResponsedMessage {
    private boolean hasMore;
    private boolean isDefault;
    private List<DressItemData> mDressItemList;
    private k mRecommand;

    public BubbleListSocketResponseMessage() {
        super(309031);
        this.hasMore = true;
        this.isDefault = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetBubbleListResIdl getBubbleListResIdl = (GetBubbleListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleListResIdl.class);
        if (getBubbleListResIdl != null) {
            if (getBubbleListResIdl.error != null) {
                setError(getBubbleListResIdl.error.errorno.intValue());
                setErrorString(getBubbleListResIdl.error.usermsg);
            }
            if (getBubbleListResIdl.data != null) {
                if (getBubbleListResIdl.data.recommend != null) {
                    this.mRecommand = new k();
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

    public k getRecommand() {
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
