package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class c {
    private String gge;
    private ArrayList<a> ggf = new ArrayList<>();
    private ArrayList<b> ggg = new ArrayList<>();

    public String bqU() {
        return this.gge;
    }

    public List<a> bqV() {
        return this.ggf;
    }

    public List<b> bqW() {
        return this.ggg;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gge = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.ggf.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.ggg.add(bVar);
                }
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gge = jSONObject.optString("list_head");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_hot");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.parserJson(jSONObject2);
                            this.ggf.add(aVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("link_info");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        if (jSONObject3 != null) {
                            b bVar = new b();
                            bVar.parserJson(jSONObject3);
                            this.ggg.add(bVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
