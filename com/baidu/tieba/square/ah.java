package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.forumdetail.ForumDetailData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private ArrayList<ak> bNg = new ArrayList<>();
    private ArrayList<ak> bNh = new ArrayList<>();
    private u bNi = new u();
    private ForumDetailData.ThreadInfo[] bNj = null;
    private aj bNk = null;
    private boolean isSuccess = true;

    public boolean adu() {
        return this.isSuccess;
    }

    public ArrayList<ak> adv() {
        return this.bNg;
    }

    public ArrayList<ak> adw() {
        return this.bNh;
    }

    public u adx() {
        return this.bNi;
    }

    public aj ady() {
        return this.bNk;
    }

    public void parserJson(String str) {
        if (str == null || str.length() < 1) {
            this.isSuccess = false;
            return;
        }
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            this.isSuccess = false;
            BdLog.e(e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            c(jSONObject.optJSONArray("banner"));
            d(jSONObject.optJSONArray("forum_list_recommend_img"));
            this.bNi.b(jSONObject.optJSONArray("forum_list_recommend"));
            e(jSONObject.optJSONArray("thread_list"));
            this.bNk = new aj();
            this.bNk.parserJson(jSONObject);
        } catch (Exception e) {
            this.isSuccess = false;
            BdLog.e(e.toString());
        }
    }

    private void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ak akVar = new ak();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        akVar.hu(jSONObject.optString("pic_url", ""));
                        akVar.setLink(jSONObject.optString("link", ""));
                        this.bNg.add(akVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private void d(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ak akVar = new ak();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        akVar.hu(jSONObject.optString("pic_url", ""));
                        akVar.setLink(jSONObject.optString("link", ""));
                        this.bNh.add(akVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.bNj = new ForumDetailData.ThreadInfo[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ForumDetailData.ThreadInfo threadInfo = new ForumDetailData.ThreadInfo();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        threadInfo.id = jSONObject.optLong("id");
                        threadInfo.title = jSONObject.optString("title");
                        threadInfo.view_num = jSONObject.optLong("view_num");
                        threadInfo.reply_num = jSONObject.optLong("reply_num");
                        threadInfo.forumName = jSONObject.optString("forum_name", "");
                        threadInfo.postAuthor = jSONObject.optString("post_author", "");
                        JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                        if (optJSONArray != null) {
                            threadInfo.Abstract = new ForumDetailData.ThreadAbstract[optJSONArray.length()];
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ForumDetailData.ThreadAbstract threadAbstract = new ForumDetailData.ThreadAbstract();
                                threadAbstract.type = jSONObject2.optInt("type", 0);
                                threadAbstract.text = jSONObject2.optString("text", "");
                                threadInfo.Abstract[i2] = threadAbstract;
                            }
                            this.bNj[i] = threadInfo;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.isSuccess) {
            if (this.bNg == null || this.bNk == null || this.bNh == null || this.bNi == null || this.bNj == null) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
