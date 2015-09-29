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
    private b cbM = null;
    private c cbN = null;
    private C0068a cbO = null;
    private int cbQ = 0;
    private int cbR = 0;
    protected l cbS = null;
    private ArrayList<MarkData> cbP = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.cbP == null) {
            return 0;
        }
        return this.cbP.size();
    }

    public int adB() {
        return this.cbR;
    }

    public void iz(int i) {
        this.cbR = i;
    }

    public boolean hasMore() {
        return this.cbQ >= 20;
    }

    public void reset() {
        this.cbR = 0;
        this.cbQ = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> adC() {
        return this.cbP;
    }

    public void N(ArrayList<MarkData> arrayList) {
        this.cbP = arrayList;
    }

    public void O(ArrayList<MarkData> arrayList) {
        if (this.cbP != null && arrayList != null) {
            this.cbP.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.cbP.add(markData);
    }

    public int getCount() {
        if (this.cbP == null) {
            return 0;
        }
        return this.cbP.size();
    }

    public int adD() {
        return this.cbQ;
    }

    public void adE() {
        ArrayList<MarkData> axw = m.axw();
        if (axw != null) {
            N(axw);
        }
    }

    public String au(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.cbP == null) {
            return null;
        }
        if (i >= this.cbP.size()) {
            i2 -= (i - this.cbP.size()) - 1;
            i = this.cbP.size() - 1;
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
                    JSONObject json = this.cbP.get(i5).toJson();
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

    public void js(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> jt(String str) {
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
                        this.cbP.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cbP.add(markData);
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
        if (this.cbM != null) {
            this.cbM.cancel();
        }
        this.cbM = new b(getOffset());
        this.cbM.setPriority(3);
        this.cbM.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e cbT;
        private int offset;
        private w Th = null;
        private String data = null;
        Boolean cbV = false;

        public b(int i) {
            this.offset = 0;
            this.cbT = null;
            this.offset = i;
            this.cbT = new e();
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
            this.cbV = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.cbV.booleanValue() && booleanValue) {
                o<String> cq = com.baidu.tbadk.core.b.a.sO().cq("tb.my_bookmarks");
                if (cq != null) {
                    publishProgress(cq.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.cbP == null) {
                    a.this.cbP = new ArrayList();
                } else {
                    a.this.cbP.clear();
                }
                a.this.cbQ = 0;
            }
            this.Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Th.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Th.o("offset", String.valueOf(0));
            } else {
                this.Th.o("offset", String.valueOf(this.offset));
            }
            this.Th.o("rn", String.valueOf(20));
            this.data = this.Th.tG();
            this.cbT.parserJson(this.data);
            if (this.Th.uh().uY().qV()) {
                aVar.js(this.data);
                if (this.offset == 0) {
                    if (a.this.cbP == null) {
                        a.this.cbP = new ArrayList();
                    } else {
                        a.this.cbP.clear();
                    }
                    a.this.cbQ = 0;
                    if (this.cbV.booleanValue()) {
                        gF(this.data);
                    }
                }
            }
            return aVar;
        }

        private void gF(String str) {
            o<String> cq;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cq = com.baidu.tbadk.core.b.a.sO().cq("tb.my_bookmarks")) != null) {
                cq.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
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
                ArrayList<MarkData> jt = a.this.jt(str);
                if (this.cbV.booleanValue()) {
                    a.this.N(jt);
                } else {
                    a.this.O(jt);
                }
            } else {
                a.this.N(arrayList);
            }
            a.this.cbS.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Th != null) {
                this.Th.gJ();
            }
            a.this.cbM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.cbM = null;
            a.this.cbQ = aVar.getCount();
            ArrayList<MarkData> adC = aVar.adC();
            if (this.cbV.booleanValue()) {
                if (adC != null && adC.size() != 0) {
                    a.this.N(adC);
                }
            } else {
                a.this.O(adC);
            }
            Iterator<MarkData> it = adC.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    int i2 = i + 1;
                    a.this.iz(i2);
                    i = i2;
                }
            }
            if (a.this.cbS != null) {
                if (this.Th.uh().uY().qV()) {
                    a.this.cbS.callback(0, this.cbT.getErrorCode() != 0 ? this.cbT.getErrorString() : null, false);
                } else {
                    a.this.cbS.callback(3, this.Th.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.cbN != null) {
            this.cbN.cancel();
        }
        this.cbN = new c(this, null);
        this.cbN.setPriority(2);
        this.cbN.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private w Th;
        private e cbT;

        private c() {
            this.Th = null;
            this.cbT = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cbT = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.adE();
                this.Th = new w();
                this.Th.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int adF = a.this.adF();
                if (aVar.getCount() - 1 <= adF) {
                    adF = aVar.getCount() - 1;
                }
                while (adF >= 0) {
                    String au = aVar.au(adF, 20);
                    this.Th.l(new ArrayList<>());
                    this.Th.o("data", au);
                    this.cbT.parserJson(this.Th.tG());
                    if (!this.Th.uh().uY().qV() || this.cbT.getErrorCode() != 0) {
                        break;
                    }
                    adF -= 20;
                }
                a.this.iB(adF);
                if (adF >= 0) {
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
            if (this.Th != null) {
                this.Th.gJ();
            }
            a.this.cbN = null;
            if (a.this.cbS != null) {
                a.this.cbS.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.cbN = null;
            if (bool.booleanValue()) {
                a.this.cbP.clear();
                str = null;
                z = false;
            } else if (this.Th.uh().uY().qV()) {
                str = this.cbT.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.cbS != null) {
                a.this.cbS.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean iA(int i) {
        if (this.cbO != null) {
            this.cbO.cancel();
        }
        if (i >= this.cbP.size() || this.cbP.get(i) == null || this.cbP.get(i).getId() == null) {
            return false;
        }
        this.cbO = new C0068a(this.cbP.get(i).getId(), i);
        this.cbO.setPriority(2);
        this.cbO.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private w Th = null;
        private e cbT;
        private int pos;
        private String tid;

        public C0068a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.cbT = null;
            this.tid = str;
            this.pos = i;
            this.cbT = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Th.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Th.o("tid", this.tid);
            this.cbT.parserJson(this.Th.tG());
            return this.Th.uh().uY().qV() && this.cbT.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Th != null) {
                this.Th.gJ();
            }
            a.this.cbO = null;
            if (a.this.cbS != null) {
                a.this.cbS.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.cbO = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.cbP.size()) {
                    a.this.cbP.remove(this.pos);
                    a aVar = a.this;
                    aVar.cbR--;
                }
            } else if (this.Th.uh().uY().qV()) {
                str = this.cbT.getErrorString();
            } else {
                str = this.Th.getErrorString();
            }
            if (a.this.cbS != null) {
                a.this.cbS.callback(2, bool, str);
            }
        }
    }

    public int adF() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getInt("uploac_mark_offset", 399);
    }

    public void iB(int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.cbM != null) {
            this.cbM.cancel();
        }
        if (this.cbN != null) {
            this.cbN.cancel();
        }
        if (this.cbO != null) {
            this.cbO.cancel();
        }
    }

    public void a(l lVar) {
        this.cbS = lVar;
    }

    private void removalDuplicate() {
        if (this.cbP != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.cbP.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
