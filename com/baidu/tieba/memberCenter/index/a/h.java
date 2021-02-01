package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class h {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private String lmC;
    private int lmD;
    private int lmF;
    private String lmG;
    private String lmH;
    private int propsID;
    private String title;
    private int updateType;

    public h(VipThemeItem vipThemeItem) {
        this.imgUrl = vipThemeItem.img_url;
        this.title = vipThemeItem.title;
        this.propsID = vipThemeItem.props_id.intValue();
        this.lmF = vipThemeItem.props_category.intValue();
        this.lmG = vipThemeItem.props_category_name;
        this.desc = vipThemeItem.desc;
        this.linkUrl = vipThemeItem.link;
        this.lmH = vipThemeItem.tag_img_url;
        this.lmC = vipThemeItem.update_time;
        this.lmD = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
