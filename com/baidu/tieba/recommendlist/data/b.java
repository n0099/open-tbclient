package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements IAdapterData {
    public static BdUniqueId ndn = BdUniqueId.gen();
    public List<IAdapterData> ndo;

    public b(List<IAdapterData> list) {
        this.ndo = list;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ndn;
    }
}
