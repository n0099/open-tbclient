package com.baidu.tieba.pb.b.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class e implements ae, d {
    private int height;
    private ArrayList<PreLoadImageInfo> iVu;
    public String iVv;
    private String src;
    private int width;

    public e(ExcContent excContent) {
        if (excContent != null && excContent.type != null && excContent.type.equals(3L)) {
            this.iVu = new ArrayList<>(1);
            this.src = excContent.src;
            this.iVv = excContent.bsize;
            if (this.iVv != null) {
                try {
                    String[] split = this.iVv.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.f.b.toInt(split[0], 0);
                    this.height = com.baidu.adp.lib.f.b.toInt(split[1], 0);
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
            this.iVu.add(preLoadImageInfo);
        }
    }

    public String getSrc() {
        return this.src;
    }

    public int zl(int i) {
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
        return this.iVu;
    }
}
