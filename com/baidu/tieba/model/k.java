package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private boolean h;
    private m b = null;
    private n c = null;
    private l d = null;
    private int f = 0;
    private int g = 0;
    protected BaseActivity.LoadDataCallBack a = null;
    private ArrayList<MarkData> e = new ArrayList<>();

    public k() {
        this.h = false;
        this.h = true;
    }

    public int a() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public int b() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public boolean c() {
        return this.f >= 20;
    }

    public void d() {
        this.g = 0;
        this.f = 0;
        this.h = true;
    }

    public boolean e() {
        return this.h;
    }

    public ArrayList<MarkData> f() {
        return this.e;
    }

    public void a(ArrayList<MarkData> arrayList) {
        this.e = arrayList;
    }

    public void b(ArrayList<MarkData> arrayList) {
        if (this.e != null && arrayList != null) {
            this.e.addAll(arrayList);
            m();
        }
    }

    public void a(MarkData markData) {
        this.e.add(markData);
    }

    public int g() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public int h() {
        return this.f;
    }

    public void i() {
        ArrayList<MarkData> l = com.baidu.tieba.util.k.l();
        if (l != null) {
            a(l);
        }
    }

    public String a(int i, int i2) {
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
                    BdLog.e(getClass().getName(), "toJson", e.toString());
                    jSONArray = null;
                }
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> b(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
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

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.e.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(Boolean bool) {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new m(this, a());
        this.b.setPriority(3);
        this.b.execute(bool);
    }

    public void j() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new n(this, null);
        this.c.setPriority(2);
        this.c.execute(new k[0]);
    }

    public boolean b(int i) {
        if (this.d != null) {
            this.d.cancel();
        }
        if (i >= this.e.size() || this.e.get(i) == null || this.e.get(i).getId() == null) {
            return false;
        }
        this.d = new l(this, this.e.get(i).getId(), i);
        this.d.setPriority(2);
        this.d.execute(new Boolean[0]);
        return true;
    }

    public int k() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("uploac_mark_offset", 399);
    }

    public void c(int i) {
        com.baidu.tbadk.core.sharedPref.b.a().b("uploac_mark_offset", i);
    }

    public void l() {
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

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.a = loadDataCallBack;
    }

    private void m() {
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
