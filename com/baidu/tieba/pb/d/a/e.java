package com.baidu.tieba.pb.d.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class e implements ai, d {
    private String big_cdn_src;
    private String big_src;
    private long cVc;
    private ArrayList<ah> cVd;
    public String cVe;
    private String cdn_src;
    private int height;
    private String src;
    private int width;

    public e(ExcContent excContent) {
        if (excContent != null && excContent.type.longValue() == 3) {
            this.cVd = new ArrayList<>(1);
            this.src = excContent.src;
            this.big_src = excContent.big_src;
            this.big_cdn_src = excContent.big_cdn_src;
            this.cVc = excContent.type.longValue();
            this.cVe = excContent.bsize;
            if (this.cVe != null) {
                try {
                    String[] split = this.cVe.split(",");
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
            ah ahVar = new ah();
            ahVar.acq = 17;
            ahVar.height = this.height;
            ahVar.width = this.width;
            if (StringUtils.isNull(this.cdn_src)) {
                ahVar.imgUrl = this.src;
            } else {
                ahVar.imgUrl = this.cdn_src;
            }
            this.cVd.add(ahVar);
        }
    }

    public String getSrc() {
        return this.src;
    }

    public int li(int i) {
        if (i <= 0) {
            return 0;
        }
        return (this.height * i) / this.width;
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public int getType() {
        return 3;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<ah> getImages() {
        return this.cVd;
    }
}
