package com.baidu.tieba.tbadkCore.videoupload.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String bLq;
    public String cln;
    public ArrayList<Integer> jkG;
    public String jkH;
    public int mErrorNo;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        this.jkG = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            this.jkG.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.jkH = optJSONObject.optString("upload_id");
                    this.cln = optJSONObject.optString("video_url");
                }
            } catch (JSONException e) {
            }
        }
    }
}
