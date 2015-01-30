package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private AntiData brD;
    private LinkedList<d> brE;
    private String atD = null;
    private String fid = null;
    private int brC = 0;
    private Context mContext = null;
    private String brF = null;
    private String brG = null;
    private String tid = null;
    private String title = null;
    private int atd = 0;

    public String TS() {
        return this.brF;
    }

    public String TT() {
        return this.brG;
    }

    public e() {
        this.brD = null;
        this.brE = null;
        this.brE = new LinkedList<>();
        this.brD = new AntiData();
    }

    public void t(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<d> TU() {
        return this.brE;
    }

    public int TV() {
        return this.brC;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                gL(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.atD = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.brC = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            d dVar = new d(this.mContext);
                            dVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = dVar.getIndex();
                            if (index >= 1 && index <= this.brC) {
                                this.brE.addLast(dVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            d dVar2 = new d(this.mContext);
                            dVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = dVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.brC) {
                                this.brE.addFirst(dVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.brF = optJSONObject2.optString("tid");
                this.brG = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void gL(int i) {
        this.atd = i;
    }
}
