package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class es extends PostData {
    public static final BdUniqueId erb = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.at erc;
    public com.baidu.tbadk.core.data.at erd;
    public com.baidu.tbadk.core.data.at ere;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erb;
    }

    public boolean hasData() {
        if (this.erc == null || StringUtils.isNull(this.erc.summary)) {
            if (this.erd == null || StringUtils.isNull(this.erd.summary)) {
                return (this.ere == null || StringUtils.isNull(this.ere.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
