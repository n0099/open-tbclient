package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private boolean fII;
    private b hbh = null;
    private c hbi = null;
    private C0341a hbj = null;
    private int hbl = 0;
    private int hbm = 0;
    protected com.baidu.tieba.myCollection.c hbn = null;
    private ArrayList<MarkData> hbk = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hbm;
        aVar.hbm = i - 1;
        return i;
    }

    public a() {
        this.fII = false;
        this.fII = true;
    }

    public int getOffset() {
        if (this.hbk == null) {
            return 0;
        }
        return this.hbk.size();
    }

    public int bFp() {
        return this.hbm;
    }

    public void vI(int i) {
        this.hbm = i;
    }

    public boolean hasMore() {
        return this.hbl >= 20;
    }

    public void reset() {
        this.hbm = 0;
        this.hbl = 0;
        this.fII = true;
    }

    public ArrayList<MarkData> bFq() {
        return this.hbk;
    }

    public void ao(ArrayList<MarkData> arrayList) {
        this.hbk = arrayList;
    }

    public void ap(ArrayList<MarkData> arrayList) {
        if (this.hbk != null && arrayList != null) {
            this.hbk.addAll(arrayList);
            bFu();
        }
    }

    public void f(MarkData markData) {
        this.hbk.add(markData);
    }

    public int getCount() {
        if (this.hbk == null) {
            return 0;
        }
        return this.hbk.size();
    }

    public int bFr() {
        return this.hbl;
    }

    public void bFs() {
        ArrayList<MarkData> cfj = com.baidu.tieba.tbadkCore.util.a.cfj();
        if (cfj != null) {
            ao(cfj);
        }
    }

    public String bP(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hbk == null) {
            return null;
        }
        if (i >= this.hbk.size()) {
            i2 -= (i - this.hbk.size()) - 1;
            i = this.hbk.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hbk.get(i5).toJson();
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

    public void zi(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> zj(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
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
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.hbk.add(markData);
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
        if (this.hbh != null) {
            this.hbh.cancel();
        }
        this.hbh = new b(getOffset());
        this.hbh.setPriority(3);
        this.hbh.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hbo;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hbq = false;

        public b(int i) {
            this.offset = 0;
            this.hbo = null;
            this.offset = i;
            this.hbo = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hbq = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hbq.booleanValue() && booleanValue) {
                l<String> lw = com.baidu.tbadk.core.c.a.aaT().lw("tb.my_bookmarks");
                if (lw != null) {
                    publishProgress(lw.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hbk == null) {
                    a.this.hbk = new ArrayList();
                } else {
                    a.this.hbk.clear();
                }
                a.this.hbl = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.fII) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.acg();
            this.hbo.parserJson(this.data);
            if (this.mNetWork.acE().adD().isRequestSuccess()) {
                aVar.zi(this.data);
                if (this.offset == 0) {
                    if (a.this.hbk == null) {
                        a.this.hbk = new ArrayList();
                    } else {
                        a.this.hbk.clear();
                    }
                    a.this.hbl = 0;
                    if (this.hbq.booleanValue()) {
                        uw(this.data);
                    }
                }
            }
            return aVar;
        }

        private void uw(String str) {
            l<String> lw;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (lw = com.baidu.tbadk.core.c.a.aaT().lw("tb.my_bookmarks")) != null) {
                lw.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.zj(str);
                if (this.hbq.booleanValue()) {
                    a.this.ao(arrayList);
                } else {
                    a.this.ap(arrayList);
                }
            } else {
                a.this.ao(arrayList);
            }
            if (!v.T(arrayList)) {
                a.this.hbn.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            a.this.hbh = null;
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
            if (this.hbo != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.hbo.getErrorCode(), this.hbo.getErrorString(), new Object[0]);
            }
            a.this.hbl = aVar.getCount();
            ArrayList<MarkData> bFq = aVar.bFq();
            if (this.hbq.booleanValue()) {
                if (bFq != null && bFq.size() != 0) {
                    a.this.ao(bFq);
                }
            } else {
                a.this.ap(bFq);
            }
            Iterator<MarkData> it = bFq.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.vI(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hbn != null) {
                String str = null;
                if (this.mNetWork.acE().adD().isRequestSuccess()) {
                    if (this.hbo.getErrorCode() != 0) {
                        str = this.hbo.getErrorString();
                    }
                    a.this.hbn.callback(0, str, false);
                } else {
                    a.this.hbn.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.fII = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hbo;
        final /* synthetic */ a hbp;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hbo = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bFs();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bFt = this.hbp.bFt();
                if (aVar.getCount() - 1 <= bFt) {
                    bFt = aVar.getCount() - 1;
                }
                while (bFt >= 0) {
                    String bP = aVar.bP(bFt, 20);
                    this.mNetWork.r(new ArrayList<>());
                    this.mNetWork.x("data", bP);
                    this.hbo.parserJson(this.mNetWork.acg());
                    if (!this.mNetWork.acE().adD().isRequestSuccess() || this.hbo.getErrorCode() != 0) {
                        break;
                    }
                    bFt -= 20;
                }
                this.hbp.vK(bFt);
                if (bFt >= 0) {
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
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            this.hbp.hbi = null;
            if (this.hbp.hbn != null) {
                this.hbp.hbn.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hbp.hbi = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.acE().adD().isRequestSuccess()) {
                str = this.hbo.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hbp.hbn != null) {
                this.hbp.hbn.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean vJ(int i) {
        if (this.hbj != null) {
            this.hbj.cancel();
        }
        if (i >= this.hbk.size() || this.hbk.get(i) == null || this.hbk.get(i).getId() == null) {
            return false;
        }
        this.hbj = new C0341a(this.hbk.get(i).getId(), i, this.hbk.get(i).getForumId());
        this.hbj.setPriority(2);
        this.hbj.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0341a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hbo;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0341a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hbo = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hbo = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.x("tid", this.tid);
            this.mNetWork.x(ImageViewerConfig.FORUM_ID, this.fid);
            this.hbo.parserJson(this.mNetWork.acg());
            return this.mNetWork.acE().adD().isRequestSuccess() && this.hbo.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            a.this.hbj = null;
            if (a.this.hbn != null) {
                a.this.hbn.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hbj = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hbk.size()) {
                    a.this.hbk.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.acE().adD().isRequestSuccess()) {
                str = this.hbo.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hbn != null) {
                a.this.hbn.callback(2, bool, str);
            }
        }
    }

    public int bFt() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void vK(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hbh != null) {
            this.hbh.cancel();
        }
        if (this.hbi != null) {
            this.hbi.cancel();
        }
        if (this.hbj != null) {
            this.hbj.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hbn = cVar;
    }

    private void bFu() {
        if (this.hbk != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hbk.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bg(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bg(String str, int i) {
        if (this.hbk != null && v.S(this.hbk) > 0) {
            Iterator<MarkData> it = this.hbk.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
