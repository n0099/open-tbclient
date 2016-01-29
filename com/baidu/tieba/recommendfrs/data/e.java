package com.baidu.tieba.recommendfrs.data;

import com.baidu.tieba.card.a.v;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends v {
    public void a(Resource resource) {
        if (resource != null) {
            this.aSM = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.aSN = resource.user_image;
            this.aSO = resource.user_link;
            this.aSP = resource.res_title;
            this.aSQ = resource.res_image;
            this.aSR = resource.res_link;
            this.aSS = resource.position.longValue();
            this.aST = resource.icon_text;
        }
    }
}
