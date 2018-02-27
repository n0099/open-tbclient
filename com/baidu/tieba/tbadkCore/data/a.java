package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int aYa;
    private String gZT;
    private String gZU;
    private String gZV;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.mWidth = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.h(split[1], 1);
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
            this.gZT = actHot.img_src;
            this.gZU = actHot.link;
            this.mTitle = actHot.author_name;
            this.gZV = actHot.img_des;
            this.aYa = actHot.img_type.intValue();
        }
    }
}
