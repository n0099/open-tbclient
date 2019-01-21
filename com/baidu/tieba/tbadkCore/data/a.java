package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int aDW;
    private String hoV;
    private String hoW;
    private String hoX;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bEq() {
        return this.hoV;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bEr() {
        return this.hoW;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.hoX;
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
            this.hoV = actHot.img_src;
            this.hoW = actHot.link;
            this.mTitle = actHot.author_name;
            this.hoX = actHot.img_des;
            this.aDW = actHot.img_type.intValue();
        }
    }
}
