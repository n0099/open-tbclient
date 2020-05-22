package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ai extends PostData {
    public static final BdUniqueId jPx = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar jPA;
    public com.baidu.tbadk.core.data.ar jPy;
    public com.baidu.tbadk.core.data.ar jPz;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return jPx;
    }

    public boolean hasData() {
        if (this.jPy == null || StringUtils.isNull(this.jPy.summary)) {
            if (this.jPz == null || StringUtils.isNull(this.jPz.summary)) {
                return (this.jPA == null || StringUtils.isNull(this.jPA.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
