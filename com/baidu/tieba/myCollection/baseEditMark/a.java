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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean inP;
    private b jMu = null;
    private c jMv = null;
    private C0686a jMw = null;
    private int jMy = 0;
    private int jMz = 0;
    protected com.baidu.tieba.myCollection.c jMA = null;
    private ArrayList<MarkData> jMx = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.jMz;
        aVar.jMz = i - 1;
        return i;
    }

    public a() {
        this.inP = false;
        this.inP = true;
    }

    public int getOffset() {
        if (this.jMx == null) {
            return 0;
        }
        return this.jMx.size();
    }

    public int cDC() {
        return this.jMz;
    }

    public void As(int i) {
        this.jMz = i;
    }

    public boolean hasMore() {
        return this.jMy > 0;
    }

    public void reset() {
        this.jMz = 0;
        this.jMy = 0;
        this.inP = true;
    }

    public ArrayList<MarkData> cDD() {
        return this.jMx;
    }

    public void aK(ArrayList<MarkData> arrayList) {
        this.jMx = arrayList;
    }

    public void aL(ArrayList<MarkData> arrayList) {
        if (this.jMx != null && arrayList != null) {
            this.jMx.addAll(arrayList);
            cDH();
        }
    }

    public void f(MarkData markData) {
        this.jMx.add(markData);
    }

    public int getCount() {
        if (this.jMx == null) {
            return 0;
        }
        return this.jMx.size();
    }

    public int cDE() {
        return this.jMy;
    }

    public void cDF() {
        ArrayList<MarkData> diU = com.baidu.tieba.tbadkCore.util.a.diU();
        if (diU != null) {
            aK(diU);
        }
    }

    public String cE(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jMx == null) {
            return null;
        }
        if (i >= this.jMx.size()) {
            i2 -= (i - this.jMx.size()) - 1;
            i = this.jMx.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jMx.get(i5).toJson();
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

    public void Jj(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Jk(String str) {
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
                    this.jMx.add(markData);
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
        if (this.jMu != null) {
            this.jMu.cancel();
        }
        this.jMu = new b(getOffset());
        this.jMu.setPriority(3);
        this.jMu.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jMB;
        private int offset;
        private y byb = null;
        private String data = null;
        Boolean jMD = false;

        public b(int i) {
            this.offset = 0;
            this.jMB = null;
            this.offset = i;
            this.jMB = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jMD = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jMD.booleanValue() && booleanValue) {
                l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.my_bookmarks");
                if (wc != null) {
                    publishProgress(wc.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jMx == null) {
                    a.this.jMx = new ArrayList();
                } else {
                    a.this.jMx.clear();
                }
                a.this.jMy = 0;
            }
            this.byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.byb.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.inP) {
                this.byb.addPostData("offset", String.valueOf(0));
            } else {
                this.byb.addPostData("offset", String.valueOf(this.offset));
            }
            this.byb.addPostData("rn", String.valueOf(20));
            this.data = this.byb.postNetData();
            this.jMB.parserJson(this.data);
            if (this.byb.aWu().aWW().isRequestSuccess()) {
                aVar.Jj(this.data);
                if (this.offset == 0) {
                    if (a.this.jMx == null) {
                        a.this.jMx = new ArrayList();
                    } else {
                        a.this.jMx.clear();
                    }
                    a.this.jMy = 0;
                    if (this.jMD.booleanValue()) {
                        EK(this.data);
                    }
                }
            }
            return aVar;
        }

        private void EK(String str) {
            l<String> wc;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.my_bookmarks")) != null) {
                wc.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Jk(str);
                if (this.jMD.booleanValue()) {
                    a.this.aK(arrayList);
                } else {
                    a.this.aL(arrayList);
                }
            } else {
                a.this.aK(arrayList);
            }
            if (!w.isEmpty(arrayList)) {
                a.this.jMA.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            a.this.jMu = null;
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
            if (this.jMB != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jMB.getErrorCode(), this.jMB.getErrorString(), new Object[0]);
            }
            a.this.jMy = aVar.getCount();
            ArrayList<MarkData> cDD = aVar.cDD();
            if (this.jMD.booleanValue()) {
                if (cDD != null && cDD.size() != 0) {
                    a.this.aK(cDD);
                }
            } else {
                a.this.aL(cDD);
            }
            Iterator<MarkData> it = cDD.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.As(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.jMA != null) {
                String str = null;
                if (this.byb.aWu().aWW().isRequestSuccess()) {
                    if (this.jMB.getErrorCode() != 0) {
                        str = this.jMB.getErrorString();
                    }
                    a.this.jMA.callback(0, str, false);
                } else {
                    a.this.jMA.callback(3, this.byb.getErrorString());
                }
            }
            a.this.inP = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private y byb;
        private com.baidu.tieba.myCollection.baseEditMark.c jMB;
        final /* synthetic */ a jMC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jMB = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cDF();
                this.byb = new y();
                this.byb.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cDG = this.jMC.cDG();
                if (aVar.getCount() - 1 <= cDG) {
                    cDG = aVar.getCount() - 1;
                }
                while (cDG >= 0) {
                    String cE = aVar.cE(cDG, 20);
                    this.byb.setPostData(new ArrayList<>());
                    this.byb.addPostData("data", cE);
                    this.jMB.parserJson(this.byb.postNetData());
                    if (!this.byb.aWu().aWW().isRequestSuccess() || this.jMB.getErrorCode() != 0) {
                        break;
                    }
                    cDG -= 20;
                }
                this.jMC.Au(cDG);
                if (cDG >= 0) {
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
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            this.jMC.jMv = null;
            if (this.jMC.jMA != null) {
                this.jMC.jMA.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.jMC.jMv = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.byb.aWu().aWW().isRequestSuccess()) {
                str = this.jMB.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.jMC.jMA != null) {
                this.jMC.jMA.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean At(int i) {
        if (this.jMw != null) {
            this.jMw.cancel();
        }
        if (i >= this.jMx.size() || this.jMx.get(i) == null || this.jMx.get(i).getId() == null) {
            return false;
        }
        this.jMw = new C0686a(this.jMx.get(i).getId(), i, this.jMx.get(i).getForumId());
        this.jMw.setPriority(2);
        this.jMw.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0686a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private y byb = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jMB;
        private int pos;
        private String tid;

        public C0686a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jMB = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jMB = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.byb.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.byb.addPostData("tid", this.tid);
            this.byb.addPostData("fid", this.fid);
            this.jMB.parserJson(this.byb.postNetData());
            return this.byb.aWu().aWW().isRequestSuccess() && this.jMB.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            a.this.jMw = null;
            if (a.this.jMA != null) {
                a.this.jMA.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jMw = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jMx.size()) {
                    a.this.jMx.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.byb.aWu().aWW().isRequestSuccess()) {
                str = this.jMB.getErrorString();
            } else {
                str = this.byb.getErrorString();
            }
            if (a.this.jMA != null) {
                a.this.jMA.callback(2, bool, str);
            }
        }
    }

    public int cDG() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Au(int i) {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.jMu != null) {
            this.jMu.cancel();
        }
        if (this.jMv != null) {
            this.jMv.cancel();
        }
        if (this.jMw != null) {
            this.jMw.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jMA = cVar;
    }

    private void cDH() {
        if (this.jMx != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jMx.iterator();
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
        if (this.jMx != null && w.getCount(this.jMx) > 0) {
            Iterator<MarkData> it = this.jMx.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
