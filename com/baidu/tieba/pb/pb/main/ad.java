package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId gee = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an gef;
    public com.baidu.tbadk.core.data.an geg;
    public com.baidu.tbadk.core.data.an geh;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gee;
    }

    public boolean hasData() {
        if (this.gef == null || StringUtils.isNull(this.gef.summary)) {
            if (this.geg == null || StringUtils.isNull(this.geg.summary)) {
                return (this.geh == null || StringUtils.isNull(this.geh.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
