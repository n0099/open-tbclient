package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class am extends PostData {
    public static final BdUniqueId kts = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ax ktt;
    public com.baidu.tbadk.core.data.ax ktu;
    public com.baidu.tbadk.core.data.ax ktv;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kts;
    }

    public boolean hasData() {
        if (this.ktt == null || StringUtils.isNull(this.ktt.summary)) {
            if (this.ktu == null || StringUtils.isNull(this.ktu.summary)) {
                return (this.ktv == null || StringUtils.isNull(this.ktv.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
