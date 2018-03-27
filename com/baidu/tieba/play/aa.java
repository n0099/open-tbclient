package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class aa {
    public String aMr;
    public String bCV;
    public String cZL;
    public String gwb;
    public String gwc;
    public String gwd;
    public String gwe;
    public String gwf;
    public String gwg;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bCV)) {
                akVar.ab("tid", this.bCV);
            }
            if (!StringUtils.isNull(this.cZL)) {
                akVar.ab(ImageViewerConfig.FORUM_ID, this.cZL);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.gwb)) {
                akVar.ab("obj_param1", this.gwb);
            }
            if (!StringUtils.isNull(this.gwc)) {
                akVar.ab("obj_param2", this.gwc);
            }
            if (!StringUtils.isNull(this.gwd)) {
                akVar.ab("obj_param3", this.gwd);
            }
            if (!StringUtils.isNull(this.aMr)) {
                akVar.ab("obj_id", this.aMr);
            }
            if (!StringUtils.isNull(this.gwe)) {
                akVar.ab("ab_tag", this.gwe);
            }
            if (!StringUtils.isNull(this.gwg)) {
                akVar.ab("topic_type", this.gwg);
            }
        }
        return akVar;
    }

    public aa blW() {
        aa aaVar = new aa();
        aaVar.mLocate = this.mLocate;
        aaVar.mType = this.mType;
        aaVar.bCV = this.bCV;
        aaVar.cZL = this.cZL;
        aaVar.mUid = this.mUid;
        aaVar.mSource = this.mSource;
        aaVar.gwb = this.gwb;
        aaVar.gwc = this.gwc;
        aaVar.gwd = this.gwd;
        aaVar.aMr = this.aMr;
        aaVar.gwe = this.gwe;
        aaVar.gwf = this.gwf;
        aaVar.gwg = this.gwg;
        return aaVar;
    }
}
