package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class af extends PostData {
    public static final BdUniqueId lXt = BdUniqueId.gen();
    public bc lXu;
    public bc lXv;
    public bc lXw;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lXt;
    }

    public boolean hasData() {
        if (this.lXu == null || StringUtils.isNull(this.lXu.summary)) {
            if (this.lXv == null || StringUtils.isNull(this.lXv.summary)) {
                return (this.lXw == null || StringUtils.isNull(this.lXw.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
