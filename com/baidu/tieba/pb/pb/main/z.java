package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class z extends PostData {
    public static final BdUniqueId eMI = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.at eMJ;
    public com.baidu.tbadk.core.data.at eMK;
    public com.baidu.tbadk.core.data.at eML;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eMI;
    }

    public boolean hasData() {
        if (this.eMJ == null || StringUtils.isNull(this.eMJ.summary)) {
            if (this.eMK == null || StringUtils.isNull(this.eMK.summary)) {
                return (this.eML == null || StringUtils.isNull(this.eML.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
