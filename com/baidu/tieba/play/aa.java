package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class aa {
    public String aMB;
    public String bDf;
    public String cZU;
    public String gvW;
    public String gvX;
    public String gvY;
    public String gvZ;
    public String gwa;
    public String gwb;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bDf)) {
                akVar.ab("tid", this.bDf);
            }
            if (!StringUtils.isNull(this.cZU)) {
                akVar.ab(ImageViewerConfig.FORUM_ID, this.cZU);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.gvW)) {
                akVar.ab("obj_param1", this.gvW);
            }
            if (!StringUtils.isNull(this.gvX)) {
                akVar.ab("obj_param2", this.gvX);
            }
            if (!StringUtils.isNull(this.gvY)) {
                akVar.ab("obj_param3", this.gvY);
            }
            if (!StringUtils.isNull(this.aMB)) {
                akVar.ab("obj_id", this.aMB);
            }
            if (!StringUtils.isNull(this.gvZ)) {
                akVar.ab("ab_tag", this.gvZ);
            }
            if (!StringUtils.isNull(this.gwb)) {
                akVar.ab("topic_type", this.gwb);
            }
        }
        return akVar;
    }

    public aa blW() {
        aa aaVar = new aa();
        aaVar.mLocate = this.mLocate;
        aaVar.mType = this.mType;
        aaVar.bDf = this.bDf;
        aaVar.cZU = this.cZU;
        aaVar.mUid = this.mUid;
        aaVar.mSource = this.mSource;
        aaVar.gvW = this.gvW;
        aaVar.gvX = this.gvX;
        aaVar.gvY = this.gvY;
        aaVar.aMB = this.aMB;
        aaVar.gvZ = this.gvZ;
        aaVar.gwa = this.gwa;
        aaVar.gwb = this.gwb;
        return aaVar;
    }
}
