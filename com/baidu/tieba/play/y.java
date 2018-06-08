package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class y {
    public String aVt;
    public String afO;
    public String cBu;
    public String gdb;
    public String gdc;
    public String gdd;
    public String gde;
    public String gdf;
    public String gdg;
    public String gdh;
    public String mExtra;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am b(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.ah("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aVt)) {
                amVar.ah("tid", this.aVt);
            }
            if (!StringUtils.isNull(this.cBu)) {
                amVar.ah(ImageViewerConfig.FORUM_ID, this.cBu);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.ah("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.gdb)) {
                amVar.ah("obj_param1", this.gdb);
            }
            if (!StringUtils.isNull(this.gdc)) {
                amVar.ah("obj_param2", this.gdc);
            }
            if (!StringUtils.isNull(this.gdd)) {
                amVar.ah("obj_param3", this.gdd);
            }
            if (!StringUtils.isNull(this.afO)) {
                amVar.ah(VideoPlayActivityConfig.OBJ_ID, this.afO);
            }
            if (!StringUtils.isNull(this.gde)) {
                amVar.ah("ab_tag", this.gde);
            }
            if (!StringUtils.isNull(this.gdg)) {
                amVar.ah("topic_type", this.gdg);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.ah("extra", this.mExtra);
            }
            if (!StringUtils.isNull(this.gdh)) {
                amVar.ah("is_vertical", this.gdh);
            }
        }
        return amVar;
    }

    public y bma() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aVt = this.aVt;
        yVar.cBu = this.cBu;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.gdb = this.gdb;
        yVar.gdc = this.gdc;
        yVar.gdd = this.gdd;
        yVar.afO = this.afO;
        yVar.gde = this.gde;
        yVar.gdf = this.gdf;
        yVar.gdg = this.gdg;
        return yVar;
    }
}
