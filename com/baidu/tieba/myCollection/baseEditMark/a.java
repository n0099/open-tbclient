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
    private boolean bEz;
    private c bEt = null;
    private d bEu = null;
    private b bEv = null;
    private int bEx = 0;
    private int bEy = 0;
    protected BaseActivity.LoadDataCallBack bEA = null;
    private ArrayList<MarkData> bEw = new ArrayList<>();

    public a() {
        this.bEz = false;
        this.bEz = true;
    }

    public int getOffset() {
        if (this.bEw == null) {
            return 0;
        }
        return this.bEw.size();
    }

    public int Yi() {
        return this.bEy;
    }

    public void gZ(int i) {
        this.bEy = i;
    }

    public boolean hasMore() {
        return this.bEx >= 20;
    }

    public void reset() {
        this.bEy = 0;
        this.bEx = 0;
        this.bEz = true;
    }

    public boolean isFirst() {
        return this.bEz;
    }

    public ArrayList<MarkData> Yj() {
        return this.bEw;
    }

    public void K(ArrayList<MarkData> arrayList) {
        this.bEw = arrayList;
    }

    public void L(ArrayList<MarkData> arrayList) {
        if (this.bEw != null && arrayList != null) {
            this.bEw.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.bEw.add(markData);
    }

    public int getCount() {
        if (this.bEw == null) {
            return 0;
        }
        return this.bEw.size();
    }

    public int Yk() {
        return this.bEx;
    }

    public void Yl() {
        ArrayList<MarkData> anI = j.anI();
        if (anI != null) {
            K(anI);
        }
    }

    public String ad(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.bEw == null) {
            return null;
        }
        if (i >= this.bEw.size()) {
            i2 -= (i - this.bEw.size()) - 1;
            i = this.bEw.size() - 1;
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
                    JSONObject json = this.bEw.get(i5).toJson();
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

    public void hx(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> hy(String str) {
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
                    this.bEw.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void e(Boolean bool) {
        if (this.bEt != null) {
            this.bEt.cancel();
        }
        this.bEt = new c(this, getOffset());
        this.bEt.setPriority(3);
        this.bEt.execute(bool);
    }

    public void startSync() {
        if (this.bEu != null) {
            this.bEu.cancel();
        }
        this.bEu = new d(this, null);
        this.bEu.setPriority(2);
        this.bEu.execute(new a[0]);
    }

    public boolean ha(int i) {
        if (this.bEv != null) {
            this.bEv.cancel();
        }
        if (i >= this.bEw.size() || this.bEw.get(i) == null || this.bEw.get(i).getId() == null) {
            return false;
        }
        this.bEv = new b(this, this.bEw.get(i).getId(), i);
        this.bEv.setPriority(2);
        this.bEv.execute(new Boolean[0]);
        return true;
    }

    public int Ym() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getInt("uploac_mark_offset", 399);
    }

    public void hb(int i) {
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.bEt != null) {
            this.bEt.cancel();
        }
        if (this.bEu != null) {
            this.bEu.cancel();
        }
        if (this.bEv != null) {
            this.bEv.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.bEA = loadDataCallBack;
    }

    private void removalDuplicate() {
        if (this.bEw != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.bEw.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
