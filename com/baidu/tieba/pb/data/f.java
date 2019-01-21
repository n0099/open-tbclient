package com.baidu.tieba.pb.data;

import android.support.v7.widget.ActivityChooserView;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class f {
    private long arz = 0;
    private String arA = "";
    private String imgUrl = "";
    private int fUr = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private String fUs = "";
    private String rankUrl = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.arz = forumHeadlineImgInfo.img_user_id.longValue();
            this.arA = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.fUr = forumHeadlineImgInfo.rank_num.intValue();
            this.fUs = forumHeadlineImgInfo.rank_up_info;
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
