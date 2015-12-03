package com.baidu.tieba.pb.c.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class e implements aj, d {
    private String big_cdn_src;
    private String big_src;
    private long cIm;
    private ArrayList<ai> cIn;
    private String cdn_src;
    private int height;
    private String src;
    private int width;

    public e(ExcContent excContent) {
        if (excContent != null && excContent.type.longValue() == 3) {
            this.cIn = new ArrayList<>(1);
            this.src = excContent.src;
            this.big_src = excContent.big_src;
            this.big_cdn_src = excContent.big_cdn_src;
            this.cIm = excContent.type.longValue();
            String str = excContent.bsize;
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
            this.cdn_src = excContent.cdn_src;
            ai aiVar = new ai();
            aiVar.abp = 17;
            aiVar.height = this.height;
            aiVar.width = this.width;
            if (StringUtils.isNull(this.cdn_src)) {
                aiVar.WN = this.src;
            } else {
                aiVar.WN = this.cdn_src;
            }
            this.cIn.add(aiVar);
        }
    }

    public String getSrc() {
        return this.src;
    }

    public int kh(int i) {
        if (i <= 0) {
            return 0;
        }
        return (this.height * i) / this.width;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 3;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        return this.cIn;
    }
}
