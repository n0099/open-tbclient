package com.baidu.tieba.mainentrance;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PostSuggestModel implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<k> datas;
    private int currentPage = 0;
    private boolean hasMore = false;

    public PostSuggestModel() {
        this.datas = null;
        this.datas = new ArrayList<>();
    }

    public ArrayList<k> getData() {
        return this.datas;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("page");
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                this.datas.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    k kVar = new k();
                    kVar.parserJson(optJSONObject2);
                    this.datas.add(kVar);
                }
                this.hasMore = optJSONObject.optInt("has_more") != 0;
                this.currentPage = optJSONObject.optInt("current_page");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
