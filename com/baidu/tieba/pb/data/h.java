package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class h {
    private long dIy = 0;
    private String dIz = "";
    private String imgUrl = "";
    private int jZJ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String jZK = "";
    private String aBR = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dIy = forumHeadlineImgInfo.img_user_id.longValue();
            this.dIz = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.jZJ = forumHeadlineImgInfo.rank_num.intValue();
            this.jZK = forumHeadlineImgInfo.rank_up_info;
            this.aBR = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cHu() {
        return this.aBR;
    }

    public String aQl() {
        return this.imgUrl;
    }
}
