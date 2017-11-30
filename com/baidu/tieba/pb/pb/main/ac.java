package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ac extends PostData {
    public static final BdUniqueId eZb = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an eZc;
    public com.baidu.tbadk.core.data.an eZd;
    public com.baidu.tbadk.core.data.an eZe;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZb;
    }

    public boolean hasData() {
        if (this.eZc == null || StringUtils.isNull(this.eZc.summary)) {
            if (this.eZd == null || StringUtils.isNull(this.eZd.summary)) {
                return (this.eZe == null || StringUtils.isNull(this.eZe.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
