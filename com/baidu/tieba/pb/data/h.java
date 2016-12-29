package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long QR = 0;
    private String QS = "";
    private String imgUrl = "";
    private int dWR = Integer.MAX_VALUE;
    private String dWS = "";
    private String dWT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.QR = forumHeadlineImgInfo.img_user_id.longValue();
            this.QS = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dWR = forumHeadlineImgInfo.rank_num.intValue();
            this.dWS = forumHeadlineImgInfo.rank_up_info;
            this.dWT = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean pP() {
        return StringUtils.isNull(this.QS, true) || this.QR <= 0;
    }

    public String aIB() {
        return this.dWT;
    }

    public String pR() {
        return this.QS;
    }

    public String pS() {
        return this.imgUrl;
    }

    public int aIC() {
        return this.dWR;
    }

    public String aID() {
        return this.dWS;
    }
}
