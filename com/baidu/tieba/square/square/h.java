package com.baidu.tieba.square.square;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.data.by;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    private long mTimeStamp;
    private ArrayList<by> nsN = new ArrayList<>();
    private ArrayList<a> nsP = new ArrayList<>();
    private ArrayList<b> nte = new ArrayList<>();
    private ArrayList<d> ntf = new ArrayList<>();
    private boolean isSuccess = true;

    public boolean dMl() {
        return true;
    }

    public ArrayList<b> dMm() {
        return this.nte;
    }

    public ArrayList<a> dMn() {
        return this.nsP;
    }

    public ArrayList<by> dMo() {
        return this.nsN;
    }

    public void be(ArrayList<by> arrayList) {
        this.nsN = arrayList;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void parserJson(String str) {
        if (str == null || str.length() < 1) {
            this.isSuccess = false;
            return;
        }
        try {
            parserJson(new JSONObject(str));
            Ta(str);
        } catch (Exception e) {
            this.isSuccess = false;
            BdLog.e(e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Y(jSONObject.optJSONArray("banner"));
                this.mTimeStamp = jSONObject.optLong("prevtime");
                JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
                if (optJSONObject != null) {
                    Z(optJSONObject.optJSONArray("new_list"));
                }
            } catch (Exception e) {
                this.isSuccess = false;
                BdLog.e(e.toString());
            }
        }
    }

    private void Y(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("pic_url_bigger", "");
                            String optString2 = jSONObject.optString("link", "");
                            String optString3 = jSONObject.optString("template_id", "");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                by byVar = new by();
                                byVar.Ad(optString);
                                byVar.setLink(optString2);
                                byVar.Ae(optString3);
                                this.nsN.add(byVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private void Z(JSONArray jSONArray) {
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
                                aVar.link = jSONObject.optString("link", "");
                                aVar.ntg = jSONObject.optString("pic", "");
                                aVar.jZS = false;
                                this.nsP.add(aVar);
                            } else if (optInt == 3) {
                                i++;
                                a aVar2 = new a();
                                aVar2.title = jSONObject.optString("title", "");
                                aVar2.link = jSONObject.optString("link", "");
                                aVar2.ntg = jSONObject.optString("pic", "");
                                aVar2.jZS = true;
                                this.nsP.add(aVar2);
                            } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                                b bVar = new b();
                                bVar.nth = true;
                                bVar.ntn = i2 - i;
                                if (optInt == 2) {
                                    bVar.nti = true;
                                } else {
                                    bVar.nti = false;
                                }
                                bVar.link = jSONObject.optString("link", "");
                                bVar.title = jSONObject.optString("title", "");
                                this.nte.add(bVar);
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                    if (jSONObject2 != null) {
                                        b bVar2 = new b();
                                        if (optInt == 2) {
                                            bVar2.nti = true;
                                        } else {
                                            bVar2.nti = false;
                                        }
                                        bVar2.nth = false;
                                        bVar2.ntn = i2 - i;
                                        bVar2.nto = i3;
                                        bVar2.forumId = jSONObject2.optInt("forum_id", 0);
                                        bVar2.forumName = jSONObject2.optString("forum_name", "");
                                        bVar2.lLk = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
                                        bVar2.ntk = jSONObject2.optString("explain", "");
                                        bVar2.ntl = jSONObject2.optString("desc", "");
                                        bVar2.ntj = jSONObject2.optString("tag", "");
                                        bVar2.ntm = jSONObject2.optLong("member_count", 0L);
                                        bVar2.threadNum = jSONObject2.optLong("thread_num", 0L);
                                        bVar2.link = jSONObject2.optString("link", "");
                                        this.nte.add(bVar2);
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
        return this.mTimeStamp;
    }

    private void Ta(String str) {
        JSONArray optJSONArray;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            d dVar = new d();
                            this.ntf.add(dVar);
                            dVar.ntr = new ArrayList<>();
                            dVar.title = jSONObject.optString("title", "");
                            dVar.type = jSONObject.optInt("type", -1);
                            dVar.pic = jSONObject.optString("pic", "");
                            dVar.link = jSONObject.optString("link", "");
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                    if (jSONObject2 != null) {
                                        c cVar = new c();
                                        cVar.forum_id = jSONObject2.optInt("forum_id", 0);
                                        cVar.forum_name = jSONObject2.optString("forum_name", "");
                                        cVar.avatar = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
                                        cVar.dJh = jSONObject2.optString("explain", "");
                                        cVar.desc = jSONObject2.optString("desc", "");
                                        cVar.tag = jSONObject2.optString("tag", "");
                                        cVar.ntp = jSONObject2.optLong("member_count", 0L);
                                        cVar.ntq = jSONObject2.optLong("thread_num", 0L);
                                        cVar.link = jSONObject2.optString("link", "");
                                        dVar.ntr.add(cVar);
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

    public String dMp() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.nsN != null && this.nsN.size() != 0) {
                Iterator<by> it = this.nsN.iterator();
                while (it.hasNext()) {
                    by next = it.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pic_url_bigger", next.getImgUrl());
                        jSONObject2.put("link", next.getLink());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("banner", jSONArray2);
            }
            jSONObject.put("prevtime", this.mTimeStamp);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        if (this.ntf == null || this.ntf.size() == 0) {
            return jSONObject.toString();
        }
        Iterator<d> it2 = this.ntf.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (next2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("title", next2.title);
                jSONObject3.put("type", next2.type);
                jSONObject3.put("pic", next2.pic);
                jSONObject3.put("link", next2.link);
                ArrayList<c> arrayList = next2.ntr;
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
                            jSONObject4.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, next3.avatar);
                            jSONObject4.put("explain", next3.dJh);
                            jSONObject4.put("desc", next3.desc);
                            jSONObject4.put("tag", next3.tag);
                            jSONObject4.put("thread_num", next3.ntq);
                            jSONObject4.put("member_count", next3.ntp);
                            jSONObject4.put("link", next3.link);
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
            if ((this.nsN == null || this.nsN.size() == 0) && ((this.nsP == null || this.nsP.size() == 0) && (this.nte == null || this.nte.size() == 0))) {
                z = true;
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        boolean jZS;
        String link;
        String ntg;
        String title;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b {
        int forumId;
        String forumName;
        String lLk;
        String link;
        boolean nth;
        boolean nti;
        String ntj;
        String ntk;
        String ntl;
        long ntm;
        int ntn;
        int nto;
        long threadNum;
        String title;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class d {
        String link;
        ArrayList<c> ntr;
        String pic;
        String title;
        int type;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class c {
        String avatar;
        String dJh;
        String desc;
        int forum_id;
        String forum_name;
        String link;
        long ntp;
        long ntq;
        String tag;

        c() {
        }
    }
}
