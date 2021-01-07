package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.themeCenter.dressCenter.e;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.GetCardByCategoryResIdl;
import tbclient.GetCardByCategory.ThemeCardInMain;
/* loaded from: classes9.dex */
public class PersonalCardCategorySocktResponse extends SocketResponsedMessage {
    private boolean hasMore;
    private List<a> mCardCategoryList;
    private e mRecommand;

    public PersonalCardCategorySocktResponse() {
        super(CmdConfigSocket.CMD_GET_CARD_BY_CATEGORY);
        this.hasMore = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetCardByCategoryResIdl getCardByCategoryResIdl = (GetCardByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardByCategoryResIdl.class);
        if (getCardByCategoryResIdl != null) {
            if (getCardByCategoryResIdl.error != null) {
                setError(getCardByCategoryResIdl.error.errorno.intValue());
                setErrorString(getCardByCategoryResIdl.error.usermsg);
            }
            if (getCardByCategoryResIdl.data != null) {
                if (getCardByCategoryResIdl.data.has_more.intValue() == 1) {
                    this.hasMore = true;
                } else {
                    this.hasMore = false;
                }
                if (getCardByCategoryResIdl.data.recommend != null) {
                    this.mRecommand = new e();
                    this.mRecommand.a(getCardByCategoryResIdl.data.recommend);
                }
                List<ThemeCardInMain> list = getCardByCategoryResIdl.data.cards;
                if (list != null && list.size() > 0) {
                    this.mCardCategoryList = new ArrayList();
                    for (ThemeCardInMain themeCardInMain : list) {
                        if (themeCardInMain != null) {
                            a aVar = new a();
                            aVar.a(themeCardInMain);
                            this.mCardCategoryList.add(aVar);
                        }
                    }
                }
            }
        }
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public List<a> getCardCategoryList() {
        return this.mCardCategoryList;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }
}
