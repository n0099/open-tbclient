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
/* loaded from: classes7.dex */
public class a {
    private boolean jVi;
    private b lpg = null;
    private c lph = null;
    private C0797a lpi = null;
    private int lpk = 0;
    private int lpl = 0;
    protected com.baidu.tieba.myCollection.c lpm = null;
    private ArrayList<MarkData> lpj = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.lpl;
        aVar.lpl = i - 1;
        return i;
    }

    public a() {
        this.jVi = false;
        this.jVi = true;
    }

    public int getOffset() {
        if (this.lpj == null) {
            return 0;
        }
        return this.lpj.size();
    }

    public int dfF() {
        return this.lpl;
    }

    public void Ew(int i) {
        this.lpl = i;
    }

    public boolean hasMore() {
        return this.lpk > 0;
    }

    public void reset() {
        this.lpl = 0;
        this.lpk = 0;
        this.jVi = true;
    }

    public ArrayList<MarkData> dfG() {
        return this.lpj;
    }

    public void aU(ArrayList<MarkData> arrayList) {
        this.lpj = arrayList;
    }

    public void aV(ArrayList<MarkData> arrayList) {
        if (this.lpj != null && arrayList != null) {
            this.lpj.addAll(arrayList);
            dfK();
        }
    }

    public void f(MarkData markData) {
        this.lpj.add(markData);
    }

    public int getCount() {
        if (this.lpj == null) {
            return 0;
        }
        return this.lpj.size();
    }

    public int dfH() {
        return this.lpk;
    }

    public void dfI() {
        ArrayList<MarkData> dMp = com.baidu.tieba.tbadkCore.util.a.dMp();
        if (dMp != null) {
            aU(dMp);
        }
    }

    public String cX(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.lpj == null) {
            return null;
        }
        if (i >= this.lpj.size()) {
            i2 -= (i - this.lpj.size()) - 1;
            i = this.lpj.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.lpj.get(i5).toJson();
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

    public void NW(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> NX(String str) {
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
                    this.lpj.add(markData);
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
        if (this.lpg != null) {
            this.lpg.cancel();
        }
        this.lpg = new b(getOffset());
        this.lpg.setPriority(3);
        this.lpg.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c lpn;
        private int offset;
        private z chV = null;
        private String data = null;
        Boolean lpp = false;

        public b(int i) {
            this.offset = 0;
            this.lpn = null;
            this.offset = i;
            this.lpn = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.lpp = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.lpp.booleanValue() && booleanValue) {
                l<String> Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.my_bookmarks");
                if (Ab != null) {
                    publishProgress(Ab.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.lpj == null) {
                    a.this.lpj = new ArrayList();
                } else {
                    a.this.lpj.clear();
                }
                a.this.lpk = 0;
            }
            this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.chV.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jVi) {
                this.chV.addPostData("offset", String.valueOf(0));
            } else {
                this.chV.addPostData("offset", String.valueOf(this.offset));
            }
            this.chV.addPostData("rn", String.valueOf(20));
            this.data = this.chV.postNetData();
            this.lpn.parserJson(this.data);
            if (this.chV.brX().bsH().isRequestSuccess()) {
                aVar.NW(this.data);
                if (this.offset == 0) {
                    if (a.this.lpj == null) {
                        a.this.lpj = new ArrayList();
                    } else {
                        a.this.lpj.clear();
                    }
                    a.this.lpk = 0;
                    if (this.lpp.booleanValue()) {
                        Ja(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Ja(String str) {
            l<String> Ab;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (Ab = com.baidu.tbadk.core.c.a.bpZ().Ab("tb.my_bookmarks")) != null) {
                Ab.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.NX(str);
                if (this.lpp.booleanValue()) {
                    a.this.aU(arrayList);
                } else {
                    a.this.aV(arrayList);
                }
            } else {
                a.this.aU(arrayList);
            }
            if (!x.isEmpty(arrayList)) {
                a.this.lpm.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            a.this.lpg = null;
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
            if (this.lpn != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.lpn.getErrorCode(), this.lpn.getErrorString(), new Object[0]);
            }
            a.this.lpk = aVar.getCount();
            ArrayList<MarkData> dfG = aVar.dfG();
            if (this.lpp.booleanValue()) {
                if (dfG != null && dfG.size() != 0) {
                    a.this.aU(dfG);
                }
            } else {
                a.this.aV(dfG);
            }
            Iterator<MarkData> it = dfG.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.Ew(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.lpm != null) {
                String str = null;
                if (this.chV.brX().bsH().isRequestSuccess()) {
                    if (this.lpn.getErrorCode() != 0) {
                        str = this.lpn.getErrorString();
                    }
                    a.this.lpm.callback(0, str, false);
                } else {
                    a.this.lpm.callback(3, this.chV.getErrorString());
                }
            }
            a.this.jVi = false;
        }
    }

    /* loaded from: classes7.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private z chV;
        private com.baidu.tieba.myCollection.baseEditMark.c lpn;
        final /* synthetic */ a lpo;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.lpn = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dfI();
                this.chV = new z();
                this.chV.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dfJ = this.lpo.dfJ();
                if (aVar.getCount() - 1 <= dfJ) {
                    dfJ = aVar.getCount() - 1;
                }
                while (dfJ >= 0) {
                    String cX = aVar.cX(dfJ, 20);
                    this.chV.setPostData(new ArrayList<>());
                    this.chV.addPostData("data", cX);
                    this.lpn.parserJson(this.chV.postNetData());
                    if (!this.chV.brX().bsH().isRequestSuccess() || this.lpn.getErrorCode() != 0) {
                        break;
                    }
                    dfJ -= 20;
                }
                this.lpo.Ey(dfJ);
                if (dfJ >= 0) {
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
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            this.lpo.lph = null;
            if (this.lpo.lpm != null) {
                this.lpo.lpm.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean z;
            String str = null;
            this.lpo.lph = null;
            if (bool.booleanValue()) {
                z = false;
            } else if (this.chV.brX().bsH().isRequestSuccess()) {
                str = this.lpn.getErrorString();
                z = false;
            } else {
                z = true;
            }
            if (this.lpo.lpm != null) {
                this.lpo.lpm.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Ex(int i) {
        if (this.lpi != null) {
            this.lpi.cancel();
        }
        if (i >= this.lpj.size() || this.lpj.get(i) == null || this.lpj.get(i).getId() == null) {
            return false;
        }
        this.lpi = new C0797a(this.lpj.get(i).getId(), i, this.lpj.get(i).getForumId());
        this.lpi.setPriority(2);
        this.lpi.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0797a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z chV = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c lpn;
        private int pos;
        private String tid;

        public C0797a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.lpn = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.lpn = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.chV.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.chV.addPostData("tid", this.tid);
            this.chV.addPostData("fid", this.fid);
            this.lpn.parserJson(this.chV.postNetData());
            return this.chV.brX().bsH().isRequestSuccess() && this.lpn.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            a.this.lpi = null;
            if (a.this.lpm != null) {
                a.this.lpm.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.lpi = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.lpj.size()) {
                    a.this.lpj.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.chV.brX().bsH().isRequestSuccess()) {
                str = this.lpn.getErrorString();
            } else {
                str = this.chV.getErrorString();
            }
            if (a.this.lpm != null) {
                a.this.lpm.callback(2, bool, str);
            }
        }
    }

    public int dfJ() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Ey(int i) {
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.lpg != null) {
            this.lpg.cancel();
        }
        if (this.lph != null) {
            this.lph.cancel();
        }
        if (this.lpi != null) {
            this.lpi.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.lpm = cVar;
    }

    private void dfK() {
        if (this.lpj != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.lpj.iterator();
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
        if (this.lpj != null && x.getCount(this.lpj) > 0) {
            Iterator<MarkData> it = this.lpj.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
