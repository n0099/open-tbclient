package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String bQL;
    public int gZs;
    public ArrayList<Integer> hdO;
    public String hdP;
    public String mErrorMessage;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.hdO = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.hdO.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.hdP = optJSONObject.optString("upload_id");
                    this.bQL = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                }
            } catch (JSONException e) {
            }
        }
    }
}
