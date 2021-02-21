package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class f extends d {
    public static BdUniqueId nbo = BdUniqueId.gen();

    @Override // com.baidu.tieba.recommendlist.data.d, com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return nbo;
    }
}
