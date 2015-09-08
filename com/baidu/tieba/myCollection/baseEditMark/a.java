package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.myCollection.l;
import com.baidu.tieba.tbadkCore.util.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean mIsFirst;
    private b bYa = null;
    private c bYb = null;
    private C0066a bYc = null;
    private int bYe = 0;
    private int bYf = 0;
    protected l bYg = null;
    private ArrayList<MarkData> bYd = new ArrayList<>();

    public a() {
        this.mIsFirst = false;
        this.mIsFirst = true;
    }

    public int getOffset() {
        if (this.bYd == null) {
            return 0;
        }
        return this.bYd.size();
    }

    public int aci() {
        return this.bYf;
    }

    public void ir(int i) {
        this.bYf = i;
    }

    public boolean hasMore() {
        return this.bYe >= 20;
    }

    public void reset() {
        this.bYf = 0;
        this.bYe = 0;
        this.mIsFirst = true;
    }

    public boolean isFirst() {
        return this.mIsFirst;
    }

    public ArrayList<MarkData> acj() {
        return this.bYd;
    }

    public void N(ArrayList<MarkData> arrayList) {
        this.bYd = arrayList;
    }

    public void O(ArrayList<MarkData> arrayList) {
        if (this.bYd != null && arrayList != null) {
            this.bYd.addAll(arrayList);
            removalDuplicate();
        }
    }

    public void b(MarkData markData) {
        this.bYd.add(markData);
    }

    public int getCount() {
        if (this.bYd == null) {
            return 0;
        }
        return this.bYd.size();
    }

    public int ack() {
        return this.bYe;
    }

    public void acl() {
        ArrayList<MarkData> avj = k.avj();
        if (avj != null) {
            N(avj);
        }
    }

    public String at(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.bYd == null) {
            return null;
        }
        if (i >= this.bYd.size()) {
            i2 -= (i - this.bYd.size()) - 1;
            i = this.bYd.size() - 1;
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
                    JSONObject json = this.bYd.get(i5).toJson();
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

    public void jf(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> jg(String str) {
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
                        this.bYd.add(markData);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bYd.add(markData);
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
        if (this.bYa != null) {
            this.bYa.cancel();
        }
        this.bYa = new b(getOffset());
        this.bYa.setPriority(3);
        this.bYa.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private e bYh;
        private int offset;
        private v Tv = null;
        private String data = null;
        Boolean bYj = false;

        public b(int i) {
            this.offset = 0;
            this.bYh = null;
            this.offset = i;
            this.bYh = new e();
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
            this.bYj = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.bYj.booleanValue() && booleanValue) {
                o<String> cq = com.baidu.tbadk.core.b.a.sR().cq("tb.my_bookmarks");
                if (cq != null) {
                    publishProgress(cq.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.bYd == null) {
                    a.this.bYd = new ArrayList();
                } else {
                    a.this.bYd.clear();
                }
                a.this.bYe = 0;
            }
            this.Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
            this.Tv.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.mIsFirst) {
                this.Tv.o("offset", String.valueOf(0));
            } else {
                this.Tv.o("offset", String.valueOf(this.offset));
            }
            this.Tv.o("rn", String.valueOf(20));
            this.data = this.Tv.tI();
            this.bYh.parserJson(this.data);
            if (this.Tv.uj().va().qZ()) {
                aVar.jf(this.data);
                if (this.offset == 0) {
                    if (a.this.bYd == null) {
                        a.this.bYd = new ArrayList();
                    } else {
                        a.this.bYd.clear();
                    }
                    a.this.bYe = 0;
                    if (this.bYj.booleanValue()) {
                        gC(this.data);
                    }
                }
            }
            return aVar;
        }

        private void gC(String str) {
            o<String> cq;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cq = com.baidu.tbadk.core.b.a.sR().cq("tb.my_bookmarks")) != null) {
                cq.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                ArrayList<MarkData> jg = a.this.jg(str);
                if (this.bYj.booleanValue()) {
                    a.this.N(jg);
                } else {
                    a.this.O(jg);
                }
            } else {
                a.this.N(arrayList);
            }
            a.this.bYg.callback(0, null, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            a.this.bYa = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            a.this.bYa = null;
            a.this.bYe = aVar.getCount();
            ArrayList<MarkData> acj = aVar.acj();
            if (this.bYj.booleanValue()) {
                if (acj != null && acj.size() != 0) {
                    a.this.N(acj);
                }
            } else {
                a.this.O(acj);
            }
            Iterator<MarkData> it = acj.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    int i2 = i + 1;
                    a.this.ir(i2);
                    i = i2;
                }
            }
            if (a.this.bYg != null) {
                if (this.Tv.uj().va().qZ()) {
                    a.this.bYg.callback(0, this.bYh.getErrorCode() != 0 ? this.bYh.getErrorString() : null, false);
                } else {
                    a.this.bYg.callback(3, this.Tv.getErrorString());
                }
            }
            a.this.mIsFirst = false;
        }
    }

    public void startSync() {
        if (this.bYb != null) {
            this.bYb.cancel();
        }
        this.bYb = new c(this, null);
        this.bYb.setPriority(2);
        this.bYb.execute(new a[0]);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private v Tv;
        private e bYh;

        private c() {
            this.Tv = null;
            this.bYh = null;
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bYh = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.acl();
                this.Tv = new v();
                this.Tv.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
                int acm = a.this.acm();
                if (aVar.getCount() - 1 <= acm) {
                    acm = aVar.getCount() - 1;
                }
                while (acm >= 0) {
                    String at = aVar.at(acm, 20);
                    this.Tv.l(new ArrayList<>());
                    this.Tv.o("data", at);
                    this.bYh.parserJson(this.Tv.tI());
                    if (!this.Tv.uj().va().qZ() || this.bYh.getErrorCode() != 0) {
                        break;
                    }
                    acm -= 20;
                }
                a.this.it(acm);
                if (acm >= 0) {
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
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            a.this.bYb = null;
            if (a.this.bYg != null) {
                a.this.bYg.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.bYb = null;
            if (bool.booleanValue()) {
                a.this.bYd.clear();
                str = null;
                z = false;
            } else if (this.Tv.uj().va().qZ()) {
                str = this.bYh.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.bYg != null) {
                a.this.bYg.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean is(int i) {
        if (this.bYc != null) {
            this.bYc.cancel();
        }
        if (i >= this.bYd.size() || this.bYd.get(i) == null || this.bYd.get(i).getId() == null) {
            return false;
        }
        this.bYc = new C0066a(this.bYd.get(i).getId(), i);
        this.bYc.setPriority(2);
        this.bYc.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private v Tv = null;
        private e bYh;
        private int pos;
        private String tid;

        public C0066a(String str, int i) {
            this.tid = null;
            this.pos = 0;
            this.bYh = null;
            this.tid = str;
            this.pos = i;
            this.bYh = new e();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            this.Tv.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.Tv.o("tid", this.tid);
            this.bYh.parserJson(this.Tv.tI());
            return this.Tv.uj().va().qZ() && this.bYh.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            a.this.bYc = null;
            if (a.this.bYg != null) {
                a.this.bYg.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.bYc = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.bYd.size()) {
                    a.this.bYd.remove(this.pos);
                    a aVar = a.this;
                    aVar.bYf--;
                }
            } else if (this.Tv.uj().va().qZ()) {
                str = this.bYh.getErrorString();
            } else {
                str = this.Tv.getErrorString();
            }
            if (a.this.bYg != null) {
                a.this.bYg.callback(2, bool, str);
            }
        }
    }

    public int acm() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getInt("uploac_mark_offset", 399);
    }

    public void it(int i) {
        com.baidu.tbadk.core.sharedPref.b.tx().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.bYa != null) {
            this.bYa.cancel();
        }
        if (this.bYb != null) {
            this.bYb.cancel();
        }
        if (this.bYc != null) {
            this.bYc.cancel();
        }
    }

    public void a(l lVar) {
        this.bYg = lVar;
    }

    private void removalDuplicate() {
        if (this.bYd != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.bYd.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }
}
