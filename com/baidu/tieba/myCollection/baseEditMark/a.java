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
/* loaded from: classes11.dex */
public class a {
    private boolean haj;
    private b iuL = null;
    private c iuM = null;
    private C0563a iuN = null;
    private int iuP = 0;
    private int iuQ = 0;
    protected com.baidu.tieba.myCollection.c iuR = null;
    private ArrayList<MarkData> iuO = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.iuQ;
        aVar.iuQ = i - 1;
        return i;
    }

    public a() {
        this.haj = false;
        this.haj = true;
    }

    public int getOffset() {
        if (this.iuO == null) {
            return 0;
        }
        return this.iuO.size();
    }

    public int cig() {
        return this.iuQ;
    }

    public void yv(int i) {
        this.iuQ = i;
    }

    public boolean hasMore() {
        return this.iuP > 0;
    }

    public void reset() {
        this.iuQ = 0;
        this.iuP = 0;
        this.haj = true;
    }

    public ArrayList<MarkData> cih() {
        return this.iuO;
    }

    public void aH(ArrayList<MarkData> arrayList) {
        this.iuO = arrayList;
    }

    public void aI(ArrayList<MarkData> arrayList) {
        if (this.iuO != null && arrayList != null) {
            this.iuO.addAll(arrayList);
            cil();
        }
    }

    public void f(MarkData markData) {
        this.iuO.add(markData);
    }

    public int getCount() {
        if (this.iuO == null) {
            return 0;
        }
        return this.iuO.size();
    }

    public int cii() {
        return this.iuP;
    }

    public void cij() {
        ArrayList<MarkData> cMr = com.baidu.tieba.tbadkCore.util.a.cMr();
        if (cMr != null) {
            aH(cMr);
        }
    }

    public String cn(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.iuO == null) {
            return null;
        }
        if (i >= this.iuO.size()) {
            i2 -= (i - this.iuO.size()) - 1;
            i = this.iuO.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.iuO.get(i5).toJson();
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

    public void Fm(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Fn(String str) {
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
                    this.iuO.add(markData);
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
        if (this.iuL != null) {
            this.iuL.cancel();
        }
        this.iuL = new b(getOffset());
        this.iuL.setPriority(3);
        this.iuL.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c iuS;
        private int offset;
        private x cLQ = null;
        private String data = null;
        Boolean iuU = false;

        public b(int i) {
            this.offset = 0;
            this.iuS = null;
            this.offset = i;
            this.iuS = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.iuU = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.iuU.booleanValue() && booleanValue) {
                l<String> sP = com.baidu.tbadk.core.c.a.aEF().sP("tb.my_bookmarks");
                if (sP != null) {
                    publishProgress(sP.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.iuO == null) {
                    a.this.iuO = new ArrayList();
                } else {
                    a.this.iuO.clear();
                }
                a.this.iuP = 0;
            }
            this.cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cLQ.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.haj) {
                this.cLQ.addPostData("offset", String.valueOf(0));
            } else {
                this.cLQ.addPostData("offset", String.valueOf(this.offset));
            }
            this.cLQ.addPostData("rn", String.valueOf(20));
            this.data = this.cLQ.postNetData();
            this.iuS.parserJson(this.data);
            if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                aVar.Fm(this.data);
                if (this.offset == 0) {
                    if (a.this.iuO == null) {
                        a.this.iuO = new ArrayList();
                    } else {
                        a.this.iuO.clear();
                    }
                    a.this.iuP = 0;
                    if (this.iuU.booleanValue()) {
                        AM(this.data);
                    }
                }
            }
            return aVar;
        }

        private void AM(String str) {
            l<String> sP;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (sP = com.baidu.tbadk.core.c.a.aEF().sP("tb.my_bookmarks")) != null) {
                sP.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Fn(str);
                if (this.iuU.booleanValue()) {
                    a.this.aH(arrayList);
                } else {
                    a.this.aI(arrayList);
                }
            } else {
                a.this.aH(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.iuR.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
            }
            a.this.iuL = null;
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
            if (this.iuS != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.iuS.getErrorCode(), this.iuS.getErrorString(), new Object[0]);
            }
            a.this.iuP = aVar.getCount();
            ArrayList<MarkData> cih = aVar.cih();
            if (this.iuU.booleanValue()) {
                if (cih != null && cih.size() != 0) {
                    a.this.aH(cih);
                }
            } else {
                a.this.aI(cih);
            }
            Iterator<MarkData> it = cih.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.yv(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.iuR != null) {
                String str = null;
                if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                    if (this.iuS.getErrorCode() != 0) {
                        str = this.iuS.getErrorString();
                    }
                    a.this.iuR.callback(0, str, false);
                } else {
                    a.this.iuR.callback(3, this.cLQ.getErrorString());
                }
            }
            a.this.haj = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x cLQ;
        private com.baidu.tieba.myCollection.baseEditMark.c iuS;
        final /* synthetic */ a iuT;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.iuS = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cij();
                this.cLQ = new x();
                this.cLQ.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cik = this.iuT.cik();
                if (aVar.getCount() - 1 <= cik) {
                    cik = aVar.getCount() - 1;
                }
                while (cik >= 0) {
                    String cn = aVar.cn(cik, 20);
                    this.cLQ.setPostData(new ArrayList<>());
                    this.cLQ.addPostData("data", cn);
                    this.iuS.parserJson(this.cLQ.postNetData());
                    if (!this.cLQ.aGk().aGM().isRequestSuccess() || this.iuS.getErrorCode() != 0) {
                        break;
                    }
                    cik -= 20;
                }
                this.iuT.yx(cik);
                if (cik >= 0) {
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
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
            }
            this.iuT.iuM = null;
            if (this.iuT.iuR != null) {
                this.iuT.iuR.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.iuT.iuM = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                str = this.iuS.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.iuT.iuR != null) {
                this.iuT.iuR.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yw(int i) {
        if (this.iuN != null) {
            this.iuN.cancel();
        }
        if (i >= this.iuO.size() || this.iuO.get(i) == null || this.iuO.get(i).getId() == null) {
            return false;
        }
        this.iuN = new C0563a(this.iuO.get(i).getId(), i, this.iuO.get(i).getForumId());
        this.iuN.setPriority(2);
        this.iuN.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0563a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLQ = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c iuS;
        private int pos;
        private String tid;

        public C0563a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.iuS = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.iuS = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cLQ.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cLQ.addPostData("tid", this.tid);
            this.cLQ.addPostData("fid", this.fid);
            this.iuS.parserJson(this.cLQ.postNetData());
            return this.cLQ.aGk().aGM().isRequestSuccess() && this.iuS.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
            }
            a.this.iuN = null;
            if (a.this.iuR != null) {
                a.this.iuR.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.iuN = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.iuO.size()) {
                    a.this.iuO.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                str = this.iuS.getErrorString();
            } else {
                str = this.cLQ.getErrorString();
            }
            if (a.this.iuR != null) {
                a.this.iuR.callback(2, bool, str);
            }
        }
    }

    public int cik() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yx(int i) {
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.iuL != null) {
            this.iuL.cancel();
        }
        if (this.iuM != null) {
            this.iuM.cancel();
        }
        if (this.iuN != null) {
            this.iuN.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.iuR = cVar;
    }

    private void cil() {
        if (this.iuO != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.iuO.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bi(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bi(String str, int i) {
        if (this.iuO != null && v.getCount(this.iuO) > 0) {
            Iterator<MarkData> it = this.iuO.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
