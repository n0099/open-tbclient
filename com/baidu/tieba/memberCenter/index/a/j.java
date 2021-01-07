package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes9.dex */
public class j {
    private int id;
    private String imgUrl;
    private String link;
    private String ljf;
    private int ljg;
    private String ljo;
    private String title;
    private int type;
    private String typeName;
    private int updateType;

    public j(VipThemeItem vipThemeItem) {
        this.id = vipThemeItem.props_id.intValue();
        this.title = vipThemeItem.title;
        this.imgUrl = vipThemeItem.img_url;
        this.ljo = vipThemeItem.tag_img_url;
        this.type = vipThemeItem.props_category.intValue();
        this.typeName = vipThemeItem.props_category_name;
        this.link = vipThemeItem.link;
        this.ljf = vipThemeItem.update_time;
        this.ljg = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
