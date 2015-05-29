package com.baidu.tieba.pb.d.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class f implements ap, e {
    private long bQF;
    private ArrayList<ao> bQG;
    private String big_cdn_src;
    private String big_src;
    private String cdn_src;
    private int height;
    private String src;
    private int width;

    public f(Content content) {
        if (content != null && content.type.longValue() == 3) {
            this.bQG = new ArrayList<>(1);
            this.src = content.src;
            this.big_src = content.big_src;
            this.big_cdn_src = content.big_cdn_src;
            this.bQF = content.type.longValue();
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
            ao aoVar = new ao();
            aoVar.Vx = 17;
            aoVar.height = this.height;
            aoVar.width = this.width;
            if (StringUtils.isNull(this.cdn_src)) {
                aoVar.Ri = this.src;
            } else {
                aoVar.Ri = this.cdn_src;
            }
            this.bQG.add(aoVar);
        }
    }

    public String getSrc() {
        return this.src;
    }

    public int hJ(int i) {
        if (i <= 0) {
            return 0;
        }
        return (this.height * i) / this.width;
    }

    @Override // com.baidu.tieba.pb.d.a.e
    public int getType() {
        return 3;
    }

    @Override // com.baidu.tbadk.core.util.ap
    public ArrayList<ao> getImages() {
        return this.bQG;
    }
}
