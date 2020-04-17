package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String ahL;
    public String dol;
    public String eQf;
    public String kin;
    public String kio;
    public String kip;
    public int kiq;
    public String kir;
    public String kis;
    public String kit;
    public String kiu;
    public String kiv;
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
            if (!StringUtils.isNull(this.ahL)) {
                anVar.cI("tid", this.ahL);
            }
            if (!StringUtils.isNull(this.eQf)) {
                anVar.cI("fid", this.eQf);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cI("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cI("obj_source", this.mSource);
            } else {
                anVar.af("obj_source", 0);
            }
            if (!StringUtils.isNull(this.kin)) {
                anVar.cI("obj_param1", this.kin);
            } else {
                anVar.af("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.kio)) {
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, this.kio);
            }
            if (!StringUtils.isNull(this.kip)) {
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, this.kip);
            }
            if (this.kiq > 0) {
                anVar.af("obj_param5", this.kiq);
            }
            if (!StringUtils.isNull(this.dol)) {
                anVar.cI("obj_id", this.dol);
            }
            if (!StringUtils.isNull(this.kir)) {
                anVar.cI(TiebaInitialize.Params.AB_TAG, this.kir);
            } else {
                anVar.af(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.kit)) {
                anVar.cI("topic_type", this.kit);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cI("extra", this.mExtra);
            } else {
                anVar.af("extra", 0);
            }
            if (!StringUtils.isNull(this.kiu)) {
                anVar.cI("is_vertical", this.kiu);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cI("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.kiv)) {
                anVar.cI("resource_id", this.kiv);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                anVar.cI("group_id", this.mGroupId);
            }
            anVar.cI("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cI("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y cKs() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.ahL = this.ahL;
        yVar.eQf = this.eQf;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.kin = this.kin;
        yVar.kio = this.kio;
        yVar.kip = this.kip;
        yVar.dol = this.dol;
        yVar.kir = this.kir;
        yVar.kis = this.kis;
        yVar.kit = this.kit;
        yVar.mFloor = this.mFloor;
        yVar.kiv = this.kiv;
        yVar.mGroupId = this.mGroupId;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
