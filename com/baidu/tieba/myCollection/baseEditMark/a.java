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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class a {
    private boolean iIo;
    private b kkx = null;
    private c kky = null;
    private C0748a kkz = null;
    private int kkB = 0;
    private int kkC = 0;
    protected com.baidu.tieba.myCollection.c kkD = null;
    private ArrayList<MarkData> kkA = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.kkC;
        aVar.kkC = i - 1;
        return i;
    }

    public a() {
        this.iIo = false;
        this.iIo = true;
    }

    public int getOffset() {
        if (this.kkA == null) {
            return 0;
        }
        return this.kkA.size();
    }

    public int cSa() {
        return this.kkC;
    }

    public void Dk(int i) {
        this.kkC = i;
    }

    public boolean hasMore() {
        return this.kkB > 0;
    }

    public void reset() {
        this.kkC = 0;
        this.kkB = 0;
        this.iIo = true;
    }

    public ArrayList<MarkData> cSb() {
        return this.kkA;
    }

    public void aR(ArrayList<MarkData> arrayList) {
        this.kkA = arrayList;
    }

    public void aS(ArrayList<MarkData> arrayList) {
        if (this.kkA != null && arrayList != null) {
            this.kkA.addAll(arrayList);
            cSf();
        }
    }

    public void f(MarkData markData) {
        this.kkA.add(markData);
    }

    public int getCount() {
        if (this.kkA == null) {
            return 0;
        }
        return this.kkA.size();
    }

    public int cSc() {
        return this.kkB;
    }

    public void cSd() {
        ArrayList<MarkData> dxD = com.baidu.tieba.tbadkCore.util.a.dxD();
        if (dxD != null) {
            aR(dxD);
        }
    }

    public String cP(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.kkA == null) {
            return null;
        }
        if (i >= this.kkA.size()) {
            i2 -= (i - this.kkA.size()) - 1;
            i = this.kkA.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.kkA.get(i5).toJson();
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

    public void MO(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> MP(String str) {
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
                    this.kkA.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void n(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.kkx != null) {
            this.kkx.cancel();
        }
        this.kkx = new b(getOffset());
        this.kkx.setPriority(3);
        this.kkx.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c kkE;
        private int offset;
        private aa bEb = null;
        private String data = null;
        Boolean kkG = false;

        public b(int i) {
            this.offset = 0;
            this.kkE = null;
            this.offset = i;
            this.kkE = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.kkG = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.kkG.booleanValue() && booleanValue) {
                l<String> zy = com.baidu.tbadk.core.c.a.bhb().zy("tb.my_bookmarks");
                if (zy != null) {
                    publishProgress(zy.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.kkA == null) {
                    a.this.kkA = new ArrayList();
                } else {
                    a.this.kkA.clear();
                }
                a.this.kkB = 0;
            }
            this.bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bEb.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.iIo) {
                this.bEb.addPostData("offset", String.valueOf(0));
            } else {
                this.bEb.addPostData("offset", String.valueOf(this.offset));
            }
            this.bEb.addPostData("rn", String.valueOf(20));
            this.data = this.bEb.postNetData();
            this.kkE.parserJson(this.data);
            if (this.bEb.biQ().bjw().isRequestSuccess()) {
                aVar.MO(this.data);
                if (this.offset == 0) {
                    if (a.this.kkA == null) {
                        a.this.kkA = new ArrayList();
                    } else {
                        a.this.kkA.clear();
                    }
                    a.this.kkB = 0;
                    if (this.kkG.booleanValue()) {
                        HX(this.data);
                    }
                }
            }
            return aVar;
        }

        private void HX(String str) {
            l<String> zy;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (zy = com.baidu.tbadk.core.c.a.bhb().zy("tb.my_bookmarks")) != null) {
                zy.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.MP(str);
                if (this.kkG.booleanValue()) {
                    a.this.aR(arrayList);
                } else {
                    a.this.aS(arrayList);
                }
            } else {
                a.this.aR(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.kkD.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            a.this.kkx = null;
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
            if (this.kkE != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.kkE.getErrorCode(), this.kkE.getErrorString(), new Object[0]);
            }
            a.this.kkB = aVar.getCount();
            ArrayList<MarkData> cSb = aVar.cSb();
            if (this.kkG.booleanValue()) {
                if (cSb != null && cSb.size() != 0) {
                    a.this.aR(cSb);
                }
            } else {
                a.this.aS(cSb);
            }
            Iterator<MarkData> it = cSb.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.Dk(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.kkD != null) {
                String str = null;
                if (this.bEb.biQ().bjw().isRequestSuccess()) {
                    if (this.kkE.getErrorCode() != 0) {
                        str = this.kkE.getErrorString();
                    }
                    a.this.kkD.callback(0, str, false);
                } else {
                    a.this.kkD.callback(3, this.bEb.getErrorString());
                }
            }
            a.this.iIo = false;
        }
    }

    /* loaded from: classes18.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa bEb;
        private com.baidu.tieba.myCollection.baseEditMark.c kkE;
        final /* synthetic */ a kkF;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.kkE = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cSd();
                this.bEb = new aa();
                this.bEb.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cSe = this.kkF.cSe();
                if (aVar.getCount() - 1 <= cSe) {
                    cSe = aVar.getCount() - 1;
                }
                while (cSe >= 0) {
                    String cP = aVar.cP(cSe, 20);
                    this.bEb.setPostData(new ArrayList<>());
                    this.bEb.addPostData("data", cP);
                    this.kkE.parserJson(this.bEb.postNetData());
                    if (!this.bEb.biQ().bjw().isRequestSuccess() || this.kkE.getErrorCode() != 0) {
                        break;
                    }
                    cSe -= 20;
                }
                this.kkF.Dm(cSe);
                if (cSe >= 0) {
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
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            this.kkF.kky = null;
            if (this.kkF.kkD != null) {
                this.kkF.kkD.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.kkF.kky = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bEb.biQ().bjw().isRequestSuccess()) {
                str = this.kkE.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.kkF.kkD != null) {
                this.kkF.kkD.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Dl(int i) {
        if (this.kkz != null) {
            this.kkz.cancel();
        }
        if (i >= this.kkA.size() || this.kkA.get(i) == null || this.kkA.get(i).getId() == null) {
            return false;
        }
        this.kkz = new C0748a(this.kkA.get(i).getId(), i, this.kkA.get(i).getForumId());
        this.kkz.setPriority(2);
        this.kkz.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0748a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bEb = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c kkE;
        private int pos;
        private String tid;

        public C0748a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.kkE = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.kkE = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bEb.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bEb.addPostData("tid", this.tid);
            this.bEb.addPostData("fid", this.fid);
            this.kkE.parserJson(this.bEb.postNetData());
            return this.bEb.biQ().bjw().isRequestSuccess() && this.kkE.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            a.this.kkz = null;
            if (a.this.kkD != null) {
                a.this.kkD.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.kkz = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.kkA.size()) {
                    a.this.kkA.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bEb.biQ().bjw().isRequestSuccess()) {
                str = this.kkE.getErrorString();
            } else {
                str = this.bEb.getErrorString();
            }
            if (a.this.kkD != null) {
                a.this.kkD.callback(2, bool, str);
            }
        }
    }

    public int cSe() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Dm(int i) {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.kkx != null) {
            this.kkx.cancel();
        }
        if (this.kky != null) {
            this.kky.cancel();
        }
        if (this.kkz != null) {
            this.kkz.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.kkD = cVar;
    }

    private void cSf() {
        if (this.kkA != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.kkA.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bu(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bu(String str, int i) {
        if (this.kkA != null && y.getCount(this.kkA) > 0) {
            Iterator<MarkData> it = this.kkA.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
