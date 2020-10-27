package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes22.dex */
public class i {
    private long euS = 0;
    private String euT = "";
    private String imgUrl = "";
    private int lhU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String lhV = "";
    private String aNy = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.euS = forumHeadlineImgInfo.img_user_id.longValue();
            this.euT = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lhU = forumHeadlineImgInfo.rank_num.intValue();
            this.lhV = forumHeadlineImgInfo.rank_up_info;
            this.aNy = forumHeadlineImgInfo.rank_url;
        }
    }

    public String dgq() {
        return this.aNy;
    }

    public String bhW() {
        return this.imgUrl;
    }
}
