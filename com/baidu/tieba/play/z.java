package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String bFP;
    public String bVL;
    public String eAC;
    public String eAy;
    public String irh;
    public String iri;
    public String irj;
    public String irk;
    public String irl;
    public String irm;
    public String irn;
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
            if (!StringUtils.isNull(this.eAC)) {
                amVar.bT("fid", this.eAC);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.bT("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.irh)) {
                amVar.bT("obj_param1", this.irh);
            } else {
                amVar.P("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.iri)) {
                amVar.bT("obj_param2", this.iri);
            }
            if (!StringUtils.isNull(this.irj)) {
                amVar.bT("obj_param3", this.irj);
            }
            if (!StringUtils.isNull(this.bFP)) {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFP);
            }
            if (!StringUtils.isNull(this.irk)) {
                amVar.bT("ab_tag", this.irk);
            } else {
                amVar.P("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.irm)) {
                amVar.bT("topic_type", this.irm);
            }
            if (!StringUtils.isNull(this.eAy)) {
                amVar.bT("extra", this.eAy);
            } else {
                amVar.P("extra", 0);
            }
            if (!StringUtils.isNull(this.irn)) {
                amVar.bT("is_vertical", this.irn);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.bT("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z cbW() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bVL = this.bVL;
        zVar.eAC = this.eAC;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.irh = this.irh;
        zVar.iri = this.iri;
        zVar.irj = this.irj;
        zVar.bFP = this.bFP;
        zVar.irk = this.irk;
        zVar.irl = this.irl;
        zVar.irm = this.irm;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
