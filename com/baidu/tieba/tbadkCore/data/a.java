package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int arU;
    private String gNn;
    private String gNo;
    private String gNp;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bvE() {
        return this.gNn;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bvF() {
        return this.gNo;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gNp;
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
            this.gNn = actHot.img_src;
            this.gNo = actHot.link;
            this.mTitle = actHot.author_name;
            this.gNp = actHot.img_des;
            this.arU = actHot.img_type.intValue();
        }
    }
}
