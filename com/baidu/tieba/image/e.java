package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private AntiData bqf;
    private LinkedList<d> bqg;
    private String asx = null;
    private String fid = null;
    private int bqe = 0;
    private Context mContext = null;
    private String bqh = null;
    private String bqi = null;
    private String tid = null;
    private String title = null;
    private int arY = 0;

    public String Tw() {
        return this.bqh;
    }

    public String Tx() {
        return this.bqi;
    }

    public e() {
        this.bqf = null;
        this.bqg = null;
        this.bqg = new LinkedList<>();
        this.bqf = new AntiData();
    }

    public void t(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<d> Ty() {
        return this.bqg;
    }

    public int Tz() {
        return this.bqe;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                gC(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.asx = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.bqe = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            d dVar = new d(this.mContext);
                            dVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = dVar.getIndex();
                            if (index >= 1 && index <= this.bqe) {
                                this.bqg.addLast(dVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            d dVar2 = new d(this.mContext);
                            dVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = dVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.bqe) {
                                this.bqg.addFirst(dVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.bqh = optJSONObject2.optString("tid");
                this.bqi = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void gC(int i) {
        this.arY = i;
    }
}
