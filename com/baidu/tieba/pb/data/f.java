package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class f {
    private long ary = 0;
    private String arz = "";
    private String imgUrl = "";
    private int fUq = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fUr = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.ary = forumHeadlineImgInfo.img_user_id.longValue();
            this.arz = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fUq = forumHeadlineImgInfo.rank_num.intValue();
            this.fUr = forumHeadlineImgInfo.rank_up_info;
            this.rankUrl = forumHeadlineImgInfo.rank_url;
        }
    }

    public String bic() {
        return this.rankUrl;
    }

    public String yF() {
        return this.imgUrl;
    }
}
