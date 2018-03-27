package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fSj = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fSk;
    public com.baidu.tbadk.core.data.an fSl;
    public com.baidu.tbadk.core.data.an fSm;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fSj;
    }

    public boolean hasData() {
        if (this.fSk == null || StringUtils.isNull(this.fSk.summary)) {
            if (this.fSl == null || StringUtils.isNull(this.fSl.summary)) {
                return (this.fSm == null || StringUtils.isNull(this.fSm.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
