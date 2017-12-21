package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class y {
    public String WI;
    public String aAv;
    public String aMX;
    public String fRn;
    public String fRo;
    public String fRp;
    public String fRq;
    public String fRr;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aMX)) {
                akVar.ac("tid", this.aMX);
            }
            if (!StringUtils.isNull(this.aAv)) {
                akVar.ac(ImageViewerConfig.FORUM_ID, this.aAv);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ac("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fRn)) {
                akVar.ac("obj_param1", this.fRn);
            }
            if (!StringUtils.isNull(this.fRo)) {
                akVar.ac("obj_param2", this.fRo);
            }
            if (!StringUtils.isNull(this.fRp)) {
                akVar.ac("obj_param3", this.fRp);
            }
            if (!StringUtils.isNull(this.WI)) {
                akVar.ac("obj_id", this.WI);
            }
            if (!StringUtils.isNull(this.fRq)) {
                akVar.ac("ab_tag", this.fRq);
            }
        }
        return akVar;
    }

    public y bjL() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aMX = this.aMX;
        yVar.aAv = this.aAv;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.fRn = this.fRn;
        yVar.fRo = this.fRo;
        yVar.fRp = this.fRp;
        yVar.WI = this.WI;
        yVar.fRq = this.fRq;
        yVar.fRr = this.fRr;
        return yVar;
    }
}
