package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class a implements IAdapterData {
    public static BdUniqueId mBZ = BdUniqueId.gen();
    public AlaRecommendLiveData nYU;
    public AlaRecommendLiveData nYV;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mBZ;
    }
}
