package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long VL = 0;
    private String VM = "";
    private String imgUrl = "";
    private int eyJ = Integer.MAX_VALUE;
    private String eyK = "";
    private String eyL = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.VL = forumHeadlineImgInfo.img_user_id.longValue();
            this.VM = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eyJ = forumHeadlineImgInfo.rank_num.intValue();
            this.eyK = forumHeadlineImgInfo.rank_up_info;
            this.eyL = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aNv() {
        return StringUtils.isNull(this.VM, true) || this.VL <= 0;
    }

    public String aNw() {
        return this.eyL;
    }

    public String aNx() {
        return this.VM;
    }

    public String pL() {
        return this.imgUrl;
    }

    public int aNy() {
        return this.eyJ;
    }

    public String aNz() {
        return this.eyK;
    }
}
