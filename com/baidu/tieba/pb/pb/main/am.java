package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class am extends PostData {
    public static final BdUniqueId lzL = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.az lzM;
    public com.baidu.tbadk.core.data.az lzN;
    public com.baidu.tbadk.core.data.az lzO;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lzL;
    }

    public boolean hasData() {
        if (this.lzM == null || StringUtils.isNull(this.lzM.summary)) {
            if (this.lzN == null || StringUtils.isNull(this.lzN.summary)) {
                return (this.lzO == null || StringUtils.isNull(this.lzO.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
