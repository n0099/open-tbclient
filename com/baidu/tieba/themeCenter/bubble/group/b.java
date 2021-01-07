package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes9.dex */
public class b {
    private String groupName;
    private List<DressItemData> jwx;

    public void a(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain != null) {
            this.groupName = themeBubbleInMain.bubble_category;
            this.jwx = new ArrayList();
            for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
                this.jwx.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<DressItemData> getBubbleList() {
        return this.jwx;
    }
}
