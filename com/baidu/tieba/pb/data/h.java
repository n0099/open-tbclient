package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Va = 0;
    private String Vb = "";
    private String imgUrl = "";
    private int edA = Integer.MAX_VALUE;
    private String edB = "";
    private String edC = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Va = forumHeadlineImgInfo.img_user_id.longValue();
            this.Vb = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.edA = forumHeadlineImgInfo.rank_num.intValue();
            this.edB = forumHeadlineImgInfo.rank_up_info;
            this.edC = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aIe() {
        return StringUtils.isNull(this.Vb, true) || this.Va <= 0;
    }

    public String aIf() {
        return this.edC;
    }

    public String aIg() {
        return this.Vb;
    }

    public String pT() {
        return this.imgUrl;
    }

    public int aIh() {
        return this.edA;
    }

    public String aIi() {
        return this.edB;
    }
}
