package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class c implements IAdapterData {
    public static BdUniqueId mjC = BdUniqueId.gen();
    public AlaRecommendLiveData mjD;
    public AlaRecommendLiveData mjE;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mjC;
    }
}
