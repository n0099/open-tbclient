package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class am extends PostData {
    public static final BdUniqueId ktu = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ax ktv;
    public com.baidu.tbadk.core.data.ax ktw;
    public com.baidu.tbadk.core.data.ax ktx;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ktu;
    }

    public boolean hasData() {
        if (this.ktv == null || StringUtils.isNull(this.ktv.summary)) {
            if (this.ktw == null || StringUtils.isNull(this.ktw.summary)) {
                return (this.ktx == null || StringUtils.isNull(this.ktx.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
