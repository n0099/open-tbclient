package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class y extends PostData {
    public static final BdUniqueId eHr = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar eHs;
    public com.baidu.tbadk.core.data.ar eHt;
    public com.baidu.tbadk.core.data.ar eHu;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eHr;
    }

    public boolean hasData() {
        if (this.eHs == null || StringUtils.isNull(this.eHs.summary)) {
            if (this.eHt == null || StringUtils.isNull(this.eHt.summary)) {
                return (this.eHu == null || StringUtils.isNull(this.eHu.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
