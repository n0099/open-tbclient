package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class o {
    public String ajJ;
    public String dOV;
    public String eKO;
    public String lcJ;
    public String lcK;
    public String lcL;
    public int lcM;
    public String lcN;
    public String lcO;
    public String lcP;
    public String lcQ;
    public String lcR;
    public String lcS;
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
            if (!StringUtils.isNull(this.lcJ)) {
                apVar.dn("obj_param1", this.lcJ);
            } else {
                apVar.ah("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.lcK)) {
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, this.lcK);
            }
            if (!StringUtils.isNull(this.lcL)) {
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, this.lcL);
            }
            if (this.lcM > 0) {
                apVar.ah("obj_param5", this.lcM);
            }
            if (!StringUtils.isNull(this.dOV)) {
                apVar.dn("obj_id", this.dOV);
            }
            if (!StringUtils.isNull(this.lcN)) {
                apVar.dn("ab_tag", this.lcN);
            } else {
                apVar.ah("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.lcP)) {
                apVar.dn("topic_type", this.lcP);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                apVar.dn("extra", this.mExtra);
            } else {
                apVar.ah("extra", 0);
            }
            if (!StringUtils.isNull(this.lcQ)) {
                apVar.dn("is_vertical", this.lcQ);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                apVar.dn("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.lcR)) {
                apVar.dn("resource_id", this.lcR);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                apVar.dn("group_id", this.mGroupId);
            }
            apVar.dn("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            apVar.dn("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            apVar.dn("nid", StringUtils.isNull(this.lcS) ? "" : this.lcS);
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
        oVar.lcJ = this.lcJ;
        oVar.lcK = this.lcK;
        oVar.lcL = this.lcL;
        oVar.dOV = this.dOV;
        oVar.lcN = this.lcN;
        oVar.lcO = this.lcO;
        oVar.lcP = this.lcP;
        oVar.mFloor = this.mFloor;
        oVar.lcR = this.lcR;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.lcS = this.lcS;
        return oVar;
    }
}
