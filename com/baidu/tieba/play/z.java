package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class z {
    public String bHq;
    public String bXN;
    public String eHk;
    public String eHo;
    public String iAD;
    public String iAE;
    public String iAF;
    public String iAG;
    public String iAH;
    public String iAI;
    public String iAJ;
    public String iAK;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an d(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.bT("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bXN)) {
                anVar.bT("tid", this.bXN);
            }
            if (!StringUtils.isNull(this.eHo)) {
                anVar.bT("fid", this.eHo);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.bT("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.iAD)) {
                anVar.bT("obj_param1", this.iAD);
            } else {
                anVar.P("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.iAE)) {
                anVar.bT("obj_param2", this.iAE);
            }
            if (!StringUtils.isNull(this.iAF)) {
                anVar.bT("obj_param3", this.iAF);
            }
            if (!StringUtils.isNull(this.bHq)) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bHq);
            }
            if (!StringUtils.isNull(this.iAG)) {
                anVar.bT("ab_tag", this.iAG);
            } else {
                anVar.P("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.iAI)) {
                anVar.bT("topic_type", this.iAI);
            }
            if (!StringUtils.isNull(this.eHk)) {
                anVar.bT("extra", this.eHk);
            } else {
                anVar.P("extra", 0);
            }
            if (!StringUtils.isNull(this.iAJ)) {
                anVar.bT("is_vertical", this.iAJ);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.bT("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.iAK)) {
                anVar.bT("resource_id", this.iAK);
            }
        }
        return anVar;
    }

    public z cfT() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bXN = this.bXN;
        zVar.eHo = this.eHo;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.iAD = this.iAD;
        zVar.iAE = this.iAE;
        zVar.iAF = this.iAF;
        zVar.bHq = this.bHq;
        zVar.iAG = this.iAG;
        zVar.iAH = this.iAH;
        zVar.iAI = this.iAI;
        zVar.mFloor = this.mFloor;
        zVar.iAK = this.iAK;
        return zVar;
    }
}
