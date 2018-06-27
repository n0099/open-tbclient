package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String aWo;
    public String agd;
    public String czo;
    public String ghc;
    public String ghd;
    public String ghe;
    public String ghf;
    public String ghg;
    public String ghh;
    public String ghi;
    public String mExtra;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an b(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.ah("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aWo)) {
                anVar.ah("tid", this.aWo);
            }
            if (!StringUtils.isNull(this.czo)) {
                anVar.ah(ImageViewerConfig.FORUM_ID, this.czo);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.ah("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.ghc)) {
                anVar.ah("obj_param1", this.ghc);
            }
            if (!StringUtils.isNull(this.ghd)) {
                anVar.ah("obj_param2", this.ghd);
            }
            if (!StringUtils.isNull(this.ghe)) {
                anVar.ah("obj_param3", this.ghe);
            }
            if (!StringUtils.isNull(this.agd)) {
                anVar.ah(VideoPlayActivityConfig.OBJ_ID, this.agd);
            }
            if (!StringUtils.isNull(this.ghf)) {
                anVar.ah("ab_tag", this.ghf);
            }
            if (!StringUtils.isNull(this.ghh)) {
                anVar.ah("topic_type", this.ghh);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.ah("extra", this.mExtra);
            }
            if (!StringUtils.isNull(this.ghi)) {
                anVar.ah("is_vertical", this.ghi);
            }
        }
        return anVar;
    }

    public y bmE() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aWo = this.aWo;
        yVar.czo = this.czo;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.ghc = this.ghc;
        yVar.ghd = this.ghd;
        yVar.ghe = this.ghe;
        yVar.agd = this.agd;
        yVar.ghf = this.ghf;
        yVar.ghg = this.ghg;
        yVar.ghh = this.ghh;
        return yVar;
    }
}
