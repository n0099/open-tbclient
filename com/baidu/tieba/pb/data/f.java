package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bGG = 0;
    private String bGH = "";
    private String imgUrl = "";
    private int dyf = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hIb = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bGG = forumHeadlineImgInfo.img_user_id.longValue();
            this.bGH = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dyf = forumHeadlineImgInfo.rank_num.intValue();
            this.hIb = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bSX() {
        return this.rankUrl;
    }

    public String acU() {
        return this.imgUrl;
    }
}
