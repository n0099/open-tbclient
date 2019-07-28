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
    private boolean geE;
    private b hyO = null;
    private c hyP = null;
    private C0364a hyQ = null;
    private int hyS = 0;
    private int hyT = 0;
    protected com.baidu.tieba.myCollection.c hyU = null;
    private ArrayList<MarkData> hyR = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hyT;
        aVar.hyT = i - 1;
        return i;
    }

    public a() {
        this.geE = false;
        this.geE = true;
    }

    public int getOffset() {
        if (this.hyR == null) {
            return 0;
        }
        return this.hyR.size();
    }

    public int bPL() {
        return this.hyT;
    }

    public void xq(int i) {
        this.hyT = i;
    }

    public boolean hasMore() {
        return this.hyS > 0;
    }

    public void reset() {
        this.hyT = 0;
        this.hyS = 0;
        this.geE = true;
    }

    public ArrayList<MarkData> bPM() {
        return this.hyR;
    }

    public void as(ArrayList<MarkData> arrayList) {
        this.hyR = arrayList;
    }

    public void at(ArrayList<MarkData> arrayList) {
        if (this.hyR != null && arrayList != null) {
            this.hyR.addAll(arrayList);
            bPQ();
        }
    }

    public void f(MarkData markData) {
        this.hyR.add(markData);
    }

    public int getCount() {
        if (this.hyR == null) {
            return 0;
        }
        return this.hyR.size();
    }

    public int bPN() {
        return this.hyS;
    }

    public void bPO() {
        ArrayList<MarkData> cqj = com.baidu.tieba.tbadkCore.util.a.cqj();
        if (cqj != null) {
            as(cqj);
        }
    }

    public String cc(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hyR == null) {
            return null;
        }
        if (i >= this.hyR.size()) {
            i2 -= (i - this.hyR.size()) - 1;
            i = this.hyR.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hyR.get(i5).toJson();
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

    public void Bl(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Bm(String str) {
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
                    this.hyR.add(markData);
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
        if (this.hyO != null) {
            this.hyO.cancel();
        }
        this.hyO = new b(getOffset());
        this.hyO.setPriority(3);
        this.hyO.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hyV;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hyX = false;

        public b(int i) {
            this.offset = 0;
            this.hyV = null;
            this.offset = i;
            this.hyV = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hyX = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hyX.booleanValue() && booleanValue) {
                l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.my_bookmarks");
                if (mL != null) {
                    publishProgress(mL.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hyR == null) {
                    a.this.hyR = new ArrayList();
                } else {
                    a.this.hyR.clear();
                }
                a.this.hyS = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.geE) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o("rn", String.valueOf(20));
            this.data = this.mNetWork.aig();
            this.hyV.parserJson(this.data);
            if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                aVar.Bl(this.data);
                if (this.offset == 0) {
                    if (a.this.hyR == null) {
                        a.this.hyR = new ArrayList();
                    } else {
                        a.this.hyR.clear();
                    }
                    a.this.hyS = 0;
                    if (this.hyX.booleanValue()) {
                        wu(this.data);
                    }
                }
            }
            return aVar;
        }

        private void wu(String str) {
            l<String> mL;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (mL = com.baidu.tbadk.core.d.a.agF().mL("tb.my_bookmarks")) != null) {
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
                arrayList = a.this.Bm(str);
                if (this.hyX.booleanValue()) {
                    a.this.as(arrayList);
                } else {
                    a.this.at(arrayList);
                }
            } else {
                a.this.as(arrayList);
            }
            if (!v.aa(arrayList)) {
                a.this.hyU.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            a.this.hyO = null;
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
            if (this.hyV != null) {
                com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "collection_thread_list_result", this.hyV.getErrorCode(), this.hyV.getErrorString(), new Object[0]);
            }
            a.this.hyS = aVar.getCount();
            ArrayList<MarkData> bPM = aVar.bPM();
            if (this.hyX.booleanValue()) {
                if (bPM != null && bPM.size() != 0) {
                    a.this.as(bPM);
                }
            } else {
                a.this.at(bPM);
            }
            Iterator<MarkData> it = bPM.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.xq(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hyU != null) {
                String str = null;
                if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                    if (this.hyV.getErrorCode() != 0) {
                        str = this.hyV.getErrorString();
                    }
                    a.this.hyU.callback(0, str, false);
                } else {
                    a.this.hyU.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.geE = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hyV;
        final /* synthetic */ a hyW;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hyV = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bPO();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bPP = this.hyW.bPP();
                if (aVar.getCount() - 1 <= bPP) {
                    bPP = aVar.getCount() - 1;
                }
                while (bPP >= 0) {
                    String cc = aVar.cc(bPP, 20);
                    this.mNetWork.u(new ArrayList<>());
                    this.mNetWork.o("data", cc);
                    this.hyV.parserJson(this.mNetWork.aig());
                    if (!this.mNetWork.aiE().ajF().isRequestSuccess() || this.hyV.getErrorCode() != 0) {
                        break;
                    }
                    bPP -= 20;
                }
                this.hyW.xs(bPP);
                if (bPP >= 0) {
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
            this.hyW.hyP = null;
            if (this.hyW.hyU != null) {
                this.hyW.hyU.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hyW.hyP = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                str = this.hyV.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hyW.hyU != null) {
                this.hyW.hyU.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean xr(int i) {
        if (this.hyQ != null) {
            this.hyQ.cancel();
        }
        if (i >= this.hyR.size() || this.hyR.get(i) == null || this.hyR.get(i).getId() == null) {
            return false;
        }
        this.hyQ = new C0364a(this.hyR.get(i).getId(), i, this.hyR.get(i).getForumId());
        this.hyQ.setPriority(2);
        this.hyQ.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0364a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hyV;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0364a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hyV = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hyV = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hyV.parserJson(this.mNetWork.aig());
            return this.mNetWork.aiE().ajF().isRequestSuccess() && this.hyV.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            a.this.hyQ = null;
            if (a.this.hyU != null) {
                a.this.hyU.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hyQ = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hyR.size()) {
                    a.this.hyR.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                str = this.hyV.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hyU != null) {
                a.this.hyU.callback(2, bool, str);
            }
        }
    }

    public int bPP() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("uploac_mark_offset", 399);
    }

    public void xs(int i) {
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hyO != null) {
            this.hyO.cancel();
        }
        if (this.hyP != null) {
            this.hyP.cancel();
        }
        if (this.hyQ != null) {
            this.hyQ.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hyU = cVar;
    }

    private void bPQ() {
        if (this.hyR != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hyR.iterator();
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
        if (this.hyR != null && v.Z(this.hyR) > 0) {
            Iterator<MarkData> it = this.hyR.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
