package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class f {
    private long aqW = 0;
    private String aqX = "";
    private String imgUrl = "";
    private int fTt = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fTu = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.aqW = forumHeadlineImgInfo.img_user_id.longValue();
            this.aqX = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fTt = forumHeadlineImgInfo.rank_num.intValue();
            this.fTu = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bhy() {
        return this.rankUrl;
    }

    public String ys() {
        return this.imgUrl;
    }
}
