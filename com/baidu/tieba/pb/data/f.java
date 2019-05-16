package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class f {
    private long bFE = 0;
    private String bFF = "";
    private String imgUrl = "";
    private int hBJ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String hBK = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.bFE = forumHeadlineImgInfo.img_user_id.longValue();
            this.bFF = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.hBJ = forumHeadlineImgInfo.rank_num.intValue();
            this.hBK = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bQi() {
        return this.rankUrl;
    }

    public String abS() {
        return this.imgUrl;
    }
}
