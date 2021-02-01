package com.baidu.tieba.themeCenter.card.category;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes9.dex */
public class a {
    private String aGs;
    private ArrayList<com.baidu.tieba.themeCenter.a> nHT;

    public void a(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain != null) {
            this.aGs = themeCardInMain.card_category;
            List<ThemeCardPropMain> list = themeCardInMain.props;
            if (list != null && list.size() > 0) {
                this.nHT = new ArrayList<>();
                for (ThemeCardPropMain themeCardPropMain : list) {
                    if (themeCardPropMain != null) {
                        com.baidu.tieba.themeCenter.a aVar = new com.baidu.tieba.themeCenter.a();
                        aVar.a(themeCardPropMain);
                        this.nHT.add(aVar);
                    }
                }
            }
        }
    }

    public String getCategoryName() {
        return this.aGs;
    }

    public ArrayList<com.baidu.tieba.themeCenter.a> dRi() {
        return this.nHT;
    }
}
