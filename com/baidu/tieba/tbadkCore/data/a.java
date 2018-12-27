package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int aDt;
    private String hnP;
    private String hnQ;
    private String hnR;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bDH() {
        return this.hnP;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bDI() {
        return this.hnQ;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.hnR;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.mWidth = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.l(split[1], 1);
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
            this.hnP = actHot.img_src;
            this.hnQ = actHot.link;
            this.mTitle = actHot.author_name;
            this.hnR = actHot.img_des;
            this.aDt = actHot.img_type.intValue();
        }
    }
}
