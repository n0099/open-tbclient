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
    public String mIA;
    public String mIB;
    public String mIC;
    public String mIE;
    public String mIF;
    public String mIv;
    public String mIw;
    public String mIx;
    public int mIy;
    public String mIz;
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
            if (!StringUtils.isNull(this.mIv)) {
                arVar.dR("obj_param1", this.mIv);
            } else {
                arVar.ap("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mIw)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, this.mIw);
            }
            if (!StringUtils.isNull(this.mIx)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, this.mIx);
            }
            if (this.mIy > 0) {
                arVar.ap("obj_param5", this.mIy);
            }
            if (!StringUtils.isNull(this.eNE)) {
                arVar.dR("obj_id", this.eNE);
            }
            if (!StringUtils.isNull(this.mIz)) {
                arVar.dR("ab_tag", this.mIz);
            } else {
                arVar.ap("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mIB)) {
                arVar.dR("topic_type", this.mIB);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                arVar.dR("extra", this.mExtra);
            } else {
                arVar.ap("extra", 0);
            }
            if (!StringUtils.isNull(this.mIC)) {
                arVar.dR("is_vertical", this.mIC);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                arVar.dR("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mIE)) {
                arVar.dR("resource_id", this.mIE);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                arVar.dR("group_id", this.mGroupId);
            }
            arVar.dR("obj_param4", StringUtils.isNull(this.eTz) ? "" : this.eTz);
            arVar.dR("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            arVar.dR(IntentConfig.NID, StringUtils.isNull(this.mIF) ? "" : this.mIF);
        }
        return arVar;
    }

    public o dAo() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.amC = this.amC;
        oVar.fNd = this.fNd;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mIv = this.mIv;
        oVar.mIw = this.mIw;
        oVar.mIx = this.mIx;
        oVar.eNE = this.eNE;
        oVar.mIz = this.mIz;
        oVar.mIA = this.mIA;
        oVar.mIB = this.mIB;
        oVar.mFloor = this.mFloor;
        oVar.mIE = this.mIE;
        oVar.mGroupId = this.mGroupId;
        oVar.eTz = this.eTz;
        oVar.mVid = this.mVid;
        oVar.mIF = this.mIF;
        return oVar;
    }
}
