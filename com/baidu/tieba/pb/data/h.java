package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long Wu = 0;
    private String Wv = "";
    private String imgUrl = "";
    private int ePR = Integer.MAX_VALUE;
    private String ePS = "";
    private String ePT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.Wu = forumHeadlineImgInfo.img_user_id.longValue();
            this.Wv = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.ePR = forumHeadlineImgInfo.rank_num.intValue();
            this.ePS = forumHeadlineImgInfo.rank_up_info;
            this.ePT = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aRP() {
        return StringUtils.isNull(this.Wv, true) || this.Wu <= 0;
    }

    public String aRQ() {
        return this.ePT;
    }

    public String aRR() {
        return this.Wv;
    }

    public String pR() {
        return this.imgUrl;
    }

    public int aRS() {
        return this.ePR;
    }

    public String aRT() {
        return this.ePS;
    }
}
