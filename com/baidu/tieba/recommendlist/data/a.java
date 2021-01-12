package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes10.dex */
public class a implements IAdapterData {
    public static BdUniqueId mRk = BdUniqueId.gen();
    public AlaRecommendLiveData mRl;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mRk;
    }
}
