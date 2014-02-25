package com.baidu.tieba.square;

import com.baidu.tieba.forumdetail.ForumDetailData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    private ArrayList<av> a = new ArrayList<>();
    private ArrayList<av> b = new ArrayList<>();
    private af c = new af();
    private ForumDetailData.ThreadInfo[] d = null;
    private au e = null;
    private boolean f = true;

    public boolean a() {
        return this.f;
    }

    public ArrayList<av> b() {
        return this.a;
    }

    public ArrayList<av> c() {
        return this.b;
    }

    public af d() {
        return this.c;
    }

    public ForumDetailData.ThreadInfo[] e() {
        return this.d;
    }

    public au f() {
        return this.e;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.f = false;
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.f = false;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            a(jSONObject.optJSONArray("banner"));
            b(jSONObject.optJSONArray("forum_list_recommend_img"));
            this.c.a(jSONObject.optJSONArray("forum_list_recommend"));
            c(jSONObject.optJSONArray("thread_list"));
            this.e = new au();
            this.e.b(jSONObject);
        } catch (Exception e) {
            this.f = false;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    private void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        av avVar = new av();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        avVar.a(jSONObject.optString("pic_url", ""));
                        avVar.b(jSONObject.optString("link", ""));
                        this.a.add(avVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parseCarouselRecommendData", e.toString());
            }
        }
    }

    private void b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        av avVar = new av();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        avVar.a(jSONObject.optString("pic_url", ""));
                        avVar.b(jSONObject.optString("link", ""));
                        this.b.add(avVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parseForumTopicRecommendData", e.toString());
            }
        }
    }

    private void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    this.d = new ForumDetailData.ThreadInfo[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ForumDetailData.ThreadInfo threadInfo = new ForumDetailData.ThreadInfo();
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        threadInfo.id = jSONObject.optLong("id");
                        threadInfo.title = jSONObject.optString("title");
                        threadInfo.viewNum = jSONObject.optLong("view_num");
                        threadInfo.replyNum = jSONObject.optLong("reply_num");
                        threadInfo.forumName = jSONObject.optString("forum_name", "");
                        threadInfo.postAuthor = jSONObject.optString("post_author", "");
                        JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                        if (optJSONArray != null) {
                            threadInfo.abstracts = new ForumDetailData.ThreadAbstract[optJSONArray.length()];
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ForumDetailData.ThreadAbstract threadAbstract = new ForumDetailData.ThreadAbstract();
                                threadAbstract.type = jSONObject2.optInt("type", 0);
                                threadAbstract.text = jSONObject2.optString("text", "");
                                threadInfo.abstracts[i2] = threadAbstract;
                            }
                            this.d[i] = threadInfo;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parseRecommendPostData", e.toString());
            }
        }
    }

    public boolean g() {
        boolean z = false;
        if (this.f) {
            if (this.a == null || this.e == null || this.b == null || this.c == null || this.d == null) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
