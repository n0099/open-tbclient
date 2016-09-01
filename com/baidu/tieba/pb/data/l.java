package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class l extends q {
    public static final BdUniqueId ekx = BdUniqueId.gen();
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ekx;
    }
}
