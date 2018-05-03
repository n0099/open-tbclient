package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fmf = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao fmg;
    public com.baidu.tbadk.core.data.ao fmh;
    public com.baidu.tbadk.core.data.ao fmi;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fmf;
    }

    public boolean hasData() {
        if (this.fmg == null || StringUtils.isNull(this.fmg.summary)) {
            if (this.fmh == null || StringUtils.isNull(this.fmh.summary)) {
                return (this.fmi == null || StringUtils.isNull(this.fmi.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
