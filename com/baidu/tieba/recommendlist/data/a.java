package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes7.dex */
public class a implements IAdapterData {
    public static BdUniqueId lKO = BdUniqueId.gen();
    public AlaRecommendLiveData lKP;
    public AlaRecommendLiveData lKQ;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return lKO;
    }
}
