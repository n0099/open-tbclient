package com.baidu.tieba.pb.data;

import androidx.appcompat.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class i {
    private long ePR = 0;
    private String ePS = "";
    private String imgUrl = "";
    private int lGP = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String lGQ = "";
    private String aQE = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.ePR = forumHeadlineImgInfo.img_user_id.longValue();
            this.ePS = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lGP = forumHeadlineImgInfo.rank_num.intValue();
            this.lGQ = forumHeadlineImgInfo.rank_up_info;
            this.aQE = forumHeadlineImgInfo.rank_url;
        }
    }

    public String dno() {
        return this.aQE;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
