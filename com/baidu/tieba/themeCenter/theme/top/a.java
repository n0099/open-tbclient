package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinByCategory.ThemeSkinInMain;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class a {
    private String dHi;
    private List<com.baidu.tieba.themeCenter.b> dHj;

    public void a(ThemeSkinInMain themeSkinInMain) {
        if (themeSkinInMain != null) {
            this.dHi = themeSkinInMain.skin_category;
            if (themeSkinInMain.props != null && themeSkinInMain.props.size() > 0) {
                this.dHj = new ArrayList();
                for (ThemeSkinPropMain themeSkinPropMain : themeSkinInMain.props) {
                    if (themeSkinPropMain != null && !StringUtils.isNull(themeSkinPropMain.title)) {
                        com.baidu.tieba.themeCenter.b bVar = new com.baidu.tieba.themeCenter.b();
                        bVar.a(themeSkinPropMain);
                        this.dHj.add(bVar);
                    }
                }
            }
        }
    }

    public String aFF() {
        return this.dHi;
    }

    public List<com.baidu.tieba.themeCenter.b> aFG() {
        return this.dHj;
    }

    public void bV(List<com.baidu.tieba.themeCenter.b> list) {
        this.dHj = list;
    }
}
