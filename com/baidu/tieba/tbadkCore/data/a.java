package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private String kfL;
    private String kfM;
    private String kfN;
    private int mHeight;
    private int mImageType;
    private String mTitle;
    private int mWidth;

    public String cKE() {
        return this.kfL;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String cKF() {
        return this.kfM;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.kfN;
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
            this.kfL = actHot.img_src;
            this.kfM = actHot.link;
            this.mTitle = actHot.author_name;
            this.kfN = actHot.img_des;
            this.mImageType = actHot.img_type.intValue();
        }
    }
}
