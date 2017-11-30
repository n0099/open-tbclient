package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class y {
    public String WL;
    public String aAn;
    public String aMR;
    public String fQp;
    public String fQq;
    public String fQr;
    public String fQs;
    public String fQt;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aMR)) {
                akVar.ac("tid", this.aMR);
            }
            if (!StringUtils.isNull(this.aAn)) {
                akVar.ac(ImageViewerConfig.FORUM_ID, this.aAn);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ac(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fQp)) {
                akVar.ac("obj_param1", this.fQp);
            }
            if (!StringUtils.isNull(this.fQq)) {
                akVar.ac("obj_param2", this.fQq);
            }
            if (!StringUtils.isNull(this.fQr)) {
                akVar.ac("obj_param3", this.fQr);
            }
            if (!StringUtils.isNull(this.WL)) {
                akVar.ac("obj_id", this.WL);
            }
            if (!StringUtils.isNull(this.fQs)) {
                akVar.ac("ab_tag", this.fQs);
            }
        }
        return akVar;
    }

    public y bjD() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aMR = this.aMR;
        yVar.aAn = this.aAn;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.fQp = this.fQp;
        yVar.fQq = this.fQq;
        yVar.fQr = this.fQr;
        yVar.WL = this.WL;
        yVar.fQs = this.fQs;
        yVar.fQt = this.fQt;
        return yVar;
    }
}
