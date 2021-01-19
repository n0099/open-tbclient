package com.baidu.tieba.themeCenter.background;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes8.dex */
public class b {
    private String groupName;
    private List<DressItemData> nwM;

    public void a(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain != null) {
            this.groupName = themeBgInMain.bg_category;
            this.nwM = new ArrayList();
            for (ThemeBgProp themeBgProp : themeBgInMain.props) {
                this.nwM.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<DressItemData> getBackgroundList() {
        return this.nwM;
    }
}
