package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int acC;
    private String fup;
    private String fuq;
    private String fur;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bji() {
        return this.fup;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bjj() {
        return this.fuq;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.fur;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.mWidth = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.h.b.g(split[1], 1);
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
            this.fup = actHot.img_src;
            this.fuq = actHot.link;
            this.mTitle = actHot.author_name;
            this.fur = actHot.img_des;
            this.acC = actHot.img_type.intValue();
        }
    }
}
