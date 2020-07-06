package com.baidu.tieba.square.square;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.core.data.br;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private long mTimeStamp;
    private ArrayList<br> lBG = new ArrayList<>();
    private ArrayList<a> lBI = new ArrayList<>();
    private ArrayList<b> lBX = new ArrayList<>();
    private ArrayList<d> lBY = new ArrayList<>();
    private boolean isSuccess = true;

    public boolean dgK() {
        return true;
    }

    public ArrayList<b> dgL() {
        return this.lBX;
    }

    public ArrayList<a> dgM() {
        return this.lBI;
    }

    public ArrayList<br> dgN() {
        return this.lBG;
    }

    public void aV(ArrayList<br> arrayList) {
        this.lBG = arrayList;
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
            MO(str);
        } catch (Exception e) {
            this.isSuccess = false;
            BdLog.e(e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                V(jSONObject.optJSONArray("banner"));
                this.mTimeStamp = jSONObject.optLong("prevtime");
                JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
                if (optJSONObject != null) {
                    W(optJSONObject.optJSONArray("new_list"));
                }
            } catch (Exception e) {
                this.isSuccess = false;
                BdLog.e(e.toString());
            }
        }
    }

    private void V(JSONArray jSONArray) {
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
                                br brVar = new br();
                                brVar.vN(optString);
                                brVar.setLink(optString2);
                                brVar.vO(optString3);
                                this.lBG.add(brVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private void W(JSONArray jSONArray) {
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
                                aVar.lBZ = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN, "");
                                aVar.lCa = false;
                                this.lBI.add(aVar);
                            } else if (optInt == 3) {
                                i++;
                                a aVar2 = new a();
                                aVar2.title = jSONObject.optString("title", "");
                                aVar2.link = jSONObject.optString("link", "");
                                aVar2.lBZ = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN, "");
                                aVar2.lCa = true;
                                this.lBI.add(aVar2);
                            } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                                b bVar = new b();
                                bVar.lCb = true;
                                bVar.lCh = i2 - i;
                                if (optInt == 2) {
                                    bVar.lCc = true;
                                } else {
                                    bVar.lCc = false;
                                }
                                bVar.link = jSONObject.optString("link", "");
                                bVar.title = jSONObject.optString("title", "");
                                this.lBX.add(bVar);
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                    if (jSONObject2 != null) {
                                        b bVar2 = new b();
                                        if (optInt == 2) {
                                            bVar2.lCc = true;
                                        } else {
                                            bVar2.lCc = false;
                                        }
                                        bVar2.lCb = false;
                                        bVar2.lCh = i2 - i;
                                        bVar2.lCi = i3;
                                        bVar2.forumId = jSONObject2.optInt("forum_id", 0);
                                        bVar2.forumName = jSONObject2.optString("forum_name", "");
                                        bVar2.jZH = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
                                        bVar2.lCe = jSONObject2.optString("explain", "");
                                        bVar2.lCf = jSONObject2.optString("desc", "");
                                        bVar2.lCd = jSONObject2.optString("tag", "");
                                        bVar2.lCg = jSONObject2.optLong("member_count", 0L);
                                        bVar2.threadNum = jSONObject2.optLong("thread_num", 0L);
                                        bVar2.link = jSONObject2.optString("link", "");
                                        this.lBX.add(bVar2);
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

    private void MO(String str) {
        JSONArray optJSONArray;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            d dVar = new d();
                            this.lBY.add(dVar);
                            dVar.lCl = new ArrayList<>();
                            dVar.title = jSONObject.optString("title", "");
                            dVar.type = jSONObject.optInt("type", -1);
                            dVar.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN, "");
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
                                        cVar.cJf = jSONObject2.optString("explain", "");
                                        cVar.desc = jSONObject2.optString("desc", "");
                                        cVar.tag = jSONObject2.optString("tag", "");
                                        cVar.lCj = jSONObject2.optLong("member_count", 0L);
                                        cVar.lCk = jSONObject2.optLong("thread_num", 0L);
                                        cVar.link = jSONObject2.optString("link", "");
                                        dVar.lCl.add(cVar);
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

    public String dgO() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.lBG != null && this.lBG.size() != 0) {
                Iterator<br> it = this.lBG.iterator();
                while (it.hasNext()) {
                    br next = it.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pic_url_bigger", next.aQl());
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
        if (this.lBY == null || this.lBY.size() == 0) {
            return jSONObject.toString();
        }
        Iterator<d> it2 = this.lBY.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (next2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("title", next2.title);
                jSONObject3.put("type", next2.type);
                jSONObject3.put(UgcUBCUtils.UGC_TYPE_PIC_BTN, next2.pic);
                jSONObject3.put("link", next2.link);
                ArrayList<c> arrayList = next2.lCl;
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
                            jSONObject4.put("explain", next3.cJf);
                            jSONObject4.put("desc", next3.desc);
                            jSONObject4.put("tag", next3.tag);
                            jSONObject4.put("thread_num", next3.lCk);
                            jSONObject4.put("member_count", next3.lCj);
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
            if ((this.lBG == null || this.lBG.size() == 0) && ((this.lBI == null || this.lBI.size() == 0) && (this.lBX == null || this.lBX.size() == 0))) {
                z = true;
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        String lBZ;
        boolean lCa;
        String link;
        String title;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class b {
        int forumId;
        String forumName;
        String jZH;
        boolean lCb;
        boolean lCc;
        String lCd;
        String lCe;
        String lCf;
        long lCg;
        int lCh;
        int lCi;
        String link;
        long threadNum;
        String title;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class d {
        ArrayList<c> lCl;
        String link;
        String pic;
        String title;
        int type;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class c {
        String avatar;
        String cJf;
        String desc;
        int forum_id;
        String forum_name;
        long lCj;
        long lCk;
        String link;
        String tag;

        c() {
        }
    }
}
