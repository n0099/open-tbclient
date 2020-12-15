package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes22.dex */
public class i {
    private long eGb = 0;
    private String eGc = "";
    private String imgUrl = "";
    private int lBJ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String lBK = "";
    private String aPP = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.eGb = forumHeadlineImgInfo.img_user_id.longValue();
            this.eGc = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lBJ = forumHeadlineImgInfo.rank_num.intValue();
            this.lBK = forumHeadlineImgInfo.rank_up_info;
            this.aPP = forumHeadlineImgInfo.rank_url;
        }
    }

    public String dnF() {
        return this.aPP;
    }

    public String bmL() {
        return this.imgUrl;
    }
}
