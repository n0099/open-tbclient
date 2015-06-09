package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private AntiData bxm;
    private LinkedList<d> bxn;
    private String bxk = null;
    private String fid = null;
    private int bxl = 0;
    private Context mContext = null;
    private String bxo = null;
    private String bxp = null;
    private String tid = null;
    private String title = null;
    private int bxq = 0;

    public String Xs() {
        return this.bxo;
    }

    public String Xt() {
        return this.bxp;
    }

    public e() {
        this.bxm = null;
        this.bxn = null;
        this.bxn = new LinkedList<>();
        this.bxm = new AntiData();
    }

    public void u(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<d> Xu() {
        return this.bxn;
    }

    public int Xv() {
        return this.bxl;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                gX(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.bxk = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.bxl = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            d dVar = new d(this.mContext);
                            dVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = dVar.getIndex();
                            if (index >= 1 && index <= this.bxl) {
                                this.bxn.addLast(dVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            d dVar2 = new d(this.mContext);
                            dVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = dVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.bxl) {
                                this.bxn.addFirst(dVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.bxo = optJSONObject2.optString("tid");
                this.bxp = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void gX(int i) {
        this.bxq = i;
    }
}
