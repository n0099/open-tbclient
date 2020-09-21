package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes21.dex */
public class i {
    private long eaq = 0;
    private String ear = "";
    private String imgUrl = "";
    private int kGk = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String kGl = "";
    private String aJO = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.eaq = forumHeadlineImgInfo.img_user_id.longValue();
            this.ear = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.kGk = forumHeadlineImgInfo.rank_num.intValue();
            this.kGl = forumHeadlineImgInfo.rank_up_info;
            this.aJO = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cZz() {
        return this.aJO;
    }

    public String bdu() {
        return this.imgUrl;
    }
}
