package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String amT;
    public String beh;
    public String cQb;
    public String gwA;
    public String gwB;
    public String gwC;
    public String gww;
    public String gwx;
    public String gwy;
    public String gwz;
    public String mExtra;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am b(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.ax("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.beh)) {
                amVar.ax("tid", this.beh);
            }
            if (!StringUtils.isNull(this.cQb)) {
                amVar.ax(ImageViewerConfig.FORUM_ID, this.cQb);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.ax("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.gww)) {
                amVar.ax("obj_param1", this.gww);
            } else {
                amVar.x("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.gwx)) {
                amVar.ax("obj_param2", this.gwx);
            }
            if (!StringUtils.isNull(this.gwy)) {
                amVar.ax("obj_param3", this.gwy);
            }
            if (!StringUtils.isNull(this.amT)) {
                amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.amT);
            }
            if (!StringUtils.isNull(this.gwz)) {
                amVar.ax("ab_tag", this.gwz);
            } else {
                amVar.x("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.gwB)) {
                amVar.ax("topic_type", this.gwB);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.ax("extra", this.mExtra);
            } else {
                amVar.x("extra", 0);
            }
            if (!StringUtils.isNull(this.gwC)) {
                amVar.ax("is_vertical", this.gwC);
            }
        }
        return amVar;
    }

    public z bqP() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.beh = this.beh;
        zVar.cQb = this.cQb;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.gww = this.gww;
        zVar.gwx = this.gwx;
        zVar.gwy = this.gwy;
        zVar.amT = this.amT;
        zVar.gwz = this.gwz;
        zVar.gwA = this.gwA;
        zVar.gwB = this.gwB;
        return zVar;
    }
}
