package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bFF = 0;
    private String bFG = "";
    private String imgUrl = "";
    private int hBN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hBO = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bFF = forumHeadlineImgInfo.img_user_id.longValue();
            this.bFG = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hBN = forumHeadlineImgInfo.rank_num.intValue();
            this.hBO = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bQm() {
        return this.rankUrl;
    }

    public String abS() {
        return this.imgUrl;
    }
}
