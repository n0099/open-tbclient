package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int agV;
    private String ftA;
    private String fty;
    private String ftz;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bgV() {
        return this.fty;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bgW() {
        return this.ftz;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.ftA;
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
            this.fty = actHot.img_src;
            this.ftz = actHot.link;
            this.mTitle = actHot.author_name;
            this.ftA = actHot.img_des;
            this.agV = actHot.img_type.intValue();
        }
    }
}
