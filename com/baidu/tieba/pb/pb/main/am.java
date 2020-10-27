package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class am extends PostData {
    public static final BdUniqueId ltw = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ay ltx;
    public com.baidu.tbadk.core.data.ay lty;
    public com.baidu.tbadk.core.data.ay ltz;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ltw;
    }

    public boolean hasData() {
        if (this.ltx == null || StringUtils.isNull(this.ltx.summary)) {
            if (this.lty == null || StringUtils.isNull(this.lty.summary)) {
                return (this.ltz == null || StringUtils.isNull(this.ltz.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
