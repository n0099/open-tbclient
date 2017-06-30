package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long UL = 0;
    private String UM = "";
    private String imgUrl = "";
    private int erV = Integer.MAX_VALUE;
    private String erW = "";
    private String erX = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.UL = forumHeadlineImgInfo.img_user_id.longValue();
            this.UM = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.erV = forumHeadlineImgInfo.rank_num.intValue();
            this.erW = forumHeadlineImgInfo.rank_up_info;
            this.erX = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aMT() {
        return StringUtils.isNull(this.UM, true) || this.UL <= 0;
    }

    public String aMU() {
        return this.erX;
    }

    public String aMV() {
        return this.UM;
    }

    public String pI() {
        return this.imgUrl;
    }

    public int aMW() {
        return this.erV;
    }

    public String aMX() {
        return this.erW;
    }
}
