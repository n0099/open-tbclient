package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId gdg = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an gdh;
    public com.baidu.tbadk.core.data.an gdi;
    public com.baidu.tbadk.core.data.an gdj;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gdg;
    }

    public boolean hasData() {
        if (this.gdh == null || StringUtils.isNull(this.gdh.summary)) {
            if (this.gdi == null || StringUtils.isNull(this.gdi.summary)) {
                return (this.gdj == null || StringUtils.isNull(this.gdj.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
