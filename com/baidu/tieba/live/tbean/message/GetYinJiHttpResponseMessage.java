package com.baidu.tieba.live.tbean.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.IconInfoData;
import com.baidu.tieba.live.tbean.data.SettingData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetYinJiHttpResponseMessage extends JsonHttpResponsedMessage implements IYinJiResponse {
    private List<CustomData> customList;
    private List<IconInfoData> iconInfoList;
    private SettingData setting;
    private UserInfoData userInfo;

    public GetYinJiHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.userInfo = new UserInfoData();
                this.userInfo.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("icon_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.iconInfoList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    IconInfoData iconInfoData = new IconInfoData();
                    iconInfoData.parserJson(optJSONArray.optJSONObject(i2));
                    this.iconInfoList.add(iconInfoData);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("custom");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.customList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    CustomData customData = new CustomData();
                    customData.parserJson(optJSONArray2.optJSONObject(i3));
                    this.customList.add(customData);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("setting");
            if (optJSONObject2 != null) {
                this.setting = new SettingData();
                this.setting.parserJson(optJSONObject2);
            }
        }
    }

    @Override // com.baidu.tieba.live.tbean.message.IYinJiResponse
    public UserInfoData getUserInfo() {
        return this.userInfo;
    }

    @Override // com.baidu.tieba.live.tbean.message.IYinJiResponse
    public List<IconInfoData> getIconInfoList() {
        return this.iconInfoList;
    }

    @Override // com.baidu.tieba.live.tbean.message.IYinJiResponse
    public SettingData getSetting() {
        return this.setting;
    }

    @Override // com.baidu.tieba.live.tbean.message.IYinJiResponse
    public List<CustomData> getCustomList() {
        return this.customList;
    }
}
