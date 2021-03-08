package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes10.dex */
public class a implements IAdapterData {
    public static BdUniqueId ndp = BdUniqueId.gen();
    public AlaRecommendLiveData oAF;
    public AlaRecommendLiveData oAG;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ndp;
    }
}
