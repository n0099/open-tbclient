package com.baidu.tieba.themeCenter.card.category;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.j0.j3.g.a.a;
import d.b.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetCardByCategory.DataRes;
import tbclient.GetCardByCategory.GetCardByCategoryResIdl;
import tbclient.GetCardByCategory.ThemeCardInMain;
/* loaded from: classes5.dex */
public class PersonalCardCategoryHttpResponse extends TbHttpResponsedMessage {
    public boolean hasMore;
    public List<a> mCardCategoryList;
    public e mRecommand;

    public PersonalCardCategoryHttpResponse(int i) {
        super(i);
        this.hasMore = true;
    }

    public List<a> getCardCategoryList() {
        return this.mCardCategoryList;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetCardByCategoryResIdl getCardByCategoryResIdl = (GetCardByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardByCategoryResIdl.class);
        if (getCardByCategoryResIdl == null) {
            return;
        }
        Error error = getCardByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getCardByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getCardByCategoryResIdl.data;
        if (dataRes == null) {
            return;
        }
        if (dataRes.has_more.intValue() == 1) {
            this.hasMore = true;
        } else {
            this.hasMore = false;
        }
        if (getCardByCategoryResIdl.data.recommend != null) {
            e eVar = new e();
            this.mRecommand = eVar;
            eVar.d(getCardByCategoryResIdl.data.recommend);
        }
        List<ThemeCardInMain> list = getCardByCategoryResIdl.data.cards;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mCardCategoryList = new ArrayList();
        for (ThemeCardInMain themeCardInMain : list) {
            if (themeCardInMain != null) {
                a aVar = new a();
                aVar.c(themeCardInMain);
                this.mCardCategoryList.add(aVar);
            }
        }
    }
}
