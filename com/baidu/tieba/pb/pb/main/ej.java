package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ej extends PostData {
    public static final BdUniqueId elo = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as elp;
    public com.baidu.tbadk.core.data.as elq;
    public com.baidu.tbadk.core.data.as elr;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return elo;
    }

    public boolean hasData() {
        if (this.elp == null || StringUtils.isNull(this.elp.summary)) {
            if (this.elq == null || StringUtils.isNull(this.elq.summary)) {
                return (this.elr == null || StringUtils.isNull(this.elr.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
