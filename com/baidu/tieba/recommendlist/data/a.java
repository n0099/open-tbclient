package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class a implements IAdapterData {
    public static BdUniqueId mBV = BdUniqueId.gen();
    public AlaRecommendLiveData mBW;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mBV;
    }
}
