package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class h {
    private String desc;
    private String imgUrl;
    private String leA;
    private int leB;
    private int leD;
    private String leE;
    private String leF;
    private String linkUrl;
    private int propsID;
    private String title;
    private int updateType;

    public h(VipThemeItem vipThemeItem) {
        this.imgUrl = vipThemeItem.img_url;
        this.title = vipThemeItem.title;
        this.propsID = vipThemeItem.props_id.intValue();
        this.leD = vipThemeItem.props_category.intValue();
        this.leE = vipThemeItem.props_category_name;
        this.desc = vipThemeItem.desc;
        this.linkUrl = vipThemeItem.link;
        this.leF = vipThemeItem.tag_img_url;
        this.leA = vipThemeItem.update_time;
        this.leB = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
