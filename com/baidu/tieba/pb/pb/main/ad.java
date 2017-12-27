package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fNb = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao fNc;
    public com.baidu.tbadk.core.data.ao fNd;
    public com.baidu.tbadk.core.data.ao fNe;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fNb;
    }

    public boolean hasData() {
        if (this.fNc == null || StringUtils.isNull(this.fNc.summary)) {
            if (this.fNd == null || StringUtils.isNull(this.fNd.summary)) {
                return (this.fNe == null || StringUtils.isNull(this.fNe.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
