package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class z extends PostData {
    public static final BdUniqueId eOC = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.at eOD;
    public com.baidu.tbadk.core.data.at eOE;
    public com.baidu.tbadk.core.data.at eOF;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eOC;
    }

    public boolean hasData() {
        if (this.eOD == null || StringUtils.isNull(this.eOD.summary)) {
            if (this.eOE == null || StringUtils.isNull(this.eOE.summary)) {
                return (this.eOF == null || StringUtils.isNull(this.eOF.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
