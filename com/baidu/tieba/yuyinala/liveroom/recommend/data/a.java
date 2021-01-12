package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes10.dex */
public class a implements IAdapterData {
    public static BdUniqueId mRo = BdUniqueId.gen();
    public AlaRecommendLiveData ooj;
    public AlaRecommendLiveData ook;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mRo;
    }
}
