package com.baidu.tieba.square.square;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.core.data.bt;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class h {
    private long mTimeStamp;
    private ArrayList<bt> maG = new ArrayList<>();
    private ArrayList<a> maI = new ArrayList<>();
    private ArrayList<b> maX = new ArrayList<>();
    private ArrayList<d> maY = new ArrayList<>();
    private boolean isSuccess = true;

    public boolean dvq() {
        return true;
    }

    public ArrayList<b> dvr() {
        return this.maX;
    }

    public ArrayList<a> dvs() {
        return this.maI;
    }

    public ArrayList<bt> dvt() {
        return this.maG;
    }

    public void bc(ArrayList<bt> arrayList) {
        this.maG = arrayList;
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
            Qx(str);
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
                                bt btVar = new bt();
                                btVar.zi(optString);
                                btVar.setLink(optString2);
                                btVar.zj(optString3);
                                this.maG.add(btVar);
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
                                aVar.maZ = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN, "");
                                aVar.mba = false;
                                this.maI.add(aVar);
                            } else if (optInt == 3) {
                                i++;
                                a aVar2 = new a();
                                aVar2.title = jSONObject.optString("title", "");
                                aVar2.link = jSONObject.optString("link", "");
                                aVar2.maZ = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN, "");
                                aVar2.mba = true;
                                this.maI.add(aVar2);
                            } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                                b bVar = new b();
                                bVar.mbb = true;
                                bVar.mbh = i2 - i;
                                if (optInt == 2) {
                                    bVar.mbc = true;
                                } else {
                                    bVar.mbc = false;
                                }
                                bVar.link = jSONObject.optString("link", "");
                                bVar.title = jSONObject.optString("title", "");
                                this.maX.add(bVar);
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                    if (jSONObject2 != null) {
                                        b bVar2 = new b();
                                        if (optInt == 2) {
                                            bVar2.mbc = true;
                                        } else {
                                            bVar2.mbc = false;
                                        }
                                        bVar2.mbb = false;
                                        bVar2.mbh = i2 - i;
                                        bVar2.mbi = i3;
                                        bVar2.forumId = jSONObject2.optInt("forum_id", 0);
                                        bVar2.forumName = jSONObject2.optString("forum_name", "");
                                        bVar2.kxD = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
                                        bVar2.mbe = jSONObject2.optString("explain", "");
                                        bVar2.mbf = jSONObject2.optString("desc", "");
                                        bVar2.mbd = jSONObject2.optString("tag", "");
                                        bVar2.mbg = jSONObject2.optLong("member_count", 0L);
                                        bVar2.threadNum = jSONObject2.optLong("thread_num", 0L);
                                        bVar2.link = jSONObject2.optString("link", "");
                                        this.maX.add(bVar2);
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

    private void Qx(String str) {
        JSONArray optJSONArray;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            d dVar = new d();
                            this.maY.add(dVar);
                            dVar.mbl = new ArrayList<>();
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
                                        cVar.cVl = jSONObject2.optString("explain", "");
                                        cVar.desc = jSONObject2.optString("desc", "");
                                        cVar.tag = jSONObject2.optString("tag", "");
                                        cVar.mbj = jSONObject2.optLong("member_count", 0L);
                                        cVar.mbk = jSONObject2.optLong("thread_num", 0L);
                                        cVar.link = jSONObject2.optString("link", "");
                                        dVar.mbl.add(cVar);
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

    public String dvu() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.maG != null && this.maG.size() != 0) {
                Iterator<bt> it = this.maG.iterator();
                while (it.hasNext()) {
                    bt next = it.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pic_url_bigger", next.bcA());
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
        if (this.maY == null || this.maY.size() == 0) {
            return jSONObject.toString();
        }
        Iterator<d> it2 = this.maY.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (next2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("title", next2.title);
                jSONObject3.put("type", next2.type);
                jSONObject3.put(UgcUBCUtils.UGC_TYPE_PIC_BTN, next2.pic);
                jSONObject3.put("link", next2.link);
                ArrayList<c> arrayList = next2.mbl;
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
                            jSONObject4.put("explain", next3.cVl);
                            jSONObject4.put("desc", next3.desc);
                            jSONObject4.put("tag", next3.tag);
                            jSONObject4.put("thread_num", next3.mbk);
                            jSONObject4.put("member_count", next3.mbj);
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
            if ((this.maG == null || this.maG.size() == 0) && ((this.maI == null || this.maI.size() == 0) && (this.maX == null || this.maX.size() == 0))) {
                z = true;
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class a {
        String link;
        String maZ;
        boolean mba;
        String title;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class b {
        int forumId;
        String forumName;
        String kxD;
        String link;
        boolean mbb;
        boolean mbc;
        String mbd;
        String mbe;
        String mbf;
        long mbg;
        int mbh;
        int mbi;
        long threadNum;
        String title;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class d {
        String link;
        ArrayList<c> mbl;
        String pic;
        String title;
        int type;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class c {
        String avatar;
        String cVl;
        String desc;
        int forum_id;
        String forum_name;
        String link;
        long mbj;
        long mbk;
        String tag;

        c() {
        }
    }
}
