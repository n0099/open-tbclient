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
    public String cBN;
    public String cBR;
    public String ghB;
    public String ghC;
    public String ghD;
    public String ghE;
    public String ghF;
    public String ghG;
    public String ghH;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an b(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.ae("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aWq)) {
                anVar.ae("tid", this.aWq);
            }
            if (!StringUtils.isNull(this.cBR)) {
                anVar.ae(ImageViewerConfig.FORUM_ID, this.cBR);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.ae("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.ghB)) {
                anVar.ae("obj_param1", this.ghB);
            }
            if (!StringUtils.isNull(this.ghC)) {
                anVar.ae("obj_param2", this.ghC);
            }
            if (!StringUtils.isNull(this.ghD)) {
                anVar.ae("obj_param3", this.ghD);
            }
            if (!StringUtils.isNull(this.afx)) {
                anVar.ae(VideoPlayActivityConfig.OBJ_ID, this.afx);
            }
            if (!StringUtils.isNull(this.ghE)) {
                anVar.ae("ab_tag", this.ghE);
            }
            if (!StringUtils.isNull(this.ghG)) {
                anVar.ae("topic_type", this.ghG);
            }
            if (!StringUtils.isNull(this.cBN)) {
                anVar.ae("extra", this.cBN);
            }
            if (!StringUtils.isNull(this.ghH)) {
                anVar.ae("is_vertical", this.ghH);
            }
        }
        return anVar;
    }

    public y bkU() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aWq = this.aWq;
        yVar.cBR = this.cBR;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.ghB = this.ghB;
        yVar.ghC = this.ghC;
        yVar.ghD = this.ghD;
        yVar.afx = this.afx;
        yVar.ghE = this.ghE;
        yVar.ghF = this.ghF;
        yVar.ghG = this.ghG;
        return yVar;
    }
}
