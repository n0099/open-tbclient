package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int arT;
    private String gNl;
    private String gNm;
    private String gNn;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bvD() {
        return this.gNl;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bvE() {
        return this.gNm;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gNn;
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
            this.gNl = actHot.img_src;
            this.gNm = actHot.link;
            this.mTitle = actHot.author_name;
            this.gNn = actHot.img_des;
            this.arT = actHot.img_type.intValue();
        }
    }
}
