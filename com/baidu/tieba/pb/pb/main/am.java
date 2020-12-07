package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class am extends PostData {
    public static final BdUniqueId lNy = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ba lNA;
    public com.baidu.tbadk.core.data.ba lNB;
    public com.baidu.tbadk.core.data.ba lNz;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lNy;
    }

    public boolean hasData() {
        if (this.lNz == null || StringUtils.isNull(this.lNz.summary)) {
            if (this.lNA == null || StringUtils.isNull(this.lNA.summary)) {
                return (this.lNB == null || StringUtils.isNull(this.lNB.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
