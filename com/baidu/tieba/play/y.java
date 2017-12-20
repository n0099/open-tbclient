package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class y {
    public String WF;
    public String aAs;
    public String aMU;
    public String fRi;
    public String fRj;
    public String fRk;
    public String fRl;
    public String fRm;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aMU)) {
                akVar.ac("tid", this.aMU);
            }
            if (!StringUtils.isNull(this.aAs)) {
                akVar.ac(ImageViewerConfig.FORUM_ID, this.aAs);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ac("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fRi)) {
                akVar.ac("obj_param1", this.fRi);
            }
            if (!StringUtils.isNull(this.fRj)) {
                akVar.ac("obj_param2", this.fRj);
            }
            if (!StringUtils.isNull(this.fRk)) {
                akVar.ac("obj_param3", this.fRk);
            }
            if (!StringUtils.isNull(this.WF)) {
                akVar.ac("obj_id", this.WF);
            }
            if (!StringUtils.isNull(this.fRl)) {
                akVar.ac("ab_tag", this.fRl);
            }
        }
        return akVar;
    }

    public y bjK() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aMU = this.aMU;
        yVar.aAs = this.aAs;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.fRi = this.fRi;
        yVar.fRj = this.fRj;
        yVar.fRk = this.fRk;
        yVar.WF = this.WF;
        yVar.fRl = this.fRl;
        yVar.fRm = this.fRm;
        return yVar;
    }
}
