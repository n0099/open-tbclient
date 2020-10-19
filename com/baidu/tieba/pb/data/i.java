package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes22.dex */
public class i {
    private long ems = 0;
    private String emt = "";
    private String imgUrl = "";
    private int kVv = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String kVw = "";
    private String aMT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.ems = forumHeadlineImgInfo.img_user_id.longValue();
            this.emt = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.kVv = forumHeadlineImgInfo.rank_num.intValue();
            this.kVw = forumHeadlineImgInfo.rank_up_info;
            this.aMT = forumHeadlineImgInfo.rank_url;
        }
    }

    public String ddi() {
        return this.aMT;
    }

    public String bgd() {
        return this.imgUrl;
    }
}
