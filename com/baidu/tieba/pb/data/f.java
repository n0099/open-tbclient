package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class f {
    private long XA = 0;
    private String XB = "";
    private String imgUrl = "";
    private int fcy = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fcz = "";
    private String bAP = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.XA = forumHeadlineImgInfo.img_user_id.longValue();
            this.XB = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fcy = forumHeadlineImgInfo.rank_num.intValue();
            this.fcz = forumHeadlineImgInfo.rank_up_info;
            this.bAP = forumHeadlineImgInfo.rank_url;
        }
    }

    public String aVT() {
        return this.bAP;
    }

    public String qG() {
        return this.imgUrl;
    }
}
