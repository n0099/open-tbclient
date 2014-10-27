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
    private boolean awM;
    private l boi = null;
    private m boj = null;
    private k bok = null;
    private int bom = 0;
    private int bon = 0;
    protected BaseActivity.LoadDataCallBack atj = null;
    private ArrayList<MarkData> bol = new ArrayList<>();

    public j() {
        this.awM = false;
        this.awM = true;
    }

    public int getOffset() {
        if (this.bol == null) {
            return 0;
        }
        return this.bol.size();
    }

    public int Th() {
        return this.bon;
    }

    public void gA(int i) {
        this.bon = i;
    }

    public boolean hasMore() {
        return this.bom >= 20;
    }

    public void reset() {
        this.bon = 0;
        this.bom = 0;
        this.awM = true;
    }

    public boolean isFirst() {
        return this.awM;
    }

    public ArrayList<MarkData> Ti() {
        return this.bol;
    }

    public void y(ArrayList<MarkData> arrayList) {
        this.bol = arrayList;
    }

    public void z(ArrayList<MarkData> arrayList) {
        if (this.bol != null && arrayList != null) {
            this.bol.addAll(arrayList);
            HC();
        }
    }

    public void a(MarkData markData) {
        this.bol.add(markData);
    }

    public int getCount() {
        if (this.bol == null) {
            return 0;
        }
        return this.bol.size();
    }

    public int Tj() {
        return this.bom;
    }

    public void Tk() {
        ArrayList<MarkData> aeF = com.baidu.tieba.util.j.aeF();
        if (aeF != null) {
            y(aeF);
        }
    }

    public String T(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.bol == null) {
            return null;
        }
        if (i >= this.bol.size()) {
            i2 -= (i - this.bol.size()) - 1;
            i = this.bol.size() - 1;
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
                    JSONObject json = this.bol.get(i5).toJson();
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
                    this.bol.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void g(Boolean bool) {
        if (this.boi != null) {
            this.boi.cancel();
        }
        this.boi = new l(this, getOffset());
        this.boi.setPriority(3);
        this.boi.execute(bool);
    }

    public void startSync() {
        if (this.boj != null) {
            this.boj.cancel();
        }
        this.boj = new m(this, null);
        this.boj.setPriority(2);
        this.boj.execute(new j[0]);
    }

    public boolean gB(int i) {
        if (this.bok != null) {
            this.bok.cancel();
        }
        if (i >= this.bol.size() || this.bol.get(i) == null || this.bol.get(i).getId() == null) {
            return false;
        }
        this.bok = new k(this, this.bol.get(i).getId(), i);
        this.bok.setPriority(2);
        this.bok.execute(new Boolean[0]);
        return true;
    }

    public int Tl() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getInt("uploac_mark_offset", 399);
    }

    public void gC(int i) {
        com.baidu.tbadk.core.sharedPref.b.lk().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.boi != null) {
            this.boi.cancel();
        }
        if (this.boj != null) {
            this.boj.cancel();
        }
        if (this.bok != null) {
            this.bok.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.atj = loadDataCallBack;
    }

    private void HC() {
        if (this.bol != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.bol.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
