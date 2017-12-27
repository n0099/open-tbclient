package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class h {
    private long aKU = 0;
    private String aKV = "";
    private String imgUrl = "";
    private int fCw = Integer.MAX_VALUE;
    private String fCx = "";
    private String fCy = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aKU = forumHeadlineImgInfo.img_user_id.longValue();
            this.aKV = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fCw = forumHeadlineImgInfo.rank_num.intValue();
            this.fCx = forumHeadlineImgInfo.rank_up_info;
            this.fCy = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aZc() {
        return StringUtils.isNull(this.aKV, true) || this.aKU <= 0;
    }

    public String aZd() {
        return this.fCy;
    }

    public String aZe() {
        return this.aKV;
    }

    public String xu() {
        return this.imgUrl;
    }

    public int aZf() {
        return this.fCw;
    }

    public String aZg() {
        return this.fCx;
    }
}
