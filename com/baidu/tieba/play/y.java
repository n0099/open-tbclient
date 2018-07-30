package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String aWq;
    public String afx;
    public String cBQ;
    public String cBU;
    public String ghC;
    public String ghD;
    public String ghE;
    public String ghF;
    public String ghG;
    public String ghH;
    public String ghI;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an b(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.af("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aWq)) {
                anVar.af("tid", this.aWq);
            }
            if (!StringUtils.isNull(this.cBU)) {
                anVar.af(ImageViewerConfig.FORUM_ID, this.cBU);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.af("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.ghC)) {
                anVar.af("obj_param1", this.ghC);
            }
            if (!StringUtils.isNull(this.ghD)) {
                anVar.af("obj_param2", this.ghD);
            }
            if (!StringUtils.isNull(this.ghE)) {
                anVar.af("obj_param3", this.ghE);
            }
            if (!StringUtils.isNull(this.afx)) {
                anVar.af(VideoPlayActivityConfig.OBJ_ID, this.afx);
            }
            if (!StringUtils.isNull(this.ghF)) {
                anVar.af("ab_tag", this.ghF);
            }
            if (!StringUtils.isNull(this.ghH)) {
                anVar.af("topic_type", this.ghH);
            }
            if (!StringUtils.isNull(this.cBQ)) {
                anVar.af("extra", this.cBQ);
            }
            if (!StringUtils.isNull(this.ghI)) {
                anVar.af("is_vertical", this.ghI);
            }
        }
        return anVar;
    }

    public y bkX() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aWq = this.aWq;
        yVar.cBU = this.cBU;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.ghC = this.ghC;
        yVar.ghD = this.ghD;
        yVar.ghE = this.ghE;
        yVar.afx = this.afx;
        yVar.ghF = this.ghF;
        yVar.ghG = this.ghG;
        yVar.ghH = this.ghH;
        return yVar;
    }
}
