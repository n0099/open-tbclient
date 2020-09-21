package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class a {
    private boolean iQP;
    private b ksW = null;
    private c ksX = null;
    private C0745a ksY = null;
    private int kta = 0;
    private int ktb = 0;
    protected com.baidu.tieba.myCollection.c ktc = null;
    private ArrayList<MarkData> ksZ = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.ktb;
        aVar.ktb = i - 1;
        return i;
    }

    public a() {
        this.iQP = false;
        this.iQP = true;
    }

    public int getOffset() {
        if (this.ksZ == null) {
            return 0;
        }
        return this.ksZ.size();
    }

    public int cVF() {
        return this.ktb;
    }

    public void DL(int i) {
        this.ktb = i;
    }

    public boolean hasMore() {
        return this.kta > 0;
    }

    public void reset() {
        this.ktb = 0;
        this.kta = 0;
        this.iQP = true;
    }

    public ArrayList<MarkData> cVG() {
        return this.ksZ;
    }

    public void aT(ArrayList<MarkData> arrayList) {
        this.ksZ = arrayList;
    }

    public void aU(ArrayList<MarkData> arrayList) {
        if (this.ksZ != null && arrayList != null) {
            this.ksZ.addAll(arrayList);
            cVK();
        }
    }

    public void f(MarkData markData) {
        this.ksZ.add(markData);
    }

    public int getCount() {
        if (this.ksZ == null) {
            return 0;
        }
        return this.ksZ.size();
    }

    public int cVH() {
        return this.kta;
    }

    public void cVI() {
        ArrayList<MarkData> dBw = com.baidu.tieba.tbadkCore.util.a.dBw();
        if (dBw != null) {
            aT(dBw);
        }
    }

    public String cS(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.ksZ == null) {
            return null;
        }
        if (i >= this.ksZ.size()) {
            i2 -= (i - this.ksZ.size()) - 1;
            i = this.ksZ.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.ksZ.get(i5).toJson();
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

    public void Nq(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Nr(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(BaseJsonData.TAG_ERRNO).equals("0")) {
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
            if (jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString(BaseJsonData.TAG_ERRNO).equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.ksZ.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void o(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.ksW != null) {
            this.ksW.cancel();
        }
        this.ksW = new b(getOffset());
        this.ksW.setPriority(3);
        this.ksW.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c ktd;
        private int offset;
        private aa bGb = null;
        private String data = null;
        Boolean ktf = false;

        public b(int i) {
            this.offset = 0;
            this.ktd = null;
            this.offset = i;
            this.ktd = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public a doInBackground(Boolean... boolArr) {
            this.ktf = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.ktf.booleanValue() && booleanValue) {
                l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.my_bookmarks");
                if (zT != null) {
                    publishProgress(zT.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.ksZ == null) {
                    a.this.ksZ = new ArrayList();
                } else {
                    a.this.ksZ.clear();
                }
                a.this.kta = 0;
            }
            this.bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bGb.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.iQP) {
                this.bGb.addPostData("offset", String.valueOf(0));
            } else {
                this.bGb.addPostData("offset", String.valueOf(this.offset));
            }
            this.bGb.addPostData("rn", String.valueOf(20));
            this.data = this.bGb.postNetData();
            this.ktd.parserJson(this.data);
            if (this.bGb.bjL().bkr().isRequestSuccess()) {
                aVar.Nq(this.data);
                if (this.offset == 0) {
                    if (a.this.ksZ == null) {
                        a.this.ksZ = new ArrayList();
                    } else {
                        a.this.ksZ.clear();
                    }
                    a.this.kta = 0;
                    if (this.ktf.booleanValue()) {
                        Iu(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Iu(String str) {
            l<String> zT;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.my_bookmarks")) != null) {
                zT.set(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.Nr(str);
                if (this.ktf.booleanValue()) {
                    a.this.aT(arrayList);
                } else {
                    a.this.aU(arrayList);
                }
            } else {
                a.this.aT(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.ktc.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            a.this.ksW = null;
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
            if (this.ktd != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.ktd.getErrorCode(), this.ktd.getErrorString(), new Object[0]);
            }
            a.this.kta = aVar.getCount();
            ArrayList<MarkData> cVG = aVar.cVG();
            if (this.ktf.booleanValue()) {
                if (cVG != null && cVG.size() != 0) {
                    a.this.aT(cVG);
                }
            } else {
                a.this.aU(cVG);
            }
            Iterator<MarkData> it = cVG.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.DL(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.ktc != null) {
                String str = null;
                if (this.bGb.bjL().bkr().isRequestSuccess()) {
                    if (this.ktd.getErrorCode() != 0) {
                        str = this.ktd.getErrorString();
                    }
                    a.this.ktc.callback(0, str, false);
                } else {
                    a.this.ktc.callback(3, this.bGb.getErrorString());
                }
            }
            a.this.iQP = false;
        }
    }

    /* loaded from: classes23.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa bGb;
        private com.baidu.tieba.myCollection.baseEditMark.c ktd;
        final /* synthetic */ a kte;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ktd = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cVI();
                this.bGb = new aa();
                this.bGb.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cVJ = this.kte.cVJ();
                if (aVar.getCount() - 1 <= cVJ) {
                    cVJ = aVar.getCount() - 1;
                }
                while (cVJ >= 0) {
                    String cS = aVar.cS(cVJ, 20);
                    this.bGb.setPostData(new ArrayList<>());
                    this.bGb.addPostData("data", cS);
                    this.ktd.parserJson(this.bGb.postNetData());
                    if (!this.bGb.bjL().bkr().isRequestSuccess() || this.ktd.getErrorCode() != 0) {
                        break;
                    }
                    cVJ -= 20;
                }
                this.kte.DN(cVJ);
                if (cVJ >= 0) {
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
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            this.kte.ksX = null;
            if (this.kte.ktc != null) {
                this.kte.ktc.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.kte.ksX = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bGb.bjL().bkr().isRequestSuccess()) {
                str = this.ktd.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.kte.ktc != null) {
                this.kte.ktc.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean DM(int i) {
        if (this.ksY != null) {
            this.ksY.cancel();
        }
        if (i >= this.ksZ.size() || this.ksZ.get(i) == null || this.ksZ.get(i).getId() == null) {
            return false;
        }
        this.ksY = new C0745a(this.ksZ.get(i).getId(), i, this.ksZ.get(i).getForumId());
        this.ksY.setPriority(2);
        this.ksY.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0745a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bGb = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c ktd;
        private int pos;
        private String tid;

        public C0745a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.ktd = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.ktd = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bGb.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bGb.addPostData("tid", this.tid);
            this.bGb.addPostData("fid", this.fid);
            this.ktd.parserJson(this.bGb.postNetData());
            return this.bGb.bjL().bkr().isRequestSuccess() && this.ktd.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            a.this.ksY = null;
            if (a.this.ktc != null) {
                a.this.ktc.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.ksY = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.ksZ.size()) {
                    a.this.ksZ.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bGb.bjL().bkr().isRequestSuccess()) {
                str = this.ktd.getErrorString();
            } else {
                str = this.bGb.getErrorString();
            }
            if (a.this.ktc != null) {
                a.this.ktc.callback(2, bool, str);
            }
        }
    }

    public int cVJ() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void DN(int i) {
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.ksW != null) {
            this.ksW.cancel();
        }
        if (this.ksX != null) {
            this.ksX.cancel();
        }
        if (this.ksY != null) {
            this.ksY.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.ktc = cVar;
    }

    private void cVK() {
        if (this.ksZ != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.ksZ.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bu(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bu(String str, int i) {
        if (this.ksZ != null && y.getCount(this.ksZ) > 0) {
            Iterator<MarkData> it = this.ksZ.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
