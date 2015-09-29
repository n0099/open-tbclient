package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinByCategory.ThemeSkinInMain;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class a {
    private String dgS;
    private List<com.baidu.tieba.themeCenter.b> dgT;

    public void a(ThemeSkinInMain themeSkinInMain) {
        if (themeSkinInMain != null) {
            this.dgS = themeSkinInMain.skin_category;
            if (themeSkinInMain.props != null && themeSkinInMain.props.size() > 0) {
                this.dgT = new ArrayList();
                for (ThemeSkinPropMain themeSkinPropMain : themeSkinInMain.props) {
                    if (themeSkinPropMain != null && !StringUtils.isNull(themeSkinPropMain.title)) {
                        com.baidu.tieba.themeCenter.b bVar = new com.baidu.tieba.themeCenter.b();
                        bVar.a(themeSkinPropMain);
                        this.dgT.add(bVar);
                    }
                }
            }
        }
    }

    public String azy() {
        return this.dgS;
    }

    public List<com.baidu.tieba.themeCenter.b> azz() {
        return this.dgT;
    }

    public void bC(List<com.baidu.tieba.themeCenter.b> list) {
        this.dgT = list;
    }
}
