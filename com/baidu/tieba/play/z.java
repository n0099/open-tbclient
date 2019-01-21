package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String arK;
    public String bjn;
    public String dbs;
    public String gIJ;
    public String gIK;
    public String gIL;
    public String gIM;
    public String gIN;
    public String gIO;
    public String gIP;
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
            if (!StringUtils.isNull(this.bjn)) {
                amVar.aB("tid", this.bjn);
            }
            if (!StringUtils.isNull(this.dbs)) {
                amVar.aB(ImageViewerConfig.FORUM_ID, this.dbs);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.aB("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.gIJ)) {
                amVar.aB("obj_param1", this.gIJ);
            } else {
                amVar.y("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.gIK)) {
                amVar.aB("obj_param2", this.gIK);
            }
            if (!StringUtils.isNull(this.gIL)) {
                amVar.aB("obj_param3", this.gIL);
            }
            if (!StringUtils.isNull(this.arK)) {
                amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.arK);
            }
            if (!StringUtils.isNull(this.gIM)) {
                amVar.aB("ab_tag", this.gIM);
            } else {
                amVar.y("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.gIO)) {
                amVar.aB("topic_type", this.gIO);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.aB("extra", this.mExtra);
            } else {
                amVar.y("extra", 0);
            }
            if (!StringUtils.isNull(this.gIP)) {
                amVar.aB("is_vertical", this.gIP);
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
        zVar.bjn = this.bjn;
        zVar.dbs = this.dbs;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.gIJ = this.gIJ;
        zVar.gIK = this.gIK;
        zVar.gIL = this.gIL;
        zVar.arK = this.arK;
        zVar.gIM = this.gIM;
        zVar.gIN = this.gIN;
        zVar.gIO = this.gIO;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
