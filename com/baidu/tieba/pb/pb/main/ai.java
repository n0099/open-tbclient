package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ai extends PostData {
    public static final BdUniqueId jQD = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar jQE;
    public com.baidu.tbadk.core.data.ar jQF;
    public com.baidu.tbadk.core.data.ar jQG;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return jQD;
    }

    public boolean hasData() {
        if (this.jQE == null || StringUtils.isNull(this.jQE.summary)) {
            if (this.jQF == null || StringUtils.isNull(this.jQF.summary)) {
                return (this.jQG == null || StringUtils.isNull(this.jQG.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
