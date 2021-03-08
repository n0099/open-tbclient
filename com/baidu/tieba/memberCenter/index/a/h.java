package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class h {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private String loX;
    private int loY;
    private int lpa;
    private String lpb;
    private String lpc;
    private int propsID;
    private String title;
    private int updateType;

    public h(VipThemeItem vipThemeItem) {
        this.imgUrl = vipThemeItem.img_url;
        this.title = vipThemeItem.title;
        this.propsID = vipThemeItem.props_id.intValue();
        this.lpa = vipThemeItem.props_category.intValue();
        this.lpb = vipThemeItem.props_category_name;
        this.desc = vipThemeItem.desc;
        this.linkUrl = vipThemeItem.link;
        this.lpc = vipThemeItem.tag_img_url;
        this.loX = vipThemeItem.update_time;
        this.loY = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
