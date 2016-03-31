package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.s;
/* loaded from: classes.dex */
public class f extends s {
    public static final BdUniqueId dcW = BdUniqueId.gen();
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dcW;
    }
}
