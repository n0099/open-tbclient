package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fSe = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fSf;
    public com.baidu.tbadk.core.data.an fSg;
    public com.baidu.tbadk.core.data.an fSh;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fSe;
    }

    public boolean hasData() {
        if (this.fSf == null || StringUtils.isNull(this.fSf.summary)) {
            if (this.fSg == null || StringUtils.isNull(this.fSg.summary)) {
                return (this.fSh == null || StringUtils.isNull(this.fSh.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
