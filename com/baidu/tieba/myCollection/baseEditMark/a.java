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
    private boolean bHu;
    private c bHo = null;
    private d bHp = null;
    private b bHq = null;
    private int bHs = 0;
    private int bHt = 0;
    protected BaseActivity.LoadDataCallBack bHv = null;
    private ArrayList<MarkData> bHr = new ArrayList<>();

    public a() {
        this.bHu = false;
        this.bHu = true;
    }

    public int getOffset() {
        if (this.bHr == null) {
            return 0;
        }
        return this.bHr.size();
    }

    public int ZI() {
        return this.bHt;
    }

    public void hq(int i) {
        this.bHt = i;
    }

    public boolean hasMore() {
        return this.bHs >= 20;
    }

    public void reset() {
        this.bHt = 0;
        this.bHs = 0;
        this.bHu = true;
    }

    public boolean isFirst() {
        return this.bHu;
    }

    public ArrayList<MarkData> ZJ() {
        return this.bHr;
    }

    public void H(ArrayList<MarkData> arrayList) {
        this.bHr = arrayList;
    }

    public void I(ArrayList<MarkData> arrayList) {
        if (this.bHr != null && arrayList != null) {
            this.bHr.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.bHr.add(markData);
    }

    public int getCount() {
        if (this.bHr == null) {
            return 0;
        }
        return this.bHr.size();
    }

    public int ZK() {
        return this.bHs;
    }

    public void ZL() {
        ArrayList<MarkData> apA = j.apA();
        if (apA != null) {
            H(apA);
        }
    }

    public String af(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.bHr == null) {
            return null;
        }
        if (i >= this.bHr.size()) {
            i2 -= (i - this.bHr.size()) - 1;
            i = this.bHr.size() - 1;
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
                    JSONObject json = this.bHr.get(i5).toJson();
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

    public void ib(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> ic(String str) {
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
                    this.bHr.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void e(Boolean bool) {
        if (this.bHo != null) {
            this.bHo.cancel();
        }
        this.bHo = new c(this, getOffset());
        this.bHo.setPriority(3);
        this.bHo.execute(bool);
    }

    public void startSync() {
        if (this.bHp != null) {
            this.bHp.cancel();
        }
        this.bHp = new d(this, null);
        this.bHp.setPriority(2);
        this.bHp.execute(new a[0]);
    }

    public boolean hr(int i) {
        if (this.bHq != null) {
            this.bHq.cancel();
        }
        if (i >= this.bHr.size() || this.bHr.get(i) == null || this.bHr.get(i).getId() == null) {
            return false;
        }
        this.bHq = new b(this, this.bHr.get(i).getId(), i);
        this.bHq.setPriority(2);
        this.bHq.execute(new Boolean[0]);
        return true;
    }

    public int ZM() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getInt("uploac_mark_offset", 399);
    }

    public void hs(int i) {
        com.baidu.tbadk.core.sharedPref.b.sl().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.bHo != null) {
            this.bHo.cancel();
        }
        if (this.bHp != null) {
            this.bHp.cancel();
        }
        if (this.bHq != null) {
            this.bHq.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.bHv = loadDataCallBack;
    }

    private void removalDuplicate() {
        if (this.bHr != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.bHr.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
