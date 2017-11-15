package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class aa extends PostData {
    public static final BdUniqueId eQv = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar eQw;
    public com.baidu.tbadk.core.data.ar eQx;
    public com.baidu.tbadk.core.data.ar eQy;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eQv;
    }

    public boolean hasData() {
        if (this.eQw == null || StringUtils.isNull(this.eQw.summary)) {
            if (this.eQx == null || StringUtils.isNull(this.eQx.summary)) {
                return (this.eQy == null || StringUtils.isNull(this.eQy.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
