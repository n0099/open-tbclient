package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String arh;
    public String biw;
    public String cXO;
    public String gEN;
    public String gEO;
    public String gEP;
    public String gEQ;
    public String gER;
    public String gES;
    public String gET;
    public String mExtra;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am b(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.aA("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.biw)) {
                amVar.aA("tid", this.biw);
            }
            if (!StringUtils.isNull(this.cXO)) {
                amVar.aA(ImageViewerConfig.FORUM_ID, this.cXO);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.aA("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.gEN)) {
                amVar.aA("obj_param1", this.gEN);
            } else {
                amVar.x("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.gEO)) {
                amVar.aA("obj_param2", this.gEO);
            }
            if (!StringUtils.isNull(this.gEP)) {
                amVar.aA("obj_param3", this.gEP);
            }
            if (!StringUtils.isNull(this.arh)) {
                amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.arh);
            }
            if (!StringUtils.isNull(this.gEQ)) {
                amVar.aA("ab_tag", this.gEQ);
            } else {
                amVar.x("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.gES)) {
                amVar.aA("topic_type", this.gES);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.aA("extra", this.mExtra);
            } else {
                amVar.x("extra", 0);
            }
            if (!StringUtils.isNull(this.gET)) {
                amVar.aA("is_vertical", this.gET);
            }
        }
        return amVar;
    }

    public z bse() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.biw = this.biw;
        zVar.cXO = this.cXO;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.gEN = this.gEN;
        zVar.gEO = this.gEO;
        zVar.gEP = this.gEP;
        zVar.arh = this.arh;
        zVar.gEQ = this.gEQ;
        zVar.gER = this.gER;
        zVar.gES = this.gES;
        return zVar;
    }
}
