package com.baidu.tieba.live.tbean.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tieba.b.a.a;
/* loaded from: classes2.dex */
public class GiftBagWrapperData extends a implements IAdapterData {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public CustomData mData;
    public SettingData mSetting;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return TYPE;
    }
}
