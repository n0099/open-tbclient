package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.tbadkCore.util.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean bEm;
    private c bEg = null;
    private d bEh = null;
    private b bEi = null;
    private int bEk = 0;
    private int bEl = 0;
    protected BaseActivity.LoadDataCallBack bEn = null;
    private ArrayList<MarkData> bEj = new ArrayList<>();

    public a() {
        this.bEm = false;
        this.bEm = true;
    }

    public int getOffset() {
        if (this.bEj == null) {
            return 0;
        }
        return this.bEj.size();
    }

    public int XW() {
        return this.bEl;
    }

    public void gX(int i) {
        this.bEl = i;
    }

    public boolean hasMore() {
        return this.bEk >= 20;
    }

    public void reset() {
        this.bEl = 0;
        this.bEk = 0;
        this.bEm = true;
    }

    public boolean isFirst() {
        return this.bEm;
    }

    public ArrayList<MarkData> XX() {
        return this.bEj;
    }

    public void I(ArrayList<MarkData> arrayList) {
        this.bEj = arrayList;
    }

    public void J(ArrayList<MarkData> arrayList) {
        if (this.bEj != null && arrayList != null) {
            this.bEj.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.bEj.add(markData);
    }

    public int getCount() {
        if (this.bEj == null) {
            return 0;
        }
        return this.bEj.size();
    }

    public int XY() {
        return this.bEk;
    }

    public void XZ() {
        ArrayList<MarkData> ant = j.ant();
        if (ant != null) {
            I(ant);
        }
    }

    public String ad(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.bEj == null) {
            return null;
        }
        if (i >= this.bEj.size()) {
            i2 -= (i - this.bEj.size()) - 1;
            i = this.bEj.size() - 1;
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
                    JSONObject json = this.bEj.get(i5).toJson();
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

    public void hu(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> hv(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals(GameInfoData.NOT_FROM_DETAIL)) {
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
            if (jSONObject.optJSONObject("error").optString("errno").equals(GameInfoData.NOT_FROM_DETAIL)) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.bEj.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void e(Boolean bool) {
        if (this.bEg != null) {
            this.bEg.cancel();
        }
        this.bEg = new c(this, getOffset());
        this.bEg.setPriority(3);
        this.bEg.execute(bool);
    }

    public void startSync() {
        if (this.bEh != null) {
            this.bEh.cancel();
        }
        this.bEh = new d(this, null);
        this.bEh.setPriority(2);
        this.bEh.execute(new a[0]);
    }

    public boolean gY(int i) {
        if (this.bEi != null) {
            this.bEi.cancel();
        }
        if (i >= this.bEj.size() || this.bEj.get(i) == null || this.bEj.get(i).getId() == null) {
            return false;
        }
        this.bEi = new b(this, this.bEj.get(i).getId(), i);
        this.bEi.setPriority(2);
        this.bEi.execute(new Boolean[0]);
        return true;
    }

    public int Ya() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getInt("uploac_mark_offset", 399);
    }

    public void gZ(int i) {
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.bEg != null) {
            this.bEg.cancel();
        }
        if (this.bEh != null) {
            this.bEh.cancel();
        }
        if (this.bEi != null) {
            this.bEi.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.bEn = loadDataCallBack;
    }

    private void removalDuplicate() {
        if (this.bEj != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.bEj.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
