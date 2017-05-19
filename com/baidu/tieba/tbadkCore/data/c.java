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
    private String ftF;
    private ArrayList<a> ftG = new ArrayList<>();
    private ArrayList<b> ftH = new ArrayList<>();

    public String bgg() {
        return this.ftF;
    }

    public List<a> bgh() {
        return this.ftG;
    }

    public List<b> bgi() {
        return this.ftH;
    }

    public void a(ActPost actPost) {
        if (actPost != null) {
            this.ftF = actPost.list_head;
            for (ActHot actHot : actPost.act_hot) {
                if (actHot != null) {
                    a aVar = new a();
                    aVar.a(actHot);
                    this.ftG.add(aVar);
                }
            }
            List<LinkInfo> list = actPost.link_info;
            for (LinkInfo linkInfo : list) {
                if (list != null) {
                    b bVar = new b();
                    bVar.a(linkInfo);
                    this.ftH.add(bVar);
                }
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ftF = jSONObject.optString("list_head");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_hot");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.parserJson(jSONObject2);
                            this.ftG.add(aVar);
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
                            this.ftH.add(bVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
