package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class am extends PostData {
    public static final BdUniqueId kRG = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ay kRH;
    public com.baidu.tbadk.core.data.ay kRI;
    public com.baidu.tbadk.core.data.ay kRJ;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kRG;
    }

    public boolean hasData() {
        if (this.kRH == null || StringUtils.isNull(this.kRH.summary)) {
            if (this.kRI == null || StringUtils.isNull(this.kRI.summary)) {
                return (this.kRJ == null || StringUtils.isNull(this.kRJ.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
