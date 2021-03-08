package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class af extends PostData {
    public static final BdUniqueId lZv = BdUniqueId.gen();
    public bc lZw;
    public bc lZx;
    public bc lZy;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lZv;
    }

    public boolean hasData() {
        if (this.lZw == null || StringUtils.isNull(this.lZw.summary)) {
            if (this.lZx == null || StringUtils.isNull(this.lZx.summary)) {
                return (this.lZy == null || StringUtils.isNull(this.lZy.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
