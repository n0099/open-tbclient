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
    private boolean hYB;
    private b jtX = null;
    private c jtY = null;
    private C0672a jtZ = null;
    private int jub = 0;
    private int juc = 0;
    protected com.baidu.tieba.myCollection.c jud = null;
    private ArrayList<MarkData> jua = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.juc;
        aVar.juc = i - 1;
        return i;
    }

    public a() {
        this.hYB = false;
        this.hYB = true;
    }

    public int getOffset() {
        if (this.jua == null) {
            return 0;
        }
        return this.jua.size();
    }

    public int czn() {
        return this.juc;
    }

    public void zE(int i) {
        this.juc = i;
    }

    public boolean hasMore() {
        return this.jub > 0;
    }

    public void reset() {
        this.juc = 0;
        this.jub = 0;
        this.hYB = true;
    }

    public ArrayList<MarkData> czo() {
        return this.jua;
    }

    public void aJ(ArrayList<MarkData> arrayList) {
        this.jua = arrayList;
    }

    public void aK(ArrayList<MarkData> arrayList) {
        if (this.jua != null && arrayList != null) {
            this.jua.addAll(arrayList);
            czs();
        }
    }

    public void f(MarkData markData) {
        this.jua.add(markData);
    }

    public int getCount() {
        if (this.jua == null) {
            return 0;
        }
        return this.jua.size();
    }

    public int czp() {
        return this.jub;
    }

    public void czq() {
        ArrayList<MarkData> des = com.baidu.tieba.tbadkCore.util.a.des();
        if (des != null) {
            aJ(des);
        }
    }

    public String cy(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jua == null) {
            return null;
        }
        if (i >= this.jua.size()) {
            i2 -= (i - this.jua.size()) - 1;
            i = this.jua.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jua.get(i5).toJson();
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

    public void IG(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> IH(String str) {
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
                    this.jua.add(markData);
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
        if (this.jtX != null) {
            this.jtX.cancel();
        }
        this.jtX = new b(getOffset());
        this.jtX.setPriority(3);
        this.jtX.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jue;
        private int offset;
        private x bth = null;
        private String data = null;
        Boolean jug = false;

        public b(int i) {
            this.offset = 0;
            this.jue = null;
            this.offset = i;
            this.jue = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jug = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jug.booleanValue() && booleanValue) {
                l<String> vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.my_bookmarks");
                if (vM != null) {
                    publishProgress(vM.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jua == null) {
                    a.this.jua = new ArrayList();
                } else {
                    a.this.jua.clear();
                }
                a.this.jub = 0;
            }
            this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bth.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.hYB) {
                this.bth.addPostData("offset", String.valueOf(0));
            } else {
                this.bth.addPostData("offset", String.valueOf(this.offset));
            }
            this.bth.addPostData("rn", String.valueOf(20));
            this.data = this.bth.postNetData();
            this.jue.parserJson(this.data);
            if (this.bth.aUA().aVb().isRequestSuccess()) {
                aVar.IG(this.data);
                if (this.offset == 0) {
                    if (a.this.jua == null) {
                        a.this.jua = new ArrayList();
                    } else {
                        a.this.jua.clear();
                    }
                    a.this.jub = 0;
                    if (this.jug.booleanValue()) {
                        Ej(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Ej(String str) {
            l<String> vM;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.my_bookmarks")) != null) {
                vM.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.IH(str);
                if (this.jug.booleanValue()) {
                    a.this.aJ(arrayList);
                } else {
                    a.this.aK(arrayList);
                }
            } else {
                a.this.aJ(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.jud.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            a.this.jtX = null;
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
            if (this.jue != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jue.getErrorCode(), this.jue.getErrorString(), new Object[0]);
            }
            a.this.jub = aVar.getCount();
            ArrayList<MarkData> czo = aVar.czo();
            if (this.jug.booleanValue()) {
                if (czo != null && czo.size() != 0) {
                    a.this.aJ(czo);
                }
            } else {
                a.this.aK(czo);
            }
            Iterator<MarkData> it = czo.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.zE(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.jud != null) {
                String str = null;
                if (this.bth.aUA().aVb().isRequestSuccess()) {
                    if (this.jue.getErrorCode() != 0) {
                        str = this.jue.getErrorString();
                    }
                    a.this.jud.callback(0, str, false);
                } else {
                    a.this.jud.callback(3, this.bth.getErrorString());
                }
            }
            a.this.hYB = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x bth;
        private com.baidu.tieba.myCollection.baseEditMark.c jue;
        final /* synthetic */ a juf;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jue = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.czq();
                this.bth = new x();
                this.bth.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int czr = this.juf.czr();
                if (aVar.getCount() - 1 <= czr) {
                    czr = aVar.getCount() - 1;
                }
                while (czr >= 0) {
                    String cy = aVar.cy(czr, 20);
                    this.bth.setPostData(new ArrayList<>());
                    this.bth.addPostData("data", cy);
                    this.jue.parserJson(this.bth.postNetData());
                    if (!this.bth.aUA().aVb().isRequestSuccess() || this.jue.getErrorCode() != 0) {
                        break;
                    }
                    czr -= 20;
                }
                this.juf.zG(czr);
                if (czr >= 0) {
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
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            this.juf.jtY = null;
            if (this.juf.jud != null) {
                this.juf.jud.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.juf.jtY = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bth.aUA().aVb().isRequestSuccess()) {
                str = this.jue.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.juf.jud != null) {
                this.juf.jud.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean zF(int i) {
        if (this.jtZ != null) {
            this.jtZ.cancel();
        }
        if (i >= this.jua.size() || this.jua.get(i) == null || this.jua.get(i).getId() == null) {
            return false;
        }
        this.jtZ = new C0672a(this.jua.get(i).getId(), i, this.jua.get(i).getForumId());
        this.jtZ.setPriority(2);
        this.jtZ.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0672a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bth = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jue;
        private int pos;
        private String tid;

        public C0672a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jue = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jue = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bth.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bth.addPostData("tid", this.tid);
            this.bth.addPostData("fid", this.fid);
            this.jue.parserJson(this.bth.postNetData());
            return this.bth.aUA().aVb().isRequestSuccess() && this.jue.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            a.this.jtZ = null;
            if (a.this.jud != null) {
                a.this.jud.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jtZ = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jua.size()) {
                    a.this.jua.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bth.aUA().aVb().isRequestSuccess()) {
                str = this.jue.getErrorString();
            } else {
                str = this.bth.getErrorString();
            }
            if (a.this.jud != null) {
                a.this.jud.callback(2, bool, str);
            }
        }
    }

    public int czr() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void zG(int i) {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.jtX != null) {
            this.jtX.cancel();
        }
        if (this.jtY != null) {
            this.jtY.cancel();
        }
        if (this.jtZ != null) {
            this.jtZ.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jud = cVar;
    }

    private void czs() {
        if (this.jua != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jua.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bt(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bt(String str, int i) {
        if (this.jua != null && v.getCount(this.jua) > 0) {
            Iterator<MarkData> it = this.jua.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
