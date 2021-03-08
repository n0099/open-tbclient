package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class j {
    private int id;
    private String imgUrl;
    private String link;
    private String loX;
    private int loY;
    private String lpg;
    private String title;
    private int type;
    private String typeName;
    private int updateType;

    public j(VipThemeItem vipThemeItem) {
        this.id = vipThemeItem.props_id.intValue();
        this.title = vipThemeItem.title;
        this.imgUrl = vipThemeItem.img_url;
        this.lpg = vipThemeItem.tag_img_url;
        this.type = vipThemeItem.props_category.intValue();
        this.typeName = vipThemeItem.props_category_name;
        this.link = vipThemeItem.link;
        this.loX = vipThemeItem.update_time;
        this.loY = vipThemeItem.id.intValue();
        this.updateType = vipThemeItem.type.intValue();
    }
}
