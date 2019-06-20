package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String bFQ;
    public String bVM;
    public String eAC;
    public String eAy;
    public String iri;
    public String irj;
    public String irk;
    public String irl;
    public String irm;
    public String irn;
    public String iro;
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
            if (!StringUtils.isNull(this.bVM)) {
                amVar.bT("tid", this.bVM);
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
            if (!StringUtils.isNull(this.iri)) {
                amVar.bT("obj_param1", this.iri);
            } else {
                amVar.P("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.irj)) {
                amVar.bT("obj_param2", this.irj);
            }
            if (!StringUtils.isNull(this.irk)) {
                amVar.bT("obj_param3", this.irk);
            }
            if (!StringUtils.isNull(this.bFQ)) {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bFQ);
            }
            if (!StringUtils.isNull(this.irl)) {
                amVar.bT("ab_tag", this.irl);
            } else {
                amVar.P("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.irn)) {
                amVar.bT("topic_type", this.irn);
            }
            if (!StringUtils.isNull(this.eAy)) {
                amVar.bT("extra", this.eAy);
            } else {
                amVar.P("extra", 0);
            }
            if (!StringUtils.isNull(this.iro)) {
                amVar.bT("is_vertical", this.iro);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.bT("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z cbX() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bVM = this.bVM;
        zVar.eAC = this.eAC;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.iri = this.iri;
        zVar.irj = this.irj;
        zVar.irk = this.irk;
        zVar.bFQ = this.bFQ;
        zVar.irl = this.irl;
        zVar.irm = this.irm;
        zVar.irn = this.irn;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
