package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ai extends PostData {
    public static final BdUniqueId kkt = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.aw kku;
    public com.baidu.tbadk.core.data.aw kkv;
    public com.baidu.tbadk.core.data.aw kkw;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kkt;
    }

    public boolean hasData() {
        if (this.kku == null || StringUtils.isNull(this.kku.summary)) {
            if (this.kkv == null || StringUtils.isNull(this.kkv.summary)) {
                return (this.kkw == null || StringUtils.isNull(this.kkw.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
