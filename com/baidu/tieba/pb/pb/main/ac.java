package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ac extends PostData {
    public static final BdUniqueId fae = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an faf;
    public com.baidu.tbadk.core.data.an fag;
    public com.baidu.tbadk.core.data.an fah;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fae;
    }

    public boolean hasData() {
        if (this.faf == null || StringUtils.isNull(this.faf.summary)) {
            if (this.fag == null || StringUtils.isNull(this.fag.summary)) {
                return (this.fah == null || StringUtils.isNull(this.fah.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
