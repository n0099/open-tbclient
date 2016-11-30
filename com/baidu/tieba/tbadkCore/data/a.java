package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int ada;
    private String fBC;
    private String fBD;
    private String fBE;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String blD() {
        return this.fBC;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String blE() {
        return this.fBD;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.fBE;
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
            this.fBC = actHot.img_src;
            this.fBD = actHot.link;
            this.mTitle = actHot.author_name;
            this.fBE = actHot.img_des;
            this.ada = actHot.img_type.intValue();
        }
    }
}
