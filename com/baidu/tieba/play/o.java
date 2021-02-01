package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class o {
    public String amC;
    public String eNE;
    public String eTz;
    public String fNd;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mIe;
    public String mIf;
    public String mIg;
    public int mIh;
    public String mIi;
    public String mIj;
    public String mIk;
    public String mIl;
    public String mIm;
    public String mIn;
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
            if (!StringUtils.isNull(this.amC)) {
                arVar.dR("tid", this.amC);
            }
            if (!StringUtils.isNull(this.fNd)) {
                arVar.dR("fid", this.fNd);
            }
            if (!StringUtils.isNull(this.mUid)) {
                arVar.dR("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                arVar.dR("obj_source", this.mSource);
            } else {
                arVar.ap("obj_source", 0);
            }
            if (!StringUtils.isNull(this.mIe)) {
                arVar.dR("obj_param1", this.mIe);
            } else {
                arVar.ap("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mIf)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, this.mIf);
            }
            if (!StringUtils.isNull(this.mIg)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, this.mIg);
            }
            if (this.mIh > 0) {
                arVar.ap("obj_param5", this.mIh);
            }
            if (!StringUtils.isNull(this.eNE)) {
                arVar.dR("obj_id", this.eNE);
            }
            if (!StringUtils.isNull(this.mIi)) {
                arVar.dR("ab_tag", this.mIi);
            } else {
                arVar.ap("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mIk)) {
                arVar.dR("topic_type", this.mIk);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                arVar.dR("extra", this.mExtra);
            } else {
                arVar.ap("extra", 0);
            }
            if (!StringUtils.isNull(this.mIl)) {
                arVar.dR("is_vertical", this.mIl);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                arVar.dR("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mIm)) {
                arVar.dR("resource_id", this.mIm);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                arVar.dR("group_id", this.mGroupId);
            }
            arVar.dR("obj_param4", StringUtils.isNull(this.eTz) ? "" : this.eTz);
            arVar.dR("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            arVar.dR(IntentConfig.NID, StringUtils.isNull(this.mIn) ? "" : this.mIn);
        }
        return arVar;
    }

    public o dAh() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.amC = this.amC;
        oVar.fNd = this.fNd;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mIe = this.mIe;
        oVar.mIf = this.mIf;
        oVar.mIg = this.mIg;
        oVar.eNE = this.eNE;
        oVar.mIi = this.mIi;
        oVar.mIj = this.mIj;
        oVar.mIk = this.mIk;
        oVar.mFloor = this.mFloor;
        oVar.mIm = this.mIm;
        oVar.mGroupId = this.mGroupId;
        oVar.eTz = this.eTz;
        oVar.mVid = this.mVid;
        oVar.mIn = this.mIn;
        return oVar;
    }
}
