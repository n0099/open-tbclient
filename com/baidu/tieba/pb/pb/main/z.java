package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class z extends PostData {
    public static final BdUniqueId eOE = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.at eOF;
    public com.baidu.tbadk.core.data.at eOG;
    public com.baidu.tbadk.core.data.at eOH;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eOE;
    }

    public boolean hasData() {
        if (this.eOF == null || StringUtils.isNull(this.eOF.summary)) {
            if (this.eOG == null || StringUtils.isNull(this.eOG.summary)) {
                return (this.eOH == null || StringUtils.isNull(this.eOH.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
