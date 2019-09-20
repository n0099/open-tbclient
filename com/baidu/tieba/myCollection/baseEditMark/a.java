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
    private boolean ghl;
    private b hBC = null;
    private c hBD = null;
    private C0375a hBE = null;
    private int hBG = 0;
    private int hBH = 0;
    protected com.baidu.tieba.myCollection.c hBI = null;
    private ArrayList<MarkData> hBF = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hBH;
        aVar.hBH = i - 1;
        return i;
    }

    public a() {
        this.ghl = false;
        this.ghl = true;
    }

    public int getOffset() {
        if (this.hBF == null) {
            return 0;
        }
        return this.hBF.size();
    }

    public int bQN() {
        return this.hBH;
    }

    public void xv(int i) {
        this.hBH = i;
    }

    public boolean hasMore() {
        return this.hBG > 0;
    }

    public void reset() {
        this.hBH = 0;
        this.hBG = 0;
        this.ghl = true;
    }

    public ArrayList<MarkData> bQO() {
        return this.hBF;
    }

    public void as(ArrayList<MarkData> arrayList) {
        this.hBF = arrayList;
    }

    public void at(ArrayList<MarkData> arrayList) {
        if (this.hBF != null && arrayList != null) {
            this.hBF.addAll(arrayList);
            bQS();
        }
    }

    public void f(MarkData markData) {
        this.hBF.add(markData);
    }

    public int getCount() {
        if (this.hBF == null) {
            return 0;
        }
        return this.hBF.size();
    }

    public int bQP() {
        return this.hBG;
    }

    public void bQQ() {
        ArrayList<MarkData> crt = com.baidu.tieba.tbadkCore.util.a.crt();
        if (crt != null) {
            as(crt);
        }
    }

    public String cc(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hBF == null) {
            return null;
        }
        if (i >= this.hBF.size()) {
            i2 -= (i - this.hBF.size()) - 1;
            i = this.hBF.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hBF.get(i5).toJson();
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

    public void BL(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> BM(String str) {
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
                    this.hBF.add(markData);
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
        if (this.hBC != null) {
            this.hBC.cancel();
        }
        this.hBC = new b(getOffset());
        this.hBC.setPriority(3);
        this.hBC.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hBJ;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hBL = false;

        public b(int i) {
            this.offset = 0;
            this.hBJ = null;
            this.offset = i;
            this.hBJ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hBL = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hBL.booleanValue() && booleanValue) {
                l<String> mN = com.baidu.tbadk.core.d.a.agL().mN("tb.my_bookmarks");
                if (mN != null) {
                    publishProgress(mN.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hBF == null) {
                    a.this.hBF = new ArrayList();
                } else {
                    a.this.hBF.clear();
                }
                a.this.hBG = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ghl) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o("rn", String.valueOf(20));
            this.data = this.mNetWork.aim();
            this.hBJ.parserJson(this.data);
            if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                aVar.BL(this.data);
                if (this.offset == 0) {
                    if (a.this.hBF == null) {
                        a.this.hBF = new ArrayList();
                    } else {
                        a.this.hBF.clear();
                    }
                    a.this.hBG = 0;
                    if (this.hBL.booleanValue()) {
                        wU(this.data);
                    }
                }
            }
            return aVar;
        }

        private void wU(String str) {
            l<String> mN;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (mN = com.baidu.tbadk.core.d.a.agL().mN("tb.my_bookmarks")) != null) {
                mN.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.BM(str);
                if (this.hBL.booleanValue()) {
                    a.this.as(arrayList);
                } else {
                    a.this.at(arrayList);
                }
            } else {
                a.this.as(arrayList);
            }
            if (!v.aa(arrayList)) {
                a.this.hBI.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            a.this.hBC = null;
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
            if (this.hBJ != null) {
                com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "collection_thread_list_result", this.hBJ.getErrorCode(), this.hBJ.getErrorString(), new Object[0]);
            }
            a.this.hBG = aVar.getCount();
            ArrayList<MarkData> bQO = aVar.bQO();
            if (this.hBL.booleanValue()) {
                if (bQO != null && bQO.size() != 0) {
                    a.this.as(bQO);
                }
            } else {
                a.this.at(bQO);
            }
            Iterator<MarkData> it = bQO.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.xv(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hBI != null) {
                String str = null;
                if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                    if (this.hBJ.getErrorCode() != 0) {
                        str = this.hBJ.getErrorString();
                    }
                    a.this.hBI.callback(0, str, false);
                } else {
                    a.this.hBI.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ghl = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hBJ;
        final /* synthetic */ a hBK;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hBJ = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bQQ();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bQR = this.hBK.bQR();
                if (aVar.getCount() - 1 <= bQR) {
                    bQR = aVar.getCount() - 1;
                }
                while (bQR >= 0) {
                    String cc = aVar.cc(bQR, 20);
                    this.mNetWork.u(new ArrayList<>());
                    this.mNetWork.o("data", cc);
                    this.hBJ.parserJson(this.mNetWork.aim());
                    if (!this.mNetWork.aiK().ajN().isRequestSuccess() || this.hBJ.getErrorCode() != 0) {
                        break;
                    }
                    bQR -= 20;
                }
                this.hBK.xx(bQR);
                if (bQR >= 0) {
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
            this.hBK.hBD = null;
            if (this.hBK.hBI != null) {
                this.hBK.hBI.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hBK.hBD = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                str = this.hBJ.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hBK.hBI != null) {
                this.hBK.hBI.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean xw(int i) {
        if (this.hBE != null) {
            this.hBE.cancel();
        }
        if (i >= this.hBF.size() || this.hBF.get(i) == null || this.hBF.get(i).getId() == null) {
            return false;
        }
        this.hBE = new C0375a(this.hBF.get(i).getId(), i, this.hBF.get(i).getForumId());
        this.hBE.setPriority(2);
        this.hBE.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0375a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hBJ;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0375a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hBJ = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hBJ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hBJ.parserJson(this.mNetWork.aim());
            return this.mNetWork.aiK().ajN().isRequestSuccess() && this.hBJ.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            a.this.hBE = null;
            if (a.this.hBI != null) {
                a.this.hBI.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hBE = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hBF.size()) {
                    a.this.hBF.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                str = this.hBJ.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hBI != null) {
                a.this.hBI.callback(2, bool, str);
            }
        }
    }

    public int bQR() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("uploac_mark_offset", 399);
    }

    public void xx(int i) {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hBC != null) {
            this.hBC.cancel();
        }
        if (this.hBD != null) {
            this.hBD.cancel();
        }
        if (this.hBE != null) {
            this.hBE.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hBI = cVar;
    }

    private void bQS() {
        if (this.hBF != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hBF.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bf(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bf(String str, int i) {
        if (this.hBF != null && v.Z(this.hBF) > 0) {
            Iterator<MarkData> it = this.hBF.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
