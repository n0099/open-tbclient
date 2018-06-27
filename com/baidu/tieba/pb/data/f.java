package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long afR = 0;
    private String afS = "";
    private String imgUrl = "";
    private int fsS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fsT = "";
    private String bLY = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.afR = forumHeadlineImgInfo.img_user_id.longValue();
            this.afS = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fsS = forumHeadlineImgInfo.rank_num.intValue();
            this.fsT = forumHeadlineImgInfo.rank_up_info;
            this.bLY = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bbx() {
        return this.bLY;
    }

    public String uh() {
        return this.imgUrl;
    }
}
