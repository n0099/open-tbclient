package com.baidu.tieba.square;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class ak implements y {
    protected String img_url = null;
    protected String link = null;

    @Override // com.baidu.tieba.square.y
    public String kJ() {
        return this.img_url;
    }

    public void hu(String str) {
        this.img_url = str;
    }

    @Override // com.baidu.tieba.square.y
    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void a(Banner banner) {
        if (banner != null) {
            a(banner, null);
        }
    }

    public void a(Banner banner, Context context) {
        if (banner != null) {
            try {
                hu(banner.pic_url);
                setLink(banner.link);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
