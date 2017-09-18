package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long VJ = 0;
    private String VK = "";
    private String imgUrl = "";
    private int eFB = Integer.MAX_VALUE;
    private String eFC = "";
    private String eFD = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.VJ = forumHeadlineImgInfo.img_user_id.longValue();
            this.VK = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eFB = forumHeadlineImgInfo.rank_num.intValue();
            this.eFC = forumHeadlineImgInfo.rank_up_info;
            this.eFD = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aPG() {
        return StringUtils.isNull(this.VK, true) || this.VJ <= 0;
    }

    public String aPH() {
        return this.eFD;
    }

    public String aPI() {
        return this.VK;
    }

    public String pR() {
        return this.imgUrl;
    }

    public int aPJ() {
        return this.eFB;
    }

    public String aPK() {
        return this.eFC;
    }
}
