package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class z {
    public String bYk;
    public String cma;
    public String dhw;
    public String ePc;
    public String iyj;
    public String iyk;
    public String iyl;
    public String iym;
    public String iyn;
    public String iyo;
    public String iyp;
    public String iyq;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an d(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.bS("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.cma)) {
                anVar.bS("tid", this.cma);
            }
            if (!StringUtils.isNull(this.ePc)) {
                anVar.bS("fid", this.ePc);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.bS("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.bS("obj_source", this.mSource);
            } else {
                anVar.O("obj_source", 0);
            }
            if (!StringUtils.isNull(this.iyj)) {
                anVar.bS("obj_param1", this.iyj);
            } else {
                anVar.O("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.iyk)) {
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, this.iyk);
            }
            if (!StringUtils.isNull(this.iyl)) {
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, this.iyl);
            }
            if (!StringUtils.isNull(this.bYk)) {
                anVar.bS("obj_id", this.bYk);
            }
            if (!StringUtils.isNull(this.iym)) {
                anVar.bS(TiebaInitialize.Params.AB_TAG, this.iym);
            } else {
                anVar.O(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.iyo)) {
                anVar.bS("topic_type", this.iyo);
            }
            if (!StringUtils.isNull(this.dhw)) {
                anVar.bS("extra", this.dhw);
            } else {
                anVar.O("extra", 0);
            }
            if (!StringUtils.isNull(this.iyp)) {
                anVar.bS("is_vertical", this.iyp);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.bS("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.iyq)) {
                anVar.bS("resource_id", this.iyq);
            }
        }
        return anVar;
    }

    public z ccS() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.cma = this.cma;
        zVar.ePc = this.ePc;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.iyj = this.iyj;
        zVar.iyk = this.iyk;
        zVar.iyl = this.iyl;
        zVar.bYk = this.bYk;
        zVar.iym = this.iym;
        zVar.iyn = this.iyn;
        zVar.iyo = this.iyo;
        zVar.mFloor = this.mFloor;
        zVar.iyq = this.iyq;
        return zVar;
    }
}
