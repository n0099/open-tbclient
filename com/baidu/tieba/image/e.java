package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private AntiData buD;
    private LinkedList<d> buE;
    private String buB = null;
    private String fid = null;
    private int buC = 0;
    private Context mContext = null;
    private String buF = null;
    private String buG = null;
    private String tid = null;
    private String title = null;
    private int buH = 0;

    public String VZ() {
        return this.buF;
    }

    public String Wa() {
        return this.buG;
    }

    public e() {
        this.buD = null;
        this.buE = null;
        this.buE = new LinkedList<>();
        this.buD = new AntiData();
    }

    public void u(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<d> Wb() {
        return this.buE;
    }

    public int Wc() {
        return this.buC;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                gG(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.buB = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.buC = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            d dVar = new d(this.mContext);
                            dVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = dVar.getIndex();
                            if (index >= 1 && index <= this.buC) {
                                this.buE.addLast(dVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            d dVar2 = new d(this.mContext);
                            dVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = dVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.buC) {
                                this.buE.addFirst(dVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.buF = optJSONObject2.optString("tid");
                this.buG = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void gG(int i) {
        this.buH = i;
    }
}
