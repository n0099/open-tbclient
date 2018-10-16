package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class f {
    private long amI = 0;
    private String amJ = "";
    private String imgUrl = "";
    private int fIm = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fIn = "";
    private String cbg = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.amI = forumHeadlineImgInfo.img_user_id.longValue();
            this.amJ = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fIm = forumHeadlineImgInfo.rank_num.intValue();
            this.fIn = forumHeadlineImgInfo.rank_up_info;
            this.cbg = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bfy() {
        return this.cbg;
    }

    public String xf() {
        return this.imgUrl;
    }
}
