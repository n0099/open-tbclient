package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String bdb;
    public int dsU;
    public ArrayList<Integer> gQJ;
    public String gQK;
    public String mErrorMessage;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.gQJ = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.gQJ.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.gQK = optJSONObject.optString("upload_id");
                    this.bdb = optJSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                }
            } catch (JSONException e) {
            }
        }
    }
}
