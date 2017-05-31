package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class h {
    private long UM = 0;
    private String UN = "";
    private String imgUrl = "";
    private int eiY = Integer.MAX_VALUE;
    private String eiZ = "";
    private String eja = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.UM = forumHeadlineImgInfo.img_user_id.longValue();
            this.UN = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eiY = forumHeadlineImgInfo.rank_num.intValue();
            this.eiZ = forumHeadlineImgInfo.rank_up_info;
            this.eja = forumHeadlineImgInfo.rank_url;
        }
    }

    public boolean aIZ() {
        return StringUtils.isNull(this.UN, true) || this.UM <= 0;
    }

    public String aJa() {
        return this.eja;
    }

    public String aJb() {
        return this.UN;
    }

    public String pL() {
        return this.imgUrl;
    }

    public int aJc() {
        return this.eiY;
    }

    public String aJd() {
        return this.eiZ;
    }
}
