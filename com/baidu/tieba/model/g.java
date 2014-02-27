package com.baidu.tieba.model;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    private boolean h;
    private i b = null;
    private j c = null;
    private h d = null;
    private int f = 0;
    private int g = 0;
    protected com.baidu.tieba.i a = null;
    private ArrayList<MarkData> e = new ArrayList<>();

    public g() {
        this.h = false;
        this.h = true;
    }

    public final int a() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public final int b() {
        return this.g;
    }

    public final void a(int i) {
        this.g = i;
    }

    public final boolean c() {
        return this.f >= 20;
    }

    public final void d() {
        this.g = 0;
        this.f = 0;
        this.h = true;
    }

    public final boolean e() {
        return this.h;
    }

    public final ArrayList<MarkData> f() {
        return this.e;
    }

    public final void a(ArrayList<MarkData> arrayList) {
        this.e = arrayList;
    }

    public final void b(ArrayList<MarkData> arrayList) {
        if (this.e != null && arrayList != null) {
            this.e.addAll(arrayList);
            if (this.e != null) {
                HashSet hashSet = new HashSet();
                Iterator<MarkData> it = this.e.iterator();
                while (it.hasNext()) {
                    if (!hashSet.add(it.next().getId())) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void a(MarkData markData) {
        this.e.add(markData);
    }

    public final int g() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public final int h() {
        return this.f;
    }

    public final void i() {
        ArrayList<MarkData> q = DatabaseService.q();
        if (q != null) {
            this.e = q;
        }
    }

    public final String a(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.e == null) {
            return null;
        }
        if (i >= this.e.size()) {
            i2 -= (i - this.e.size()) - 1;
            i = this.e.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (true) {
            if (i5 < 0) {
                jSONArray = jSONArray2;
                break;
            } else if (i5 <= i - i2) {
                jSONArray = jSONArray2;
                break;
            } else {
                try {
                    JSONObject json = this.e.get(i5).toJson();
                    if (json == null || i4 < 0) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        jSONArray2.put(i4, json);
                    }
                    i5--;
                    i4 = i3;
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "toJson", e.toString());
                    jSONArray = null;
                }
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> a(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals(SocialConstants.FALSE)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
            for (int i = 0; i < optJSONArray.length(); i++) {
                MarkData markData = new MarkData();
                markData.paserJson(optJSONArray.getJSONObject(i));
                arrayList.add(markData);
            }
            return arrayList;
        }
        return null;
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals(SocialConstants.FALSE)) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.e.add(markData);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public final void a(Boolean bool) {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new i(this, a());
        this.b.setPriority(3);
        this.b.execute(bool);
    }

    public final void j() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new j(this, (byte) 0);
        this.c.setPriority(2);
        this.c.execute(new g[0]);
    }

    public final boolean b(int i) {
        if (this.d != null) {
            this.d.cancel();
        }
        if (i >= this.e.size() || this.e.get(i) == null || this.e.get(i).getId() == null) {
            return false;
        }
        this.d = new h(this, this.e.get(i).getId(), i);
        this.d.setPriority(2);
        this.d.execute(new Boolean[0]);
        return true;
    }

    public static int k() {
        return com.baidu.tieba.sharedPref.b.a().a("uploac_mark_offset", 399);
    }

    public final void l() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.d != null) {
            this.d.cancel();
        }
    }

    public final void a(com.baidu.tieba.i iVar) {
        this.a = iVar;
    }
}
