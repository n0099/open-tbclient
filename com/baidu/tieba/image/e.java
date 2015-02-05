package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private AntiData brC;
    private LinkedList<d> brD;
    private String atA = null;
    private String fid = null;
    private int brB = 0;
    private Context mContext = null;
    private String brE = null;
    private String brF = null;
    private String tid = null;
    private String title = null;
    private int ata = 0;

    public String TN() {
        return this.brE;
    }

    public String TO() {
        return this.brF;
    }

    public e() {
        this.brC = null;
        this.brD = null;
        this.brD = new LinkedList<>();
        this.brC = new AntiData();
    }

    public void t(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<d> TP() {
        return this.brD;
    }

    public int TQ() {
        return this.brB;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                gL(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.atA = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.brB = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            d dVar = new d(this.mContext);
                            dVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = dVar.getIndex();
                            if (index >= 1 && index <= this.brB) {
                                this.brD.addLast(dVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            d dVar2 = new d(this.mContext);
                            dVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = dVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.brB) {
                                this.brD.addFirst(dVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.brE = optJSONObject2.optString("tid");
                this.brF = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void gL(int i) {
        this.ata = i;
    }
}
