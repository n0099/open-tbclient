package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int azd;
    private String hcm;
    private String hcn;
    private String hco;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bBz() {
        return this.hcm;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bBA() {
        return this.hcn;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.hco;
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
            this.hcm = actHot.img_src;
            this.hcn = actHot.link;
            this.mTitle = actHot.author_name;
            this.hco = actHot.img_des;
            this.azd = actHot.img_type.intValue();
        }
    }
}
