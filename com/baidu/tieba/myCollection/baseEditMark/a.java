package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.x;
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
    private b cFg = null;
    private c cFh = null;
    private C0072a cFi = null;
    private int cFk = 0;
    private int cFl = 0;
    protected o cFm = null;
    private ArrayList<MarkData> cFj = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.cFj == null) {
            return 0;
        }
        return this.cFj.size();
    }

    public int anq() {
        return this.cFl;
    }

    public void kB(int i) {
        this.cFl = i;
    }

    public boolean hasMore() {
        return this.cFk >= 20;
    }

    public void reset() {
        this.cFl = 0;
        this.cFk = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> anr() {
        return this.cFj;
    }

    public void T(ArrayList<MarkData> arrayList) {
        this.cFj = arrayList;
    }

    public void U(ArrayList<MarkData> arrayList) {
        if (this.cFj != null && arrayList != null) {
            this.cFj.addAll(arrayList);
            SR();
        }
    }

    public void b(MarkData markData) {
        this.cFj.add(markData);
    }

    public int getCount() {
        if (this.cFj == null) {
            return 0;
        }
        return this.cFj.size();
    }

    public int ans() {
        return this.cFk;
    }

    public void ant() {
        ArrayList<MarkData> aNt = m.aNt();
        if (aNt != null) {
            T(aNt);
        }
    }

    public String aL(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.cFj == null) {
            return null;
        }
        if (i >= this.cFj.size()) {
            i2 -= (i - this.cFj.size()) - 1;
            i = this.cFj.size() - 1;
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
                    JSONObject json = this.cFj.get(i5).toJson();
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

    public void kk(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> kl(String str) {
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
                        this.cFj.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cFj.add(markData);
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
        if (this.cFg != null) {
            this.cFg.cancel();
        }
        this.cFg = new b(getOffset());
        this.cFg.setPriority(3);
        this.cFg.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e cFn;
        private int offset;
        private aa Ty = null;
        private String data = null;
        Boolean cFp = false;

        public b(int i) {
            this.offset = 0;
            this.cFn = null;
            this.offset = i;
            this.cFn = new e();
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
            this.cFp = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.cFp.booleanValue() && booleanValue) {
                com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.b.a.ug().cB("tb.my_bookmarks");
                if (cB != null) {
                    publishProgress(cB.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.cFj == null) {
                    a.this.cFj = new ArrayList();
                } else {
                    a.this.cFj.clear();
                }
                a.this.cFk = 0;
            }
            this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Ty.p("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Ty.p("offset", String.valueOf(0));
            } else {
                this.Ty.p("offset", String.valueOf(this.offset));
            }
            this.Ty.p("rn", String.valueOf(20));
            this.data = this.Ty.uZ();
            this.cFn.parserJson(this.data);
            if (this.Ty.vB().ww().rl()) {
                aVar.kk(this.data);
                if (this.offset == 0) {
                    if (a.this.cFj == null) {
                        a.this.cFj = new ArrayList();
                    } else {
                        a.this.cFj.clear();
                    }
                    a.this.cFk = 0;
                    if (this.cFp.booleanValue()) {
                        hi(this.data);
                    }
                }
            }
            return aVar;
        }

        private void hi(String str) {
            com.baidu.adp.lib.cache.o<String> cB;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cB = com.baidu.tbadk.core.b.a.ug().cB("tb.my_bookmarks")) != null) {
                cB.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                ArrayList<MarkData> kl = a.this.kl(str);
                if (this.cFp.booleanValue()) {
                    a.this.T(kl);
                } else {
                    a.this.U(kl);
                }
            } else {
                a.this.T(arrayList);
            }
            a.this.cFm.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ty != null) {
                this.Ty.gT();
            }
            a.this.cFg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.cFg = null;
            a.this.cFk = aVar.getCount();
            ArrayList<MarkData> anr = aVar.anr();
            if (this.cFp.booleanValue()) {
                if (anr != null && anr.size() != 0) {
                    a.this.T(anr);
                }
            } else {
                a.this.U(anr);
            }
            Iterator<MarkData> it = anr.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    int i2 = i + 1;
                    a.this.kB(i2);
                    i = i2;
                }
            }
            if (a.this.cFm != null) {
                if (this.Ty.vB().ww().rl()) {
                    a.this.cFm.callback(0, this.cFn.getErrorCode() != 0 ? this.cFn.getErrorString() : null, false);
                } else {
                    a.this.cFm.callback(3, this.Ty.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.cFh != null) {
            this.cFh.cancel();
        }
        this.cFh = new c(this, null);
        this.cFh.setPriority(2);
        this.cFh.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa Ty;
        private e cFn;

        private c() {
            this.Ty = null;
            this.cFn = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cFn = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.ant();
                this.Ty = new aa();
                this.Ty.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int anu = a.this.anu();
                if (aVar.getCount() - 1 <= anu) {
                    anu = aVar.getCount() - 1;
                }
                while (anu >= 0) {
                    String aL = aVar.aL(anu, 20);
                    this.Ty.n(new ArrayList<>());
                    this.Ty.p("data", aL);
                    this.cFn.parserJson(this.Ty.uZ());
                    if (!this.Ty.vB().ww().rl() || this.cFn.getErrorCode() != 0) {
                        break;
                    }
                    anu -= 20;
                }
                a.this.kD(anu);
                if (anu >= 0) {
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
                this.Ty.gT();
            }
            a.this.cFh = null;
            if (a.this.cFm != null) {
                a.this.cFm.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.cFh = null;
            if (bool.booleanValue()) {
                a.this.cFj.clear();
                str = null;
                z = false;
            } else if (this.Ty.vB().ww().rl()) {
                str = this.cFn.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.cFm != null) {
                a.this.cFm.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean kC(int i) {
        if (this.cFi != null) {
            this.cFi.cancel();
        }
        if (i >= this.cFj.size() || this.cFj.get(i) == null || this.cFj.get(i).getId() == null) {
            return false;
        }
        this.cFi = new C0072a(this.cFj.get(i).getId(), i);
        this.cFi.setPriority(2);
        this.cFi.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0072a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa Ty = null;
        private e cFn;
        private int pos;
        private String tid;

        public C0072a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.cFn = null;
            this.tid = str;
            this.pos = i;
            this.cFn = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Ty.p("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Ty.p("tid", this.tid);
            this.cFn.parserJson(this.Ty.uZ());
            return this.Ty.vB().ww().rl() && this.cFn.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Ty != null) {
                this.Ty.gT();
            }
            a.this.cFi = null;
            if (a.this.cFm != null) {
                a.this.cFm.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.cFi = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.cFj.size()) {
                    a.this.cFj.remove(this.pos);
                    a aVar = a.this;
                    aVar.cFl--;
                }
            } else if (this.Ty.vB().ww().rl()) {
                str = this.cFn.getErrorString();
            } else {
                str = this.Ty.getErrorString();
            }
            if (a.this.cFm != null) {
                a.this.cFm.callback(2, bool, str);
            }
        }
    }

    public int anu() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getInt("uploac_mark_offset", 399);
    }

    public void kD(int i) {
        com.baidu.tbadk.core.sharedPref.b.uO().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.cFg != null) {
            this.cFg.cancel();
        }
        if (this.cFh != null) {
            this.cFh.cancel();
        }
        if (this.cFi != null) {
            this.cFi.cancel();
        }
    }

    public void a(o oVar) {
        this.cFm = oVar;
    }

    private void SR() {
        if (this.cFj != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.cFj.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    ad(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void ad(String str, int i) {
        if (this.cFj != null && x.o(this.cFj) > 0) {
            Iterator<MarkData> it = this.cFj.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
