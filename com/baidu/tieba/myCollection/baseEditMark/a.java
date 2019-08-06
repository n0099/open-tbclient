package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
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
    private boolean gfu;
    private b hzG = null;
    private c hzH = null;
    private C0364a hzI = null;
    private int hzK = 0;
    private int hzL = 0;
    protected com.baidu.tieba.myCollection.c hzM = null;
    private ArrayList<MarkData> hzJ = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hzL;
        aVar.hzL = i - 1;
        return i;
    }

    public a() {
        this.gfu = false;
        this.gfu = true;
    }

    public int getOffset() {
        if (this.hzJ == null) {
            return 0;
        }
        return this.hzJ.size();
    }

    public int bPZ() {
        return this.hzL;
    }

    public void xs(int i) {
        this.hzL = i;
    }

    public boolean hasMore() {
        return this.hzK > 0;
    }

    public void reset() {
        this.hzL = 0;
        this.hzK = 0;
        this.gfu = true;
    }

    public ArrayList<MarkData> bQa() {
        return this.hzJ;
    }

    public void as(ArrayList<MarkData> arrayList) {
        this.hzJ = arrayList;
    }

    public void at(ArrayList<MarkData> arrayList) {
        if (this.hzJ != null && arrayList != null) {
            this.hzJ.addAll(arrayList);
            bQe();
        }
    }

    public void f(MarkData markData) {
        this.hzJ.add(markData);
    }

    public int getCount() {
        if (this.hzJ == null) {
            return 0;
        }
        return this.hzJ.size();
    }

    public int bQb() {
        return this.hzK;
    }

    public void bQc() {
        ArrayList<MarkData> cqF = com.baidu.tieba.tbadkCore.util.a.cqF();
        if (cqF != null) {
            as(cqF);
        }
    }

    public String cc(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hzJ == null) {
            return null;
        }
        if (i >= this.hzJ.size()) {
            i2 -= (i - this.hzJ.size()) - 1;
            i = this.hzJ.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hzJ.get(i5).toJson();
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

    public void Bm(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Bn(String str) {
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
                    this.hzJ.add(markData);
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
        if (this.hzG != null) {
            this.hzG.cancel();
        }
        this.hzG = new b(getOffset());
        this.hzG.setPriority(3);
        this.hzG.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hzN;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hzP = false;

        public b(int i) {
            this.offset = 0;
            this.hzN = null;
            this.offset = i;
            this.hzN = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hzP = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hzP.booleanValue() && booleanValue) {
                l<String> mL = com.baidu.tbadk.core.d.a.agH().mL("tb.my_bookmarks");
                if (mL != null) {
                    publishProgress(mL.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hzJ == null) {
                    a.this.hzJ = new ArrayList();
                } else {
                    a.this.hzJ.clear();
                }
                a.this.hzK = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gfu) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o("rn", String.valueOf(20));
            this.data = this.mNetWork.aii();
            this.hzN.parserJson(this.data);
            if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                aVar.Bm(this.data);
                if (this.offset == 0) {
                    if (a.this.hzJ == null) {
                        a.this.hzJ = new ArrayList();
                    } else {
                        a.this.hzJ.clear();
                    }
                    a.this.hzK = 0;
                    if (this.hzP.booleanValue()) {
                        wv(this.data);
                    }
                }
            }
            return aVar;
        }

        private void wv(String str) {
            l<String> mL;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (mL = com.baidu.tbadk.core.d.a.agH().mL("tb.my_bookmarks")) != null) {
                mL.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.Bn(str);
                if (this.hzP.booleanValue()) {
                    a.this.as(arrayList);
                } else {
                    a.this.at(arrayList);
                }
            } else {
                a.this.as(arrayList);
            }
            if (!v.aa(arrayList)) {
                a.this.hzM.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            a.this.hzG = null;
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
            if (this.hzN != null) {
                com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "collection_thread_list_result", this.hzN.getErrorCode(), this.hzN.getErrorString(), new Object[0]);
            }
            a.this.hzK = aVar.getCount();
            ArrayList<MarkData> bQa = aVar.bQa();
            if (this.hzP.booleanValue()) {
                if (bQa != null && bQa.size() != 0) {
                    a.this.as(bQa);
                }
            } else {
                a.this.at(bQa);
            }
            Iterator<MarkData> it = bQa.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.xs(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hzM != null) {
                String str = null;
                if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                    if (this.hzN.getErrorCode() != 0) {
                        str = this.hzN.getErrorString();
                    }
                    a.this.hzM.callback(0, str, false);
                } else {
                    a.this.hzM.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.gfu = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hzN;
        final /* synthetic */ a hzO;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hzN = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bQc();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bQd = this.hzO.bQd();
                if (aVar.getCount() - 1 <= bQd) {
                    bQd = aVar.getCount() - 1;
                }
                while (bQd >= 0) {
                    String cc = aVar.cc(bQd, 20);
                    this.mNetWork.u(new ArrayList<>());
                    this.mNetWork.o("data", cc);
                    this.hzN.parserJson(this.mNetWork.aii());
                    if (!this.mNetWork.aiG().ajH().isRequestSuccess() || this.hzN.getErrorCode() != 0) {
                        break;
                    }
                    bQd -= 20;
                }
                this.hzO.xu(bQd);
                if (bQd >= 0) {
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
                this.mNetWork.ik();
            }
            this.hzO.hzH = null;
            if (this.hzO.hzM != null) {
                this.hzO.hzM.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hzO.hzH = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                str = this.hzN.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hzO.hzM != null) {
                this.hzO.hzM.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean xt(int i) {
        if (this.hzI != null) {
            this.hzI.cancel();
        }
        if (i >= this.hzJ.size() || this.hzJ.get(i) == null || this.hzJ.get(i).getId() == null) {
            return false;
        }
        this.hzI = new C0364a(this.hzJ.get(i).getId(), i, this.hzJ.get(i).getForumId());
        this.hzI.setPriority(2);
        this.hzI.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0364a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hzN;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0364a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hzN = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hzN = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.o("tid", this.tid);
            this.mNetWork.o("fid", this.fid);
            this.hzN.parserJson(this.mNetWork.aii());
            return this.mNetWork.aiG().ajH().isRequestSuccess() && this.hzN.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            a.this.hzI = null;
            if (a.this.hzM != null) {
                a.this.hzM.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hzI = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hzJ.size()) {
                    a.this.hzJ.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                str = this.hzN.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hzM != null) {
                a.this.hzM.callback(2, bool, str);
            }
        }
    }

    public int bQd() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("uploac_mark_offset", 399);
    }

    public void xu(int i) {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hzG != null) {
            this.hzG.cancel();
        }
        if (this.hzH != null) {
            this.hzH.cancel();
        }
        if (this.hzI != null) {
            this.hzI.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hzM = cVar;
    }

    private void bQe() {
        if (this.hzJ != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hzJ.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bd(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bd(String str, int i) {
        if (this.hzJ != null && v.Z(this.hzJ) > 0) {
            Iterator<MarkData> it = this.hzJ.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
