package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes11.dex */
public class c implements IAdapterData {
    public static BdUniqueId nbp = BdUniqueId.gen();
    public int count;
    public int type;

    public c(int i) {
        this.type = i;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return nbp;
    }
}
