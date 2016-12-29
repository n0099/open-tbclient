package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int act;
    private String ffH;
    private String ffI;
    private String ffJ;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bfs() {
        return this.ffH;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bft() {
        return this.ffI;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.ffJ;
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
            this.ffH = actHot.img_src;
            this.ffI = actHot.link;
            this.mTitle = actHot.author_name;
            this.ffJ = actHot.img_des;
            this.act = actHot.img_type.intValue();
        }
    }
}
