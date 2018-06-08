package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long afC = 0;
    private String afD = "";
    private String imgUrl = "";
    private int foY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String foZ = "";
    private String bJP = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.afC = forumHeadlineImgInfo.img_user_id.longValue();
            this.afD = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.foY = forumHeadlineImgInfo.rank_num.intValue();
            this.foZ = forumHeadlineImgInfo.rank_up_info;
            this.bJP = forumHeadlineImgInfo.rank_url;
        }
    }

    public String baP() {
        return this.bJP;
    }

    public String ub() {
        return this.imgUrl;
    }
}
