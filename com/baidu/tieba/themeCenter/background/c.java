package com.baidu.tieba.themeCenter.background;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class c {
    private List<DressItemData> dgM;
    private String groupName;

    public void a(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain != null) {
            this.groupName = themeBgInMain.bg_category;
            this.dgM = new ArrayList();
            for (ThemeBgProp themeBgProp : themeBgInMain.props) {
                this.dgM.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<DressItemData> getBackgroundList() {
        return this.dgM;
    }
}
