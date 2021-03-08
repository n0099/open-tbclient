package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private String eOp;
    private int mHeight;
    private int mImageType;
    private String mTitle;
    private int mWidth;
    private String nyq;
    private String nyr;

    public String dNn() {
        return this.nyq;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String dNo() {
        return this.eOp;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.nyr;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.mWidth = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.f.b.toInt(split[1], 1);
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
            this.nyq = actHot.img_src;
            this.eOp = actHot.link;
            this.mTitle = actHot.author_name;
            this.nyr = actHot.img_des;
            this.mImageType = actHot.img_type.intValue();
        }
    }
}
