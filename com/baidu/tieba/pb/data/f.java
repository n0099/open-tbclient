package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bGH = 0;
    private String bGI = "";
    private String imgUrl = "";
    private int dym = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hIU = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bGH = forumHeadlineImgInfo.img_user_id.longValue();
            this.bGI = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dym = forumHeadlineImgInfo.rank_num.intValue();
            this.hIU = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bTl() {
        return this.rankUrl;
    }

    public String acV() {
        return this.imgUrl;
    }
}
