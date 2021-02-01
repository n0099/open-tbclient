package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes11.dex */
public class a implements IAdapterData {
    public static BdUniqueId naL = BdUniqueId.gen();
    public AlaRecommendLiveData oya;
    public AlaRecommendLiveData oyb;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return naL;
    }
}
