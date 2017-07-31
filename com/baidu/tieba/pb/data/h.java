package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Wy = 0;
    private String Wz = "";
    private String imgUrl = "";
    private int eEr = Integer.MAX_VALUE;
    private String eEs = "";
    private String eEt = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Wy = forumHeadlineImgInfo.img_user_id.longValue();
            this.Wz = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eEr = forumHeadlineImgInfo.rank_num.intValue();
            this.eEs = forumHeadlineImgInfo.rank_up_info;
            this.eEt = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aPH() {
        return StringUtils.isNull(this.Wz, true) || this.Wy <= 0;
    }

    public String aPI() {
        return this.eEt;
    }

    public String aPJ() {
        return this.Wz;
    }

    public String pV() {
        return this.imgUrl;
    }

    public int aPK() {
        return this.eEr;
    }

    public String aPL() {
        return this.eEs;
    }
}
