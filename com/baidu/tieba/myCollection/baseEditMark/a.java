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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean hJY;
    private b jeQ = null;
    private c jeR = null;
    private C0601a jeS = null;
    private int jeU = 0;
    private int jeV = 0;
    protected com.baidu.tieba.myCollection.c jeW = null;
    private ArrayList<MarkData> jeT = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.jeV;
        aVar.jeV = i - 1;
        return i;
    }

    public a() {
        this.hJY = false;
        this.hJY = true;
    }

    public int getOffset() {
        if (this.jeT == null) {
            return 0;
        }
        return this.jeT.size();
    }

    public int csN() {
        return this.jeV;
    }

    public void yW(int i) {
        this.jeV = i;
    }

    public boolean hasMore() {
        return this.jeU > 0;
    }

    public void reset() {
        this.jeV = 0;
        this.jeU = 0;
        this.hJY = true;
    }

    public ArrayList<MarkData> csO() {
        return this.jeT;
    }

    public void aJ(ArrayList<MarkData> arrayList) {
        this.jeT = arrayList;
    }

    public void aK(ArrayList<MarkData> arrayList) {
        if (this.jeT != null && arrayList != null) {
            this.jeT.addAll(arrayList);
            csS();
        }
    }

    public void f(MarkData markData) {
        this.jeT.add(markData);
    }

    public int getCount() {
        if (this.jeT == null) {
            return 0;
        }
        return this.jeT.size();
    }

    public int csP() {
        return this.jeU;
    }

    public void csQ() {
        ArrayList<MarkData> cXn = com.baidu.tieba.tbadkCore.util.a.cXn();
        if (cXn != null) {
            aJ(cXn);
        }
    }

    public String ct(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jeT == null) {
            return null;
        }
        if (i >= this.jeT.size()) {
            i2 -= (i - this.jeT.size()) - 1;
            i = this.jeT.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jeT.get(i5).toJson();
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

    public void GU(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> GV(String str) {
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
                    this.jeT.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void j(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.jeQ != null) {
            this.jeQ.cancel();
        }
        this.jeQ = new b(getOffset());
        this.jeQ.setPriority(3);
        this.jeQ.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jeX;
        private int offset;
        private x blF = null;
        private String data = null;
        Boolean jeZ = false;

        public b(int i) {
            this.offset = 0;
            this.jeX = null;
            this.offset = i;
            this.jeX = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jeZ = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jeZ.booleanValue() && booleanValue) {
                l<String> ud = com.baidu.tbadk.core.c.a.aMT().ud("tb.my_bookmarks");
                if (ud != null) {
                    publishProgress(ud.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jeT == null) {
                    a.this.jeT = new ArrayList();
                } else {
                    a.this.jeT.clear();
                }
                a.this.jeU = 0;
            }
            this.blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.blF.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.hJY) {
                this.blF.addPostData("offset", String.valueOf(0));
            } else {
                this.blF.addPostData("offset", String.valueOf(this.offset));
            }
            this.blF.addPostData("rn", String.valueOf(20));
            this.data = this.blF.postNetData();
            this.jeX.parserJson(this.data);
            if (this.blF.aOy().aPa().isRequestSuccess()) {
                aVar.GU(this.data);
                if (this.offset == 0) {
                    if (a.this.jeT == null) {
                        a.this.jeT = new ArrayList();
                    } else {
                        a.this.jeT.clear();
                    }
                    a.this.jeU = 0;
                    if (this.jeZ.booleanValue()) {
                        Cx(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Cx(String str) {
            l<String> ud;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (ud = com.baidu.tbadk.core.c.a.aMT().ud("tb.my_bookmarks")) != null) {
                ud.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.GV(str);
                if (this.jeZ.booleanValue()) {
                    a.this.aJ(arrayList);
                } else {
                    a.this.aK(arrayList);
                }
            } else {
                a.this.aJ(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.jeW.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            a.this.jeQ = null;
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
            if (this.jeX != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jeX.getErrorCode(), this.jeX.getErrorString(), new Object[0]);
            }
            a.this.jeU = aVar.getCount();
            ArrayList<MarkData> csO = aVar.csO();
            if (this.jeZ.booleanValue()) {
                if (csO != null && csO.size() != 0) {
                    a.this.aJ(csO);
                }
            } else {
                a.this.aK(csO);
            }
            Iterator<MarkData> it = csO.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.yW(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.jeW != null) {
                String str = null;
                if (this.blF.aOy().aPa().isRequestSuccess()) {
                    if (this.jeX.getErrorCode() != 0) {
                        str = this.jeX.getErrorString();
                    }
                    a.this.jeW.callback(0, str, false);
                } else {
                    a.this.jeW.callback(3, this.blF.getErrorString());
                }
            }
            a.this.hJY = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x blF;
        private com.baidu.tieba.myCollection.baseEditMark.c jeX;
        final /* synthetic */ a jeY;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jeX = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.csQ();
                this.blF = new x();
                this.blF.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int csR = this.jeY.csR();
                if (aVar.getCount() - 1 <= csR) {
                    csR = aVar.getCount() - 1;
                }
                while (csR >= 0) {
                    String ct = aVar.ct(csR, 20);
                    this.blF.setPostData(new ArrayList<>());
                    this.blF.addPostData("data", ct);
                    this.jeX.parserJson(this.blF.postNetData());
                    if (!this.blF.aOy().aPa().isRequestSuccess() || this.jeX.getErrorCode() != 0) {
                        break;
                    }
                    csR -= 20;
                }
                this.jeY.yY(csR);
                if (csR >= 0) {
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
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            this.jeY.jeR = null;
            if (this.jeY.jeW != null) {
                this.jeY.jeW.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.jeY.jeR = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.blF.aOy().aPa().isRequestSuccess()) {
                str = this.jeX.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.jeY.jeW != null) {
                this.jeY.jeW.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yX(int i) {
        if (this.jeS != null) {
            this.jeS.cancel();
        }
        if (i >= this.jeT.size() || this.jeT.get(i) == null || this.jeT.get(i).getId() == null) {
            return false;
        }
        this.jeS = new C0601a(this.jeT.get(i).getId(), i, this.jeT.get(i).getForumId());
        this.jeS.setPriority(2);
        this.jeS.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0601a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x blF = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jeX;
        private int pos;
        private String tid;

        public C0601a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jeX = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jeX = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.blF.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.blF.addPostData("tid", this.tid);
            this.blF.addPostData("fid", this.fid);
            this.jeX.parserJson(this.blF.postNetData());
            return this.blF.aOy().aPa().isRequestSuccess() && this.jeX.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            a.this.jeS = null;
            if (a.this.jeW != null) {
                a.this.jeW.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jeS = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jeT.size()) {
                    a.this.jeT.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.blF.aOy().aPa().isRequestSuccess()) {
                str = this.jeX.getErrorString();
            } else {
                str = this.blF.getErrorString();
            }
            if (a.this.jeW != null) {
                a.this.jeW.callback(2, bool, str);
            }
        }
    }

    public int csR() {
        return com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yY(int i) {
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.jeQ != null) {
            this.jeQ.cancel();
        }
        if (this.jeR != null) {
            this.jeR.cancel();
        }
        if (this.jeS != null) {
            this.jeS.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jeW = cVar;
    }

    private void csS() {
        if (this.jeT != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jeT.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bs(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bs(String str, int i) {
        if (this.jeT != null && v.getCount(this.jeT) > 0) {
            Iterator<MarkData> it = this.jeT.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
