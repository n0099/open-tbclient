package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String aXD;
    public ArrayList<Integer> gsX;
    public String gsY;
    public int gsZ;
    public String mErrorMessage;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.gsX = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.gsX.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.gsY = optJSONObject.optString("upload_id");
                    this.aXD = optJSONObject.optString("video_url");
                }
            } catch (JSONException e) {
            }
        }
    }
}
