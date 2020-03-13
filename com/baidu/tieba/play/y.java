package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String Pj;
    public String cOS;
    public String emo;
    public String jwS;
    public String jwT;
    public String jwU;
    public int jwV;
    public String jwW;
    public String jwX;
    public String jwY;
    public String jwZ;
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
            if (!StringUtils.isNull(this.emo)) {
                anVar.cy("fid", this.emo);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cy("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cy("obj_source", this.mSource);
            } else {
                anVar.X("obj_source", 0);
            }
            if (!StringUtils.isNull(this.jwS)) {
                anVar.cy("obj_param1", this.jwS);
            } else {
                anVar.X("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jwT)) {
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, this.jwT);
            }
            if (!StringUtils.isNull(this.jwU)) {
                anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, this.jwU);
            }
            if (this.jwV > 0) {
                anVar.X("obj_param5", this.jwV);
            }
            if (!StringUtils.isNull(this.cOS)) {
                anVar.cy("obj_id", this.cOS);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cy(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.X(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jwX)) {
                anVar.cy("topic_type", this.jwX);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cy("extra", this.mExtra);
            } else {
                anVar.X("extra", 0);
            }
            if (!StringUtils.isNull(this.jwY)) {
                anVar.cy("is_vertical", this.jwY);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cy("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jwZ)) {
                anVar.cy("resource_id", this.jwZ);
            }
            anVar.cy("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cy("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y czu() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.Pj = this.Pj;
        yVar.emo = this.emo;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jwS = this.jwS;
        yVar.jwT = this.jwT;
        yVar.jwU = this.jwU;
        yVar.cOS = this.cOS;
        yVar.mAbTag = this.mAbTag;
        yVar.jwW = this.jwW;
        yVar.jwX = this.jwX;
        yVar.mFloor = this.mFloor;
        yVar.jwZ = this.jwZ;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
