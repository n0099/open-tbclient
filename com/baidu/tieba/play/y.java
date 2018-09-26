package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class y {
    public String aZG;
    public String ahY;
    public String cHE;
    public String cHI;
    public String goU;
    public String goV;
    public String goW;
    public String goX;
    public String goY;
    public String goZ;
    public String gpa;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am b(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.al("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aZG)) {
                amVar.al("tid", this.aZG);
            }
            if (!StringUtils.isNull(this.cHI)) {
                amVar.al(ImageViewerConfig.FORUM_ID, this.cHI);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.al("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.goU)) {
                amVar.al("obj_param1", this.goU);
            } else {
                amVar.w("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.goV)) {
                amVar.al("obj_param2", this.goV);
            }
            if (!StringUtils.isNull(this.goW)) {
                amVar.al("obj_param3", this.goW);
            }
            if (!StringUtils.isNull(this.ahY)) {
                amVar.al(VideoPlayActivityConfig.OBJ_ID, this.ahY);
            }
            if (!StringUtils.isNull(this.goX)) {
                amVar.al("ab_tag", this.goX);
            } else {
                amVar.w("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.goZ)) {
                amVar.al("topic_type", this.goZ);
            }
            if (!StringUtils.isNull(this.cHE)) {
                amVar.al("extra", this.cHE);
            } else {
                amVar.w("extra", 0);
            }
            if (!StringUtils.isNull(this.gpa)) {
                amVar.al("is_vertical", this.gpa);
            }
        }
        return amVar;
    }

    public y bnA() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aZG = this.aZG;
        yVar.cHI = this.cHI;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.goU = this.goU;
        yVar.goV = this.goV;
        yVar.goW = this.goW;
        yVar.ahY = this.ahY;
        yVar.goX = this.goX;
        yVar.goY = this.goY;
        yVar.goZ = this.goZ;
        return yVar;
    }
}
