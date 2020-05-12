package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String ahO;
    public String dop;
    public String eQk;
    public String kir;
    public String kis;
    public String kit;
    public int kiu;
    public String kiv;
    public String kiw;
    public String kix;
    public String kiy;
    public String kiz;
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
                anVar.cI("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.ahO)) {
                anVar.cI("tid", this.ahO);
            }
            if (!StringUtils.isNull(this.eQk)) {
                anVar.cI("fid", this.eQk);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cI("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cI("obj_source", this.mSource);
            } else {
                anVar.af("obj_source", 0);
            }
            if (!StringUtils.isNull(this.kir)) {
                anVar.cI("obj_param1", this.kir);
            } else {
                anVar.af("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.kis)) {
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, this.kis);
            }
            if (!StringUtils.isNull(this.kit)) {
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, this.kit);
            }
            if (this.kiu > 0) {
                anVar.af("obj_param5", this.kiu);
            }
            if (!StringUtils.isNull(this.dop)) {
                anVar.cI("obj_id", this.dop);
            }
            if (!StringUtils.isNull(this.kiv)) {
                anVar.cI(TiebaInitialize.Params.AB_TAG, this.kiv);
            } else {
                anVar.af(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.kix)) {
                anVar.cI("topic_type", this.kix);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cI("extra", this.mExtra);
            } else {
                anVar.af("extra", 0);
            }
            if (!StringUtils.isNull(this.kiy)) {
                anVar.cI("is_vertical", this.kiy);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cI("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.kiz)) {
                anVar.cI("resource_id", this.kiz);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                anVar.cI("group_id", this.mGroupId);
            }
            anVar.cI("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cI("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y cKq() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.ahO = this.ahO;
        yVar.eQk = this.eQk;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.kir = this.kir;
        yVar.kis = this.kis;
        yVar.kit = this.kit;
        yVar.dop = this.dop;
        yVar.kiv = this.kiv;
        yVar.kiw = this.kiw;
        yVar.kix = this.kix;
        yVar.mFloor = this.mFloor;
        yVar.kiz = this.kiz;
        yVar.mGroupId = this.mGroupId;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
