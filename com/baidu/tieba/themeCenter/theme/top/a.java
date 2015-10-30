package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinByCategory.ThemeSkinInMain;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class a {
    private String dhs;
    private List<com.baidu.tieba.themeCenter.b> dht;

    public void a(ThemeSkinInMain themeSkinInMain) {
        if (themeSkinInMain != null) {
            this.dhs = themeSkinInMain.skin_category;
            if (themeSkinInMain.props != null && themeSkinInMain.props.size() > 0) {
                this.dht = new ArrayList();
                for (ThemeSkinPropMain themeSkinPropMain : themeSkinInMain.props) {
                    if (themeSkinPropMain != null && !StringUtils.isNull(themeSkinPropMain.title)) {
                        com.baidu.tieba.themeCenter.b bVar = new com.baidu.tieba.themeCenter.b();
                        bVar.a(themeSkinPropMain);
                        this.dht.add(bVar);
                    }
                }
            }
        }
    }

    public String azE() {
        return this.dhs;
    }

    public List<com.baidu.tieba.themeCenter.b> azF() {
        return this.dht;
    }

    public void bD(List<com.baidu.tieba.themeCenter.b> list) {
        this.dht = list;
    }
}
