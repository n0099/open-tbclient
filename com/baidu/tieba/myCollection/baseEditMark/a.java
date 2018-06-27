package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.myCollection.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean dRO;
    private b fkf = null;
    private c fkg = null;
    private C0200a fkh = null;
    private int fkj = 0;
    private int fkk = 0;
    protected d fkl = null;
    private ArrayList<MarkData> fki = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fkk;
        aVar.fkk = i - 1;
        return i;
    }

    public a() {
        this.dRO = false;
        this.dRO = true;
    }

    public int getOffset() {
        if (this.fki == null) {
            return 0;
        }
        return this.fki.size();
    }

    public int aYA() {
        return this.fkk;
    }

    public void qc(int i) {
        this.fkk = i;
    }

    public boolean hasMore() {
        return this.fkj >= 20;
    }

    public void reset() {
        this.fkk = 0;
        this.fkj = 0;
        this.dRO = true;
    }

    public boolean isFirst() {
        return this.dRO;
    }

    public ArrayList<MarkData> aYB() {
        return this.fki;
    }

    public void an(ArrayList<MarkData> arrayList) {
        this.fki = arrayList;
    }

    public void ao(ArrayList<MarkData> arrayList) {
        if (this.fki != null && arrayList != null) {
            this.fki.addAll(arrayList);
            aYF();
        }
    }

    public void f(MarkData markData) {
        this.fki.add(markData);
    }

    public int getCount() {
        if (this.fki == null) {
            return 0;
        }
        return this.fki.size();
    }

    public int aYC() {
        return this.fkj;
    }

    public void aYD() {
        ArrayList<MarkData> byy = com.baidu.tieba.tbadkCore.util.a.byy();
        if (byy != null) {
            an(byy);
        }
    }

    public String bk(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fki == null) {
            return null;
        }
        if (i >= this.fki.size()) {
            i2 -= (i - this.fki.size()) - 1;
            i = this.fki.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fki.get(i5).toJson();
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
        jSONArray = jSONArray2;
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void qJ(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> qK(String str) {
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
                arrayList.add(markData);
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
                    this.fki.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void d(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.fkf != null) {
            this.fkf.cancel();
        }
        this.fkf = new b(getOffset());
        this.fkf.setPriority(3);
        this.fkf.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fkm;
        private int offset;
        private y mNetWork = null;
        private String data = null;
        Boolean fko = false;

        public b(int i) {
            this.offset = 0;
            this.fkm = null;
            this.offset = i;
            this.fkm = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fko = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fko.booleanValue() && booleanValue) {
                l<String> dB = com.baidu.tbadk.core.c.a.xj().dB("tb.my_bookmarks");
                if (dB != null) {
                    publishProgress(dB.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fki == null) {
                    a.this.fki = new ArrayList();
                } else {
                    a.this.fki.clear();
                }
                a.this.fkj = 0;
            }
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dRO) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.yz();
            this.fkm.parserJson(this.data);
            if (this.mNetWork.yX().zY().isRequestSuccess()) {
                aVar.qJ(this.data);
                if (this.offset == 0) {
                    if (a.this.fki == null) {
                        a.this.fki = new ArrayList();
                    } else {
                        a.this.fki.clear();
                    }
                    a.this.fkj = 0;
                    if (this.fko.booleanValue()) {
                        lU(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lU(String str) {
            l<String> dB;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dB = com.baidu.tbadk.core.c.a.xj().dB("tb.my_bookmarks")) != null) {
                dB.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.qK(str);
                if (this.fko.booleanValue()) {
                    a.this.an(arrayList);
                } else {
                    a.this.ao(arrayList);
                }
            } else {
                a.this.an(arrayList);
            }
            if (!w.A(arrayList)) {
                a.this.fkl.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkf = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            int i;
            if (aVar == null) {
                aVar = new a();
            }
            if (this.fkm != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fkm.getErrorCode(), this.fkm.getErrorString(), new Object[0]);
            }
            a.this.fkj = aVar.getCount();
            ArrayList<MarkData> aYB = aVar.aYB();
            if (this.fko.booleanValue()) {
                if (aYB != null && aYB.size() != 0) {
                    a.this.an(aYB);
                }
            } else {
                a.this.ao(aYB);
            }
            Iterator<MarkData> it = aYB.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.qc(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fkl != null) {
                String str = null;
                if (this.mNetWork.yX().zY().isRequestSuccess()) {
                    if (this.fkm.getErrorCode() != 0) {
                        str = this.fkm.getErrorString();
                    }
                    a.this.fkl.callback(0, str, false);
                } else {
                    a.this.fkl.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dRO = false;
        }
    }

    public void startSync() {
        if (this.fkg != null) {
            this.fkg.cancel();
        }
        this.fkg = new c();
        this.fkg.setPriority(2);
        this.fkg.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fkm;
        private y mNetWork;

        private c() {
            this.mNetWork = null;
            this.fkm = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fkm = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aYD();
                this.mNetWork = new y();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aYE = a.this.aYE();
                if (aVar.getCount() - 1 <= aYE) {
                    aYE = aVar.getCount() - 1;
                }
                while (aYE >= 0) {
                    String bk = aVar.bk(aYE, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.o("data", bk);
                    this.fkm.parserJson(this.mNetWork.yz());
                    if (!this.mNetWork.yX().zY().isRequestSuccess() || this.fkm.getErrorCode() != 0) {
                        break;
                    }
                    aYE -= 20;
                }
                a.this.qe(aYE);
                if (aYE >= 0) {
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
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkg = null;
            if (a.this.fkl != null) {
                a.this.fkl.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fkg = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.yX().zY().isRequestSuccess()) {
                str = this.fkm.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fkl != null) {
                a.this.fkl.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean qd(int i) {
        if (this.fkh != null) {
            this.fkh.cancel();
        }
        if (i >= this.fki.size() || this.fki.get(i) == null || this.fki.get(i).getId() == null) {
            return false;
        }
        this.fkh = new C0200a(this.fki.get(i).getId(), i, this.fki.get(i).getForumId());
        this.fkh.setPriority(2);
        this.fkh.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0200a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fkm;
        private y mNetWork = null;
        private int pos;
        private String tid;

        public C0200a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fkm = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fkm = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.o("tid", this.tid);
            this.mNetWork.o(ImageViewerConfig.FORUM_ID, this.fid);
            this.fkm.parserJson(this.mNetWork.yz());
            return this.mNetWork.yX().zY().isRequestSuccess() && this.fkm.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkh = null;
            if (a.this.fkl != null) {
                a.this.fkl.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fkh = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fki.size()) {
                    a.this.fki.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.yX().zY().isRequestSuccess()) {
                str = this.fkm.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fkl != null) {
                a.this.fkl.callback(2, bool, str);
            }
        }
    }

    public int aYE() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void qe(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fkf != null) {
            this.fkf.cancel();
        }
        if (this.fkg != null) {
            this.fkg.cancel();
        }
        if (this.fkh != null) {
            this.fkh.cancel();
        }
    }

    public void a(d dVar) {
        this.fkl = dVar;
    }

    private void aYF() {
        if (this.fki != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fki.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aE(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aE(String str, int i) {
        if (this.fki != null && w.z(this.fki) > 0) {
            Iterator<MarkData> it = this.fki.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
