package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class j extends PostData {
    public static final BdUniqueId VD = BdUniqueId.gen();
    public String jGj;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return VD;
    }
}
