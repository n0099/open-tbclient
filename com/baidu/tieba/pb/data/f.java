package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long afl = 0;
    private String afm = "";
    private String imgUrl = "";
    private int fsX = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fsY = "";
    private String bMS = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.afl = forumHeadlineImgInfo.img_user_id.longValue();
            this.afm = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fsX = forumHeadlineImgInfo.rank_num.intValue();
            this.fsY = forumHeadlineImgInfo.rank_up_info;
            this.bMS = forumHeadlineImgInfo.rank_url;
        }
    }

    public String aZL() {
        return this.bMS;
    }

    public String tT() {
        return this.imgUrl;
    }
}
