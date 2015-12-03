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
    private b cuz = null;
    private c cuA = null;
    private C0076a cuB = null;
    private int cuD = 0;
    private int cuE = 0;
    protected o cuF = null;
    private ArrayList<MarkData> cuC = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.cuC == null) {
            return 0;
        }
        return this.cuC.size();
    }

    public int aif() {
        return this.cuE;
    }

    public void jD(int i) {
        this.cuE = i;
    }

    public boolean hasMore() {
        return this.cuD >= 20;
    }

    public void reset() {
        this.cuE = 0;
        this.cuD = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> aig() {
        return this.cuC;
    }

    public void T(ArrayList<MarkData> arrayList) {
        this.cuC = arrayList;
    }

    public void U(ArrayList<MarkData> arrayList) {
        if (this.cuC != null && arrayList != null) {
            this.cuC.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.cuC.add(markData);
    }

    public int getCount() {
        if (this.cuC == null) {
            return 0;
        }
        return this.cuC.size();
    }

    public int aih() {
        return this.cuD;
    }

    public void aii() {
        ArrayList<MarkData> aEb = m.aEb();
        if (aEb != null) {
            T(aEb);
        }
    }

    public String ay(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.cuC == null) {
            return null;
        }
        if (i >= this.cuC.size()) {
            i2 -= (i - this.cuC.size()) - 1;
            i = this.cuC.size() - 1;
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
                    JSONObject json = this.cuC.get(i5).toJson();
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

    public void jR(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> jS(String str) {
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
                        this.cuC.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cuC.add(markData);
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
        if (this.cuz != null) {
            this.cuz.cancel();
        }
        this.cuz = new b(getOffset());
        this.cuz.setPriority(3);
        this.cuz.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e cuG;
        private int offset;
        private ab Ty = null;
        private String data = null;
        Boolean cuI = false;

        public b(int i) {
            this.offset = 0;
            this.cuG = null;
            this.offset = i;
            this.cuG = new e();
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
            this.cuI = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.cuI.booleanValue() && booleanValue) {
                com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.b.a.ts().cz("tb.my_bookmarks");
                if (cz != null) {
                    publishProgress(cz.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.cuC == null) {
                    a.this.cuC = new ArrayList();
                } else {
                    a.this.cuC.clear();
                }
                a.this.cuD = 0;
            }
            this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Ty.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Ty.o("offset", String.valueOf(0));
            } else {
                this.Ty.o("offset", String.valueOf(this.offset));
            }
            this.Ty.o("rn", String.valueOf(20));
            this.data = this.Ty.ul();
            this.cuG.parserJson(this.data);
            if (this.Ty.uM().vG().rf()) {
                aVar.jR(this.data);
                if (this.offset == 0) {
                    if (a.this.cuC == null) {
                        a.this.cuC = new ArrayList();
                    } else {
                        a.this.cuC.clear();
                    }
                    a.this.cuD = 0;
                    if (this.cuI.booleanValue()) {
                        gX(this.data);
                    }
                }
            }
            return aVar;
        }

        private void gX(String str) {
            com.baidu.adp.lib.cache.o<String> cz;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cz = com.baidu.tbadk.core.b.a.ts().cz("tb.my_bookmarks")) != null) {
                cz.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
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
                ArrayList<MarkData> jS = a.this.jS(str);
                if (this.cuI.booleanValue()) {
                    a.this.T(jS);
                } else {
                    a.this.U(jS);
                }
            } else {
                a.this.T(arrayList);
            }
            a.this.cuF.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ty != null) {
                this.Ty.gL();
            }
            a.this.cuz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.cuz = null;
            a.this.cuD = aVar.getCount();
            ArrayList<MarkData> aig = aVar.aig();
            if (this.cuI.booleanValue()) {
                if (aig != null && aig.size() != 0) {
                    a.this.T(aig);
                }
            } else {
                a.this.U(aig);
            }
            Iterator<MarkData> it = aig.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    int i2 = i + 1;
                    a.this.jD(i2);
                    i = i2;
                }
            }
            if (a.this.cuF != null) {
                if (this.Ty.uM().vG().rf()) {
                    a.this.cuF.callback(0, this.cuG.getErrorCode() != 0 ? this.cuG.getErrorString() : null, false);
                } else {
                    a.this.cuF.callback(3, this.Ty.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.cuA != null) {
            this.cuA.cancel();
        }
        this.cuA = new c(this, null);
        this.cuA.setPriority(2);
        this.cuA.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private ab Ty;
        private e cuG;

        private c() {
            this.Ty = null;
            this.cuG = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cuG = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aii();
                this.Ty = new ab();
                this.Ty.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int aij = a.this.aij();
                if (aVar.getCount() - 1 <= aij) {
                    aij = aVar.getCount() - 1;
                }
                while (aij >= 0) {
                    String ay = aVar.ay(aij, 20);
                    this.Ty.m(new ArrayList<>());
                    this.Ty.o("data", ay);
                    this.cuG.parserJson(this.Ty.ul());
                    if (!this.Ty.uM().vG().rf() || this.cuG.getErrorCode() != 0) {
                        break;
                    }
                    aij -= 20;
                }
                a.this.jF(aij);
                if (aij >= 0) {
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
            if (this.Ty != null) {
                this.Ty.gL();
            }
            a.this.cuA = null;
            if (a.this.cuF != null) {
                a.this.cuF.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.cuA = null;
            if (bool.booleanValue()) {
                a.this.cuC.clear();
                str = null;
                z = false;
            } else if (this.Ty.uM().vG().rf()) {
                str = this.cuG.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.cuF != null) {
                a.this.cuF.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean jE(int i) {
        if (this.cuB != null) {
            this.cuB.cancel();
        }
        if (i >= this.cuC.size() || this.cuC.get(i) == null || this.cuC.get(i).getId() == null) {
            return false;
        }
        this.cuB = new C0076a(this.cuC.get(i).getId(), i);
        this.cuB.setPriority(2);
        this.cuB.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0076a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private ab Ty = null;
        private e cuG;
        private int pos;
        private String tid;

        public C0076a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.cuG = null;
            this.tid = str;
            this.pos = i;
            this.cuG = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Ty.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Ty.o("tid", this.tid);
            this.cuG.parserJson(this.Ty.ul());
            return this.Ty.uM().vG().rf() && this.cuG.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ty != null) {
                this.Ty.gL();
            }
            a.this.cuB = null;
            if (a.this.cuF != null) {
                a.this.cuF.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.cuB = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.cuC.size()) {
                    a.this.cuC.remove(this.pos);
                    a aVar = a.this;
                    aVar.cuE--;
                }
            } else if (this.Ty.uM().vG().rf()) {
                str = this.cuG.getErrorString();
            } else {
                str = this.Ty.getErrorString();
            }
            if (a.this.cuF != null) {
                a.this.cuF.callback(2, bool, str);
            }
        }
    }

    public int aij() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getInt("uploac_mark_offset", 399);
    }

    public void jF(int i) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.cuz != null) {
            this.cuz.cancel();
        }
        if (this.cuA != null) {
            this.cuA.cancel();
        }
        if (this.cuB != null) {
            this.cuB.cancel();
        }
    }

    public void a(o oVar) {
        this.cuF = oVar;
    }

    private void removalDuplicate() {
        if (this.cuC != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.cuC.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
