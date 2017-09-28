package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class y extends PostData {
    public static final BdUniqueId eHF = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar eHG;
    public com.baidu.tbadk.core.data.ar eHH;
    public com.baidu.tbadk.core.data.ar eHI;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eHF;
    }

    public boolean hasData() {
        if (this.eHG == null || StringUtils.isNull(this.eHG.summary)) {
            if (this.eHH == null || StringUtils.isNull(this.eHH.summary)) {
                return (this.eHI == null || StringUtils.isNull(this.eHI.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
