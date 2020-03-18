package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String Pk;
    public String cPf;
    public String emF;
    public String jyr;
    public String jys;
    public String jyt;
    public int jyu;
    public String jyv;
    public String jyw;
    public String jyx;
    public String jyy;
    public String mAbTag;
    public String mExtra;
    public String mFloor;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public an f(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.cx("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.Pk)) {
                anVar.cx("tid", this.Pk);
            }
            if (!StringUtils.isNull(this.emF)) {
                anVar.cx("fid", this.emF);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cx("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cx("obj_source", this.mSource);
            } else {
                anVar.X("obj_source", 0);
            }
            if (!StringUtils.isNull(this.jyr)) {
                anVar.cx("obj_param1", this.jyr);
            } else {
                anVar.X("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jys)) {
                anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, this.jys);
            }
            if (!StringUtils.isNull(this.jyt)) {
                anVar.cx(TiebaInitialize.Params.OBJ_PARAM3, this.jyt);
            }
            if (this.jyu > 0) {
                anVar.X("obj_param5", this.jyu);
            }
            if (!StringUtils.isNull(this.cPf)) {
                anVar.cx("obj_id", this.cPf);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cx(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.X(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jyw)) {
                anVar.cx("topic_type", this.jyw);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cx("extra", this.mExtra);
            } else {
                anVar.X("extra", 0);
            }
            if (!StringUtils.isNull(this.jyx)) {
                anVar.cx("is_vertical", this.jyx);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cx("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jyy)) {
                anVar.cx("resource_id", this.jyy);
            }
            anVar.cx("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cx("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y czN() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.Pk = this.Pk;
        yVar.emF = this.emF;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jyr = this.jyr;
        yVar.jys = this.jys;
        yVar.jyt = this.jyt;
        yVar.cPf = this.cPf;
        yVar.mAbTag = this.mAbTag;
        yVar.jyv = this.jyv;
        yVar.jyw = this.jyw;
        yVar.mFloor = this.mFloor;
        yVar.jyy = this.jyy;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
