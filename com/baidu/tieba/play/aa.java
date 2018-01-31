package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class aa {
    public String aLh;
    public String bBb;
    public String cXh;
    public String guq;
    public String gur;
    public String gus;
    public String gut;
    public String guu;
    public String guv;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bBb)) {
                akVar.aa("tid", this.bBb);
            }
            if (!StringUtils.isNull(this.cXh)) {
                akVar.aa(ImageViewerConfig.FORUM_ID, this.cXh);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.aa("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.guq)) {
                akVar.aa("obj_param1", this.guq);
            }
            if (!StringUtils.isNull(this.gur)) {
                akVar.aa("obj_param2", this.gur);
            }
            if (!StringUtils.isNull(this.gus)) {
                akVar.aa("obj_param3", this.gus);
            }
            if (!StringUtils.isNull(this.aLh)) {
                akVar.aa("obj_id", this.aLh);
            }
            if (!StringUtils.isNull(this.gut)) {
                akVar.aa("ab_tag", this.gut);
            }
            if (!StringUtils.isNull(this.guv)) {
                akVar.aa("topic_type", this.guv);
            }
        }
        return akVar;
    }

    public aa bkJ() {
        aa aaVar = new aa();
        aaVar.mLocate = this.mLocate;
        aaVar.mType = this.mType;
        aaVar.bBb = this.bBb;
        aaVar.cXh = this.cXh;
        aaVar.mUid = this.mUid;
        aaVar.mSource = this.mSource;
        aaVar.guq = this.guq;
        aaVar.gur = this.gur;
        aaVar.gus = this.gus;
        aaVar.aLh = this.aLh;
        aaVar.gut = this.gut;
        aaVar.guu = this.guu;
        aaVar.guv = this.guv;
        return aaVar;
    }
}
