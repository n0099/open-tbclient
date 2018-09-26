package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int aus;
    private String gUR;
    private String gUS;
    private String gUT;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String byk() {
        return this.gUR;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String byl() {
        return this.gUS;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gUT;
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
            this.gUR = actHot.img_src;
            this.gUS = actHot.link;
            this.mTitle = actHot.author_name;
            this.gUT = actHot.img_des;
            this.aus = actHot.img_type.intValue();
        }
    }
}
