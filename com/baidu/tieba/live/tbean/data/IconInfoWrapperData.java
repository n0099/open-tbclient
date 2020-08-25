package com.baidu.tieba.live.tbean.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tieba.b.a.a;
/* loaded from: classes7.dex */
public class IconInfoWrapperData extends a implements IAdapterData {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public IconInfoData info;
    public SettingData mSetting;
    public UserInfoData userInfo;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return TYPE;
    }
}
