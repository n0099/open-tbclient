package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class am extends PostData {
    public static final BdUniqueId kJg = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ay kJh;
    public com.baidu.tbadk.core.data.ay kJi;
    public com.baidu.tbadk.core.data.ay kJj;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kJg;
    }

    public boolean hasData() {
        if (this.kJh == null || StringUtils.isNull(this.kJh.summary)) {
            if (this.kJi == null || StringUtils.isNull(this.kJi.summary)) {
                return (this.kJj == null || StringUtils.isNull(this.kJj.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
