package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bFE = 0;
    private String bFF = "";
    private String imgUrl = "";
    private int hBM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hBN = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bFE = forumHeadlineImgInfo.img_user_id.longValue();
            this.bFF = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hBM = forumHeadlineImgInfo.rank_num.intValue();
            this.hBN = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bQl() {
        return this.rankUrl;
    }

    public String abS() {
        return this.imgUrl;
    }
}
