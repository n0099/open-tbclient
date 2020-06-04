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
    private boolean hZo;
    private b jvd = null;
    private c jve = null;
    private C0673a jvf = null;
    private int jvh = 0;
    private int jvi = 0;
    protected com.baidu.tieba.myCollection.c jvj = null;
    private ArrayList<MarkData> jvg = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.jvi;
        aVar.jvi = i - 1;
        return i;
    }

    public a() {
        this.hZo = false;
        this.hZo = true;
    }

    public int getOffset() {
        if (this.jvg == null) {
            return 0;
        }
        return this.jvg.size();
    }

    public int czE() {
        return this.jvi;
    }

    public void zG(int i) {
        this.jvi = i;
    }

    public boolean hasMore() {
        return this.jvh > 0;
    }

    public void reset() {
        this.jvi = 0;
        this.jvh = 0;
        this.hZo = true;
    }

    public ArrayList<MarkData> czF() {
        return this.jvg;
    }

    public void aJ(ArrayList<MarkData> arrayList) {
        this.jvg = arrayList;
    }

    public void aK(ArrayList<MarkData> arrayList) {
        if (this.jvg != null && arrayList != null) {
            this.jvg.addAll(arrayList);
            czJ();
        }
    }

    public void f(MarkData markData) {
        this.jvg.add(markData);
    }

    public int getCount() {
        if (this.jvg == null) {
            return 0;
        }
        return this.jvg.size();
    }

    public int czG() {
        return this.jvh;
    }

    public void czH() {
        ArrayList<MarkData> deH = com.baidu.tieba.tbadkCore.util.a.deH();
        if (deH != null) {
            aJ(deH);
        }
    }

    public String cy(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jvg == null) {
            return null;
        }
        if (i >= this.jvg.size()) {
            i2 -= (i - this.jvg.size()) - 1;
            i = this.jvg.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jvg.get(i5).toJson();
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

    public void IH(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> II(String str) {
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
                    this.jvg.add(markData);
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
        if (this.jvd != null) {
            this.jvd.cancel();
        }
        this.jvd = new b(getOffset());
        this.jvd.setPriority(3);
        this.jvd.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jvk;
        private int offset;
        private x bth = null;
        private String data = null;
        Boolean jvm = false;

        public b(int i) {
            this.offset = 0;
            this.jvk = null;
            this.offset = i;
            this.jvk = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jvm = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jvm.booleanValue() && booleanValue) {
                l<String> vM = com.baidu.tbadk.core.c.a.aSS().vM("tb.my_bookmarks");
                if (vM != null) {
                    publishProgress(vM.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jvg == null) {
                    a.this.jvg = new ArrayList();
                } else {
                    a.this.jvg.clear();
                }
                a.this.jvh = 0;
            }
            this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bth.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.hZo) {
                this.bth.addPostData("offset", String.valueOf(0));
            } else {
                this.bth.addPostData("offset", String.valueOf(this.offset));
            }
            this.bth.addPostData("rn", String.valueOf(20));
            this.data = this.bth.postNetData();
            this.jvk.parserJson(this.data);
            if (this.bth.aUA().aVc().isRequestSuccess()) {
                aVar.IH(this.data);
                if (this.offset == 0) {
                    if (a.this.jvg == null) {
                        a.this.jvg = new ArrayList();
                    } else {
                        a.this.jvg.clear();
                    }
                    a.this.jvh = 0;
                    if (this.jvm.booleanValue()) {
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
                arrayList = a.this.II(str);
                if (this.jvm.booleanValue()) {
                    a.this.aJ(arrayList);
                } else {
                    a.this.aK(arrayList);
                }
            } else {
                a.this.aJ(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.jvj.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            a.this.jvd = null;
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
            if (this.jvk != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jvk.getErrorCode(), this.jvk.getErrorString(), new Object[0]);
            }
            a.this.jvh = aVar.getCount();
            ArrayList<MarkData> czF = aVar.czF();
            if (this.jvm.booleanValue()) {
                if (czF != null && czF.size() != 0) {
                    a.this.aJ(czF);
                }
            } else {
                a.this.aK(czF);
            }
            Iterator<MarkData> it = czF.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.zG(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.jvj != null) {
                String str = null;
                if (this.bth.aUA().aVc().isRequestSuccess()) {
                    if (this.jvk.getErrorCode() != 0) {
                        str = this.jvk.getErrorString();
                    }
                    a.this.jvj.callback(0, str, false);
                } else {
                    a.this.jvj.callback(3, this.bth.getErrorString());
                }
            }
            a.this.hZo = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x bth;
        private com.baidu.tieba.myCollection.baseEditMark.c jvk;
        final /* synthetic */ a jvl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jvk = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.czH();
                this.bth = new x();
                this.bth.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int czI = this.jvl.czI();
                if (aVar.getCount() - 1 <= czI) {
                    czI = aVar.getCount() - 1;
                }
                while (czI >= 0) {
                    String cy = aVar.cy(czI, 20);
                    this.bth.setPostData(new ArrayList<>());
                    this.bth.addPostData("data", cy);
                    this.jvk.parserJson(this.bth.postNetData());
                    if (!this.bth.aUA().aVc().isRequestSuccess() || this.jvk.getErrorCode() != 0) {
                        break;
                    }
                    czI -= 20;
                }
                this.jvl.zI(czI);
                if (czI >= 0) {
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
            this.jvl.jve = null;
            if (this.jvl.jvj != null) {
                this.jvl.jvj.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.jvl.jve = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bth.aUA().aVc().isRequestSuccess()) {
                str = this.jvk.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.jvl.jvj != null) {
                this.jvl.jvj.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean zH(int i) {
        if (this.jvf != null) {
            this.jvf.cancel();
        }
        if (i >= this.jvg.size() || this.jvg.get(i) == null || this.jvg.get(i).getId() == null) {
            return false;
        }
        this.jvf = new C0673a(this.jvg.get(i).getId(), i, this.jvg.get(i).getForumId());
        this.jvf.setPriority(2);
        this.jvf.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0673a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bth = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jvk;
        private int pos;
        private String tid;

        public C0673a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jvk = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jvk = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jvk.parserJson(this.bth.postNetData());
            return this.bth.aUA().aVc().isRequestSuccess() && this.jvk.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            a.this.jvf = null;
            if (a.this.jvj != null) {
                a.this.jvj.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jvf = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jvg.size()) {
                    a.this.jvg.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bth.aUA().aVc().isRequestSuccess()) {
                str = this.jvk.getErrorString();
            } else {
                str = this.bth.getErrorString();
            }
            if (a.this.jvj != null) {
                a.this.jvj.callback(2, bool, str);
            }
        }
    }

    public int czI() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void zI(int i) {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.jvd != null) {
            this.jvd.cancel();
        }
        if (this.jve != null) {
            this.jve.cancel();
        }
        if (this.jvf != null) {
            this.jvf.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jvj = cVar;
    }

    private void czJ() {
        if (this.jvg != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jvg.iterator();
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
        if (this.jvg != null && v.getCount(this.jvg) > 0) {
            Iterator<MarkData> it = this.jvg.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
