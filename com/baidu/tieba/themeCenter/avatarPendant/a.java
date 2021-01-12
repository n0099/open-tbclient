package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes8.dex */
public class a {
    private List<DressItemData> mAvatarPendantList;
    private String nwb;

    public void a(ThemePendantInMain themePendantInMain) {
        if (themePendantInMain != null) {
            this.nwb = themePendantInMain.pendant_category;
            this.mAvatarPendantList = new ArrayList();
            for (ThemeBgProp themeBgProp : themePendantInMain.props) {
                this.mAvatarPendantList.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String dON() {
        return this.nwb;
    }

    public List<DressItemData> dOO() {
        return this.mAvatarPendantList;
    }
}
