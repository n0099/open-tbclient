package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private String eyy;
    private int mHeight;
    private int mImageType;
    private String mTitle;
    private int mWidth;
    private String mXc;
    private String mXd;

    public String dJt() {
        return this.mXc;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String dJu() {
        return this.eyy;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mXd;
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
            this.mXc = actHot.img_src;
            this.eyy = actHot.link;
            this.mTitle = actHot.author_name;
            this.mXd = actHot.img_des;
            this.mImageType = actHot.img_type.intValue();
        }
    }
}
