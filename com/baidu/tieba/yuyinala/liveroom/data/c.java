package com.baidu.tieba.yuyinala.liveroom.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public String aKm;
    public String appUrl;
    public String hpZ;
    public String hqa;
    public String hqb;
    public int needToast;
    public String packageName;
    public String portrait;
    public String subappType;
    public String userName;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.needToast = jSONObject.optInt("need_toast", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("jump_conf");
            if (optJSONObject != null) {
                this.packageName = optJSONObject.optString("package_name", "");
                this.appUrl = optJSONObject.optString("app_url", "");
                this.hpZ = optJSONObject.optString("app_deeplink_url", "");
                this.hqa = optJSONObject.optString("app_backup_deeplink_url", "");
                this.hqb = optJSONObject.optString("app_clipboard_url", "");
            }
            this.aKm = jSONObject.optString("toast_text", "");
            this.subappType = jSONObject.optString("subapp_type", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.userName = optJSONObject2.optString("user_name", "");
                this.portrait = optJSONObject2.optString("portrait", "");
            }
        }
    }
}
