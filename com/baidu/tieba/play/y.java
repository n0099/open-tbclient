package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String Pj;
    public String cOQ;
    public String ema;
    public String jwE;
    public String jwF;
    public String jwG;
    public int jwH;
    public String jwI;
    public String jwJ;
    public String jwK;
    public String jwL;
    public String mAbTag;
    public String mExtra;
    public String mFloor;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public an e(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.cy("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.Pj)) {
                anVar.cy("tid", this.Pj);
            }
            if (!StringUtils.isNull(this.ema)) {
                anVar.cy("fid", this.ema);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cy("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cy("obj_source", this.mSource);
            } else {
                anVar.X("obj_source", 0);
            }
            if (!StringUtils.isNull(this.jwE)) {
                anVar.cy("obj_param1", this.jwE);
            } else {
                anVar.X("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jwF)) {
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, this.jwF);
            }
            if (!StringUtils.isNull(this.jwG)) {
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, this.jwG);
            }
            if (this.jwH > 0) {
                anVar.X("obj_param5", this.jwH);
            }
            if (!StringUtils.isNull(this.cOQ)) {
                anVar.cy("obj_id", this.cOQ);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cy(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.X(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jwJ)) {
                anVar.cy("topic_type", this.jwJ);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cy("extra", this.mExtra);
            } else {
                anVar.X("extra", 0);
            }
            if (!StringUtils.isNull(this.jwK)) {
                anVar.cy("is_vertical", this.jwK);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cy("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jwL)) {
                anVar.cy("resource_id", this.jwL);
            }
            anVar.cy("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cy("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y czr() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.Pj = this.Pj;
        yVar.ema = this.ema;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jwE = this.jwE;
        yVar.jwF = this.jwF;
        yVar.jwG = this.jwG;
        yVar.cOQ = this.cOQ;
        yVar.mAbTag = this.mAbTag;
        yVar.jwI = this.jwI;
        yVar.jwJ = this.jwJ;
        yVar.mFloor = this.mFloor;
        yVar.jwL = this.jwL;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
