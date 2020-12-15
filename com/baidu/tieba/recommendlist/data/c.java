package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class c implements IAdapterData {
    public static BdUniqueId mQB = BdUniqueId.gen();
    public AlaRecommendLiveData mQC;
    public AlaRecommendLiveData mQD;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mQB;
    }
}
