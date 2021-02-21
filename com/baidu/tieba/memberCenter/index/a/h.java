package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class h {
    private String desc;
    private String imgUrl;
    private String linkUrl;
    private String lmQ;
    private int lmR;
    private int lmT;
    private String lmU;
    private String lmV;
    private int propsID;
    private String title;
    private int updateType;

    public h(VipThemeItem vipThemeItem) {
        this.imgUrl = vipThemeItem.img_url;
        this.title = vipThemeItem.title;
        this.propsID = vipThemeItem.props_id.intValue();
        this.lmT = vipThemeItem.props_category.intValue();
        this.lmU = vipThemeItem.props_category_name;
        this.desc = vipThemeItem.desc;
        this.linkUrl = vipThemeItem.link;
        this.lmV = vipThemeItem.tag_img_url;
        this.lmQ = vipThemeItem.update_time;
        this.lmR = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
