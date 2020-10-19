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
/* loaded from: classes24.dex */
public class a {
    private boolean jfJ;
    private b kIi = null;
    private c kIj = null;
    private C0763a kIk = null;
    private int kIm = 0;
    private int kIn = 0;
    protected com.baidu.tieba.myCollection.c kIo = null;
    private ArrayList<MarkData> kIl = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.kIn;
        aVar.kIn = i - 1;
        return i;
    }

    public a() {
        this.jfJ = false;
        this.jfJ = true;
    }

    public int getOffset() {
        if (this.kIl == null) {
            return 0;
        }
        return this.kIl.size();
    }

    public int cZo() {
        return this.kIn;
    }

    public void Er(int i) {
        this.kIn = i;
    }

    public boolean hasMore() {
        return this.kIm > 0;
    }

    public void reset() {
        this.kIn = 0;
        this.kIm = 0;
        this.jfJ = true;
    }

    public ArrayList<MarkData> cZp() {
        return this.kIl;
    }

    public void aT(ArrayList<MarkData> arrayList) {
        this.kIl = arrayList;
    }

    public void aU(ArrayList<MarkData> arrayList) {
        if (this.kIl != null && arrayList != null) {
            this.kIl.addAll(arrayList);
            cZt();
        }
    }

    public void f(MarkData markData) {
        this.kIl.add(markData);
    }

    public int getCount() {
        if (this.kIl == null) {
            return 0;
        }
        return this.kIl.size();
    }

    public int cZq() {
        return this.kIm;
    }

    public void cZr() {
        ArrayList<MarkData> dFi = com.baidu.tieba.tbadkCore.util.a.dFi();
        if (dFi != null) {
            aT(dFi);
        }
    }

    public String cS(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.kIl == null) {
            return null;
        }
        if (i >= this.kIl.size()) {
            i2 -= (i - this.kIl.size()) - 1;
            i = this.kIl.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.kIl.get(i5).toJson();
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

    public void Of(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Og(String str) {
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
                    this.kIl.add(markData);
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
        if (this.kIi != null) {
            this.kIi.cancel();
        }
        this.kIi = new b(getOffset());
        this.kIi.setPriority(3);
        this.kIi.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c kIp;
        private int offset;
        private aa bML = null;
        private String data = null;
        Boolean kIr = false;

        public b(int i) {
            this.offset = 0;
            this.kIp = null;
            this.offset = i;
            this.kIp = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.kIr = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.kIr.booleanValue() && booleanValue) {
                l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.my_bookmarks");
                if (AF != null) {
                    publishProgress(AF.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.kIl == null) {
                    a.this.kIl = new ArrayList();
                } else {
                    a.this.kIl.clear();
                }
                a.this.kIm = 0;
            }
            this.bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bML.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jfJ) {
                this.bML.addPostData("offset", String.valueOf(0));
            } else {
                this.bML.addPostData("offset", String.valueOf(this.offset));
            }
            this.bML.addPostData("rn", String.valueOf(20));
            this.data = this.bML.postNetData();
            this.kIp.parserJson(this.data);
            if (this.bML.bmu().bnb().isRequestSuccess()) {
                aVar.Of(this.data);
                if (this.offset == 0) {
                    if (a.this.kIl == null) {
                        a.this.kIl = new ArrayList();
                    } else {
                        a.this.kIl.clear();
                    }
                    a.this.kIm = 0;
                    if (this.kIr.booleanValue()) {
                        Jh(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Jh(String str) {
            l<String> AF;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.my_bookmarks")) != null) {
                AF.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Og(str);
                if (this.kIr.booleanValue()) {
                    a.this.aT(arrayList);
                } else {
                    a.this.aU(arrayList);
                }
            } else {
                a.this.aT(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.kIo.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            a.this.kIi = null;
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
            if (this.kIp != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.kIp.getErrorCode(), this.kIp.getErrorString(), new Object[0]);
            }
            a.this.kIm = aVar.getCount();
            ArrayList<MarkData> cZp = aVar.cZp();
            if (this.kIr.booleanValue()) {
                if (cZp != null && cZp.size() != 0) {
                    a.this.aT(cZp);
                }
            } else {
                a.this.aU(cZp);
            }
            Iterator<MarkData> it = cZp.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.Er(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.kIo != null) {
                String str = null;
                if (this.bML.bmu().bnb().isRequestSuccess()) {
                    if (this.kIp.getErrorCode() != 0) {
                        str = this.kIp.getErrorString();
                    }
                    a.this.kIo.callback(0, str, false);
                } else {
                    a.this.kIo.callback(3, this.bML.getErrorString());
                }
            }
            a.this.jfJ = false;
        }
    }

    /* loaded from: classes24.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa bML;
        private com.baidu.tieba.myCollection.baseEditMark.c kIp;
        final /* synthetic */ a kIq;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.kIp = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cZr();
                this.bML = new aa();
                this.bML.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cZs = this.kIq.cZs();
                if (aVar.getCount() - 1 <= cZs) {
                    cZs = aVar.getCount() - 1;
                }
                while (cZs >= 0) {
                    String cS = aVar.cS(cZs, 20);
                    this.bML.setPostData(new ArrayList<>());
                    this.bML.addPostData("data", cS);
                    this.kIp.parserJson(this.bML.postNetData());
                    if (!this.bML.bmu().bnb().isRequestSuccess() || this.kIp.getErrorCode() != 0) {
                        break;
                    }
                    cZs -= 20;
                }
                this.kIq.Et(cZs);
                if (cZs >= 0) {
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
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            this.kIq.kIj = null;
            if (this.kIq.kIo != null) {
                this.kIq.kIo.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.kIq.kIj = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bML.bmu().bnb().isRequestSuccess()) {
                str = this.kIp.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.kIq.kIo != null) {
                this.kIq.kIo.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Es(int i) {
        if (this.kIk != null) {
            this.kIk.cancel();
        }
        if (i >= this.kIl.size() || this.kIl.get(i) == null || this.kIl.get(i).getId() == null) {
            return false;
        }
        this.kIk = new C0763a(this.kIl.get(i).getId(), i, this.kIl.get(i).getForumId());
        this.kIk.setPriority(2);
        this.kIk.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0763a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bML = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c kIp;
        private int pos;
        private String tid;

        public C0763a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.kIp = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.kIp = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bML.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bML.addPostData("tid", this.tid);
            this.bML.addPostData("fid", this.fid);
            this.kIp.parserJson(this.bML.postNetData());
            return this.bML.bmu().bnb().isRequestSuccess() && this.kIp.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            a.this.kIk = null;
            if (a.this.kIo != null) {
                a.this.kIo.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.kIk = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.kIl.size()) {
                    a.this.kIl.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bML.bmu().bnb().isRequestSuccess()) {
                str = this.kIp.getErrorString();
            } else {
                str = this.bML.getErrorString();
            }
            if (a.this.kIo != null) {
                a.this.kIo.callback(2, bool, str);
            }
        }
    }

    public int cZs() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Et(int i) {
        com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.kIi != null) {
            this.kIi.cancel();
        }
        if (this.kIj != null) {
            this.kIj.cancel();
        }
        if (this.kIk != null) {
            this.kIk.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.kIo = cVar;
    }

    private void cZt() {
        if (this.kIl != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.kIl.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bv(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bv(String str, int i) {
        if (this.kIl != null && y.getCount(this.kIl) > 0) {
            Iterator<MarkData> it = this.kIl.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
