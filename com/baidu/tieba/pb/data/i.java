package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class i extends p {
    public static final BdUniqueId efQ = BdUniqueId.gen();
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return efQ;
    }
}
