package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class l {
    private long QU = 0;
    private String QV = "";
    private String imgUrl = "";
    private int est = Integer.MAX_VALUE;
    private String esu = "";
    private String esv = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.QU = forumHeadlineImgInfo.img_user_id.longValue();
            this.QV = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.est = forumHeadlineImgInfo.rank_num.intValue();
            this.esu = forumHeadlineImgInfo.rank_up_info;
            this.esv = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean pO() {
        return StringUtils.isNull(this.QV, true) || this.QU <= 0;
    }

    public String aOC() {
        return this.esv;
    }

    public String pQ() {
        return this.QV;
    }

    public String pR() {
        return this.imgUrl;
    }

    public int aOD() {
        return this.est;
    }

    public String aOE() {
        return this.esu;
    }
}
