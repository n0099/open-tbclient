package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes9.dex */
public class h {
    private long dCd = 0;
    private String dCe = "";
    private String imgUrl = "";
    private int jET = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String jEU = "";
    private String azz = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dCd = forumHeadlineImgInfo.img_user_id.longValue();
            this.dCe = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.jET = forumHeadlineImgInfo.rank_num.intValue();
            this.jEU = forumHeadlineImgInfo.rank_up_info;
            this.azz = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cCO() {
        return this.azz;
    }

    public String aOP() {
        return this.imgUrl;
    }
}
