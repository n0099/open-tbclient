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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private boolean jZN;
    private b ltM = null;
    private c ltN = null;
    private C0814a ltO = null;
    private int ltQ = 0;
    private int ltR = 0;
    protected com.baidu.tieba.myCollection.c ltS = null;
    private ArrayList<MarkData> ltP = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.ltR;
        aVar.ltR = i - 1;
        return i;
    }

    public a() {
        this.jZN = false;
        this.jZN = true;
    }

    public int getOffset() {
        if (this.ltP == null) {
            return 0;
        }
        return this.ltP.size();
    }

    public int djx() {
        return this.ltR;
    }

    public void Gc(int i) {
        this.ltR = i;
    }

    public boolean hasMore() {
        return this.ltQ > 0;
    }

    public void reset() {
        this.ltR = 0;
        this.ltQ = 0;
        this.jZN = true;
    }

    public ArrayList<MarkData> djy() {
        return this.ltP;
    }

    public void aZ(ArrayList<MarkData> arrayList) {
        this.ltP = arrayList;
    }

    public void ba(ArrayList<MarkData> arrayList) {
        if (this.ltP != null && arrayList != null) {
            this.ltP.addAll(arrayList);
            djC();
        }
    }

    public void f(MarkData markData) {
        this.ltP.add(markData);
    }

    public int getCount() {
        if (this.ltP == null) {
            return 0;
        }
        return this.ltP.size();
    }

    public int djz() {
        return this.ltQ;
    }

    public void djA() {
        ArrayList<MarkData> dQh = com.baidu.tieba.tbadkCore.util.a.dQh();
        if (dQh != null) {
            aZ(dQh);
        }
    }

    public String cX(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.ltP == null) {
            return null;
        }
        if (i >= this.ltP.size()) {
            i2 -= (i - this.ltP.size()) - 1;
            i = this.ltP.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.ltP.get(i5).toJson();
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

    public void Pd(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Pe(String str) {
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
                    this.ltP.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void q(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.ltM != null) {
            this.ltM.cancel();
        }
        this.ltM = new b(getOffset());
        this.ltM.setPriority(3);
        this.ltM.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c ltT;
        private int offset;
        private z cmJ = null;
        private String data = null;
        Boolean ltV = false;

        public b(int i) {
            this.offset = 0;
            this.ltT = null;
            this.offset = i;
            this.ltT = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.ltV = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.ltV.booleanValue() && booleanValue) {
                l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.my_bookmarks");
                if (Bm != null) {
                    publishProgress(Bm.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.ltP == null) {
                    a.this.ltP = new ArrayList();
                } else {
                    a.this.ltP.clear();
                }
                a.this.ltQ = 0;
            }
            this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cmJ.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jZN) {
                this.cmJ.addPostData("offset", String.valueOf(0));
            } else {
                this.cmJ.addPostData("offset", String.valueOf(this.offset));
            }
            this.cmJ.addPostData("rn", String.valueOf(20));
            this.data = this.cmJ.postNetData();
            this.ltT.parserJson(this.data);
            if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                aVar.Pd(this.data);
                if (this.offset == 0) {
                    if (a.this.ltP == null) {
                        a.this.ltP = new ArrayList();
                    } else {
                        a.this.ltP.clear();
                    }
                    a.this.ltQ = 0;
                    if (this.ltV.booleanValue()) {
                        Kl(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Kl(String str) {
            l<String> Bm;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.my_bookmarks")) != null) {
                Bm.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Pe(str);
                if (this.ltV.booleanValue()) {
                    a.this.aZ(arrayList);
                } else {
                    a.this.ba(arrayList);
                }
            } else {
                a.this.aZ(arrayList);
            }
            if (!x.isEmpty(arrayList)) {
                a.this.ltS.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            a.this.ltM = null;
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
            if (this.ltT != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.ltT.getErrorCode(), this.ltT.getErrorString(), new Object[0]);
            }
            a.this.ltQ = aVar.getCount();
            ArrayList<MarkData> djy = aVar.djy();
            if (this.ltV.booleanValue()) {
                if (djy != null && djy.size() != 0) {
                    a.this.aZ(djy);
                }
            } else {
                a.this.ba(djy);
            }
            Iterator<MarkData> it = djy.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.Gc(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.ltS != null) {
                String str = null;
                if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                    if (this.ltT.getErrorCode() != 0) {
                        str = this.ltT.getErrorString();
                    }
                    a.this.ltS.callback(0, str, false);
                } else {
                    a.this.ltS.callback(3, this.cmJ.getErrorString());
                }
            }
            a.this.jZN = false;
        }
    }

    /* loaded from: classes8.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private z cmJ;
        private com.baidu.tieba.myCollection.baseEditMark.c ltT;
        final /* synthetic */ a ltU;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ltT = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.djA();
                this.cmJ = new z();
                this.cmJ.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int djB = this.ltU.djB();
                if (aVar.getCount() - 1 <= djB) {
                    djB = aVar.getCount() - 1;
                }
                while (djB >= 0) {
                    String cX = aVar.cX(djB, 20);
                    this.cmJ.setPostData(new ArrayList<>());
                    this.cmJ.addPostData("data", cX);
                    this.ltT.parserJson(this.cmJ.postNetData());
                    if (!this.cmJ.bvR().bwB().isRequestSuccess() || this.ltT.getErrorCode() != 0) {
                        break;
                    }
                    djB -= 20;
                }
                this.ltU.Ge(djB);
                if (djB >= 0) {
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
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            this.ltU.ltN = null;
            if (this.ltU.ltS != null) {
                this.ltU.ltS.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean z;
            String str = null;
            this.ltU.ltN = null;
            if (bool.booleanValue()) {
                z = false;
            } else if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                str = this.ltT.getErrorString();
                z = false;
            } else {
                z = true;
            }
            if (this.ltU.ltS != null) {
                this.ltU.ltS.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Gd(int i) {
        if (this.ltO != null) {
            this.ltO.cancel();
        }
        if (i >= this.ltP.size() || this.ltP.get(i) == null || this.ltP.get(i).getId() == null) {
            return false;
        }
        this.ltO = new C0814a(this.ltP.get(i).getId(), i, this.ltP.get(i).getForumId());
        this.ltO.setPriority(2);
        this.ltO.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0814a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z cmJ = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c ltT;
        private int pos;
        private String tid;

        public C0814a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.ltT = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.ltT = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cmJ.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cmJ.addPostData("tid", this.tid);
            this.cmJ.addPostData("fid", this.fid);
            this.ltT.parserJson(this.cmJ.postNetData());
            return this.cmJ.bvR().bwB().isRequestSuccess() && this.ltT.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            a.this.ltO = null;
            if (a.this.ltS != null) {
                a.this.ltS.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.ltO = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.ltP.size()) {
                    a.this.ltP.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                str = this.ltT.getErrorString();
            } else {
                str = this.cmJ.getErrorString();
            }
            if (a.this.ltS != null) {
                a.this.ltS.callback(2, bool, str);
            }
        }
    }

    public int djB() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Ge(int i) {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.ltM != null) {
            this.ltM.cancel();
        }
        if (this.ltN != null) {
            this.ltN.cancel();
        }
        if (this.ltO != null) {
            this.ltO.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.ltS = cVar;
    }

    private void djC() {
        if (this.ltP != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.ltP.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bF(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bF(String str, int i) {
        if (this.ltP != null && x.getCount(this.ltP) > 0) {
            Iterator<MarkData> it = this.ltP.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
