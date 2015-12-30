package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes.dex */
public class c {
    private List<DressItemData> dNe;
    private String groupName;

    public void a(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain != null) {
            this.groupName = themeBubbleInMain.bubble_category;
            this.dNe = new ArrayList();
            for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
                this.dNe.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<DressItemData> getBubbleList() {
        return this.dNe;
    }
}
