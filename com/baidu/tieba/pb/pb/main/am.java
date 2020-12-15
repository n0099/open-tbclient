package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class am extends PostData {
    public static final BdUniqueId lNA = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ba lNB;
    public com.baidu.tbadk.core.data.ba lNC;
    public com.baidu.tbadk.core.data.ba lND;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lNA;
    }

    public boolean hasData() {
        if (this.lNB == null || StringUtils.isNull(this.lNB.summary)) {
            if (this.lNC == null || StringUtils.isNull(this.lNC.summary)) {
                return (this.lND == null || StringUtils.isNull(this.lND.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
