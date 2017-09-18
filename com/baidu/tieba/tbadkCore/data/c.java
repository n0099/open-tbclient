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
    private String gix;
    private ArrayList<a> giy = new ArrayList<>();
    private ArrayList<b> giz = new ArrayList<>();

    public String brW() {
        return this.gix;
    }

    public List<a> brX() {
        return this.giy;
    }

    public List<b> brY() {
        return this.giz;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.gix = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.giy.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.giz.add(bVar);
                }
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gix = jSONObject.optString("list_head");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_hot");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.parserJson(jSONObject2);
                            this.giy.add(aVar);
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
                            this.giz.add(bVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
