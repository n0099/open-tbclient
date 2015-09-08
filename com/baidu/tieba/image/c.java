package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private AntiData bLI;
    private LinkedList<b> bLJ;
    private String bLG = null;
    private String fid = null;
    private int bLH = 0;
    private Context mContext = null;
    private String bLK = null;
    private String bLL = null;
    private String tid = null;
    private String title = null;
    private int bLM = 0;

    public String Za() {
        return this.bLK;
    }

    public String Zb() {
        return this.bLL;
    }

    public c() {
        this.bLI = null;
        this.bLJ = null;
        this.bLJ = new LinkedList<>();
        this.bLI = new AntiData();
    }

    public void w(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<b> Zc() {
        return this.bLJ;
    }

    public int getImageNum() {
        return this.bLH;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                hL(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.bLG = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.bLH = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            b bVar = new b(this.mContext);
                            bVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = bVar.getIndex();
                            if (index >= 1 && index <= this.bLH) {
                                this.bLJ.addLast(bVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            b bVar2 = new b(this.mContext);
                            bVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = bVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.bLH) {
                                this.bLJ.addFirst(bVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.bLK = optJSONObject2.optString("tid");
                this.bLL = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void hL(int i) {
        this.bLM = i;
    }
}
