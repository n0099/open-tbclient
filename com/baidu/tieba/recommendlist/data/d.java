package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes11.dex */
public class d implements IAdapterData {
    public static BdUniqueId mWa = BdUniqueId.gen();
    public AlaRecommendLiveData mWb;
    public AlaRecommendLiveData mWc;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mWa;
    }
}
