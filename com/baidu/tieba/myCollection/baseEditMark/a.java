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
    private boolean jMz;
    private b lox = null;
    private c loy = null;
    private C0811a loz = null;
    private int loB = 0;
    private int loC = 0;
    protected com.baidu.tieba.myCollection.c loD = null;
    private ArrayList<MarkData> loA = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.loC;
        aVar.loC = i - 1;
        return i;
    }

    public a() {
        this.jMz = false;
        this.jMz = true;
    }

    public int getOffset() {
        if (this.loA == null) {
            return 0;
        }
        return this.loA.size();
    }

    public int djI() {
        return this.loC;
    }

    public void Gk(int i) {
        this.loC = i;
    }

    public boolean hasMore() {
        return this.loB > 0;
    }

    public void reset() {
        this.loC = 0;
        this.loB = 0;
        this.jMz = true;
    }

    public ArrayList<MarkData> djJ() {
        return this.loA;
    }

    public void aZ(ArrayList<MarkData> arrayList) {
        this.loA = arrayList;
    }

    public void ba(ArrayList<MarkData> arrayList) {
        if (this.loA != null && arrayList != null) {
            this.loA.addAll(arrayList);
            djN();
        }
    }

    public void f(MarkData markData) {
        this.loA.add(markData);
    }

    public int getCount() {
        if (this.loA == null) {
            return 0;
        }
        return this.loA.size();
    }

    public int djK() {
        return this.loB;
    }

    public void djL() {
        ArrayList<MarkData> dQk = com.baidu.tieba.tbadkCore.util.a.dQk();
        if (dQk != null) {
            aZ(dQk);
        }
    }

    public String db(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.loA == null) {
            return null;
        }
        if (i >= this.loA.size()) {
            i2 -= (i - this.loA.size()) - 1;
            i = this.loA.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.loA.get(i5).toJson();
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

    public void Py(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Pz(String str) {
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
                    this.loA.add(markData);
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
        if (this.lox != null) {
            this.lox.cancel();
        }
        this.lox = new b(getOffset());
        this.lox.setPriority(3);
        this.lox.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c loE;
        private int offset;
        private aa cfI = null;
        private String data = null;
        Boolean loG = false;

        public b(int i) {
            this.offset = 0;
            this.loE = null;
            this.offset = i;
            this.loE = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.loG = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.loG.booleanValue() && booleanValue) {
                l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.my_bookmarks");
                if (Bo != null) {
                    publishProgress(Bo.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.loA == null) {
                    a.this.loA = new ArrayList();
                } else {
                    a.this.loA.clear();
                }
                a.this.loB = 0;
            }
            this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cfI.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jMz) {
                this.cfI.addPostData("offset", String.valueOf(0));
            } else {
                this.cfI.addPostData("offset", String.valueOf(this.offset));
            }
            this.cfI.addPostData("rn", String.valueOf(20));
            this.data = this.cfI.postNetData();
            this.loE.parserJson(this.data);
            if (this.cfI.btv().buf().isRequestSuccess()) {
                aVar.Py(this.data);
                if (this.offset == 0) {
                    if (a.this.loA == null) {
                        a.this.loA = new ArrayList();
                    } else {
                        a.this.loA.clear();
                    }
                    a.this.loB = 0;
                    if (this.loG.booleanValue()) {
                        Ko(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Ko(String str) {
            l<String> Bo;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.my_bookmarks")) != null) {
                Bo.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Pz(str);
                if (this.loG.booleanValue()) {
                    a.this.aZ(arrayList);
                } else {
                    a.this.ba(arrayList);
                }
            } else {
                a.this.aZ(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.loD.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            a.this.lox = null;
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
            if (this.loE != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.loE.getErrorCode(), this.loE.getErrorString(), new Object[0]);
            }
            a.this.loB = aVar.getCount();
            ArrayList<MarkData> djJ = aVar.djJ();
            if (this.loG.booleanValue()) {
                if (djJ != null && djJ.size() != 0) {
                    a.this.aZ(djJ);
                }
            } else {
                a.this.ba(djJ);
            }
            Iterator<MarkData> it = djJ.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.Gk(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.loD != null) {
                String str = null;
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    if (this.loE.getErrorCode() != 0) {
                        str = this.loE.getErrorString();
                    }
                    a.this.loD.callback(0, str, false);
                } else {
                    a.this.loD.callback(3, this.cfI.getErrorString());
                }
            }
            a.this.jMz = false;
        }
    }

    /* loaded from: classes24.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa cfI;
        private com.baidu.tieba.myCollection.baseEditMark.c loE;
        final /* synthetic */ a loF;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.loE = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.djL();
                this.cfI = new aa();
                this.cfI.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int djM = this.loF.djM();
                if (aVar.getCount() - 1 <= djM) {
                    djM = aVar.getCount() - 1;
                }
                while (djM >= 0) {
                    String db = aVar.db(djM, 20);
                    this.cfI.setPostData(new ArrayList<>());
                    this.cfI.addPostData("data", db);
                    this.loE.parserJson(this.cfI.postNetData());
                    if (!this.cfI.btv().buf().isRequestSuccess() || this.loE.getErrorCode() != 0) {
                        break;
                    }
                    djM -= 20;
                }
                this.loF.Gm(djM);
                if (djM >= 0) {
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
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            this.loF.loy = null;
            if (this.loF.loD != null) {
                this.loF.loD.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.loF.loy = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cfI.btv().buf().isRequestSuccess()) {
                str = this.loE.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.loF.loD != null) {
                this.loF.loD.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Gl(int i) {
        if (this.loz != null) {
            this.loz.cancel();
        }
        if (i >= this.loA.size() || this.loA.get(i) == null || this.loA.get(i).getId() == null) {
            return false;
        }
        this.loz = new C0811a(this.loA.get(i).getId(), i, this.loA.get(i).getForumId());
        this.loz.setPriority(2);
        this.loz.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0811a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cfI = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c loE;
        private int pos;
        private String tid;

        public C0811a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.loE = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.loE = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cfI.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cfI.addPostData("tid", this.tid);
            this.cfI.addPostData("fid", this.fid);
            this.loE.parserJson(this.cfI.postNetData());
            return this.cfI.btv().buf().isRequestSuccess() && this.loE.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            a.this.loz = null;
            if (a.this.loD != null) {
                a.this.loD.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.loz = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.loA.size()) {
                    a.this.loA.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cfI.btv().buf().isRequestSuccess()) {
                str = this.loE.getErrorString();
            } else {
                str = this.cfI.getErrorString();
            }
            if (a.this.loD != null) {
                a.this.loD.callback(2, bool, str);
            }
        }
    }

    public int djM() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Gm(int i) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.lox != null) {
            this.lox.cancel();
        }
        if (this.loy != null) {
            this.loy.cancel();
        }
        if (this.loz != null) {
            this.loz.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.loD = cVar;
    }

    private void djN() {
        if (this.loA != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.loA.iterator();
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
        if (this.loA != null && y.getCount(this.loA) > 0) {
            Iterator<MarkData> it = this.loA.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
