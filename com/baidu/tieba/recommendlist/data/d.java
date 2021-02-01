package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes11.dex */
public class d implements IAdapterData {
    public static BdUniqueId naL = BdUniqueId.gen();
    public AlaRecommendLiveData naM;
    public AlaRecommendLiveData naN;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return naL;
    }
}
