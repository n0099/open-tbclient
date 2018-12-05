package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId gao = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an gap;
    public com.baidu.tbadk.core.data.an gaq;
    public com.baidu.tbadk.core.data.an gar;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gao;
    }

    public boolean hasData() {
        if (this.gap == null || StringUtils.isNull(this.gap.summary)) {
            if (this.gaq == null || StringUtils.isNull(this.gaq.summary)) {
                return (this.gar == null || StringUtils.isNull(this.gar.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
