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
    private boolean bHv;
    private c bHp = null;
    private d bHq = null;
    private b bHr = null;
    private int bHt = 0;
    private int bHu = 0;
    protected BaseActivity.LoadDataCallBack bHw = null;
    private ArrayList<MarkData> bHs = new ArrayList<>();

    public a() {
        this.bHv = false;
        this.bHv = true;
    }

    public int getOffset() {
        if (this.bHs == null) {
            return 0;
        }
        return this.bHs.size();
    }

    public int ZJ() {
        return this.bHu;
    }

    public void hq(int i) {
        this.bHu = i;
    }

    public boolean hasMore() {
        return this.bHt >= 20;
    }

    public void reset() {
        this.bHu = 0;
        this.bHt = 0;
        this.bHv = true;
    }

    public boolean isFirst() {
        return this.bHv;
    }

    public ArrayList<MarkData> ZK() {
        return this.bHs;
    }

    public void H(ArrayList<MarkData> arrayList) {
        this.bHs = arrayList;
    }

    public void I(ArrayList<MarkData> arrayList) {
        if (this.bHs != null && arrayList != null) {
            this.bHs.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.bHs.add(markData);
    }

    public int getCount() {
        if (this.bHs == null) {
            return 0;
        }
        return this.bHs.size();
    }

    public int ZL() {
        return this.bHt;
    }

    public void ZM() {
        ArrayList<MarkData> apB = j.apB();
        if (apB != null) {
            H(apB);
        }
    }

    public String af(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.bHs == null) {
            return null;
        }
        if (i >= this.bHs.size()) {
            i2 -= (i - this.bHs.size()) - 1;
            i = this.bHs.size() - 1;
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
                    JSONObject json = this.bHs.get(i5).toJson();
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
                    this.bHs.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void e(Boolean bool) {
        if (this.bHp != null) {
            this.bHp.cancel();
        }
        this.bHp = new c(this, getOffset());
        this.bHp.setPriority(3);
        this.bHp.execute(bool);
    }

    public void startSync() {
        if (this.bHq != null) {
            this.bHq.cancel();
        }
        this.bHq = new d(this, null);
        this.bHq.setPriority(2);
        this.bHq.execute(new a[0]);
    }

    public boolean hr(int i) {
        if (this.bHr != null) {
            this.bHr.cancel();
        }
        if (i >= this.bHs.size() || this.bHs.get(i) == null || this.bHs.get(i).getId() == null) {
            return false;
        }
        this.bHr = new b(this, this.bHs.get(i).getId(), i);
        this.bHr.setPriority(2);
        this.bHr.execute(new Boolean[0]);
        return true;
    }

    public int ZN() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getInt("uploac_mark_offset", 399);
    }

    public void hs(int i) {
        com.baidu.tbadk.core.sharedPref.b.sl().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.bHp != null) {
            this.bHp.cancel();
        }
        if (this.bHq != null) {
            this.bHq.cancel();
        }
        if (this.bHr != null) {
            this.bHr.cancel();
        }
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.bHw = loadDataCallBack;
    }

    private void removalDuplicate() {
        if (this.bHs != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.bHs.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
