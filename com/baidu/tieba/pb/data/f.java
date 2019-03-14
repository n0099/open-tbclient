package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long byp = 0;
    private String byq = "";
    private String imgUrl = "";
    private int hkC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hkD = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.byp = forumHeadlineImgInfo.img_user_id.longValue();
            this.byq = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hkC = forumHeadlineImgInfo.rank_num.intValue();
            this.hkD = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bIz() {
        return this.rankUrl;
    }

    public String Xn() {
        return this.imgUrl;
    }
}
