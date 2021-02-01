package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class af extends PostData {
    public static final BdUniqueId lXe = BdUniqueId.gen();
    public bc lXf;
    public bc lXg;
    public bc lXh;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lXe;
    }

    public boolean hasData() {
        if (this.lXf == null || StringUtils.isNull(this.lXf.summary)) {
            if (this.lXg == null || StringUtils.isNull(this.lXg.summary)) {
                return (this.lXh == null || StringUtils.isNull(this.lXh.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
