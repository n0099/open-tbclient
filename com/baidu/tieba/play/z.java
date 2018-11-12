package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String anG;
    public String beV;
    public String cRh;
    public String gxX;
    public String gxY;
    public String gxZ;
    public String gya;
    public String gyb;
    public String gyc;
    public String gyd;
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
            if (!StringUtils.isNull(this.beV)) {
                amVar.ax("tid", this.beV);
            }
            if (!StringUtils.isNull(this.cRh)) {
                amVar.ax(ImageViewerConfig.FORUM_ID, this.cRh);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.ax("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.gxX)) {
                amVar.ax("obj_param1", this.gxX);
            } else {
                amVar.x("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.gxY)) {
                amVar.ax("obj_param2", this.gxY);
            }
            if (!StringUtils.isNull(this.gxZ)) {
                amVar.ax("obj_param3", this.gxZ);
            }
            if (!StringUtils.isNull(this.anG)) {
                amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.anG);
            }
            if (!StringUtils.isNull(this.gya)) {
                amVar.ax("ab_tag", this.gya);
            } else {
                amVar.x("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.gyc)) {
                amVar.ax("topic_type", this.gyc);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.ax("extra", this.mExtra);
            } else {
                amVar.x("extra", 0);
            }
            if (!StringUtils.isNull(this.gyd)) {
                amVar.ax("is_vertical", this.gyd);
            }
        }
        return amVar;
    }

    public z bql() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.beV = this.beV;
        zVar.cRh = this.cRh;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.gxX = this.gxX;
        zVar.gxY = this.gxY;
        zVar.gxZ = this.gxZ;
        zVar.anG = this.anG;
        zVar.gya = this.gya;
        zVar.gyb = this.gyb;
        zVar.gyc = this.gyc;
        return zVar;
    }
}
