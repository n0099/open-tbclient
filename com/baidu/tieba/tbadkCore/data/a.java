package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private String kfJ;
    private String kfK;
    private String kfL;
    private int mHeight;
    private int mImageType;
    private String mTitle;
    private int mWidth;

    public String cKC() {
        return this.kfJ;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String cKD() {
        return this.kfK;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.kfL;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.mWidth = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.f.b.toInt(split[1], 1);
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
            this.kfJ = actHot.img_src;
            this.kfK = actHot.link;
            this.mTitle = actHot.author_name;
            this.kfL = actHot.img_des;
            this.mImageType = actHot.img_type.intValue();
        }
    }
}
