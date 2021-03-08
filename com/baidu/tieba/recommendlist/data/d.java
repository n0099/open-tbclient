package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes10.dex */
public class d implements IAdapterData {
    public static BdUniqueId ndp = BdUniqueId.gen();
    public AlaRecommendLiveData ndq;
    public AlaRecommendLiveData ndr;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ndp;
    }
}
