package com.baidu.tieba.pb.c.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class e implements ae, d {
    private String big_cdn_src;
    private String big_src;
    private String cdn_src;
    private long cny;
    private ArrayList<ad> cnz;
    private int height;
    private String src;
    private int width;

    public e(Content content) {
        if (content != null && content.type.longValue() == 3) {
            this.cnz = new ArrayList<>(1);
            this.src = content.src;
            this.big_src = content.big_src;
            this.big_cdn_src = content.big_cdn_src;
            this.cny = content.type.longValue();
            String str = content.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = Integer.valueOf(split[0]).intValue();
                    this.height = Integer.valueOf(split[1]).intValue();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.width <= 0) {
                this.width = 1;
            }
            if (this.height <= 0) {
                this.height = 1;
            }
            this.cdn_src = content.cdn_src;
            ad adVar = new ad();
            adVar.aax = 17;
            adVar.height = this.height;
            adVar.width = this.width;
            if (StringUtils.isNull(this.cdn_src)) {
                adVar.VY = this.src;
            } else {
                adVar.VY = this.cdn_src;
            }
            this.cnz.add(adVar);
        }
    }

    public String getSrc() {
        return this.src;
    }

    public int iZ(int i) {
        if (i <= 0) {
            return 0;
        }
        return (this.height * i) / this.width;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 3;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        return this.cnz;
    }
}
