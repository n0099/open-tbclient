package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.myCollection.l;
import com.baidu.tieba.tbadkCore.util.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean mIsFirst;
    private b ccy = null;
    private c ccz = null;
    private C0068a ccA = null;
    private int ccC = 0;
    private int ccD = 0;
    protected l ccE = null;
    private ArrayList<MarkData> ccB = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.ccB == null) {
            return 0;
        }
        return this.ccB.size();
    }

    public int adS() {
        return this.ccD;
    }

    public void iM(int i) {
        this.ccD = i;
    }

    public boolean hasMore() {
        return this.ccC >= 20;
    }

    public void reset() {
        this.ccD = 0;
        this.ccC = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> adT() {
        return this.ccB;
    }

    public void N(ArrayList<MarkData> arrayList) {
        this.ccB = arrayList;
    }

    public void O(ArrayList<MarkData> arrayList) {
        if (this.ccB != null && arrayList != null) {
            this.ccB.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.ccB.add(markData);
    }

    public int getCount() {
        if (this.ccB == null) {
            return 0;
        }
        return this.ccB.size();
    }

    public int adU() {
        return this.ccC;
    }

    public void adV() {
        ArrayList<MarkData> ayL = m.ayL();
        if (ayL != null) {
            N(ayL);
        }
    }

    public String aw(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.ccB == null) {
            return null;
        }
        if (i >= this.ccB.size()) {
            i2 -= (i - this.ccB.size()) - 1;
            i = this.ccB.size() - 1;
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
                    JSONObject json = this.ccB.get(i5).toJson();
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

    public void ju(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> jv(String str) {
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
                if (!markData.isPhotoLiveThread()) {
                    arrayList.add(markData);
                } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    arrayList.add(markData);
                }
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
                    if (!markData.isPhotoLiveThread()) {
                        this.ccB.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.ccB.add(markData);
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void f(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.ccy != null) {
            this.ccy.cancel();
        }
        this.ccy = new b(getOffset());
        this.ccy.setPriority(3);
        this.ccy.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e ccF;
        private int offset;
        private w Tj = null;
        private String data = null;
        Boolean ccH = false;

        public b(int i) {
            this.offset = 0;
            this.ccF = null;
            this.offset = i;
            this.ccF = new e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.ccH = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.ccH.booleanValue() && booleanValue) {
                o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.my_bookmarks");
                if (cr != null) {
                    publishProgress(cr.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.ccB == null) {
                    a.this.ccB = new ArrayList();
                } else {
                    a.this.ccB.clear();
                }
                a.this.ccC = 0;
            }
            this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Tj.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Tj.o("offset", String.valueOf(0));
            } else {
                this.Tj.o("offset", String.valueOf(this.offset));
            }
            this.Tj.o("rn", String.valueOf(20));
            this.data = this.Tj.tG();
            this.ccF.parserJson(this.data);
            if (this.Tj.uh().va().qT()) {
                aVar.ju(this.data);
                if (this.offset == 0) {
                    if (a.this.ccB == null) {
                        a.this.ccB = new ArrayList();
                    } else {
                        a.this.ccB.clear();
                    }
                    a.this.ccC = 0;
                    if (this.ccH.booleanValue()) {
                        gH(this.data);
                    }
                }
            }
            return aVar;
        }

        private void gH(String str) {
            o<String> cr;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cr = com.baidu.tbadk.core.b.a.sO().cr("tb.my_bookmarks")) != null) {
                cr.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                ArrayList<MarkData> jv = a.this.jv(str);
                if (this.ccH.booleanValue()) {
                    a.this.N(jv);
                } else {
                    a.this.O(jv);
                }
            } else {
                a.this.N(arrayList);
            }
            a.this.ccE.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            a.this.ccy = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.ccy = null;
            a.this.ccC = aVar.getCount();
            ArrayList<MarkData> adT = aVar.adT();
            if (this.ccH.booleanValue()) {
                if (adT != null && adT.size() != 0) {
                    a.this.N(adT);
                }
            } else {
                a.this.O(adT);
            }
            Iterator<MarkData> it = adT.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    int i2 = i + 1;
                    a.this.iM(i2);
                    i = i2;
                }
            }
            if (a.this.ccE != null) {
                if (this.Tj.uh().va().qT()) {
                    a.this.ccE.callback(0, this.ccF.getErrorCode() != 0 ? this.ccF.getErrorString() : null, false);
                } else {
                    a.this.ccE.callback(3, this.Tj.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.ccz != null) {
            this.ccz.cancel();
        }
        this.ccz = new c(this, null);
        this.ccz.setPriority(2);
        this.ccz.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private w Tj;
        private e ccF;

        private c() {
            this.Tj = null;
            this.ccF = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ccF = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.adV();
                this.Tj = new w();
                this.Tj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int adW = a.this.adW();
                if (aVar.getCount() - 1 <= adW) {
                    adW = aVar.getCount() - 1;
                }
                while (adW >= 0) {
                    String aw = aVar.aw(adW, 20);
                    this.Tj.l(new ArrayList<>());
                    this.Tj.o("data", aw);
                    this.ccF.parserJson(this.Tj.tG());
                    if (!this.Tj.uh().va().qT() || this.ccF.getErrorCode() != 0) {
                        break;
                    }
                    adW -= 20;
                }
                a.this.iO(adW);
                if (adW >= 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            a.this.ccz = null;
            if (a.this.ccE != null) {
                a.this.ccE.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.ccz = null;
            if (bool.booleanValue()) {
                a.this.ccB.clear();
                str = null;
                z = false;
            } else if (this.Tj.uh().va().qT()) {
                str = this.ccF.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.ccE != null) {
                a.this.ccE.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean iN(int i) {
        if (this.ccA != null) {
            this.ccA.cancel();
        }
        if (i >= this.ccB.size() || this.ccB.get(i) == null || this.ccB.get(i).getId() == null) {
            return false;
        }
        this.ccA = new C0068a(this.ccB.get(i).getId(), i);
        this.ccA.setPriority(2);
        this.ccA.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private w Tj = null;
        private e ccF;
        private int pos;
        private String tid;

        public C0068a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.ccF = null;
            this.tid = str;
            this.pos = i;
            this.ccF = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Tj.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Tj.o("tid", this.tid);
            this.ccF.parserJson(this.Tj.tG());
            return this.Tj.uh().va().qT() && this.ccF.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            a.this.ccA = null;
            if (a.this.ccE != null) {
                a.this.ccE.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.ccA = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.ccB.size()) {
                    a.this.ccB.remove(this.pos);
                    a aVar = a.this;
                    aVar.ccD--;
                }
            } else if (this.Tj.uh().va().qT()) {
                str = this.ccF.getErrorString();
            } else {
                str = this.Tj.getErrorString();
            }
            if (a.this.ccE != null) {
                a.this.ccE.callback(2, bool, str);
            }
        }
    }

    public int adW() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getInt("uploac_mark_offset", 399);
    }

    public void iO(int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.ccy != null) {
            this.ccy.cancel();
        }
        if (this.ccz != null) {
            this.ccz.cancel();
        }
        if (this.ccA != null) {
            this.ccA.cancel();
        }
    }

    public void a(l lVar) {
        this.ccE = lVar;
    }

    private void removalDuplicate() {
        if (this.ccB != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.ccB.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
