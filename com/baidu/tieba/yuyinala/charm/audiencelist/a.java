package com.baidu.tieba.yuyinala.charm.audiencelist;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BaseData {
    public AlaLiveUserInfoData aKu;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKu = new AlaLiveUserInfoData();
            this.aKu.parserJson(jSONObject);
        }
    }
}
