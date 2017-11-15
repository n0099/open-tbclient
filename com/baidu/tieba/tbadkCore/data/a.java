package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int ahY;
    private String gpF;
    private String gpG;
    private String gpH;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String buc() {
        return this.gpF;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bud() {
        return this.gpG;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gpH;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.mWidth = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.g(split[1], 1);
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
            this.gpF = actHot.img_src;
            this.gpG = actHot.link;
            this.mTitle = actHot.author_name;
            this.gpH = actHot.img_des;
            this.ahY = actHot.img_type.intValue();
        }
    }
}
