package com.baidu.tieba.square.square;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {
    private long bck;
    private ArrayList<bd> jbc = new ArrayList<>();
    private ArrayList<a> jbe = new ArrayList<>();
    private ArrayList<b> jbu = new ArrayList<>();
    private ArrayList<d> jbv = new ArrayList<>();
    private boolean isSuccess = true;

    public boolean cob() {
        return true;
    }

    public ArrayList<b> coc() {
        return this.jbu;
    }

    public ArrayList<a> cod() {
        return this.jbe;
    }

    public ArrayList<bd> coe() {
        return this.jbc;
    }

    public void aE(ArrayList<bd> arrayList) {
        this.jbc = arrayList;
    }

    public void ew(long j) {
        this.bck = j;
    }

    public void parserJson(String str) {
        if (str == null || str.length() < 1) {
            this.isSuccess = false;
            return;
        }
        try {
            parserJson(new JSONObject(str));
            Ew(str);
        } catch (Exception e) {
            this.isSuccess = false;
            BdLog.e(e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                I(jSONObject.optJSONArray("banner"));
                this.bck = jSONObject.optLong("prevtime");
                JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
                if (optJSONObject != null) {
                    J(optJSONObject.optJSONArray("new_list"));
                }
            } catch (Exception e) {
                this.isSuccess = false;
                BdLog.e(e.toString());
            }
        }
    }

    private void I(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("pic_url_bigger", "");
                            String optString2 = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                            String optString3 = jSONObject.optString("template_id", "");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                bd bdVar = new bd();
                                bdVar.mv(optString);
                                bdVar.setLink(optString2);
                                bdVar.mw(optString3);
                                this.jbc.add(bdVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private void J(JSONArray jSONArray) {
        int optInt;
        JSONArray optJSONArray;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && (optInt = jSONObject.optInt("type", -1)) != -1) {
                            if (optInt == 1) {
                                i++;
                                a aVar = new a();
                                aVar.title = jSONObject.optString("title", "");
                                aVar.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                aVar.jbw = jSONObject.optString("pic", "");
                                aVar.jbx = false;
                                this.jbe.add(aVar);
                            } else if (optInt == 3) {
                                i++;
                                a aVar2 = new a();
                                aVar2.title = jSONObject.optString("title", "");
                                aVar2.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                aVar2.jbw = jSONObject.optString("pic", "");
                                aVar2.jbx = true;
                                this.jbe.add(aVar2);
                            } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                                b bVar = new b();
                                bVar.jby = true;
                                bVar.jbF = i2 - i;
                                if (optInt == 2) {
                                    bVar.jbz = true;
                                } else {
                                    bVar.jbz = false;
                                }
                                bVar.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                bVar.title = jSONObject.optString("title", "");
                                this.jbu.add(bVar);
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                    if (jSONObject2 != null) {
                                        b bVar2 = new b();
                                        if (optInt == 2) {
                                            bVar2.jbz = true;
                                        } else {
                                            bVar2.jbz = false;
                                        }
                                        bVar2.jby = false;
                                        bVar2.jbF = i2 - i;
                                        bVar2.jbG = i3;
                                        bVar2.forumId = jSONObject2.optInt("forum_id", 0);
                                        bVar2.forumName = jSONObject2.optString("forum_name", "");
                                        bVar2.jbA = jSONObject2.optString("avatar", "");
                                        bVar2.jbC = jSONObject2.optString("explain", "");
                                        bVar2.jbD = jSONObject2.optString("desc", "");
                                        bVar2.jbB = jSONObject2.optString("tag", "");
                                        bVar2.jbE = jSONObject2.optLong("member_count", 0L);
                                        bVar2.threadNum = jSONObject2.optLong("thread_num", 0L);
                                        bVar2.link = jSONObject2.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                        this.jbu.add(bVar2);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public long getTimeStamp() {
        return this.bck;
    }

    private void Ew(String str) {
        JSONArray optJSONArray;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            d dVar = new d();
                            this.jbv.add(dVar);
                            dVar.jbK = new ArrayList<>();
                            dVar.title = jSONObject.optString("title", "");
                            dVar.type = jSONObject.optInt("type", -1);
                            dVar.pic = jSONObject.optString("pic", "");
                            dVar.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                    if (jSONObject2 != null) {
                                        c cVar = new c();
                                        cVar.forum_id = jSONObject2.optInt("forum_id", 0);
                                        cVar.forum_name = jSONObject2.optString("forum_name", "");
                                        cVar.avatar = jSONObject2.optString("avatar", "");
                                        cVar.jbJ = jSONObject2.optString("explain", "");
                                        cVar.desc = jSONObject2.optString("desc", "");
                                        cVar.tag = jSONObject2.optString("tag", "");
                                        cVar.jbH = jSONObject2.optLong("member_count", 0L);
                                        cVar.jbI = jSONObject2.optLong("thread_num", 0L);
                                        cVar.link = jSONObject2.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                        dVar.jbK.add(cVar);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public String aQD() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.jbc != null && this.jbc.size() != 0) {
                Iterator<bd> it = this.jbc.iterator();
                while (it.hasNext()) {
                    bd next = it.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pic_url_bigger", next.acU());
                        jSONObject2.put(SelectForumActivityConfig.KEY_SHARE_LINK, next.getLink());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("banner", jSONArray2);
            }
            jSONObject.put("prevtime", this.bck);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        if (this.jbv == null || this.jbv.size() == 0) {
            return jSONObject.toString();
        }
        Iterator<d> it2 = this.jbv.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (next2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("title", next2.title);
                jSONObject3.put("type", next2.type);
                jSONObject3.put("pic", next2.pic);
                jSONObject3.put(SelectForumActivityConfig.KEY_SHARE_LINK, next2.link);
                ArrayList<c> arrayList = next2.jbK;
                if (arrayList == null || arrayList.size() == 0) {
                    jSONArray.put(jSONObject3);
                } else {
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator<c> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        c next3 = it3.next();
                        if (next3 != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("forum_id", next3.forum_id);
                            jSONObject4.put("forum_name", next3.forum_name);
                            jSONObject4.put("avatar", next3.avatar);
                            jSONObject4.put("explain", next3.jbJ);
                            jSONObject4.put("desc", next3.desc);
                            jSONObject4.put("tag", next3.tag);
                            jSONObject4.put("thread_num", next3.jbI);
                            jSONObject4.put("member_count", next3.jbH);
                            jSONObject4.put(SelectForumActivityConfig.KEY_SHARE_LINK, next3.link);
                            jSONArray3.put(jSONObject4);
                        }
                    }
                    jSONObject3.put("forum_list", jSONArray3);
                    jSONArray.put(jSONObject3);
                }
            }
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("new_list", jSONArray);
        jSONObject.put("new_recommend_topic", jSONObject5);
        return jSONObject.toString();
    }

    public boolean isEmpty() {
        boolean z = false;
        if (this.isSuccess) {
            if ((this.jbc == null || this.jbc.size() == 0) && ((this.jbe == null || this.jbe.size() == 0) && (this.jbu == null || this.jbu.size() == 0))) {
                z = true;
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        String jbw;
        boolean jbx;
        String link;
        String title;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {
        int forumId;
        String forumName;
        String jbA;
        String jbB;
        String jbC;
        String jbD;
        long jbE;
        int jbF;
        int jbG;
        boolean jby;
        boolean jbz;
        String link;
        long threadNum;
        String title;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class d {
        ArrayList<c> jbK;
        String link;
        String pic;
        String title;
        int type;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class c {
        String avatar;
        String desc;
        int forum_id;
        String forum_name;
        long jbH;
        long jbI;
        String jbJ;
        String link;
        String tag;

        c() {
        }
    }
}
