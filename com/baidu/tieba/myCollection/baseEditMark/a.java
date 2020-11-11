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
    private boolean jye;
    private b laC = null;
    private c laD = null;
    private C0793a laE = null;
    private int laG = 0;
    private int laH = 0;
    protected com.baidu.tieba.myCollection.c laI = null;
    private ArrayList<MarkData> laF = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.laH;
        aVar.laH = i - 1;
        return i;
    }

    public a() {
        this.jye = false;
        this.jye = true;
    }

    public int getOffset() {
        if (this.laF == null) {
            return 0;
        }
        return this.laF.size();
    }

    public int deY() {
        return this.laH;
    }

    public void EX(int i) {
        this.laH = i;
    }

    public boolean hasMore() {
        return this.laG > 0;
    }

    public void reset() {
        this.laH = 0;
        this.laG = 0;
        this.jye = true;
    }

    public ArrayList<MarkData> deZ() {
        return this.laF;
    }

    public void aW(ArrayList<MarkData> arrayList) {
        this.laF = arrayList;
    }

    public void aX(ArrayList<MarkData> arrayList) {
        if (this.laF != null && arrayList != null) {
            this.laF.addAll(arrayList);
            dfd();
        }
    }

    public void f(MarkData markData) {
        this.laF.add(markData);
    }

    public int getCount() {
        if (this.laF == null) {
            return 0;
        }
        return this.laF.size();
    }

    public int dfa() {
        return this.laG;
    }

    public void dfb() {
        ArrayList<MarkData> dKS = com.baidu.tieba.tbadkCore.util.a.dKS();
        if (dKS != null) {
            aW(dKS);
        }
    }

    public String cW(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.laF == null) {
            return null;
        }
        if (i >= this.laF.size()) {
            i2 -= (i - this.laF.size()) - 1;
            i = this.laF.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.laF.get(i5).toJson();
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

    public void OU(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> OV(String str) {
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
                    this.laF.add(markData);
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
        if (this.laC != null) {
            this.laC.cancel();
        }
        this.laC = new b(getOffset());
        this.laC.setPriority(3);
        this.laC.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c laJ;
        private int offset;
        private aa caS = null;
        private String data = null;
        Boolean laL = false;

        public b(int i) {
            this.offset = 0;
            this.laJ = null;
            this.offset = i;
            this.laJ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.laL = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.laL.booleanValue() && booleanValue) {
                l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.my_bookmarks");
                if (Bm != null) {
                    publishProgress(Bm.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.laF == null) {
                    a.this.laF = new ArrayList();
                } else {
                    a.this.laF.clear();
                }
                a.this.laG = 0;
            }
            this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.caS.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jye) {
                this.caS.addPostData("offset", String.valueOf(0));
            } else {
                this.caS.addPostData("offset", String.valueOf(this.offset));
            }
            this.caS.addPostData("rn", String.valueOf(20));
            this.data = this.caS.postNetData();
            this.laJ.parserJson(this.data);
            if (this.caS.bqN().bru().isRequestSuccess()) {
                aVar.OU(this.data);
                if (this.offset == 0) {
                    if (a.this.laF == null) {
                        a.this.laF = new ArrayList();
                    } else {
                        a.this.laF.clear();
                    }
                    a.this.laG = 0;
                    if (this.laL.booleanValue()) {
                        JX(this.data);
                    }
                }
            }
            return aVar;
        }

        private void JX(String str) {
            l<String> Bm;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.my_bookmarks")) != null) {
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
                arrayList = a.this.OV(str);
                if (this.laL.booleanValue()) {
                    a.this.aW(arrayList);
                } else {
                    a.this.aX(arrayList);
                }
            } else {
                a.this.aW(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.laI.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            a.this.laC = null;
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
            if (this.laJ != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.laJ.getErrorCode(), this.laJ.getErrorString(), new Object[0]);
            }
            a.this.laG = aVar.getCount();
            ArrayList<MarkData> deZ = aVar.deZ();
            if (this.laL.booleanValue()) {
                if (deZ != null && deZ.size() != 0) {
                    a.this.aW(deZ);
                }
            } else {
                a.this.aX(deZ);
            }
            Iterator<MarkData> it = deZ.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.EX(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.laI != null) {
                String str = null;
                if (this.caS.bqN().bru().isRequestSuccess()) {
                    if (this.laJ.getErrorCode() != 0) {
                        str = this.laJ.getErrorString();
                    }
                    a.this.laI.callback(0, str, false);
                } else {
                    a.this.laI.callback(3, this.caS.getErrorString());
                }
            }
            a.this.jye = false;
        }
    }

    /* loaded from: classes24.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa caS;
        private com.baidu.tieba.myCollection.baseEditMark.c laJ;
        final /* synthetic */ a laK;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.laJ = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dfb();
                this.caS = new aa();
                this.caS.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dfc = this.laK.dfc();
                if (aVar.getCount() - 1 <= dfc) {
                    dfc = aVar.getCount() - 1;
                }
                while (dfc >= 0) {
                    String cW = aVar.cW(dfc, 20);
                    this.caS.setPostData(new ArrayList<>());
                    this.caS.addPostData("data", cW);
                    this.laJ.parserJson(this.caS.postNetData());
                    if (!this.caS.bqN().bru().isRequestSuccess() || this.laJ.getErrorCode() != 0) {
                        break;
                    }
                    dfc -= 20;
                }
                this.laK.EZ(dfc);
                if (dfc >= 0) {
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
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            this.laK.laD = null;
            if (this.laK.laI != null) {
                this.laK.laI.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.laK.laD = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.caS.bqN().bru().isRequestSuccess()) {
                str = this.laJ.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.laK.laI != null) {
                this.laK.laI.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean EY(int i) {
        if (this.laE != null) {
            this.laE.cancel();
        }
        if (i >= this.laF.size() || this.laF.get(i) == null || this.laF.get(i).getId() == null) {
            return false;
        }
        this.laE = new C0793a(this.laF.get(i).getId(), i, this.laF.get(i).getForumId());
        this.laE.setPriority(2);
        this.laE.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0793a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa caS = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c laJ;
        private int pos;
        private String tid;

        public C0793a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.laJ = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.laJ = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.caS.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.caS.addPostData("tid", this.tid);
            this.caS.addPostData("fid", this.fid);
            this.laJ.parserJson(this.caS.postNetData());
            return this.caS.bqN().bru().isRequestSuccess() && this.laJ.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            a.this.laE = null;
            if (a.this.laI != null) {
                a.this.laI.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.laE = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.laF.size()) {
                    a.this.laF.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.caS.bqN().bru().isRequestSuccess()) {
                str = this.laJ.getErrorString();
            } else {
                str = this.caS.getErrorString();
            }
            if (a.this.laI != null) {
                a.this.laI.callback(2, bool, str);
            }
        }
    }

    public int dfc() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void EZ(int i) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.laC != null) {
            this.laC.cancel();
        }
        if (this.laD != null) {
            this.laD.cancel();
        }
        if (this.laE != null) {
            this.laE.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.laI = cVar;
    }

    private void dfd() {
        if (this.laF != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.laF.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    by(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void by(String str, int i) {
        if (this.laF != null && y.getCount(this.laF) > 0) {
            Iterator<MarkData> it = this.laF.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
