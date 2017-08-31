package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class w {
    public String VU;
    public String azO;
    public String bGH;
    public String fAU;
    public String fAV;
    public String fAW;
    public String fAX;
    public String fAY;
    public String mLocate;
    public String mSource;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ad("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bGH)) {
                akVar.ad("tid", this.bGH);
            }
            if (!StringUtils.isNull(this.azO)) {
                akVar.ad("fid", this.azO);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ad(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fAU)) {
                akVar.ad("obj_param1", this.fAU);
            }
            if (!StringUtils.isNull(this.fAV)) {
                akVar.ad("obj_param2", this.fAV);
            }
            if (!StringUtils.isNull(this.fAW)) {
                akVar.ad("obj_param3", this.fAW);
            }
            if (!StringUtils.isNull(this.VU)) {
                akVar.ad("obj_id", this.VU);
            }
            if (!StringUtils.isNull(this.fAX)) {
                akVar.ad("ab_tag", this.fAX);
            }
        }
        return akVar;
    }
}
