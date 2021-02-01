package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements IAdapterData {
    public static BdUniqueId naJ = BdUniqueId.gen();
    public List<IAdapterData> naK;

    public b(List<IAdapterData> list) {
        this.naK = list;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return naJ;
    }
}
