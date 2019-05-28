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
    private boolean fZE;
    private b hsB = null;
    private c hsC = null;
    private C0359a hsD = null;
    private int hsF = 0;
    private int hsG = 0;
    protected com.baidu.tieba.myCollection.c hsH = null;
    private ArrayList<MarkData> hsE = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hsG;
        aVar.hsG = i - 1;
        return i;
    }

    public a() {
        this.fZE = false;
        this.fZE = true;
    }

    public int getOffset() {
        if (this.hsE == null) {
            return 0;
        }
        return this.hsE.size();
    }

    public int bNc() {
        return this.hsG;
    }

    public void wN(int i) {
        this.hsG = i;
    }

    public boolean hasMore() {
        return this.hsF >= 20;
    }

    public void reset() {
        this.hsG = 0;
        this.hsF = 0;
        this.fZE = true;
    }

    public ArrayList<MarkData> bNd() {
        return this.hsE;
    }

    public void as(ArrayList<MarkData> arrayList) {
        this.hsE = arrayList;
    }

    public void at(ArrayList<MarkData> arrayList) {
        if (this.hsE != null && arrayList != null) {
            this.hsE.addAll(arrayList);
            bNh();
        }
    }

    public void f(MarkData markData) {
        this.hsE.add(markData);
    }

    public int getCount() {
        if (this.hsE == null) {
            return 0;
        }
        return this.hsE.size();
    }

    public int bNe() {
        return this.hsF;
    }

    public void bNf() {
        ArrayList<MarkData> cnp = com.baidu.tieba.tbadkCore.util.a.cnp();
        if (cnp != null) {
            as(cnp);
        }
    }

    public String bW(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hsE == null) {
            return null;
        }
        if (i >= this.hsE.size()) {
            i2 -= (i - this.hsE.size()) - 1;
            i = this.hsE.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hsE.get(i5).toJson();
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
                    this.hsE.add(markData);
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
        if (this.hsB != null) {
            this.hsB.cancel();
        }
        this.hsB = new b(getOffset());
        this.hsB.setPriority(3);
        this.hsB.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hsI;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hsK = false;

        public b(int i) {
            this.offset = 0;
            this.hsI = null;
            this.offset = i;
            this.hsI = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hsK = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hsK.booleanValue() && booleanValue) {
                l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.my_bookmarks");
                if (mB != null) {
                    publishProgress(mB.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hsE == null) {
                    a.this.hsE = new ArrayList();
                } else {
                    a.this.hsE.clear();
                }
                a.this.hsF = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.fZE) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o("rn", String.valueOf(20));
            this.data = this.mNetWork.ahe();
            this.hsI.parserJson(this.data);
            if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                aVar.Ay(this.data);
                if (this.offset == 0) {
                    if (a.this.hsE == null) {
                        a.this.hsE = new ArrayList();
                    } else {
                        a.this.hsE.clear();
                    }
                    a.this.hsF = 0;
                    if (this.hsK.booleanValue()) {
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
                if (this.hsK.booleanValue()) {
                    a.this.as(arrayList);
                } else {
                    a.this.at(arrayList);
                }
            } else {
                a.this.as(arrayList);
            }
            if (!v.aa(arrayList)) {
                a.this.hsH.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            a.this.hsB = null;
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
            if (this.hsI != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.hsI.getErrorCode(), this.hsI.getErrorString(), new Object[0]);
            }
            a.this.hsF = aVar.getCount();
            ArrayList<MarkData> bNd = aVar.bNd();
            if (this.hsK.booleanValue()) {
                if (bNd != null && bNd.size() != 0) {
                    a.this.as(bNd);
                }
            } else {
                a.this.at(bNd);
            }
            Iterator<MarkData> it = bNd.iterator();
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
            if (a.this.hsH != null) {
                String str = null;
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    if (this.hsI.getErrorCode() != 0) {
                        str = this.hsI.getErrorString();
                    }
                    a.this.hsH.callback(0, str, false);
                } else {
                    a.this.hsH.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.fZE = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hsI;
        final /* synthetic */ a hsJ;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hsI = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bNf();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bNg = this.hsJ.bNg();
                if (aVar.getCount() - 1 <= bNg) {
                    bNg = aVar.getCount() - 1;
                }
                while (bNg >= 0) {
                    String bW = aVar.bW(bNg, 20);
                    this.mNetWork.u(new ArrayList<>());
                    this.mNetWork.o("data", bW);
                    this.hsI.parserJson(this.mNetWork.ahe());
                    if (!this.mNetWork.ahC().aiC().isRequestSuccess() || this.hsI.getErrorCode() != 0) {
                        break;
                    }
                    bNg -= 20;
                }
                this.hsJ.wP(bNg);
                if (bNg >= 0) {
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
            this.hsJ.hsC = null;
            if (this.hsJ.hsH != null) {
                this.hsJ.hsH.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hsJ.hsC = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                str = this.hsI.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hsJ.hsH != null) {
                this.hsJ.hsH.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean wO(int i) {
        if (this.hsD != null) {
            this.hsD.cancel();
        }
        if (i >= this.hsE.size() || this.hsE.get(i) == null || this.hsE.get(i).getId() == null) {
            return false;
        }
        this.hsD = new C0359a(this.hsE.get(i).getId(), i, this.hsE.get(i).getForumId());
        this.hsD.setPriority(2);
        this.hsD.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0359a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hsI;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0359a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hsI = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hsI = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hsI.parserJson(this.mNetWork.ahe());
            return this.mNetWork.ahC().aiC().isRequestSuccess() && this.hsI.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            a.this.hsD = null;
            if (a.this.hsH != null) {
                a.this.hsH.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hsD = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hsE.size()) {
                    a.this.hsE.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                str = this.hsI.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hsH != null) {
                a.this.hsH.callback(2, bool, str);
            }
        }
    }

    public int bNg() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("uploac_mark_offset", 399);
    }

    public void wP(int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hsB != null) {
            this.hsB.cancel();
        }
        if (this.hsC != null) {
            this.hsC.cancel();
        }
        if (this.hsD != null) {
            this.hsD.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hsH = cVar;
    }

    private void bNh() {
        if (this.hsE != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hsE.iterator();
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
        if (this.hsE != null && v.Z(this.hsE) > 0) {
            Iterator<MarkData> it = this.hsE.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
