package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class a implements IAdapterData {
    public static BdUniqueId mQB = BdUniqueId.gen();
    public AlaRecommendLiveData opA;
    public AlaRecommendLiveData opB;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mQB;
    }
}
