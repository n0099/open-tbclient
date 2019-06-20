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
    private boolean fZG;
    private b hsC = null;
    private c hsD = null;
    private C0359a hsE = null;
    private int hsG = 0;
    private int hsH = 0;
    protected com.baidu.tieba.myCollection.c hsI = null;
    private ArrayList<MarkData> hsF = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hsH;
        aVar.hsH = i - 1;
        return i;
    }

    public a() {
        this.fZG = false;
        this.fZG = true;
    }

    public int getOffset() {
        if (this.hsF == null) {
            return 0;
        }
        return this.hsF.size();
    }

    public int bNd() {
        return this.hsH;
    }

    public void wN(int i) {
        this.hsH = i;
    }

    public boolean hasMore() {
        return this.hsG > 0;
    }

    public void reset() {
        this.hsH = 0;
        this.hsG = 0;
        this.fZG = true;
    }

    public ArrayList<MarkData> bNe() {
        return this.hsF;
    }

    public void as(ArrayList<MarkData> arrayList) {
        this.hsF = arrayList;
    }

    public void at(ArrayList<MarkData> arrayList) {
        if (this.hsF != null && arrayList != null) {
            this.hsF.addAll(arrayList);
            bNi();
        }
    }

    public void f(MarkData markData) {
        this.hsF.add(markData);
    }

    public int getCount() {
        if (this.hsF == null) {
            return 0;
        }
        return this.hsF.size();
    }

    public int bNf() {
        return this.hsG;
    }

    public void bNg() {
        ArrayList<MarkData> cnq = com.baidu.tieba.tbadkCore.util.a.cnq();
        if (cnq != null) {
            as(cnq);
        }
    }

    public String bW(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hsF == null) {
            return null;
        }
        if (i >= this.hsF.size()) {
            i2 -= (i - this.hsF.size()) - 1;
            i = this.hsF.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hsF.get(i5).toJson();
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

    public void AA(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> AB(String str) {
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
                    this.hsF.add(markData);
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
        if (this.hsC != null) {
            this.hsC.cancel();
        }
        this.hsC = new b(getOffset());
        this.hsC.setPriority(3);
        this.hsC.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hsJ;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hsL = false;

        public b(int i) {
            this.offset = 0;
            this.hsJ = null;
            this.offset = i;
            this.hsJ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hsL = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hsL.booleanValue() && booleanValue) {
                l<String> mA = com.baidu.tbadk.core.c.a.afD().mA("tb.my_bookmarks");
                if (mA != null) {
                    publishProgress(mA.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hsF == null) {
                    a.this.hsF = new ArrayList();
                } else {
                    a.this.hsF.clear();
                }
                a.this.hsG = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.fZG) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o("rn", String.valueOf(20));
            this.data = this.mNetWork.ahe();
            this.hsJ.parserJson(this.data);
            if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                aVar.AA(this.data);
                if (this.offset == 0) {
                    if (a.this.hsF == null) {
                        a.this.hsF = new ArrayList();
                    } else {
                        a.this.hsF.clear();
                    }
                    a.this.hsG = 0;
                    if (this.hsL.booleanValue()) {
                        vP(this.data);
                    }
                }
            }
            return aVar;
        }

        private void vP(String str) {
            l<String> mA;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (mA = com.baidu.tbadk.core.c.a.afD().mA("tb.my_bookmarks")) != null) {
                mA.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.AB(str);
                if (this.hsL.booleanValue()) {
                    a.this.as(arrayList);
                } else {
                    a.this.at(arrayList);
                }
            } else {
                a.this.as(arrayList);
            }
            if (!v.aa(arrayList)) {
                a.this.hsI.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            a.this.hsC = null;
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
            if (this.hsJ != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.hsJ.getErrorCode(), this.hsJ.getErrorString(), new Object[0]);
            }
            a.this.hsG = aVar.getCount();
            ArrayList<MarkData> bNe = aVar.bNe();
            if (this.hsL.booleanValue()) {
                if (bNe != null && bNe.size() != 0) {
                    a.this.as(bNe);
                }
            } else {
                a.this.at(bNe);
            }
            Iterator<MarkData> it = bNe.iterator();
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
            if (a.this.hsI != null) {
                String str = null;
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    if (this.hsJ.getErrorCode() != 0) {
                        str = this.hsJ.getErrorString();
                    }
                    a.this.hsI.callback(0, str, false);
                } else {
                    a.this.hsI.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.fZG = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hsJ;
        final /* synthetic */ a hsK;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hsJ = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bNg();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bNh = this.hsK.bNh();
                if (aVar.getCount() - 1 <= bNh) {
                    bNh = aVar.getCount() - 1;
                }
                while (bNh >= 0) {
                    String bW = aVar.bW(bNh, 20);
                    this.mNetWork.u(new ArrayList<>());
                    this.mNetWork.o("data", bW);
                    this.hsJ.parserJson(this.mNetWork.ahe());
                    if (!this.mNetWork.ahC().aiC().isRequestSuccess() || this.hsJ.getErrorCode() != 0) {
                        break;
                    }
                    bNh -= 20;
                }
                this.hsK.wP(bNh);
                if (bNh >= 0) {
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
            this.hsK.hsD = null;
            if (this.hsK.hsI != null) {
                this.hsK.hsI.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hsK.hsD = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                str = this.hsJ.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hsK.hsI != null) {
                this.hsK.hsI.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean wO(int i) {
        if (this.hsE != null) {
            this.hsE.cancel();
        }
        if (i >= this.hsF.size() || this.hsF.get(i) == null || this.hsF.get(i).getId() == null) {
            return false;
        }
        this.hsE = new C0359a(this.hsF.get(i).getId(), i, this.hsF.get(i).getForumId());
        this.hsE.setPriority(2);
        this.hsE.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0359a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hsJ;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0359a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hsJ = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hsJ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hsJ.parserJson(this.mNetWork.ahe());
            return this.mNetWork.ahC().aiC().isRequestSuccess() && this.hsJ.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            a.this.hsE = null;
            if (a.this.hsI != null) {
                a.this.hsI.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hsE = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hsF.size()) {
                    a.this.hsF.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                str = this.hsJ.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hsI != null) {
                a.this.hsI.callback(2, bool, str);
            }
        }
    }

    public int bNh() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("uploac_mark_offset", 399);
    }

    public void wP(int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hsC != null) {
            this.hsC.cancel();
        }
        if (this.hsD != null) {
            this.hsD.cancel();
        }
        if (this.hsE != null) {
            this.hsE.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hsI = cVar;
    }

    private void bNi() {
        if (this.hsF != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hsF.iterator();
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
        if (this.hsF != null && v.Z(this.hsF) > 0) {
            Iterator<MarkData> it = this.hsF.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
