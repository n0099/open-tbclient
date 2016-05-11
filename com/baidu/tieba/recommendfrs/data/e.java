package com.baidu.tieba.recommendfrs.data;

import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a.q {
    public void a(Resource resource) {
        if (resource != null) {
            this.aSs = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.aSt = resource.user_image;
            this.aSu = resource.user_link;
            this.aSv = resource.res_title;
            this.aSw = resource.res_image;
            this.aSx = resource.res_link;
            this.aSy = resource.position.longValue();
            this.aSz = resource.icon_text;
        }
    }
}
