package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long VJ = 0;
    private String VK = "";
    private String imgUrl = "";
    private int eEH = Integer.MAX_VALUE;
    private String eEI = "";
    private String eEJ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.VJ = forumHeadlineImgInfo.img_user_id.longValue();
            this.VK = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eEH = forumHeadlineImgInfo.rank_num.intValue();
            this.eEI = forumHeadlineImgInfo.rank_up_info;
            this.eEJ = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aPv() {
        return StringUtils.isNull(this.VK, true) || this.VJ <= 0;
    }

    public String aPw() {
        return this.eEJ;
    }

    public String aPx() {
        return this.VK;
    }

    public String pR() {
        return this.imgUrl;
    }

    public int aPy() {
        return this.eEH;
    }

    public String aPz() {
        return this.eEI;
    }
}
