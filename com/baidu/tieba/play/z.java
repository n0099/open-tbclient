package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String arJ;
    public String bjm;
    public String dbr;
    public String gII;
    public String gIJ;
    public String gIK;
    public String gIL;
    public String gIM;
    public String gIN;
    public String gIO;
    public String mExtra;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am b(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.aB("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bjm)) {
                amVar.aB("tid", this.bjm);
            }
            if (!StringUtils.isNull(this.dbr)) {
                amVar.aB(ImageViewerConfig.FORUM_ID, this.dbr);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.aB("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.gII)) {
                amVar.aB("obj_param1", this.gII);
            } else {
                amVar.y("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.gIJ)) {
                amVar.aB("obj_param2", this.gIJ);
            }
            if (!StringUtils.isNull(this.gIK)) {
                amVar.aB("obj_param3", this.gIK);
            }
            if (!StringUtils.isNull(this.arJ)) {
                amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.arJ);
            }
            if (!StringUtils.isNull(this.gIL)) {
                amVar.aB("ab_tag", this.gIL);
            } else {
                amVar.y("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.gIN)) {
                amVar.aB("topic_type", this.gIN);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.aB("extra", this.mExtra);
            } else {
                amVar.y("extra", 0);
            }
            if (!StringUtils.isNull(this.gIO)) {
                amVar.aB("is_vertical", this.gIO);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.aB("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z bty() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bjm = this.bjm;
        zVar.dbr = this.dbr;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.gII = this.gII;
        zVar.gIJ = this.gIJ;
        zVar.gIK = this.gIK;
        zVar.arJ = this.arJ;
        zVar.gIL = this.gIL;
        zVar.gIM = this.gIM;
        zVar.gIN = this.gIN;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
