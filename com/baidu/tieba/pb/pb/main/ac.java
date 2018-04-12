package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fmi = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao fmj;
    public com.baidu.tbadk.core.data.ao fmk;
    public com.baidu.tbadk.core.data.ao fml;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fmi;
    }

    public boolean hasData() {
        if (this.fmj == null || StringUtils.isNull(this.fmj.summary)) {
            if (this.fmk == null || StringUtils.isNull(this.fmk.summary)) {
                return (this.fml == null || StringUtils.isNull(this.fml.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
