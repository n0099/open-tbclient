package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private AntiData bun;
    private LinkedList<d> buo;
    private String bul = null;
    private String fid = null;
    private int bum = 0;
    private Context mContext = null;
    private String bup = null;
    private String buq = null;
    private String tid = null;
    private String title = null;
    private int bur = 0;

    public String VM() {
        return this.bup;
    }

    public String VN() {
        return this.buq;
    }

    public e() {
        this.bun = null;
        this.buo = null;
        this.buo = new LinkedList<>();
        this.bun = new AntiData();
    }

    public void u(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<d> VO() {
        return this.buo;
    }

    public int VP() {
        return this.bum;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                gE(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.bul = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.bum = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            d dVar = new d(this.mContext);
                            dVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = dVar.getIndex();
                            if (index >= 1 && index <= this.bum) {
                                this.buo.addLast(dVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            d dVar2 = new d(this.mContext);
                            dVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = dVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.bum) {
                                this.buo.addFirst(dVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.bup = optJSONObject2.optString("tid");
                this.buq = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void gE(int i) {
        this.bur = i;
    }
}
