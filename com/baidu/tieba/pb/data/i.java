package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes16.dex */
public class i {
    private long dYg = 0;
    private String dYh = "";
    private String imgUrl = "";
    private int kxM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String kxN = "";
    private String aIy = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dYg = forumHeadlineImgInfo.img_user_id.longValue();
            this.dYh = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.kxM = forumHeadlineImgInfo.rank_num.intValue();
            this.kxN = forumHeadlineImgInfo.rank_up_info;
            this.aIy = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cVU() {
        return this.aIy;
    }

    public String bcA() {
        return this.imgUrl;
    }
}
