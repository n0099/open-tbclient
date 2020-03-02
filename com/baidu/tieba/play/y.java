package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String Pj;
    public String cOR;
    public String emb;
    public String jwG;
    public String jwH;
    public String jwI;
    public int jwJ;
    public String jwK;
    public String jwL;
    public String jwM;
    public String jwN;
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
            if (!StringUtils.isNull(this.emb)) {
                anVar.cy("fid", this.emb);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cy("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cy("obj_source", this.mSource);
            } else {
                anVar.X("obj_source", 0);
            }
            if (!StringUtils.isNull(this.jwG)) {
                anVar.cy("obj_param1", this.jwG);
            } else {
                anVar.X("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jwH)) {
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, this.jwH);
            }
            if (!StringUtils.isNull(this.jwI)) {
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, this.jwI);
            }
            if (this.jwJ > 0) {
                anVar.X("obj_param5", this.jwJ);
            }
            if (!StringUtils.isNull(this.cOR)) {
                anVar.cy("obj_id", this.cOR);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cy(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.X(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jwL)) {
                anVar.cy("topic_type", this.jwL);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cy("extra", this.mExtra);
            } else {
                anVar.X("extra", 0);
            }
            if (!StringUtils.isNull(this.jwM)) {
                anVar.cy("is_vertical", this.jwM);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cy("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jwN)) {
                anVar.cy("resource_id", this.jwN);
            }
            anVar.cy("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cy("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y czt() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.Pj = this.Pj;
        yVar.emb = this.emb;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jwG = this.jwG;
        yVar.jwH = this.jwH;
        yVar.jwI = this.jwI;
        yVar.cOR = this.cOR;
        yVar.mAbTag = this.mAbTag;
        yVar.jwK = this.jwK;
        yVar.jwL = this.jwL;
        yVar.mFloor = this.mFloor;
        yVar.jwN = this.jwN;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
