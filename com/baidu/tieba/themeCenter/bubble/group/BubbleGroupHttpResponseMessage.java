package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryResIdl;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
/* loaded from: classes.dex */
public class BubbleGroupHttpResponseMessage extends TbHttpResponsedMessage {
    private List<c> mBubbleGroupList;
    private k mRecommand;

    public BubbleGroupHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetBubbleByCategoryResIdl getBubbleByCategoryResIdl = (GetBubbleByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleByCategoryResIdl.class);
        if (getBubbleByCategoryResIdl != null) {
            if (getBubbleByCategoryResIdl.error != null) {
                setError(getBubbleByCategoryResIdl.error.errorno.intValue());
                setErrorString(getBubbleByCategoryResIdl.error.usermsg);
            }
            if (getBubbleByCategoryResIdl.data != null) {
                if (getBubbleByCategoryResIdl.data.recommend != null) {
                    this.mRecommand = new k();
                    this.mRecommand.a(getBubbleByCategoryResIdl.data.recommend);
                }
                if (getBubbleByCategoryResIdl.data.bubbles != null) {
                    this.mBubbleGroupList = new ArrayList();
                    for (ThemeBubbleInMain themeBubbleInMain : getBubbleByCategoryResIdl.data.bubbles) {
                        if (themeBubbleInMain != null && !StringUtils.isNull(themeBubbleInMain.bubble_category)) {
                            c cVar = new c();
                            cVar.a(themeBubbleInMain);
                            this.mBubbleGroupList.add(cVar);
                        }
                    }
                }
            }
        }
    }

    public k getRecommand() {
        return this.mRecommand;
    }

    public List<c> getGroupList() {
        return this.mBubbleGroupList;
    }
}
