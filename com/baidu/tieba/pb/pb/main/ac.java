package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fyG = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao fyH;
    public com.baidu.tbadk.core.data.ao fyI;
    public com.baidu.tbadk.core.data.ao fyJ;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fyG;
    }

    public boolean hasData() {
        if (this.fyH == null || StringUtils.isNull(this.fyH.summary)) {
            if (this.fyI == null || StringUtils.isNull(this.fyI.summary)) {
                return (this.fyJ == null || StringUtils.isNull(this.fyJ.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
