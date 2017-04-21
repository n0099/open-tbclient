package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class du extends PostData {
    public static final BdUniqueId epq = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar epr;
    public com.baidu.tbadk.core.data.ar eps;
    public com.baidu.tbadk.core.data.ar ept;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return epq;
    }

    public boolean hasData() {
        if (this.epr == null || StringUtils.isNull(this.epr.summary)) {
            if (this.eps == null || StringUtils.isNull(this.eps.summary)) {
                return (this.ept == null || StringUtils.isNull(this.ept.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
