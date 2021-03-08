package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class o {
    public String anU;
    public String ePf;
    public String eVa;
    public String fOD;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mKA;
    public String mKB;
    public int mKC;
    public String mKD;
    public String mKE;
    public String mKF;
    public String mKG;
    public String mKH;
    public String mKI;
    public String mKz;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public ar f(ar arVar) {
        if (arVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                arVar.dR("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.anU)) {
                arVar.dR("tid", this.anU);
            }
            if (!StringUtils.isNull(this.fOD)) {
                arVar.dR("fid", this.fOD);
            }
            if (!StringUtils.isNull(this.mUid)) {
                arVar.dR("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                arVar.dR("obj_source", this.mSource);
            } else {
                arVar.aq("obj_source", 0);
            }
            if (!StringUtils.isNull(this.mKz)) {
                arVar.dR("obj_param1", this.mKz);
            } else {
                arVar.aq("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mKA)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, this.mKA);
            }
            if (!StringUtils.isNull(this.mKB)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, this.mKB);
            }
            if (this.mKC > 0) {
                arVar.aq("obj_param5", this.mKC);
            }
            if (!StringUtils.isNull(this.ePf)) {
                arVar.dR("obj_id", this.ePf);
            }
            if (!StringUtils.isNull(this.mKD)) {
                arVar.dR("ab_tag", this.mKD);
            } else {
                arVar.aq("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mKF)) {
                arVar.dR("topic_type", this.mKF);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                arVar.dR("extra", this.mExtra);
            } else {
                arVar.aq("extra", 0);
            }
            if (!StringUtils.isNull(this.mKG)) {
                arVar.dR("is_vertical", this.mKG);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                arVar.dR("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mKH)) {
                arVar.dR("resource_id", this.mKH);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                arVar.dR("group_id", this.mGroupId);
            }
            arVar.dR("obj_param4", StringUtils.isNull(this.eVa) ? "" : this.eVa);
            arVar.dR("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            arVar.dR(IntentConfig.NID, StringUtils.isNull(this.mKI) ? "" : this.mKI);
        }
        return arVar;
    }

    public o dAw() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.anU = this.anU;
        oVar.fOD = this.fOD;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mKz = this.mKz;
        oVar.mKA = this.mKA;
        oVar.mKB = this.mKB;
        oVar.ePf = this.ePf;
        oVar.mKD = this.mKD;
        oVar.mKE = this.mKE;
        oVar.mKF = this.mKF;
        oVar.mFloor = this.mFloor;
        oVar.mKH = this.mKH;
        oVar.mGroupId = this.mGroupId;
        oVar.eVa = this.eVa;
        oVar.mVid = this.mVid;
        oVar.mKI = this.mKI;
        return oVar;
    }
}
