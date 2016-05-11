package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private String erZ;
    private String esa;
    private String esb;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String aTk() {
        return this.erZ;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String aTl() {
        return this.esa;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.esb;
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
            this.erZ = actHot.img_src;
            this.esa = actHot.link;
            this.mTitle = actHot.author_name;
            this.esb = actHot.img_des;
        }
    }
}
