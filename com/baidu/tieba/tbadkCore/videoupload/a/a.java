package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String bVa;
    public ArrayList<Integer> jbM;
    public String jbN;
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
                        this.jbM = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.jbM.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.jbN = optJSONObject.optString("upload_id");
                    this.bVa = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                }
            } catch (JSONException e) {
            }
        }
    }
}
