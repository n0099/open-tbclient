package com.baidu.tieba.pb.data;

import androidx.appcompat.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class i {
    private long eLg = 0;
    private String eLh = "";
    private String imgUrl = "";
    private int lCj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String lCk = "";
    private String aLR = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.eLg = forumHeadlineImgInfo.img_user_id.longValue();
            this.eLh = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.lCj = forumHeadlineImgInfo.rank_num.intValue();
            this.lCk = forumHeadlineImgInfo.rank_up_info;
            this.aLR = forumHeadlineImgInfo.rank_url;
        }
    }

    public String djx() {
        return this.aLR;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
