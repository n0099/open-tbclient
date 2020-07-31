package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class o {
    public String ajJ;
    public String dOV;
    public String eKO;
    public String lcH;
    public String lcI;
    public String lcJ;
    public int lcK;
    public String lcL;
    public String lcM;
    public String lcN;
    public String lcO;
    public String lcP;
    public String lcQ;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public ap f(ap apVar) {
        if (apVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                apVar.dn("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.ajJ)) {
                apVar.dn("tid", this.ajJ);
            }
            if (!StringUtils.isNull(this.eKO)) {
                apVar.dn("fid", this.eKO);
            }
            if (!StringUtils.isNull(this.mUid)) {
                apVar.dn("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                apVar.dn("obj_source", this.mSource);
            } else {
                apVar.ah("obj_source", 0);
            }
            if (!StringUtils.isNull(this.lcH)) {
                apVar.dn("obj_param1", this.lcH);
            } else {
                apVar.ah("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.lcI)) {
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, this.lcI);
            }
            if (!StringUtils.isNull(this.lcJ)) {
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, this.lcJ);
            }
            if (this.lcK > 0) {
                apVar.ah("obj_param5", this.lcK);
            }
            if (!StringUtils.isNull(this.dOV)) {
                apVar.dn("obj_id", this.dOV);
            }
            if (!StringUtils.isNull(this.lcL)) {
                apVar.dn("ab_tag", this.lcL);
            } else {
                apVar.ah("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.lcN)) {
                apVar.dn("topic_type", this.lcN);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                apVar.dn("extra", this.mExtra);
            } else {
                apVar.ah("extra", 0);
            }
            if (!StringUtils.isNull(this.lcO)) {
                apVar.dn("is_vertical", this.lcO);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                apVar.dn("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.lcP)) {
                apVar.dn("resource_id", this.lcP);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                apVar.dn("group_id", this.mGroupId);
            }
            apVar.dn("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            apVar.dn("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            apVar.dn("nid", StringUtils.isNull(this.lcQ) ? "" : this.lcQ);
        }
        return apVar;
    }

    public o cZb() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.ajJ = this.ajJ;
        oVar.eKO = this.eKO;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.lcH = this.lcH;
        oVar.lcI = this.lcI;
        oVar.lcJ = this.lcJ;
        oVar.dOV = this.dOV;
        oVar.lcL = this.lcL;
        oVar.lcM = this.lcM;
        oVar.lcN = this.lcN;
        oVar.mFloor = this.mFloor;
        oVar.lcP = this.lcP;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.lcQ = this.lcQ;
        return oVar;
    }
}
