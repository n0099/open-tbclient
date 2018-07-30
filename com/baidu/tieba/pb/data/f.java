package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long afl = 0;
    private String afm = "";
    private String imgUrl = "";
    private int fte = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String ftf = "";
    private String bMT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.afl = forumHeadlineImgInfo.img_user_id.longValue();
            this.afm = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fte = forumHeadlineImgInfo.rank_num.intValue();
            this.ftf = forumHeadlineImgInfo.rank_up_info;
            this.bMT = forumHeadlineImgInfo.rank_url;
        }
    }

    public String aZQ() {
        return this.bMT;
    }

    public String tU() {
        return this.imgUrl;
    }
}
