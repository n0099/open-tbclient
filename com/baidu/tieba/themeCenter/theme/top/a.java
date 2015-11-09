package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinByCategory.ThemeSkinInMain;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class a {
    private String diY;
    private List<com.baidu.tieba.themeCenter.b> diZ;

    public void a(ThemeSkinInMain themeSkinInMain) {
        if (themeSkinInMain != null) {
            this.diY = themeSkinInMain.skin_category;
            if (themeSkinInMain.props != null && themeSkinInMain.props.size() > 0) {
                this.diZ = new ArrayList();
                for (ThemeSkinPropMain themeSkinPropMain : themeSkinInMain.props) {
                    if (themeSkinPropMain != null && !StringUtils.isNull(themeSkinPropMain.title)) {
                        com.baidu.tieba.themeCenter.b bVar = new com.baidu.tieba.themeCenter.b();
                        bVar.a(themeSkinPropMain);
                        this.diZ.add(bVar);
                    }
                }
            }
        }
    }

    public String aAu() {
        return this.diY;
    }

    public List<com.baidu.tieba.themeCenter.b> aAv() {
        return this.diZ;
    }

    public void bH(List<com.baidu.tieba.themeCenter.b> list) {
        this.diZ = list;
    }
}
