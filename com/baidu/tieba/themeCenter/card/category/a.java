package com.baidu.tieba.themeCenter.card.category;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes8.dex */
public class a {
    private String aHS;
    private ArrayList<com.baidu.tieba.themeCenter.a> nKz;

    public void a(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain != null) {
            this.aHS = themeCardInMain.card_category;
            List<ThemeCardPropMain> list = themeCardInMain.props;
            if (list != null && list.size() > 0) {
                this.nKz = new ArrayList<>();
                for (ThemeCardPropMain themeCardPropMain : list) {
                    if (themeCardPropMain != null) {
                        com.baidu.tieba.themeCenter.a aVar = new com.baidu.tieba.themeCenter.a();
                        aVar.a(themeCardPropMain);
                        this.nKz.add(aVar);
                    }
                }
            }
        }
    }

    public String getCategoryName() {
        return this.aHS;
    }

    public ArrayList<com.baidu.tieba.themeCenter.a> dRz() {
        return this.nKz;
    }
}
