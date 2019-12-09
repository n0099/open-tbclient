package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes6.dex */
public class a {
    private boolean gfR;
    private b hzu = null;
    private c hzv = null;
    private C0464a hzw = null;
    private int hzy = 0;
    private int hzz = 0;
    protected com.baidu.tieba.myCollection.c hzA = null;
    private ArrayList<MarkData> hzx = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hzz;
        aVar.hzz = i - 1;
        return i;
    }

    public a() {
        this.gfR = false;
        this.gfR = true;
    }

    public int getOffset() {
        if (this.hzx == null) {
            return 0;
        }
        return this.hzx.size();
    }

    public int bNK() {
        return this.hzz;
    }

    public void wa(int i) {
        this.hzz = i;
    }

    public boolean hasMore() {
        return this.hzy > 0;
    }

    public void reset() {
        this.hzz = 0;
        this.hzy = 0;
        this.gfR = true;
    }

    public ArrayList<MarkData> bNL() {
        return this.hzx;
    }

    public void aw(ArrayList<MarkData> arrayList) {
        this.hzx = arrayList;
    }

    public void ax(ArrayList<MarkData> arrayList) {
        if (this.hzx != null && arrayList != null) {
            this.hzx.addAll(arrayList);
            bNP();
        }
    }

    public void f(MarkData markData) {
        this.hzx.add(markData);
    }

    public int getCount() {
        if (this.hzx == null) {
            return 0;
        }
        return this.hzx.size();
    }

    public int bNM() {
        return this.hzy;
    }

    public void bNN() {
        ArrayList<MarkData> cpk = com.baidu.tieba.tbadkCore.util.a.cpk();
        if (cpk != null) {
            aw(cpk);
        }
    }

    public String bT(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hzx == null) {
            return null;
        }
        if (i >= this.hzx.size()) {
            i2 -= (i - this.hzx.size()) - 1;
            i = this.hzx.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hzx.get(i5).toJson();
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

    public void Af(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Ag(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString("errno").equals("0")) {
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
            if (jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR).optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.hzx.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void g(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.hzu != null) {
            this.hzu.cancel();
        }
        this.hzu = new b(getOffset());
        this.hzu.setPriority(3);
        this.hzu.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hzB;
        private int offset;
        private x bUY = null;
        private String data = null;
        Boolean hzD = false;

        public b(int i) {
            this.offset = 0;
            this.hzB = null;
            this.offset = i;
            this.hzB = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.hzD = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hzD.booleanValue() && booleanValue) {
                l<String> nl = com.baidu.tbadk.core.d.a.akL().nl("tb.my_bookmarks");
                if (nl != null) {
                    publishProgress(nl.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hzx == null) {
                    a.this.hzx = new ArrayList();
                } else {
                    a.this.hzx.clear();
                }
                a.this.hzy = 0;
            }
            this.bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bUY.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gfR) {
                this.bUY.addPostData("offset", String.valueOf(0));
            } else {
                this.bUY.addPostData("offset", String.valueOf(this.offset));
            }
            this.bUY.addPostData("rn", String.valueOf(20));
            this.data = this.bUY.postNetData();
            this.hzB.parserJson(this.data);
            if (this.bUY.amp().amQ().isRequestSuccess()) {
                aVar.Af(this.data);
                if (this.offset == 0) {
                    if (a.this.hzx == null) {
                        a.this.hzx = new ArrayList();
                    } else {
                        a.this.hzx.clear();
                    }
                    a.this.hzy = 0;
                    if (this.hzD.booleanValue()) {
                        vs(this.data);
                    }
                }
            }
            return aVar;
        }

        private void vs(String str) {
            l<String> nl;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (nl = com.baidu.tbadk.core.d.a.akL().nl("tb.my_bookmarks")) != null) {
                nl.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Ag(str);
                if (this.hzD.booleanValue()) {
                    a.this.aw(arrayList);
                } else {
                    a.this.ax(arrayList);
                }
            } else {
                a.this.aw(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.hzA.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            a.this.hzu = null;
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
            if (this.hzB != null) {
                com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "collection_thread_list_result", this.hzB.getErrorCode(), this.hzB.getErrorString(), new Object[0]);
            }
            a.this.hzy = aVar.getCount();
            ArrayList<MarkData> bNL = aVar.bNL();
            if (this.hzD.booleanValue()) {
                if (bNL != null && bNL.size() != 0) {
                    a.this.aw(bNL);
                }
            } else {
                a.this.ax(bNL);
            }
            Iterator<MarkData> it = bNL.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.wa(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hzA != null) {
                String str = null;
                if (this.bUY.amp().amQ().isRequestSuccess()) {
                    if (this.hzB.getErrorCode() != 0) {
                        str = this.hzB.getErrorString();
                    }
                    a.this.hzA.callback(0, str, false);
                } else {
                    a.this.hzA.callback(3, this.bUY.getErrorString());
                }
            }
            a.this.gfR = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x bUY;
        private com.baidu.tieba.myCollection.baseEditMark.c hzB;
        final /* synthetic */ a hzC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hzB = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bNN();
                this.bUY = new x();
                this.bUY.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bNO = this.hzC.bNO();
                if (aVar.getCount() - 1 <= bNO) {
                    bNO = aVar.getCount() - 1;
                }
                while (bNO >= 0) {
                    String bT = aVar.bT(bNO, 20);
                    this.bUY.setPostData(new ArrayList<>());
                    this.bUY.addPostData("data", bT);
                    this.hzB.parserJson(this.bUY.postNetData());
                    if (!this.bUY.amp().amQ().isRequestSuccess() || this.hzB.getErrorCode() != 0) {
                        break;
                    }
                    bNO -= 20;
                }
                this.hzC.wc(bNO);
                if (bNO >= 0) {
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
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            this.hzC.hzv = null;
            if (this.hzC.hzA != null) {
                this.hzC.hzA.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hzC.hzv = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bUY.amp().amQ().isRequestSuccess()) {
                str = this.hzB.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hzC.hzA != null) {
                this.hzC.hzA.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean wb(int i) {
        if (this.hzw != null) {
            this.hzw.cancel();
        }
        if (i >= this.hzx.size() || this.hzx.get(i) == null || this.hzx.get(i).getId() == null) {
            return false;
        }
        this.hzw = new C0464a(this.hzx.get(i).getId(), i, this.hzx.get(i).getForumId());
        this.hzw.setPriority(2);
        this.hzw.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0464a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bUY = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hzB;
        private int pos;
        private String tid;

        public C0464a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hzB = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hzB = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bUY.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bUY.addPostData("tid", this.tid);
            this.bUY.addPostData("fid", this.fid);
            this.hzB.parserJson(this.bUY.postNetData());
            return this.bUY.amp().amQ().isRequestSuccess() && this.hzB.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            a.this.hzw = null;
            if (a.this.hzA != null) {
                a.this.hzA.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hzw = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hzx.size()) {
                    a.this.hzx.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bUY.amp().amQ().isRequestSuccess()) {
                str = this.hzB.getErrorString();
            } else {
                str = this.bUY.getErrorString();
            }
            if (a.this.hzA != null) {
                a.this.hzA.callback(2, bool, str);
            }
        }
    }

    public int bNO() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void wc(int i) {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.hzu != null) {
            this.hzu.cancel();
        }
        if (this.hzv != null) {
            this.hzv.cancel();
        }
        if (this.hzw != null) {
            this.hzw.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hzA = cVar;
    }

    private void bNP() {
        if (this.hzx != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hzx.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    ba(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void ba(String str, int i) {
        if (this.hzx != null && v.getCount(this.hzx) > 0) {
            Iterator<MarkData> it = this.hzx.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
