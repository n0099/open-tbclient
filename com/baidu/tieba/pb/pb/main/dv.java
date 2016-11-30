package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class dv extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId eyO = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.aq eyP;
    public com.baidu.tbadk.core.data.aq eyQ;
    public com.baidu.tbadk.core.data.aq eyR;

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eyO;
    }

    public boolean hasData() {
        if (this.eyP == null || StringUtils.isNull(this.eyP.summary)) {
            if (this.eyQ == null || StringUtils.isNull(this.eyQ.summary)) {
                return (this.eyR == null || StringUtils.isNull(this.eyR.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
