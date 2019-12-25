package com.baidu.tieba.live.tbean.message;

import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.IconInfoData;
import com.baidu.tieba.live.tbean.data.SettingData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
import java.util.List;
/* loaded from: classes2.dex */
public interface IYinJiResponse {
    List<CustomData> getCustomList();

    List<IconInfoData> getIconInfoList();

    SettingData getSetting();

    UserInfoData getUserInfo();
}
