package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String bFP;
    public String bVL;
    public String eAB;
    public String eAx;
    public String ire;
    public String irf;
    public String irg;
    public String irh;
    public String iri;
    public String irj;
    public String irk;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am c(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.bT("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bVL)) {
                amVar.bT("tid", this.bVL);
            }
            if (!StringUtils.isNull(this.eAB)) {
                amVar.bT("fid", this.eAB);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.bT("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.ire)) {
                amVar.bT("obj_param1", this.ire);
            } else {
                amVar.P("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.irf)) {
                amVar.bT("obj_param2", this.irf);
            }
            if (!StringUtils.isNull(this.irg)) {
                amVar.bT("obj_param3", this.irg);
            }
            if (!StringUtils.isNull(this.bFP)) {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFP);
            }
            if (!StringUtils.isNull(this.irh)) {
                amVar.bT("ab_tag", this.irh);
            } else {
                amVar.P("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.irj)) {
                amVar.bT("topic_type", this.irj);
            }
            if (!StringUtils.isNull(this.eAx)) {
                amVar.bT("extra", this.eAx);
            } else {
                amVar.P("extra", 0);
            }
            if (!StringUtils.isNull(this.irk)) {
                amVar.bT("is_vertical", this.irk);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.bT("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z cbT() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bVL = this.bVL;
        zVar.eAB = this.eAB;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.ire = this.ire;
        zVar.irf = this.irf;
        zVar.irg = this.irg;
        zVar.bFP = this.bFP;
        zVar.irh = this.irh;
        zVar.iri = this.iri;
        zVar.irj = this.irj;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
