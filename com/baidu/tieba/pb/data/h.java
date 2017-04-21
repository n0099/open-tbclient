package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long VH = 0;
    private String VI = "";
    private String imgUrl = "";
    private int eiG = Integer.MAX_VALUE;
    private String eiH = "";
    private String eiI = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.VH = forumHeadlineImgInfo.img_user_id.longValue();
            this.VI = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eiG = forumHeadlineImgInfo.rank_num.intValue();
            this.eiH = forumHeadlineImgInfo.rank_up_info;
            this.eiI = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean qy() {
        return StringUtils.isNull(this.VI, true) || this.VH <= 0;
    }

    public String aKS() {
        return this.eiI;
    }

    public String qA() {
        return this.VI;
    }

    public String qB() {
        return this.imgUrl;
    }

    public int aKT() {
        return this.eiG;
    }

    public String aKU() {
        return this.eiH;
    }
}
