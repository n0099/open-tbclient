package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String ais;
    public String dCp;
    public String evm;
    public String kAl;
    public String kAm;
    public String kAn;
    public int kAo;
    public String kAp;
    public String kAq;
    public String kAr;
    public String kAs;
    public String kAt;
    public String kAu;
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
            if (!StringUtils.isNull(this.kAl)) {
                anVar.dh("obj_param1", this.kAl);
            } else {
                anVar.ag("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.kAm)) {
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, this.kAm);
            }
            if (!StringUtils.isNull(this.kAn)) {
                anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, this.kAn);
            }
            if (this.kAo > 0) {
                anVar.ag("obj_param5", this.kAo);
            }
            if (!StringUtils.isNull(this.dCp)) {
                anVar.dh("obj_id", this.dCp);
            }
            if (!StringUtils.isNull(this.kAp)) {
                anVar.dh("ab_tag", this.kAp);
            } else {
                anVar.ag("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.kAr)) {
                anVar.dh("topic_type", this.kAr);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.dh("extra", this.mExtra);
            } else {
                anVar.ag("extra", 0);
            }
            if (!StringUtils.isNull(this.kAs)) {
                anVar.dh("is_vertical", this.kAs);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.dh("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.kAt)) {
                anVar.dh("resource_id", this.kAt);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                anVar.dh("group_id", this.mGroupId);
            }
            anVar.dh("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.dh("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            anVar.dh("nid", StringUtils.isNull(this.kAu) ? "" : this.kAu);
        }
        return anVar;
    }

    public y cRp() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.ais = this.ais;
        yVar.evm = this.evm;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.kAl = this.kAl;
        yVar.kAm = this.kAm;
        yVar.kAn = this.kAn;
        yVar.dCp = this.dCp;
        yVar.kAp = this.kAp;
        yVar.kAq = this.kAq;
        yVar.kAr = this.kAr;
        yVar.mFloor = this.mFloor;
        yVar.kAt = this.kAt;
        yVar.mGroupId = this.mGroupId;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        yVar.kAu = this.kAu;
        return yVar;
    }
}
