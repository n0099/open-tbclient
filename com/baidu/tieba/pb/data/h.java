package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class h {
    private long aKV = 0;
    private String aKW = "";
    private String imgUrl = "";
    private int fEr = Integer.MAX_VALUE;
    private String fEs = "";
    private String fEt = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aKV = forumHeadlineImgInfo.img_user_id.longValue();
            this.aKW = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fEr = forumHeadlineImgInfo.rank_num.intValue();
            this.fEs = forumHeadlineImgInfo.rank_up_info;
            this.fEt = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aZl() {
        return StringUtils.isNull(this.aKW, true) || this.aKV <= 0;
    }

    public String aZm() {
        return this.fEt;
    }

    public String aZn() {
        return this.aKW;
    }

    public String xu() {
        return this.imgUrl;
    }

    public int aZo() {
        return this.fEr;
    }

    public String aZp() {
        return this.fEs;
    }
}
