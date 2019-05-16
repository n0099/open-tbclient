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
    private boolean fZD;
    private b hsy = null;
    private c hsz = null;
    private C0359a hsA = null;
    private int hsC = 0;
    private int hsD = 0;
    protected com.baidu.tieba.myCollection.c hsE = null;
    private ArrayList<MarkData> hsB = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hsD;
        aVar.hsD = i - 1;
        return i;
    }

    public a() {
        this.fZD = false;
        this.fZD = true;
    }

    public int getOffset() {
        if (this.hsB == null) {
            return 0;
        }
        return this.hsB.size();
    }

    public int bMZ() {
        return this.hsD;
    }

    public void wN(int i) {
        this.hsD = i;
    }

    public boolean hasMore() {
        return this.hsC >= 20;
    }

    public void reset() {
        this.hsD = 0;
        this.hsC = 0;
        this.fZD = true;
    }

    public ArrayList<MarkData> bNa() {
        return this.hsB;
    }

    public void as(ArrayList<MarkData> arrayList) {
        this.hsB = arrayList;
    }

    public void at(ArrayList<MarkData> arrayList) {
        if (this.hsB != null && arrayList != null) {
            this.hsB.addAll(arrayList);
            bNe();
        }
    }

    public void f(MarkData markData) {
        this.hsB.add(markData);
    }

    public int getCount() {
        if (this.hsB == null) {
            return 0;
        }
        return this.hsB.size();
    }

    public int bNb() {
        return this.hsC;
    }

    public void bNc() {
        ArrayList<MarkData> cnn = com.baidu.tieba.tbadkCore.util.a.cnn();
        if (cnn != null) {
            as(cnn);
        }
    }

    public String bW(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hsB == null) {
            return null;
        }
        if (i >= this.hsB.size()) {
            i2 -= (i - this.hsB.size()) - 1;
            i = this.hsB.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hsB.get(i5).toJson();
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

    public void Ay(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Az(String str) {
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
                    this.hsB.add(markData);
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
        if (this.hsy != null) {
            this.hsy.cancel();
        }
        this.hsy = new b(getOffset());
        this.hsy.setPriority(3);
        this.hsy.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hsF;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hsH = false;

        public b(int i) {
            this.offset = 0;
            this.hsF = null;
            this.offset = i;
            this.hsF = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hsH = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hsH.booleanValue() && booleanValue) {
                l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.my_bookmarks");
                if (mB != null) {
                    publishProgress(mB.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hsB == null) {
                    a.this.hsB = new ArrayList();
                } else {
                    a.this.hsB.clear();
                }
                a.this.hsC = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.fZD) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o("rn", String.valueOf(20));
            this.data = this.mNetWork.ahe();
            this.hsF.parserJson(this.data);
            if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                aVar.Ay(this.data);
                if (this.offset == 0) {
                    if (a.this.hsB == null) {
                        a.this.hsB = new ArrayList();
                    } else {
                        a.this.hsB.clear();
                    }
                    a.this.hsC = 0;
                    if (this.hsH.booleanValue()) {
                        vQ(this.data);
                    }
                }
            }
            return aVar;
        }

        private void vQ(String str) {
            l<String> mB;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (mB = com.baidu.tbadk.core.c.a.afD().mB("tb.my_bookmarks")) != null) {
                mB.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.Az(str);
                if (this.hsH.booleanValue()) {
                    a.this.as(arrayList);
                } else {
                    a.this.at(arrayList);
                }
            } else {
                a.this.as(arrayList);
            }
            if (!v.aa(arrayList)) {
                a.this.hsE.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            a.this.hsy = null;
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
            if (this.hsF != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.hsF.getErrorCode(), this.hsF.getErrorString(), new Object[0]);
            }
            a.this.hsC = aVar.getCount();
            ArrayList<MarkData> bNa = aVar.bNa();
            if (this.hsH.booleanValue()) {
                if (bNa != null && bNa.size() != 0) {
                    a.this.as(bNa);
                }
            } else {
                a.this.at(bNa);
            }
            Iterator<MarkData> it = bNa.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.wN(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hsE != null) {
                String str = null;
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    if (this.hsF.getErrorCode() != 0) {
                        str = this.hsF.getErrorString();
                    }
                    a.this.hsE.callback(0, str, false);
                } else {
                    a.this.hsE.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.fZD = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hsF;
        final /* synthetic */ a hsG;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hsF = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bNc();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bNd = this.hsG.bNd();
                if (aVar.getCount() - 1 <= bNd) {
                    bNd = aVar.getCount() - 1;
                }
                while (bNd >= 0) {
                    String bW = aVar.bW(bNd, 20);
                    this.mNetWork.u(new ArrayList<>());
                    this.mNetWork.o("data", bW);
                    this.hsF.parserJson(this.mNetWork.ahe());
                    if (!this.mNetWork.ahC().aiC().isRequestSuccess() || this.hsF.getErrorCode() != 0) {
                        break;
                    }
                    bNd -= 20;
                }
                this.hsG.wP(bNd);
                if (bNd >= 0) {
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
                this.mNetWork.ia();
            }
            this.hsG.hsz = null;
            if (this.hsG.hsE != null) {
                this.hsG.hsE.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hsG.hsz = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                str = this.hsF.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hsG.hsE != null) {
                this.hsG.hsE.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean wO(int i) {
        if (this.hsA != null) {
            this.hsA.cancel();
        }
        if (i >= this.hsB.size() || this.hsB.get(i) == null || this.hsB.get(i).getId() == null) {
            return false;
        }
        this.hsA = new C0359a(this.hsB.get(i).getId(), i, this.hsB.get(i).getForumId());
        this.hsA.setPriority(2);
        this.hsA.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0359a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hsF;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0359a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hsF = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hsF = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hsF.parserJson(this.mNetWork.ahe());
            return this.mNetWork.ahC().aiC().isRequestSuccess() && this.hsF.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            a.this.hsA = null;
            if (a.this.hsE != null) {
                a.this.hsE.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hsA = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hsB.size()) {
                    a.this.hsB.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                str = this.hsF.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hsE != null) {
                a.this.hsE.callback(2, bool, str);
            }
        }
    }

    public int bNd() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("uploac_mark_offset", 399);
    }

    public void wP(int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hsy != null) {
            this.hsy.cancel();
        }
        if (this.hsz != null) {
            this.hsz.cancel();
        }
        if (this.hsA != null) {
            this.hsA.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hsE = cVar;
    }

    private void bNe() {
        if (this.hsB != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hsB.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bc(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bc(String str, int i) {
        if (this.hsB != null && v.Z(this.hsB) > 0) {
            Iterator<MarkData> it = this.hsB.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
