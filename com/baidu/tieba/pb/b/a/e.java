package com.baidu.tieba.pb.b.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class e implements ae, d {
    private ArrayList<PreLoadImageInfo> fTU;
    public String fTV;
    private int height;
    private String src;
    private int width;

    public e(ExcContent excContent) {
        if (excContent != null && excContent.type != null && excContent.type.equals(3L)) {
            this.fTU = new ArrayList<>(1);
            this.src = excContent.src;
            this.fTV = excContent.bsize;
            if (this.fTV != null) {
                try {
                    String[] split = this.fTV.split(",");
                    this.width = com.baidu.adp.lib.g.b.l(split[0], 0);
                    this.height = com.baidu.adp.lib.g.b.l(split[1], 0);
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
            String str = excContent.cdn_src;
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.procType = 17;
            preLoadImageInfo.height = this.height;
            preLoadImageInfo.width = this.width;
            if (StringUtils.isNull(str)) {
                preLoadImageInfo.imgUrl = this.src;
            } else {
                preLoadImageInfo.imgUrl = str;
            }
            this.fTU.add(preLoadImageInfo);
        }
    }

    public String Pi() {
        return this.src;
    }

    public int rz(int i) {
        if (i <= 0) {
            return 0;
        }
        return (this.height * i) / this.width;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 3;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        return this.fTU;
    }
}
