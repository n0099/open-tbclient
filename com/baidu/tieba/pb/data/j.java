package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class j extends PostData {
    public static final BdUniqueId Wk = BdUniqueId.gen();
    public String jZT;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Wk;
    }
}
