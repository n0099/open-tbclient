package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinByCategory.ThemeSkinInMain;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class a {
    private String dOJ;
    private List<com.baidu.tieba.themeCenter.b> dOK;

    public void a(ThemeSkinInMain themeSkinInMain) {
        if (themeSkinInMain != null) {
            this.dOJ = themeSkinInMain.skin_category;
            if (themeSkinInMain.props != null && themeSkinInMain.props.size() > 0) {
                this.dOK = new ArrayList();
                for (ThemeSkinPropMain themeSkinPropMain : themeSkinInMain.props) {
                    if (themeSkinPropMain != null && !StringUtils.isNull(themeSkinPropMain.title)) {
                        com.baidu.tieba.themeCenter.b bVar = new com.baidu.tieba.themeCenter.b();
                        bVar.a(themeSkinPropMain);
                        this.dOK.add(bVar);
                    }
                }
            }
        }
    }

    public String aHU() {
        return this.dOJ;
    }

    public List<com.baidu.tieba.themeCenter.b> aHV() {
        return this.dOK;
    }

    public void bY(List<com.baidu.tieba.themeCenter.b> list) {
        this.dOK = list;
    }
}
