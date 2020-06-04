package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String ais;
    public String dCp;
    public String evm;
    public String kBA;
    public String kBr;
    public String kBs;
    public String kBt;
    public int kBu;
    public String kBv;
    public String kBw;
    public String kBx;
    public String kBy;
    public String kBz;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public an f(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.dh("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.ais)) {
                anVar.dh("tid", this.ais);
            }
            if (!StringUtils.isNull(this.evm)) {
                anVar.dh("fid", this.evm);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.dh("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.dh("obj_source", this.mSource);
            } else {
                anVar.ag("obj_source", 0);
            }
            if (!StringUtils.isNull(this.kBr)) {
                anVar.dh("obj_param1", this.kBr);
            } else {
                anVar.ag("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.kBs)) {
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, this.kBs);
            }
            if (!StringUtils.isNull(this.kBt)) {
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, this.kBt);
            }
            if (this.kBu > 0) {
                anVar.ag("obj_param5", this.kBu);
            }
            if (!StringUtils.isNull(this.dCp)) {
                anVar.dh("obj_id", this.dCp);
            }
            if (!StringUtils.isNull(this.kBv)) {
                anVar.dh("ab_tag", this.kBv);
            } else {
                anVar.ag("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.kBx)) {
                anVar.dh("topic_type", this.kBx);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.dh("extra", this.mExtra);
            } else {
                anVar.ag("extra", 0);
            }
            if (!StringUtils.isNull(this.kBy)) {
                anVar.dh("is_vertical", this.kBy);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.dh("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.kBz)) {
                anVar.dh("resource_id", this.kBz);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                anVar.dh("group_id", this.mGroupId);
            }
            anVar.dh("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.dh("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            anVar.dh("nid", StringUtils.isNull(this.kBA) ? "" : this.kBA);
        }
        return anVar;
    }

    public y cRF() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.ais = this.ais;
        yVar.evm = this.evm;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.kBr = this.kBr;
        yVar.kBs = this.kBs;
        yVar.kBt = this.kBt;
        yVar.dCp = this.dCp;
        yVar.kBv = this.kBv;
        yVar.kBw = this.kBw;
        yVar.kBx = this.kBx;
        yVar.mFloor = this.mFloor;
        yVar.kBz = this.kBz;
        yVar.mGroupId = this.mGroupId;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        yVar.kBA = this.kBA;
        return yVar;
    }
}
