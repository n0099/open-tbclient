package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class h {
    private long aKS = 0;
    private String aKT = "";
    private String imgUrl = "";
    private int fDW = Integer.MAX_VALUE;
    private String fDX = "";
    private String fDY = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aKS = forumHeadlineImgInfo.img_user_id.longValue();
            this.aKT = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fDW = forumHeadlineImgInfo.rank_num.intValue();
            this.fDX = forumHeadlineImgInfo.rank_up_info;
            this.fDY = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aZg() {
        return StringUtils.isNull(this.aKT, true) || this.aKS <= 0;
    }

    public String aZh() {
        return this.fDY;
    }

    public String aZi() {
        return this.aKT;
    }

    public String xt() {
        return this.imgUrl;
    }

    public int aZj() {
        return this.fDW;
    }

    public String aZk() {
        return this.fDX;
    }
}
