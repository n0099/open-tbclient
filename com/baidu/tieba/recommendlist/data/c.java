package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class c implements IAdapterData {
    public static BdUniqueId mQz = BdUniqueId.gen();
    public AlaRecommendLiveData mQA;
    public AlaRecommendLiveData mQB;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mQz;
    }
}
