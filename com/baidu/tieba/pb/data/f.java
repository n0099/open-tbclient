package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long byt = 0;
    private String byu = "";
    private String imgUrl = "";
    private int hkq = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hkr = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.byt = forumHeadlineImgInfo.img_user_id.longValue();
            this.byu = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hkq = forumHeadlineImgInfo.rank_num.intValue();
            this.hkr = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bIw() {
        return this.rankUrl;
    }

    public String Xk() {
        return this.imgUrl;
    }
}
