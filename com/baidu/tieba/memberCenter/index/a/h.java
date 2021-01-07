package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class h {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private String ljf;
    private int ljg;
    private int lji;
    private String ljj;
    private String ljk;
    private int propsID;
    private String title;
    private int updateType;

    public h(VipThemeItem vipThemeItem) {
        this.imgUrl = vipThemeItem.img_url;
        this.title = vipThemeItem.title;
        this.propsID = vipThemeItem.props_id.intValue();
        this.lji = vipThemeItem.props_category.intValue();
        this.ljj = vipThemeItem.props_category_name;
        this.desc = vipThemeItem.desc;
        this.linkUrl = vipThemeItem.link;
        this.ljk = vipThemeItem.tag_img_url;
        this.ljf = vipThemeItem.update_time;
        this.ljg = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
