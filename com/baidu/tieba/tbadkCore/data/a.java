package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int aDs;
    private String hkE;
    private String hkF;
    private String hkG;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bCQ() {
        return this.hkE;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bCR() {
        return this.hkF;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.hkG;
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
            this.hkE = actHot.img_src;
            this.hkF = actHot.link;
            this.mTitle = actHot.author_name;
            this.hkG = actHot.img_des;
            this.aDs = actHot.img_type.intValue();
        }
    }
}
