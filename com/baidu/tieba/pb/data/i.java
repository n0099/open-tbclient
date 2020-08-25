package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes16.dex */
public class i {
    private long dYc = 0;
    private String dYd = "";
    private String imgUrl = "";
    private int kxF = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String kxG = "";
    private String aIw = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dYc = forumHeadlineImgInfo.img_user_id.longValue();
            this.dYd = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.kxF = forumHeadlineImgInfo.rank_num.intValue();
            this.kxG = forumHeadlineImgInfo.rank_up_info;
            this.aIw = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cVT() {
        return this.aIw;
    }

    public String bcA() {
        return this.imgUrl;
    }
}
