package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class aa {
    public String aLe;
    public String bAT;
    public String cWM;
    public String gtV;
    public String gtW;
    public String gtX;
    public String gtY;
    public String gtZ;
    public String gua;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bAT)) {
                akVar.ab("tid", this.bAT);
            }
            if (!StringUtils.isNull(this.cWM)) {
                akVar.ab(ImageViewerConfig.FORUM_ID, this.cWM);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.gtV)) {
                akVar.ab("obj_param1", this.gtV);
            }
            if (!StringUtils.isNull(this.gtW)) {
                akVar.ab("obj_param2", this.gtW);
            }
            if (!StringUtils.isNull(this.gtX)) {
                akVar.ab("obj_param3", this.gtX);
            }
            if (!StringUtils.isNull(this.aLe)) {
                akVar.ab("obj_id", this.aLe);
            }
            if (!StringUtils.isNull(this.gtY)) {
                akVar.ab("ab_tag", this.gtY);
            }
            if (!StringUtils.isNull(this.gua)) {
                akVar.ab("topic_type", this.gua);
            }
        }
        return akVar;
    }

    public aa bkI() {
        aa aaVar = new aa();
        aaVar.mLocate = this.mLocate;
        aaVar.mType = this.mType;
        aaVar.bAT = this.bAT;
        aaVar.cWM = this.cWM;
        aaVar.mUid = this.mUid;
        aaVar.mSource = this.mSource;
        aaVar.gtV = this.gtV;
        aaVar.gtW = this.gtW;
        aaVar.gtX = this.gtX;
        aaVar.aLe = this.aLe;
        aaVar.gtY = this.gtY;
        aaVar.gtZ = this.gtZ;
        aaVar.gua = this.gua;
        return aaVar;
    }
}
