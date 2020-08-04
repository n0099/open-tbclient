package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes16.dex */
public class i {
    private long dOJ = 0;
    private String dOK = "";
    private String imgUrl = "";
    private int kin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String kio = "";
    private String aDm = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.dOJ = forumHeadlineImgInfo.img_user_id.longValue();
            this.dOK = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.kin = forumHeadlineImgInfo.rank_num.intValue();
            this.kio = forumHeadlineImgInfo.rank_up_info;
            this.aDm = forumHeadlineImgInfo.rank_url;
        }
    }

    public String cLf() {
        return this.aDm;
    }

    public String aUh() {
        return this.imgUrl;
    }
}
