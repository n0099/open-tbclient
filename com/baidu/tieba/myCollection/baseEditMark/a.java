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
    private boolean kcX;
    private b lxy = null;
    private c lxz = null;
    private C0800a lxA = null;
    private int lxC = 0;
    private int lxD = 0;
    protected d lxE = null;
    private ArrayList<MarkData> lxB = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.lxD;
        aVar.lxD = i - 1;
        return i;
    }

    public a() {
        this.kcX = false;
        this.kcX = true;
    }

    public int getOffset() {
        if (this.lxB == null) {
            return 0;
        }
        return this.lxB.size();
    }

    public int dhN() {
        return this.lxD;
    }

    public void EO(int i) {
        this.lxD = i;
    }

    public boolean hasMore() {
        return this.lxC > 0;
    }

    public void reset() {
        this.lxD = 0;
        this.lxC = 0;
        this.kcX = true;
    }

    public ArrayList<MarkData> dhO() {
        return this.lxB;
    }

    public void aT(ArrayList<MarkData> arrayList) {
        this.lxB = arrayList;
    }

    public void aU(ArrayList<MarkData> arrayList) {
        if (this.lxB != null && arrayList != null) {
            this.lxB.addAll(arrayList);
            dhS();
        }
    }

    public void f(MarkData markData) {
        this.lxB.add(markData);
    }

    public int getCount() {
        if (this.lxB == null) {
            return 0;
        }
        return this.lxB.size();
    }

    public int dhP() {
        return this.lxC;
    }

    public void dhQ() {
        ArrayList<MarkData> dOI = com.baidu.tieba.tbadkCore.util.a.dOI();
        if (dOI != null) {
            aT(dOI);
        }
    }

    public String cV(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.lxB == null) {
            return null;
        }
        if (i >= this.lxB.size()) {
            i2 -= (i - this.lxB.size()) - 1;
            i = this.lxB.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.lxB.get(i5).toJson();
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

    public void OM(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> ON(String str) {
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
                    this.lxB.add(markData);
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
        if (this.lxy != null) {
            this.lxy.cancel();
        }
        this.lxy = new b(getOffset());
        this.lxy.setPriority(3);
        this.lxy.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c lxF;
        private int offset;
        private aa cml = null;
        private String data = null;
        Boolean lxH = false;

        public b(int i) {
            this.offset = 0;
            this.lxF = null;
            this.offset = i;
            this.lxF = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.lxH = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.lxH.booleanValue() && booleanValue) {
                l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.my_bookmarks");
                if (As != null) {
                    publishProgress(As.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.lxB == null) {
                    a.this.lxB = new ArrayList();
                } else {
                    a.this.lxB.clear();
                }
                a.this.lxC = 0;
            }
            this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cml.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.kcX) {
                this.cml.addPostData("offset", String.valueOf(0));
            } else {
                this.cml.addPostData("offset", String.valueOf(this.offset));
            }
            this.cml.addPostData("rn", String.valueOf(20));
            this.data = this.cml.postNetData();
            this.lxF.parserJson(this.data);
            if (this.cml.bsr().btb().isRequestSuccess()) {
                aVar.OM(this.data);
                if (this.offset == 0) {
                    if (a.this.lxB == null) {
                        a.this.lxB = new ArrayList();
                    } else {
                        a.this.lxB.clear();
                    }
                    a.this.lxC = 0;
                    if (this.lxH.booleanValue()) {
                        JM(this.data);
                    }
                }
            }
            return aVar;
        }

        private void JM(String str) {
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
                arrayList = a.this.ON(str);
                if (this.lxH.booleanValue()) {
                    a.this.aT(arrayList);
                } else {
                    a.this.aU(arrayList);
                }
            } else {
                a.this.aT(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.lxE.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            a.this.lxy = null;
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
            if (this.lxF != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.lxF.getErrorCode(), this.lxF.getErrorString(), new Object[0]);
            }
            a.this.lxC = aVar.getCount();
            ArrayList<MarkData> dhO = aVar.dhO();
            if (this.lxH.booleanValue()) {
                if (dhO != null && dhO.size() != 0) {
                    a.this.aT(dhO);
                }
            } else {
                a.this.aU(dhO);
            }
            Iterator<MarkData> it = dhO.iterator();
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
            if (a.this.lxE != null) {
                String str = null;
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    if (this.lxF.getErrorCode() != 0) {
                        str = this.lxF.getErrorString();
                    }
                    a.this.lxE.callback(0, str, false);
                } else {
                    a.this.lxE.callback(3, this.cml.getErrorString());
                }
            }
            a.this.kcX = false;
        }
    }

    /* loaded from: classes8.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa cml;
        private com.baidu.tieba.myCollection.baseEditMark.c lxF;
        final /* synthetic */ a lxG;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.lxF = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dhQ();
                this.cml = new aa();
                this.cml.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dhR = this.lxG.dhR();
                if (aVar.getCount() - 1 <= dhR) {
                    dhR = aVar.getCount() - 1;
                }
                while (dhR >= 0) {
                    String cV = aVar.cV(dhR, 20);
                    this.cml.setPostData(new ArrayList<>());
                    this.cml.addPostData("data", cV);
                    this.lxF.parserJson(this.cml.postNetData());
                    if (!this.cml.bsr().btb().isRequestSuccess() || this.lxF.getErrorCode() != 0) {
                        break;
                    }
                    dhR -= 20;
                }
                this.lxG.EQ(dhR);
                if (dhR >= 0) {
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
            this.lxG.lxz = null;
            if (this.lxG.lxE != null) {
                this.lxG.lxE.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean z;
            String str = null;
            this.lxG.lxz = null;
            if (bool.booleanValue()) {
                z = false;
            } else if (this.cml.bsr().btb().isRequestSuccess()) {
                str = this.lxF.getErrorString();
                z = false;
            } else {
                z = true;
            }
            if (this.lxG.lxE != null) {
                this.lxG.lxE.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean EP(int i) {
        if (this.lxA != null) {
            this.lxA.cancel();
        }
        if (i >= this.lxB.size() || this.lxB.get(i) == null || this.lxB.get(i).getId() == null) {
            return false;
        }
        this.lxA = new C0800a(this.lxB.get(i).getId(), i, this.lxB.get(i).getForumId());
        this.lxA.setPriority(2);
        this.lxA.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0800a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cml = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c lxF;
        private int pos;
        private String tid;

        public C0800a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.lxF = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.lxF = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.lxF.parserJson(this.cml.postNetData());
            return this.cml.bsr().btb().isRequestSuccess() && this.lxF.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            a.this.lxA = null;
            if (a.this.lxE != null) {
                a.this.lxE.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.lxA = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.lxB.size()) {
                    a.this.lxB.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cml.bsr().btb().isRequestSuccess()) {
                str = this.lxF.getErrorString();
            } else {
                str = this.cml.getErrorString();
            }
            if (a.this.lxE != null) {
                a.this.lxE.callback(2, bool, str);
            }
        }
    }

    public int dhR() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void EQ(int i) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.lxy != null) {
            this.lxy.cancel();
        }
        if (this.lxz != null) {
            this.lxz.cancel();
        }
        if (this.lxA != null) {
            this.lxA.cancel();
        }
    }

    public void a(d dVar) {
        this.lxE = dVar;
    }

    private void dhS() {
        if (this.lxB != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.lxB.iterator();
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
        if (this.lxB != null && y.getCount(this.lxB) > 0) {
            Iterator<MarkData> it = this.lxB.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
