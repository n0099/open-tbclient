package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class l {
    private long QB = 0;
    private String QC = "";
    private String imgUrl = "";
    private int emw = Integer.MAX_VALUE;
    private String emx = "";
    private String emy = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.QB = forumHeadlineImgInfo.img_user_id.longValue();
            this.QC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.emw = forumHeadlineImgInfo.rank_num.intValue();
            this.emx = forumHeadlineImgInfo.rank_up_info;
            this.emy = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean pL() {
        return StringUtils.isNull(this.QC, true) || this.QB <= 0;
    }

    public String aMJ() {
        return this.emy;
    }

    public String pN() {
        return this.QC;
    }

    public String pO() {
        return this.imgUrl;
    }

    public int aMK() {
        return this.emw;
    }

    public String aML() {
        return this.emx;
    }
}
