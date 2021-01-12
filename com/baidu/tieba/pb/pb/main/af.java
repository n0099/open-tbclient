package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class af extends PostData {
    public static final BdUniqueId lOi = BdUniqueId.gen();
    public ba lOj;
    public ba lOk;
    public ba lOl;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lOi;
    }

    public boolean hasData() {
        if (this.lOj == null || StringUtils.isNull(this.lOj.summary)) {
            if (this.lOk == null || StringUtils.isNull(this.lOk.summary)) {
                return (this.lOl == null || StringUtils.isNull(this.lOl.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
