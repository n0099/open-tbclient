package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId gef = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an geg;
    public com.baidu.tbadk.core.data.an geh;
    public com.baidu.tbadk.core.data.an gei;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gef;
    }

    public boolean hasData() {
        if (this.geg == null || StringUtils.isNull(this.geg.summary)) {
            if (this.geh == null || StringUtils.isNull(this.geh.summary)) {
                return (this.gei == null || StringUtils.isNull(this.gei.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
