package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fOB = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fOC;
    public com.baidu.tbadk.core.data.an fOD;
    public com.baidu.tbadk.core.data.an fOE;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fOB;
    }

    public boolean hasData() {
        if (this.fOC == null || StringUtils.isNull(this.fOC.summary)) {
            if (this.fOD == null || StringUtils.isNull(this.fOD.summary)) {
                return (this.fOE == null || StringUtils.isNull(this.fOE.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
