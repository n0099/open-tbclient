package com.baidu.tieba.yuyinala.liveroom.k;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends BaseData {
    public AlaLiveInfoData mLiveInfo;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mLiveInfo = new AlaLiveInfoData();
            this.mLiveInfo.parserJson(jSONObject);
        }
    }
}
