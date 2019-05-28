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
    private long bbz;
    private ArrayList<bd> iUI = new ArrayList<>();
    private ArrayList<a> iUK = new ArrayList<>();
    private ArrayList<b> iVa = new ArrayList<>();
    private ArrayList<d> iVb = new ArrayList<>();
    private boolean isSuccess = true;

    public boolean cli() {
        return true;
    }

    public ArrayList<b> clj() {
        return this.iVa;
    }

    public ArrayList<a> clk() {
        return this.iUK;
    }

    public ArrayList<bd> cll() {
        return this.iUI;
    }

    public void aE(ArrayList<bd> arrayList) {
        this.iUI = arrayList;
    }

    public void em(long j) {
        this.bbz = j;
    }

    public void parserJson(String str) {
        if (str == null || str.length() < 1) {
            this.isSuccess = false;
            return;
        }
        try {
            parserJson(new JSONObject(str));
            DH(str);
        } catch (Exception e) {
            this.isSuccess = false;
            BdLog.e(e.toString());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                I(jSONObject.optJSONArray("banner"));
                this.bbz = jSONObject.optLong("prevtime");
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
                                bdVar.ml(optString);
                                bdVar.setLink(optString2);
                                bdVar.mm(optString3);
                                this.iUI.add(bdVar);
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
                                aVar.iVc = jSONObject.optString("pic", "");
                                aVar.iVd = false;
                                this.iUK.add(aVar);
                            } else if (optInt == 3) {
                                i++;
                                a aVar2 = new a();
                                aVar2.title = jSONObject.optString("title", "");
                                aVar2.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                aVar2.iVc = jSONObject.optString("pic", "");
                                aVar2.iVd = true;
                                this.iUK.add(aVar2);
                            } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                                b bVar = new b();
                                bVar.iVe = true;
                                bVar.iVl = i2 - i;
                                if (optInt == 2) {
                                    bVar.iVf = true;
                                } else {
                                    bVar.iVf = false;
                                }
                                bVar.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                bVar.title = jSONObject.optString("title", "");
                                this.iVa.add(bVar);
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                    if (jSONObject2 != null) {
                                        b bVar2 = new b();
                                        if (optInt == 2) {
                                            bVar2.iVf = true;
                                        } else {
                                            bVar2.iVf = false;
                                        }
                                        bVar2.iVe = false;
                                        bVar2.iVl = i2 - i;
                                        bVar2.iVm = i3;
                                        bVar2.forumId = jSONObject2.optInt("forum_id", 0);
                                        bVar2.forumName = jSONObject2.optString("forum_name", "");
                                        bVar2.iVg = jSONObject2.optString("avatar", "");
                                        bVar2.iVi = jSONObject2.optString("explain", "");
                                        bVar2.iVj = jSONObject2.optString("desc", "");
                                        bVar2.iVh = jSONObject2.optString("tag", "");
                                        bVar2.iVk = jSONObject2.optLong("member_count", 0L);
                                        bVar2.threadNum = jSONObject2.optLong("thread_num", 0L);
                                        bVar2.link = jSONObject2.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                        this.iVa.add(bVar2);
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
        return this.bbz;
    }

    private void DH(String str) {
        JSONArray optJSONArray;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            d dVar = new d();
                            this.iVb.add(dVar);
                            dVar.iVq = new ArrayList<>();
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
                                        cVar.iVp = jSONObject2.optString("explain", "");
                                        cVar.desc = jSONObject2.optString("desc", "");
                                        cVar.tag = jSONObject2.optString("tag", "");
                                        cVar.iVn = jSONObject2.optLong("member_count", 0L);
                                        cVar.iVo = jSONObject2.optLong("thread_num", 0L);
                                        cVar.link = jSONObject2.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
                                        dVar.iVq.add(cVar);
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

    public String aOS() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.iUI != null && this.iUI.size() != 0) {
                Iterator<bd> it = this.iUI.iterator();
                while (it.hasNext()) {
                    bd next = it.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pic_url_bigger", next.abS());
                        jSONObject2.put(SelectForumActivityConfig.KEY_SHARE_LINK, next.getLink());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("banner", jSONArray2);
            }
            jSONObject.put("prevtime", this.bbz);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        if (this.iVb == null || this.iVb.size() == 0) {
            return jSONObject.toString();
        }
        Iterator<d> it2 = this.iVb.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (next2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("title", next2.title);
                jSONObject3.put("type", next2.type);
                jSONObject3.put("pic", next2.pic);
                jSONObject3.put(SelectForumActivityConfig.KEY_SHARE_LINK, next2.link);
                ArrayList<c> arrayList = next2.iVq;
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
                            jSONObject4.put("explain", next3.iVp);
                            jSONObject4.put("desc", next3.desc);
                            jSONObject4.put("tag", next3.tag);
                            jSONObject4.put("thread_num", next3.iVo);
                            jSONObject4.put("member_count", next3.iVn);
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
            if ((this.iUI == null || this.iUI.size() == 0) && ((this.iUK == null || this.iUK.size() == 0) && (this.iVa == null || this.iVa.size() == 0))) {
                z = true;
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        String iVc;
        boolean iVd;
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
        boolean iVe;
        boolean iVf;
        String iVg;
        String iVh;
        String iVi;
        String iVj;
        long iVk;
        int iVl;
        int iVm;
        String link;
        long threadNum;
        String title;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class d {
        ArrayList<c> iVq;
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
        long iVn;
        long iVo;
        String iVp;
        String link;
        String tag;

        c() {
        }
    }
}
