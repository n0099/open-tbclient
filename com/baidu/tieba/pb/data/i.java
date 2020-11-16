package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes21.dex */
public class i {
    private long ezc = 0;
    private String ezd = "";
    private String imgUrl = "";
    private int loj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String lok = "";
    private String aMQ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.ezc = forumHeadlineImgInfo.img_user_id.longValue();
            this.ezd = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.loj = forumHeadlineImgInfo.rank_num.intValue();
            this.lok = forumHeadlineImgInfo.rank_up_info;
            this.aMQ = forumHeadlineImgInfo.rank_url;
        }
    }

    public String dip() {
        return this.aMQ;
    }

    public String bjy() {
        return this.imgUrl;
    }
}
