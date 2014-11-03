package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private int bBF = 0;
    private int bBG = 0;
    private ArrayList<ForumData> bBC = new ArrayList<>();
    private ArrayList<ForumData> bBD = new ArrayList<>();
    private com.baidu.tbadk.core.data.m alT = new com.baidu.tbadk.core.data.m();
    private Date bBE = null;
    private boolean Ln = true;

    public int ZK() {
        return this.bBF;
    }

    public void gV(int i) {
        this.bBF = i;
    }

    public int ZL() {
        return this.bBG;
    }

    public void gW(int i) {
        this.bBG = i;
    }

    public ArrayList<ForumData> ZM() {
        return this.bBC;
    }

    public void F(ArrayList<ForumData> arrayList) {
        this.bBC = arrayList;
    }

    public ArrayList<ForumData> ZN() {
        return this.bBD;
    }

    public void G(ArrayList<ForumData> arrayList) {
        this.bBD = arrayList;
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Ln = false;
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
                    this.bBF = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bBC.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bBC.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bBG = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bBD.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bBD.add(forumData4);
                        }
                    }
                    this.alT.parserJson(jSONObject.optJSONObject("page"));
                    long optLong = jSONObject.optLong("ctime", 0L);
                    if (optLong > 0) {
                        this.bBE = new Date(optLong);
                    } else {
                        this.bBE = new Date();
                    }
                }
            }
        } catch (Exception e) {
            this.Ln = false;
            BdLog.e(e.getMessage());
        }
    }
}
