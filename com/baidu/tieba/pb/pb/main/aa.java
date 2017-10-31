package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class aa extends PostData {
    public static final BdUniqueId eQb = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar eQc;
    public com.baidu.tbadk.core.data.ar eQd;
    public com.baidu.tbadk.core.data.ar eQe;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eQb;
    }

    public boolean hasData() {
        if (this.eQc == null || StringUtils.isNull(this.eQc.summary)) {
            if (this.eQd == null || StringUtils.isNull(this.eQd.summary)) {
                return (this.eQe == null || StringUtils.isNull(this.eQe.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
