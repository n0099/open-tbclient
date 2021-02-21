package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes9.dex */
public class a {
    private List<DressItemData> mAvatarPendantList;
    private String nGm;

    public void a(ThemePendantInMain themePendantInMain) {
        if (themePendantInMain != null) {
            this.nGm = themePendantInMain.pendant_category;
            this.mAvatarPendantList = new ArrayList();
            for (ThemeBgProp themeBgProp : themePendantInMain.props) {
                this.mAvatarPendantList.add(new DressItemData(themeBgProp));
            }
        }
    }

    public String dRg() {
        return this.nGm;
    }

    public List<DressItemData> dRh() {
        return this.mAvatarPendantList;
    }
}
