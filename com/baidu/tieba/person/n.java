package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private int bBr = 0;
    private int bBs = 0;
    private ArrayList<ForumData> bBo = new ArrayList<>();
    private ArrayList<ForumData> bBp = new ArrayList<>();
    private com.baidu.tbadk.core.data.m alK = new com.baidu.tbadk.core.data.m();
    private Date bBq = null;
    private boolean Lk = true;

    public int ZI() {
        return this.bBr;
    }

    public void gV(int i) {
        this.bBr = i;
    }

    public int ZJ() {
        return this.bBs;
    }

    public void gW(int i) {
        this.bBs = i;
    }

    public ArrayList<ForumData> ZK() {
        return this.bBo;
    }

    public void E(ArrayList<ForumData> arrayList) {
        this.bBo = arrayList;
    }

    public ArrayList<ForumData> ZL() {
        return this.bBp;
    }

    public void F(ArrayList<ForumData> arrayList) {
        this.bBp = arrayList;
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Lk = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bBr = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bBo.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bBo.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bBs = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bBp.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bBp.add(forumData4);
                        }
                    }
                    this.alK.parserJson(jSONObject.optJSONObject("page"));
                    long optLong = jSONObject.optLong("ctime", 0L);
                    if (optLong > 0) {
                        this.bBq = new Date(optLong);
                    } else {
                        this.bBq = new Date();
                    }
                }
            }
        } catch (Exception e) {
            this.Lk = false;
            BdLog.e(e.getMessage());
        }
    }
}
