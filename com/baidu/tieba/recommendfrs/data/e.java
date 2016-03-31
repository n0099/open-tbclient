package com.baidu.tieba.recommendfrs.data;

import com.baidu.tieba.card.a.y;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends y {
    public void a(Resource resource) {
        if (resource != null) {
            this.aWy = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.aWz = resource.user_image;
            this.aWA = resource.user_link;
            this.aWB = resource.res_title;
            this.aWC = resource.res_image;
            this.aWD = resource.res_link;
            this.aWE = resource.position.longValue();
            this.aWF = resource.icon_text;
        }
    }
}
