package com.baidu.tieba.themeCenter.background;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class c {
    private List<DressItemData> deG;
    private String groupName;

    public void a(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain != null) {
            this.groupName = themeBgInMain.bg_category;
            this.deG = new ArrayList();
            for (ThemeBgProp themeBgProp : themeBgInMain.props) {
                this.deG.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<DressItemData> getBackgroundList() {
        return this.deG;
    }
}
