package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int asq;
    private String gMn;
    private String gMo;
    private String gMp;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bxa() {
        return this.gMn;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bxb() {
        return this.gMo;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gMp;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
            this.gMn = actHot.img_src;
            this.gMo = actHot.link;
            this.mTitle = actHot.author_name;
            this.gMp = actHot.img_des;
            this.asq = actHot.img_type.intValue();
        }
    }
}
