package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class fb extends PostData {
    public static final BdUniqueId eAm = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.au eAn;
    public com.baidu.tbadk.core.data.au eAo;
    public com.baidu.tbadk.core.data.au eAp;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eAm;
    }

    public boolean hasData() {
        if (this.eAn == null || StringUtils.isNull(this.eAn.summary)) {
            if (this.eAo == null || StringUtils.isNull(this.eAo.summary)) {
                return (this.eAp == null || StringUtils.isNull(this.eAp.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
