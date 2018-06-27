package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fCH = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao fCI;
    public com.baidu.tbadk.core.data.ao fCJ;
    public com.baidu.tbadk.core.data.ao fCK;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCH;
    }

    public boolean hasData() {
        if (this.fCI == null || StringUtils.isNull(this.fCI.summary)) {
            if (this.fCJ == null || StringUtils.isNull(this.fCJ.summary)) {
                return (this.fCK == null || StringUtils.isNull(this.fCK.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
