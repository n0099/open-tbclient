package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String biU;
    public int dmW;
    public ArrayList<Integer> gLJ;
    public String gLK;
    public String mErrorMessage;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.gLJ = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.gLJ.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.gLK = optJSONObject.optString("upload_id");
                    this.biU = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                }
            } catch (JSONException e) {
            }
        }
    }
}
