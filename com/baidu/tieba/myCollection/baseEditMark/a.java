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
    private boolean jMx;
    private b lou = null;
    private c lov = null;
    private C0811a lox = null;
    private int loz = 0;
    private int loA = 0;
    protected com.baidu.tieba.myCollection.c loB = null;
    private ArrayList<MarkData> loy = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.loA;
        aVar.loA = i - 1;
        return i;
    }

    public a() {
        this.jMx = false;
        this.jMx = true;
    }

    public int getOffset() {
        if (this.loy == null) {
            return 0;
        }
        return this.loy.size();
    }

    public int djH() {
        return this.loA;
    }

    public void Gk(int i) {
        this.loA = i;
    }

    public boolean hasMore() {
        return this.loz > 0;
    }

    public void reset() {
        this.loA = 0;
        this.loz = 0;
        this.jMx = true;
    }

    public ArrayList<MarkData> djI() {
        return this.loy;
    }

    public void aZ(ArrayList<MarkData> arrayList) {
        this.loy = arrayList;
    }

    public void ba(ArrayList<MarkData> arrayList) {
        if (this.loy != null && arrayList != null) {
            this.loy.addAll(arrayList);
            djM();
        }
    }

    public void f(MarkData markData) {
        this.loy.add(markData);
    }

    public int getCount() {
        if (this.loy == null) {
            return 0;
        }
        return this.loy.size();
    }

    public int djJ() {
        return this.loz;
    }

    public void djK() {
        ArrayList<MarkData> dQj = com.baidu.tieba.tbadkCore.util.a.dQj();
        if (dQj != null) {
            aZ(dQj);
        }
    }

    public String db(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.loy == null) {
            return null;
        }
        if (i >= this.loy.size()) {
            i2 -= (i - this.loy.size()) - 1;
            i = this.loy.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.loy.get(i5).toJson();
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
                    this.loy.add(markData);
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
        if (this.lou != null) {
            this.lou.cancel();
        }
        this.lou = new b(getOffset());
        this.lou.setPriority(3);
        this.lou.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c loC;
        private int offset;
        private aa cfI = null;
        private String data = null;
        Boolean loE = false;

        public b(int i) {
            this.offset = 0;
            this.loC = null;
            this.offset = i;
            this.loC = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.loE = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.loE.booleanValue() && booleanValue) {
                l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.my_bookmarks");
                if (Bo != null) {
                    publishProgress(Bo.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.loy == null) {
                    a.this.loy = new ArrayList();
                } else {
                    a.this.loy.clear();
                }
                a.this.loz = 0;
            }
            this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cfI.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jMx) {
                this.cfI.addPostData("offset", String.valueOf(0));
            } else {
                this.cfI.addPostData("offset", String.valueOf(this.offset));
            }
            this.cfI.addPostData("rn", String.valueOf(20));
            this.data = this.cfI.postNetData();
            this.loC.parserJson(this.data);
            if (this.cfI.btv().buf().isRequestSuccess()) {
                aVar.Py(this.data);
                if (this.offset == 0) {
                    if (a.this.loy == null) {
                        a.this.loy = new ArrayList();
                    } else {
                        a.this.loy.clear();
                    }
                    a.this.loz = 0;
                    if (this.loE.booleanValue()) {
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
                if (this.loE.booleanValue()) {
                    a.this.aZ(arrayList);
                } else {
                    a.this.ba(arrayList);
                }
            } else {
                a.this.aZ(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.loB.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            a.this.lou = null;
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
            if (this.loC != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.loC.getErrorCode(), this.loC.getErrorString(), new Object[0]);
            }
            a.this.loz = aVar.getCount();
            ArrayList<MarkData> djI = aVar.djI();
            if (this.loE.booleanValue()) {
                if (djI != null && djI.size() != 0) {
                    a.this.aZ(djI);
                }
            } else {
                a.this.ba(djI);
            }
            Iterator<MarkData> it = djI.iterator();
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
            if (a.this.loB != null) {
                String str = null;
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    if (this.loC.getErrorCode() != 0) {
                        str = this.loC.getErrorString();
                    }
                    a.this.loB.callback(0, str, false);
                } else {
                    a.this.loB.callback(3, this.cfI.getErrorString());
                }
            }
            a.this.jMx = false;
        }
    }

    /* loaded from: classes24.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa cfI;
        private com.baidu.tieba.myCollection.baseEditMark.c loC;
        final /* synthetic */ a loD;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.loC = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.djK();
                this.cfI = new aa();
                this.cfI.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int djL = this.loD.djL();
                if (aVar.getCount() - 1 <= djL) {
                    djL = aVar.getCount() - 1;
                }
                while (djL >= 0) {
                    String db = aVar.db(djL, 20);
                    this.cfI.setPostData(new ArrayList<>());
                    this.cfI.addPostData("data", db);
                    this.loC.parserJson(this.cfI.postNetData());
                    if (!this.cfI.btv().buf().isRequestSuccess() || this.loC.getErrorCode() != 0) {
                        break;
                    }
                    djL -= 20;
                }
                this.loD.Gm(djL);
                if (djL >= 0) {
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
            this.loD.lov = null;
            if (this.loD.loB != null) {
                this.loD.loB.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.loD.lov = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cfI.btv().buf().isRequestSuccess()) {
                str = this.loC.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.loD.loB != null) {
                this.loD.loB.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Gl(int i) {
        if (this.lox != null) {
            this.lox.cancel();
        }
        if (i >= this.loy.size() || this.loy.get(i) == null || this.loy.get(i).getId() == null) {
            return false;
        }
        this.lox = new C0811a(this.loy.get(i).getId(), i, this.loy.get(i).getForumId());
        this.lox.setPriority(2);
        this.lox.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0811a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cfI = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c loC;
        private int pos;
        private String tid;

        public C0811a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.loC = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.loC = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.loC.parserJson(this.cfI.postNetData());
            return this.cfI.btv().buf().isRequestSuccess() && this.loC.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            a.this.lox = null;
            if (a.this.loB != null) {
                a.this.loB.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.lox = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.loy.size()) {
                    a.this.loy.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cfI.btv().buf().isRequestSuccess()) {
                str = this.loC.getErrorString();
            } else {
                str = this.cfI.getErrorString();
            }
            if (a.this.loB != null) {
                a.this.loB.callback(2, bool, str);
            }
        }
    }

    public int djL() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Gm(int i) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.lou != null) {
            this.lou.cancel();
        }
        if (this.lov != null) {
            this.lov.cancel();
        }
        if (this.lox != null) {
            this.lox.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.loB = cVar;
    }

    private void djM() {
        if (this.loy != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.loy.iterator();
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
        if (this.loy != null && y.getCount(this.loy) > 0) {
            Iterator<MarkData> it = this.loy.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
