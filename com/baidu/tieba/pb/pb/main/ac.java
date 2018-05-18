package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fnm = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao fnn;
    public com.baidu.tbadk.core.data.ao fno;
    public com.baidu.tbadk.core.data.ao fnp;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fnm;
    }

    public boolean hasData() {
        if (this.fnn == null || StringUtils.isNull(this.fnn.summary)) {
            if (this.fno == null || StringUtils.isNull(this.fno.summary)) {
                return (this.fnp == null || StringUtils.isNull(this.fnp.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
