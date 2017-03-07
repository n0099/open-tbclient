package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Vn = 0;
    private String Vo = "";
    private String imgUrl = "";
    private int eij = Integer.MAX_VALUE;
    private String eik = "";
    private String eil = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Vn = forumHeadlineImgInfo.img_user_id.longValue();
            this.Vo = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eij = forumHeadlineImgInfo.rank_num.intValue();
            this.eik = forumHeadlineImgInfo.rank_up_info;
            this.eil = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean qa() {
        return StringUtils.isNull(this.Vo, true) || this.Vn <= 0;
    }

    public String aJK() {
        return this.eil;
    }

    public String qc() {
        return this.Vo;
    }

    public String qd() {
        return this.imgUrl;
    }

    public int aJL() {
        return this.eij;
    }

    public String aJM() {
        return this.eik;
    }
}
