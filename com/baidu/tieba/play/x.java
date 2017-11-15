package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class x {
    public String Wo;
    public String aMq;
    public String azM;
    public String fHj;
    public String fHk;
    public String fHl;
    public String fHm;
    public String fHn;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aMq)) {
                akVar.ac("tid", this.aMq);
            }
            if (!StringUtils.isNull(this.azM)) {
                akVar.ac(ImageViewerConfig.FORUM_ID, this.azM);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ac(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fHj)) {
                akVar.ac("obj_param1", this.fHj);
            }
            if (!StringUtils.isNull(this.fHk)) {
                akVar.ac("obj_param2", this.fHk);
            }
            if (!StringUtils.isNull(this.fHl)) {
                akVar.ac("obj_param3", this.fHl);
            }
            if (!StringUtils.isNull(this.Wo)) {
                akVar.ac("obj_id", this.Wo);
            }
            if (!StringUtils.isNull(this.fHm)) {
                akVar.ac("ab_tag", this.fHm);
            }
        }
        return akVar;
    }

    public x bhT() {
        x xVar = new x();
        xVar.mLocate = this.mLocate;
        xVar.mType = this.mType;
        xVar.aMq = this.aMq;
        xVar.azM = this.azM;
        xVar.mUid = this.mUid;
        xVar.mSource = this.mSource;
        xVar.fHj = this.fHj;
        xVar.fHk = this.fHk;
        xVar.fHl = this.fHl;
        xVar.Wo = this.Wo;
        xVar.fHm = this.fHm;
        xVar.fHn = this.fHn;
        return xVar;
    }
}
