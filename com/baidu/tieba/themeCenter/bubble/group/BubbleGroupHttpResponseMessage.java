package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.j3.f.b.b;
import d.b.i0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBubbleByCategory.DataRes;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryResIdl;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
/* loaded from: classes5.dex */
public class BubbleGroupHttpResponseMessage extends TbHttpResponsedMessage {
    public List<b> mBubbleGroupList;
    public e mRecommand;

    public BubbleGroupHttpResponseMessage(int i) {
        super(i);
    }

    public List<b> getGroupList() {
        return this.mBubbleGroupList;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBubbleByCategoryResIdl getBubbleByCategoryResIdl = (GetBubbleByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleByCategoryResIdl.class);
        if (getBubbleByCategoryResIdl == null) {
            return;
        }
        Error error = getBubbleByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBubbleByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getBubbleByCategoryResIdl.data;
        if (dataRes != null) {
            if (dataRes.recommend != null) {
                e eVar = new e();
                this.mRecommand = eVar;
                eVar.d(getBubbleByCategoryResIdl.data.recommend);
            }
            if (getBubbleByCategoryResIdl.data.bubbles != null) {
                this.mBubbleGroupList = new ArrayList();
                for (ThemeBubbleInMain themeBubbleInMain : getBubbleByCategoryResIdl.data.bubbles) {
                    if (themeBubbleInMain != null && !StringUtils.isNull(themeBubbleInMain.bubble_category)) {
                        b bVar = new b();
                        bVar.c(themeBubbleInMain);
                        this.mBubbleGroupList.add(bVar);
                    }
                }
            }
        }
    }
}
