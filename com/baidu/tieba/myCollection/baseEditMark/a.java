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
    private b cbX = null;
    private c cbY = null;
    private C0068a cbZ = null;
    private int ccb = 0;
    private int ccc = 0;
    protected l ccd = null;
    private ArrayList<MarkData> cca = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.cca == null) {
            return 0;
        }
        return this.cca.size();
    }

    public int adB() {
        return this.ccc;
    }

    public void iz(int i) {
        this.ccc = i;
    }

    public boolean hasMore() {
        return this.ccb >= 20;
    }

    public void reset() {
        this.ccc = 0;
        this.ccb = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> adC() {
        return this.cca;
    }

    public void N(ArrayList<MarkData> arrayList) {
        this.cca = arrayList;
    }

    public void O(ArrayList<MarkData> arrayList) {
        if (this.cca != null && arrayList != null) {
            this.cca.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.cca.add(markData);
    }

    public int getCount() {
        if (this.cca == null) {
            return 0;
        }
        return this.cca.size();
    }

    public int adD() {
        return this.ccb;
    }

    public void adE() {
        ArrayList<MarkData> axG = m.axG();
        if (axG != null) {
            N(axG);
        }
    }

    public String au(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.cca == null) {
            return null;
        }
        if (i >= this.cca.size()) {
            i2 -= (i - this.cca.size()) - 1;
            i = this.cca.size() - 1;
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
                    JSONObject json = this.cca.get(i5).toJson();
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
                        this.cca.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cca.add(markData);
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
        if (this.cbX != null) {
            this.cbX.cancel();
        }
        this.cbX = new b(getOffset());
        this.cbX.setPriority(3);
        this.cbX.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e cce;
        private int offset;
        private w Ti = null;
        private String data = null;
        Boolean ccg = false;

        public b(int i) {
            this.offset = 0;
            this.cce = null;
            this.offset = i;
            this.cce = new e();
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
            this.ccg = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.ccg.booleanValue() && booleanValue) {
                o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.my_bookmarks");
                if (cr != null) {
                    publishProgress(cr.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.cca == null) {
                    a.this.cca = new ArrayList();
                } else {
                    a.this.cca.clear();
                }
                a.this.ccb = 0;
            }
            this.Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Ti.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Ti.o("offset", String.valueOf(0));
            } else {
                this.Ti.o("offset", String.valueOf(this.offset));
            }
            this.Ti.o("rn", String.valueOf(20));
            this.data = this.Ti.tG();
            this.cce.parserJson(this.data);
            if (this.Ti.uh().uZ().qV()) {
                aVar.js(this.data);
                if (this.offset == 0) {
                    if (a.this.cca == null) {
                        a.this.cca = new ArrayList();
                    } else {
                        a.this.cca.clear();
                    }
                    a.this.ccb = 0;
                    if (this.ccg.booleanValue()) {
                        gF(this.data);
                    }
                }
            }
            return aVar;
        }

        private void gF(String str) {
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
                ArrayList<MarkData> jt = a.this.jt(str);
                if (this.ccg.booleanValue()) {
                    a.this.N(jt);
                } else {
                    a.this.O(jt);
                }
            } else {
                a.this.N(arrayList);
            }
            a.this.ccd.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            a.this.cbX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.cbX = null;
            a.this.ccb = aVar.getCount();
            ArrayList<MarkData> adC = aVar.adC();
            if (this.ccg.booleanValue()) {
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
            if (a.this.ccd != null) {
                if (this.Ti.uh().uZ().qV()) {
                    a.this.ccd.callback(0, this.cce.getErrorCode() != 0 ? this.cce.getErrorString() : null, false);
                } else {
                    a.this.ccd.callback(3, this.Ti.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.cbY != null) {
            this.cbY.cancel();
        }
        this.cbY = new c(this, null);
        this.cbY.setPriority(2);
        this.cbY.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private w Ti;
        private e cce;

        private c() {
            this.Ti = null;
            this.cce = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cce = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.adE();
                this.Ti = new w();
                this.Ti.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int adF = a.this.adF();
                if (aVar.getCount() - 1 <= adF) {
                    adF = aVar.getCount() - 1;
                }
                while (adF >= 0) {
                    String au = aVar.au(adF, 20);
                    this.Ti.l(new ArrayList<>());
                    this.Ti.o("data", au);
                    this.cce.parserJson(this.Ti.tG());
                    if (!this.Ti.uh().uZ().qV() || this.cce.getErrorCode() != 0) {
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
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            a.this.cbY = null;
            if (a.this.ccd != null) {
                a.this.ccd.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.cbY = null;
            if (bool.booleanValue()) {
                a.this.cca.clear();
                str = null;
                z = false;
            } else if (this.Ti.uh().uZ().qV()) {
                str = this.cce.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.ccd != null) {
                a.this.ccd.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean iA(int i) {
        if (this.cbZ != null) {
            this.cbZ.cancel();
        }
        if (i >= this.cca.size() || this.cca.get(i) == null || this.cca.get(i).getId() == null) {
            return false;
        }
        this.cbZ = new C0068a(this.cca.get(i).getId(), i);
        this.cbZ.setPriority(2);
        this.cbZ.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private w Ti = null;
        private e cce;
        private int pos;
        private String tid;

        public C0068a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.cce = null;
            this.tid = str;
            this.pos = i;
            this.cce = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Ti.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Ti.o("tid", this.tid);
            this.cce.parserJson(this.Ti.tG());
            return this.Ti.uh().uZ().qV() && this.cce.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            a.this.cbZ = null;
            if (a.this.ccd != null) {
                a.this.ccd.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.cbZ = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.cca.size()) {
                    a.this.cca.remove(this.pos);
                    a aVar = a.this;
                    aVar.ccc--;
                }
            } else if (this.Ti.uh().uZ().qV()) {
                str = this.cce.getErrorString();
            } else {
                str = this.Ti.getErrorString();
            }
            if (a.this.ccd != null) {
                a.this.ccd.callback(2, bool, str);
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
        if (this.cbX != null) {
            this.cbX.cancel();
        }
        if (this.cbY != null) {
            this.cbY.cancel();
        }
        if (this.cbZ != null) {
            this.cbZ.cancel();
        }
    }

    public void a(l lVar) {
        this.ccd = lVar;
    }

    private void removalDuplicate() {
        if (this.cca != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.cca.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
