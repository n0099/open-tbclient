package com.baidu.tieba.recommendfrs.data;

import com.baidu.tieba.card.a.s;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class d extends s {
    public void a(Resource resource) {
        if (resource != null) {
            this.aQJ = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.aQK = resource.user_image;
            this.aQL = resource.user_link;
            this.aQM = resource.res_title;
            this.aQN = resource.res_image;
            this.aQO = resource.res_link;
            this.aQP = resource.position.longValue();
            this.aQQ = resource.icon_text;
        }
    }
}
