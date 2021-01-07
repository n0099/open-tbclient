package com.baidu.tieba.themeCenter.card.category;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes9.dex */
public class a {
    private String aJs;
    private ArrayList<com.baidu.tieba.themeCenter.a> nCN;

    public void a(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain != null) {
            this.aJs = themeCardInMain.card_category;
            List<ThemeCardPropMain> list = themeCardInMain.props;
            if (list != null && list.size() > 0) {
                this.nCN = new ArrayList<>();
                for (ThemeCardPropMain themeCardPropMain : list) {
                    if (themeCardPropMain != null) {
                        com.baidu.tieba.themeCenter.a aVar = new com.baidu.tieba.themeCenter.a();
                        aVar.a(themeCardPropMain);
                        this.nCN.add(aVar);
                    }
                }
            }
        }
    }

    public String getCategoryName() {
        return this.aJs;
    }

    public ArrayList<com.baidu.tieba.themeCenter.a> dSP() {
        return this.nCN;
    }
}
