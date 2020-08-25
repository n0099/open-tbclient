package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class am extends PostData {
    public static final BdUniqueId kIZ = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ay kJa;
    public com.baidu.tbadk.core.data.ay kJb;
    public com.baidu.tbadk.core.data.ay kJc;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kIZ;
    }

    public boolean hasData() {
        if (this.kJa == null || StringUtils.isNull(this.kJa.summary)) {
            if (this.kJb == null || StringUtils.isNull(this.kJb.summary)) {
                return (this.kJc == null || StringUtils.isNull(this.kJc.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
