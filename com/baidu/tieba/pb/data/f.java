package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long XB = 0;
    private String XC = "";
    private String imgUrl = "";
    private int fdC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fdD = "";
    private String bBM = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.XB = forumHeadlineImgInfo.img_user_id.longValue();
            this.XC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fdC = forumHeadlineImgInfo.rank_num.intValue();
            this.fdD = forumHeadlineImgInfo.rank_up_info;
            this.bBM = forumHeadlineImgInfo.rank_url;
        }
    }

    public String aVT() {
        return this.bBM;
    }

    public String qF() {
        return this.imgUrl;
    }
}
