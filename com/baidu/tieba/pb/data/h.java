package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Vc = 0;
    private String Vd = "";
    private String imgUrl = "";
    private int eDe = Integer.MAX_VALUE;
    private String eDf = "";
    private String eDg = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Vc = forumHeadlineImgInfo.img_user_id.longValue();
            this.Vd = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eDe = forumHeadlineImgInfo.rank_num.intValue();
            this.eDf = forumHeadlineImgInfo.rank_up_info;
            this.eDg = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aPw() {
        return StringUtils.isNull(this.Vd, true) || this.Vc <= 0;
    }

    public String aPx() {
        return this.eDg;
    }

    public String aPy() {
        return this.Vd;
    }

    public String pL() {
        return this.imgUrl;
    }

    public int aPz() {
        return this.eDe;
    }

    public String aPA() {
        return this.eDf;
    }
}
