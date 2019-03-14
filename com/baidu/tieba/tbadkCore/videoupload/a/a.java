package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String bNl;
    public ArrayList<Integer> iJb;
    public String iJc;
    public String mErrorMessage;
    public int mErrorNo;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.iJb = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.iJb.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.iJc = optJSONObject.optString("upload_id");
                    this.bNl = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                }
            } catch (JSONException e) {
            }
        }
    }
}
