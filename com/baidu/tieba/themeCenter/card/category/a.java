package com.baidu.tieba.themeCenter.card.category;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes8.dex */
public class a {
    private String aEF;
    private ArrayList<com.baidu.tieba.themeCenter.a> nyj;

    public void a(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain != null) {
            this.aEF = themeCardInMain.card_category;
            List<ThemeCardPropMain> list = themeCardInMain.props;
            if (list != null && list.size() > 0) {
                this.nyj = new ArrayList<>();
                for (ThemeCardPropMain themeCardPropMain : list) {
                    if (themeCardPropMain != null) {
                        com.baidu.tieba.themeCenter.a aVar = new com.baidu.tieba.themeCenter.a();
                        aVar.a(themeCardPropMain);
                        this.nyj.add(aVar);
                    }
                }
            }
        }
    }

    public String getCategoryName() {
        return this.aEF;
    }

    public ArrayList<com.baidu.tieba.themeCenter.a> dOX() {
        return this.nyj;
    }
}
