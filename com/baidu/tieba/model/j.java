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
public class j {
    private boolean awV;
    private l bow = null;
    private m box = null;
    private k boy = null;
    private int boA = 0;
    private int boB = 0;
    protected BaseActivity.LoadDataCallBack ats = null;
    private ArrayList<MarkData> boz = new ArrayList<>();

    public j() {
        this.awV = false;
        this.awV = true;
    }

    public int getOffset() {
        if (this.boz == null) {
            return 0;
        }
        return this.boz.size();
    }

    public int Tk() {
        return this.boB;
    }

    public void gA(int i) {
        this.boB = i;
    }

    public boolean hasMore() {
        return this.boA >= 20;
    }

    public void reset() {
        this.boB = 0;
        this.boA = 0;
        this.awV = true;
    }

    public boolean isFirst() {
        return this.awV;
    }

    public ArrayList<MarkData> Tl() {
        return this.boz;
    }

    public void z(ArrayList<MarkData> arrayList) {
        this.boz = arrayList;
    }

    public void A(ArrayList<MarkData> arrayList) {
        if (this.boz != null && arrayList != null) {
            this.boz.addAll(arrayList);
            HF();
        }
    }

    public void a(MarkData markData) {
        this.boz.add(markData);
    }

    public int getCount() {
        if (this.boz == null) {
            return 0;
        }
        return this.boz.size();
    }

    public int Tm() {
        return this.boA;
    }

    public void Tn() {
        ArrayList<MarkData> aeI = com.baidu.tieba.util.j.aeI();
        if (aeI != null) {
            z(aeI);
        }
    }

    public String T(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.boz == null) {
            return null;
        }
        if (i >= this.boz.size()) {
            i2 -= (i - this.boz.size()) - 1;
            i = this.boz.size() - 1;
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
                    JSONObject json = this.boz.get(i5).toJson();
                    if (json == null || i4 < 0) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        jSONArray2.put(i4, json);
                    }
                    i5--;
                    i4 = i3;
                } catch (Exception e) {
                    BdLog.e(e.toString());
                    jSONArray = null;
                }
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void gQ(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> gR(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
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

    public void paserJson(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.boz.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void g(Boolean bool) {
        if (this.bow != null) {
            this.bow.cancel();
        }
        this.bow = new l(this, getOffset());
        this.bow.setPriority(3);
        this.bow.execute(bool);
    }

    public void startSync() {
        if (this.box != null) {
            this.box.cancel();
        }
        this.box = new m(this, null);
        this.box.setPriority(2);
        this.box.execute(new j[0]);
    }

    public boolean gB(int i) {
        if (this.boy != null) {
            this.boy.cancel();
        }
        if (i >= this.boz.size() || this.boz.get(i) == null || this.boz.get(i).getId() == null) {
            return false;
        }
        this.boy = new k(this, this.boz.get(i).getId(), i);
        this.boy.setPriority(2);
        this.boy.execute(new Boolean[0]);
        return true;
    }

    public int To() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getInt("uploac_mark_offset", 399);
    }

    public void gC(int i) {
        com.baidu.tbadk.core.sharedPref.b.lk().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.bow != null) {
            this.bow.cancel();
        }
        if (this.box != null) {
            this.box.cancel();
        }
        if (this.boy != null) {
            this.boy.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.ats = loadDataCallBack;
    }

    private void HF() {
        if (this.boz != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.boz.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
