package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long ahM = 0;
    private String ahN = "";
    private String imgUrl = "";
    private int fAK = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fAL = "";
    private String bSH = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.ahM = forumHeadlineImgInfo.img_user_id.longValue();
            this.ahN = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fAK = forumHeadlineImgInfo.rank_num.intValue();
            this.fAL = forumHeadlineImgInfo.rank_up_info;
            this.bSH = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bcm() {
        return this.bSH;
    }

    public String uW() {
        return this.imgUrl;
    }
}
