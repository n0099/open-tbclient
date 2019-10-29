package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String bMh;
    public String cmf;
    public ArrayList<Integer> jlx;
    public String jly;
    public int mErrorNo;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.jlx = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.jlx.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.jly = optJSONObject.optString("upload_id");
                    this.cmf = optJSONObject.optString("video_url");
                }
            } catch (JSONException e) {
            }
        }
    }
}
