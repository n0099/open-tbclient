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
import com.baidu.tieba.myCollection.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private boolean kcJ;
    private b lxk = null;
    private c lxl = null;
    private C0799a lxm = null;
    private int lxo = 0;
    private int lxp = 0;
    protected d lxq = null;
    private ArrayList<MarkData> lxn = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.lxp;
        aVar.lxp = i - 1;
        return i;
    }

    public a() {
        this.kcJ = false;
        this.kcJ = true;
    }

    public int getOffset() {
        if (this.lxn == null) {
            return 0;
        }
        return this.lxn.size();
    }

    public int dhG() {
        return this.lxp;
    }

    public void EO(int i) {
        this.lxp = i;
    }

    public boolean hasMore() {
        return this.lxo > 0;
    }

    public void reset() {
        this.lxp = 0;
        this.lxo = 0;
        this.kcJ = true;
    }

    public ArrayList<MarkData> dhH() {
        return this.lxn;
    }

    public void aT(ArrayList<MarkData> arrayList) {
        this.lxn = arrayList;
    }

    public void aU(ArrayList<MarkData> arrayList) {
        if (this.lxn != null && arrayList != null) {
            this.lxn.addAll(arrayList);
            dhL();
        }
    }

    public void f(MarkData markData) {
        this.lxn.add(markData);
    }

    public int getCount() {
        if (this.lxn == null) {
            return 0;
        }
        return this.lxn.size();
    }

    public int dhI() {
        return this.lxo;
    }

    public void dhJ() {
        ArrayList<MarkData> dOA = com.baidu.tieba.tbadkCore.util.a.dOA();
        if (dOA != null) {
            aT(dOA);
        }
    }

    public String cU(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.lxn == null) {
            return null;
        }
        if (i >= this.lxn.size()) {
            i2 -= (i - this.lxn.size()) - 1;
            i = this.lxn.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.lxn.get(i5).toJson();
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

    public void OL(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> OM(String str) {
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
                    this.lxn.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void p(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.lxk != null) {
            this.lxk.cancel();
        }
        this.lxk = new b(getOffset());
        this.lxk.setPriority(3);
        this.lxk.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c lxr;
        private int offset;
        private aa cml = null;
        private String data = null;
        Boolean lxt = false;

        public b(int i) {
            this.offset = 0;
            this.lxr = null;
            this.offset = i;
            this.lxr = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.lxt = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.lxt.booleanValue() && booleanValue) {
                l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.my_bookmarks");
                if (As != null) {
                    publishProgress(As.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.lxn == null) {
                    a.this.lxn = new ArrayList();
                } else {
                    a.this.lxn.clear();
                }
                a.this.lxo = 0;
            }
            this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cml.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.kcJ) {
                this.cml.addPostData("offset", String.valueOf(0));
            } else {
                this.cml.addPostData("offset", String.valueOf(this.offset));
            }
            this.cml.addPostData("rn", String.valueOf(20));
            this.data = this.cml.postNetData();
            this.lxr.parserJson(this.data);
            if (this.cml.bsr().btb().isRequestSuccess()) {
                aVar.OL(this.data);
                if (this.offset == 0) {
                    if (a.this.lxn == null) {
                        a.this.lxn = new ArrayList();
                    } else {
                        a.this.lxn.clear();
                    }
                    a.this.lxo = 0;
                    if (this.lxt.booleanValue()) {
                        JL(this.data);
                    }
                }
            }
            return aVar;
        }

        private void JL(String str) {
            l<String> As;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (As = com.baidu.tbadk.core.c.a.bqr().As("tb.my_bookmarks")) != null) {
                As.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.OM(str);
                if (this.lxt.booleanValue()) {
                    a.this.aT(arrayList);
                } else {
                    a.this.aU(arrayList);
                }
            } else {
                a.this.aT(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.lxq.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            a.this.lxk = null;
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
            if (this.lxr != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.lxr.getErrorCode(), this.lxr.getErrorString(), new Object[0]);
            }
            a.this.lxo = aVar.getCount();
            ArrayList<MarkData> dhH = aVar.dhH();
            if (this.lxt.booleanValue()) {
                if (dhH != null && dhH.size() != 0) {
                    a.this.aT(dhH);
                }
            } else {
                a.this.aU(dhH);
            }
            Iterator<MarkData> it = dhH.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.EO(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.lxq != null) {
                String str = null;
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    if (this.lxr.getErrorCode() != 0) {
                        str = this.lxr.getErrorString();
                    }
                    a.this.lxq.callback(0, str, false);
                } else {
                    a.this.lxq.callback(3, this.cml.getErrorString());
                }
            }
            a.this.kcJ = false;
        }
    }

    /* loaded from: classes8.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa cml;
        private com.baidu.tieba.myCollection.baseEditMark.c lxr;
        final /* synthetic */ a lxs;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.lxr = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dhJ();
                this.cml = new aa();
                this.cml.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dhK = this.lxs.dhK();
                if (aVar.getCount() - 1 <= dhK) {
                    dhK = aVar.getCount() - 1;
                }
                while (dhK >= 0) {
                    String cU = aVar.cU(dhK, 20);
                    this.cml.setPostData(new ArrayList<>());
                    this.cml.addPostData("data", cU);
                    this.lxr.parserJson(this.cml.postNetData());
                    if (!this.cml.bsr().btb().isRequestSuccess() || this.lxr.getErrorCode() != 0) {
                        break;
                    }
                    dhK -= 20;
                }
                this.lxs.EQ(dhK);
                if (dhK >= 0) {
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
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            this.lxs.lxl = null;
            if (this.lxs.lxq != null) {
                this.lxs.lxq.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean z;
            String str = null;
            this.lxs.lxl = null;
            if (bool.booleanValue()) {
                z = false;
            } else if (this.cml.bsr().btb().isRequestSuccess()) {
                str = this.lxr.getErrorString();
                z = false;
            } else {
                z = true;
            }
            if (this.lxs.lxq != null) {
                this.lxs.lxq.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean EP(int i) {
        if (this.lxm != null) {
            this.lxm.cancel();
        }
        if (i >= this.lxn.size() || this.lxn.get(i) == null || this.lxn.get(i).getId() == null) {
            return false;
        }
        this.lxm = new C0799a(this.lxn.get(i).getId(), i, this.lxn.get(i).getForumId());
        this.lxm.setPriority(2);
        this.lxm.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0799a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cml = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c lxr;
        private int pos;
        private String tid;

        public C0799a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.lxr = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.lxr = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cml.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cml.addPostData("tid", this.tid);
            this.cml.addPostData("fid", this.fid);
            this.lxr.parserJson(this.cml.postNetData());
            return this.cml.bsr().btb().isRequestSuccess() && this.lxr.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            a.this.lxm = null;
            if (a.this.lxq != null) {
                a.this.lxq.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.lxm = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.lxn.size()) {
                    a.this.lxn.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cml.bsr().btb().isRequestSuccess()) {
                str = this.lxr.getErrorString();
            } else {
                str = this.cml.getErrorString();
            }
            if (a.this.lxq != null) {
                a.this.lxq.callback(2, bool, str);
            }
        }
    }

    public int dhK() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void EQ(int i) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.lxk != null) {
            this.lxk.cancel();
        }
        if (this.lxl != null) {
            this.lxl.cancel();
        }
        if (this.lxm != null) {
            this.lxm.cancel();
        }
    }

    public void a(d dVar) {
        this.lxq = dVar;
    }

    private void dhL() {
        if (this.lxn != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.lxn.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bG(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bG(String str, int i) {
        if (this.lxn != null && y.getCount(this.lxn) > 0) {
            Iterator<MarkData> it = this.lxn.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
