package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.myCollection.o;
import com.baidu.tieba.tbadkCore.util.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean mIsFirst;
    private b cyz = null;
    private c cyA = null;
    private C0070a cyB = null;
    private int cyD = 0;
    private int cyE = 0;
    protected o cyF = null;
    private ArrayList<MarkData> cyC = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.cyC == null) {
            return 0;
        }
        return this.cyC.size();
    }

    public int ajs() {
        return this.cyE;
    }

    public void kb(int i) {
        this.cyE = i;
    }

    public boolean hasMore() {
        return this.cyD >= 20;
    }

    public void reset() {
        this.cyE = 0;
        this.cyD = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> ajt() {
        return this.cyC;
    }

    public void S(ArrayList<MarkData> arrayList) {
        this.cyC = arrayList;
    }

    public void T(ArrayList<MarkData> arrayList) {
        if (this.cyC != null && arrayList != null) {
            this.cyC.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.cyC.add(markData);
    }

    public int getCount() {
        if (this.cyC == null) {
            return 0;
        }
        return this.cyC.size();
    }

    public int aju() {
        return this.cyD;
    }

    public void ajv() {
        ArrayList<MarkData> aGo = m.aGo();
        if (aGo != null) {
            S(aGo);
        }
    }

    public String aK(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.cyC == null) {
            return null;
        }
        if (i >= this.cyC.size()) {
            i2 -= (i - this.cyC.size()) - 1;
            i = this.cyC.size() - 1;
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
                    JSONObject json = this.cyC.get(i5).toJson();
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

    public void kg(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> kh(String str) {
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
                        this.cyC.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cyC.add(markData);
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
        if (this.cyz != null) {
            this.cyz.cancel();
        }
        this.cyz = new b(getOffset());
        this.cyz.setPriority(3);
        this.cyz.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e cyG;
        private int offset;
        private ab Ua = null;
        private String data = null;
        Boolean cyI = false;

        public b(int i) {
            this.offset = 0;
            this.cyG = null;
            this.offset = i;
            this.cyG = new e();
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
            this.cyI = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.cyI.booleanValue() && booleanValue) {
                com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tc().cC("tb.my_bookmarks");
                if (cC != null) {
                    publishProgress(cC.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.cyC == null) {
                    a.this.cyC = new ArrayList();
                } else {
                    a.this.cyC.clear();
                }
                a.this.cyD = 0;
            }
            this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Ua.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Ua.o("offset", String.valueOf(0));
            } else {
                this.Ua.o("offset", String.valueOf(this.offset));
            }
            this.Ua.o("rn", String.valueOf(20));
            this.data = this.Ua.tV();
            this.cyG.parserJson(this.data);
            if (this.Ua.uw().vq().qO()) {
                aVar.kg(this.data);
                if (this.offset == 0) {
                    if (a.this.cyC == null) {
                        a.this.cyC = new ArrayList();
                    } else {
                        a.this.cyC.clear();
                    }
                    a.this.cyD = 0;
                    if (this.cyI.booleanValue()) {
                        hi(this.data);
                    }
                }
            }
            return aVar;
        }

        private void hi(String str) {
            com.baidu.adp.lib.cache.o<String> cC;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cC = com.baidu.tbadk.core.b.a.tc().cC("tb.my_bookmarks")) != null) {
                cC.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
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
                ArrayList<MarkData> kh = a.this.kh(str);
                if (this.cyI.booleanValue()) {
                    a.this.S(kh);
                } else {
                    a.this.T(kh);
                }
            } else {
                a.this.S(arrayList);
            }
            a.this.cyF.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ua != null) {
                this.Ua.gL();
            }
            a.this.cyz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.cyz = null;
            a.this.cyD = aVar.getCount();
            ArrayList<MarkData> ajt = aVar.ajt();
            if (this.cyI.booleanValue()) {
                if (ajt != null && ajt.size() != 0) {
                    a.this.S(ajt);
                }
            } else {
                a.this.T(ajt);
            }
            Iterator<MarkData> it = ajt.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    int i2 = i + 1;
                    a.this.kb(i2);
                    i = i2;
                }
            }
            if (a.this.cyF != null) {
                if (this.Ua.uw().vq().qO()) {
                    a.this.cyF.callback(0, this.cyG.getErrorCode() != 0 ? this.cyG.getErrorString() : null, false);
                } else {
                    a.this.cyF.callback(3, this.Ua.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.cyA != null) {
            this.cyA.cancel();
        }
        this.cyA = new c(this, null);
        this.cyA.setPriority(2);
        this.cyA.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private ab Ua;
        private e cyG;

        private c() {
            this.Ua = null;
            this.cyG = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cyG = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.ajv();
                this.Ua = new ab();
                this.Ua.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int ajw = a.this.ajw();
                if (aVar.getCount() - 1 <= ajw) {
                    ajw = aVar.getCount() - 1;
                }
                while (ajw >= 0) {
                    String aK = aVar.aK(ajw, 20);
                    this.Ua.m(new ArrayList<>());
                    this.Ua.o("data", aK);
                    this.cyG.parserJson(this.Ua.tV());
                    if (!this.Ua.uw().vq().qO() || this.cyG.getErrorCode() != 0) {
                        break;
                    }
                    ajw -= 20;
                }
                a.this.kd(ajw);
                if (ajw >= 0) {
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
            if (this.Ua != null) {
                this.Ua.gL();
            }
            a.this.cyA = null;
            if (a.this.cyF != null) {
                a.this.cyF.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.cyA = null;
            if (bool.booleanValue()) {
                a.this.cyC.clear();
                str = null;
                z = false;
            } else if (this.Ua.uw().vq().qO()) {
                str = this.cyG.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.cyF != null) {
                a.this.cyF.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean kc(int i) {
        if (this.cyB != null) {
            this.cyB.cancel();
        }
        if (i >= this.cyC.size() || this.cyC.get(i) == null || this.cyC.get(i).getId() == null) {
            return false;
        }
        this.cyB = new C0070a(this.cyC.get(i).getId(), i);
        this.cyB.setPriority(2);
        this.cyB.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0070a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private ab Ua = null;
        private e cyG;
        private int pos;
        private String tid;

        public C0070a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.cyG = null;
            this.tid = str;
            this.pos = i;
            this.cyG = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Ua.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Ua.o("tid", this.tid);
            this.cyG.parserJson(this.Ua.tV());
            return this.Ua.uw().vq().qO() && this.cyG.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ua != null) {
                this.Ua.gL();
            }
            a.this.cyB = null;
            if (a.this.cyF != null) {
                a.this.cyF.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.cyB = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.cyC.size()) {
                    a.this.cyC.remove(this.pos);
                    a aVar = a.this;
                    aVar.cyE--;
                }
            } else if (this.Ua.uw().vq().qO()) {
                str = this.cyG.getErrorString();
            } else {
                str = this.Ua.getErrorString();
            }
            if (a.this.cyF != null) {
                a.this.cyF.callback(2, bool, str);
            }
        }
    }

    public int ajw() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getInt("uploac_mark_offset", 399);
    }

    public void kd(int i) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.cyz != null) {
            this.cyz.cancel();
        }
        if (this.cyA != null) {
            this.cyA.cancel();
        }
        if (this.cyB != null) {
            this.cyB.cancel();
        }
    }

    public void a(o oVar) {
        this.cyF = oVar;
    }

    private void removalDuplicate() {
        if (this.cyC != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.cyC.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
