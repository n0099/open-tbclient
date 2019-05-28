package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private String iXT;
    private String iXU;
    private String iXV;
    private int mHeight;
    private int mImageType;
    private String mTitle;
    private int mWidth;

    public String clU() {
        return this.iXT;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String clV() {
        return this.iXU;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.iXV;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.mWidth = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.f(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.mWidth <= 0) {
                this.mWidth = 1;
            }
            if (this.mHeight <= 0) {
                this.mHeight = 1;
            }
            this.iXT = actHot.img_src;
            this.iXU = actHot.link;
            this.mTitle = actHot.author_name;
            this.iXV = actHot.img_des;
            this.mImageType = actHot.img_type.intValue();
        }
    }
}
