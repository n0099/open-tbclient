package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class x {
    public String Wo;
    public String aMi;
    public String azE;
    public String fGE;
    public String fGF;
    public String fGG;
    public String fGH;
    public String fGI;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aMi)) {
                akVar.ac("tid", this.aMi);
            }
            if (!StringUtils.isNull(this.azE)) {
                akVar.ac(ImageViewerConfig.FORUM_ID, this.azE);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ac(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fGE)) {
                akVar.ac("obj_param1", this.fGE);
            }
            if (!StringUtils.isNull(this.fGF)) {
                akVar.ac("obj_param2", this.fGF);
            }
            if (!StringUtils.isNull(this.fGG)) {
                akVar.ac("obj_param3", this.fGG);
            }
            if (!StringUtils.isNull(this.Wo)) {
                akVar.ac("obj_id", this.Wo);
            }
            if (!StringUtils.isNull(this.fGH)) {
                akVar.ac("ab_tag", this.fGH);
            }
        }
        return akVar;
    }

    public x bhL() {
        x xVar = new x();
        xVar.mLocate = this.mLocate;
        xVar.mType = this.mType;
        xVar.aMi = this.aMi;
        xVar.azE = this.azE;
        xVar.mUid = this.mUid;
        xVar.mSource = this.mSource;
        xVar.fGE = this.fGE;
        xVar.fGF = this.fGF;
        xVar.fGG = this.fGG;
        xVar.Wo = this.Wo;
        xVar.fGH = this.fGH;
        xVar.fGI = this.fGI;
        return xVar;
    }
}
