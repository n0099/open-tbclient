package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes22.dex */
public class i {
    private long eAL = 0;
    private String eAM = "";
    private String imgUrl = "";
    private int lnR = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String lnS = "";
    private String aOB = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.eAL = forumHeadlineImgInfo.img_user_id.longValue();
            this.eAM = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lnR = forumHeadlineImgInfo.rank_num.intValue();
            this.lnS = forumHeadlineImgInfo.rank_up_info;
            this.aOB = forumHeadlineImgInfo.rank_url;
        }
    }

    public String diS() {
        return this.aOB;
    }

    public String bkw() {
        return this.imgUrl;
    }
}
