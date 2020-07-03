package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class y {
    public String ajO;
    public String dIK;
    public String eEs;
    public String kVo;
    public String kVp;
    public String kVq;
    public int kVr;
    public String kVs;
    public String kVt;
    public String kVu;
    public String kVv;
    public String kVw;
    public String kVx;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public ao f(ao aoVar) {
        if (aoVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                aoVar.dk("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.ajO)) {
                aoVar.dk("tid", this.ajO);
            }
            if (!StringUtils.isNull(this.eEs)) {
                aoVar.dk("fid", this.eEs);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aoVar.dk("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aoVar.dk("obj_source", this.mSource);
            } else {
                aoVar.ag("obj_source", 0);
            }
            if (!StringUtils.isNull(this.kVo)) {
                aoVar.dk("obj_param1", this.kVo);
            } else {
                aoVar.ag("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.kVp)) {
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, this.kVp);
            }
            if (!StringUtils.isNull(this.kVq)) {
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, this.kVq);
            }
            if (this.kVr > 0) {
                aoVar.ag("obj_param5", this.kVr);
            }
            if (!StringUtils.isNull(this.dIK)) {
                aoVar.dk("obj_id", this.dIK);
            }
            if (!StringUtils.isNull(this.kVs)) {
                aoVar.dk("ab_tag", this.kVs);
            } else {
                aoVar.ag("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.kVu)) {
                aoVar.dk("topic_type", this.kVu);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aoVar.dk("extra", this.mExtra);
            } else {
                aoVar.ag("extra", 0);
            }
            if (!StringUtils.isNull(this.kVv)) {
                aoVar.dk("is_vertical", this.kVv);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aoVar.dk("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.kVw)) {
                aoVar.dk("resource_id", this.kVw);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aoVar.dk("group_id", this.mGroupId);
            }
            aoVar.dk("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aoVar.dk("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aoVar.dk("nid", StringUtils.isNull(this.kVx) ? "" : this.kVx);
        }
        return aoVar;
    }

    public y cVW() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.ajO = this.ajO;
        yVar.eEs = this.eEs;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.kVo = this.kVo;
        yVar.kVp = this.kVp;
        yVar.kVq = this.kVq;
        yVar.dIK = this.dIK;
        yVar.kVs = this.kVs;
        yVar.kVt = this.kVt;
        yVar.kVu = this.kVu;
        yVar.mFloor = this.mFloor;
        yVar.kVw = this.kVw;
        yVar.mGroupId = this.mGroupId;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        yVar.kVx = this.kVx;
        return yVar;
    }
}
