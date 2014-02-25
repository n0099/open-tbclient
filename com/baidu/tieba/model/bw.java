package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.data.emotions.AdsEmotionGroupData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bw {
    private int g;
    private int h = 0;
    private VersionData a = new VersionData();
    private com.baidu.tieba.data.h b = new com.baidu.tieba.data.h();
    private com.baidu.tieba.data.j c = new com.baidu.tieba.data.j();
    private CombineDownload d = new CombineDownload();
    private au e = new au();
    private List<AdsEmotionGroupData> f = new LinkedList();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.parserJson(jSONObject.optJSONObject("version"));
                this.b.a(jSONObject.optJSONObject("client"));
                com.baidu.tieba.util.s.a(jSONObject.optString("client_ip", null));
                this.c.a(jSONObject.optJSONObject("config"));
                this.d.parserJson(jSONObject.optJSONObject("combine_download"));
                this.e.a(jSONObject.optJSONObject("mainbar"));
                this.h = jSONObject.optInt("sync_active", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("recmd_face");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length() && i < 2; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        AdsEmotionGroupData adsEmotionGroupData = new AdsEmotionGroupData();
                        adsEmotionGroupData.parseJsonFromSyncService(jSONObject2);
                        this.f.add(adsEmotionGroupData);
                    }
                }
                this.g = jSONObject.optInt("faceshop_version");
                if (this.g > TiebaApplication.g().bg()) {
                    TiebaApplication.g().r(this.g);
                    TiebaApplication.g().A(true);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public com.baidu.tieba.data.j a() {
        return this.c;
    }

    public CombineDownload b() {
        return this.d;
    }

    public VersionData c() {
        return this.a;
    }

    public com.baidu.tieba.data.h d() {
        return this.b;
    }

    public List<AdsEmotionGroupData> e() {
        return this.f;
    }
}
