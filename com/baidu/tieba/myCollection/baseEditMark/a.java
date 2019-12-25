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
/* loaded from: classes8.dex */
public class a {
    private boolean gTt;
    private b iny = null;
    private c inz = null;
    private C0550a inA = null;
    private int inC = 0;
    private int inD = 0;
    protected com.baidu.tieba.myCollection.c inE = null;
    private ArrayList<MarkData> inB = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.inD;
        aVar.inD = i - 1;
        return i;
    }

    public a() {
        this.gTt = false;
        this.gTt = true;
    }

    public int getOffset() {
        if (this.inB == null) {
            return 0;
        }
        return this.inB.size();
    }

    public int ceW() {
        return this.inD;
    }

    public void yb(int i) {
        this.inD = i;
    }

    public boolean hasMore() {
        return this.inC > 0;
    }

    public void reset() {
        this.inD = 0;
        this.inC = 0;
        this.gTt = true;
    }

    public ArrayList<MarkData> ceX() {
        return this.inB;
    }

    public void aH(ArrayList<MarkData> arrayList) {
        this.inB = arrayList;
    }

    public void aI(ArrayList<MarkData> arrayList) {
        if (this.inB != null && arrayList != null) {
            this.inB.addAll(arrayList);
            cfb();
        }
    }

    public void f(MarkData markData) {
        this.inB.add(markData);
    }

    public int getCount() {
        if (this.inB == null) {
            return 0;
        }
        return this.inB.size();
    }

    public int ceY() {
        return this.inC;
    }

    public void ceZ() {
        ArrayList<MarkData> cJq = com.baidu.tieba.tbadkCore.util.a.cJq();
        if (cJq != null) {
            aH(cJq);
        }
    }

    public String cm(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.inB == null) {
            return null;
        }
        if (i >= this.inB.size()) {
            i2 -= (i - this.inB.size()) - 1;
            i = this.inB.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.inB.get(i5).toJson();
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

    public void EN(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> EO(String str) {
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
                    this.inB.add(markData);
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
        if (this.iny != null) {
            this.iny.cancel();
        }
        this.iny = new b(getOffset());
        this.iny.setPriority(3);
        this.iny.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c inF;
        private int offset;
        private x cHo = null;
        private String data = null;
        Boolean inH = false;

        public b(int i) {
            this.offset = 0;
            this.inF = null;
            this.offset = i;
            this.inF = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.inH = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.inH.booleanValue() && booleanValue) {
                l<String> sx = com.baidu.tbadk.core.c.a.aBV().sx("tb.my_bookmarks");
                if (sx != null) {
                    publishProgress(sx.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.inB == null) {
                    a.this.inB = new ArrayList();
                } else {
                    a.this.inB.clear();
                }
                a.this.inC = 0;
            }
            this.cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cHo.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gTt) {
                this.cHo.addPostData("offset", String.valueOf(0));
            } else {
                this.cHo.addPostData("offset", String.valueOf(this.offset));
            }
            this.cHo.addPostData("rn", String.valueOf(20));
            this.data = this.cHo.postNetData();
            this.inF.parserJson(this.data);
            if (this.cHo.aDB().aEc().isRequestSuccess()) {
                aVar.EN(this.data);
                if (this.offset == 0) {
                    if (a.this.inB == null) {
                        a.this.inB = new ArrayList();
                    } else {
                        a.this.inB.clear();
                    }
                    a.this.inC = 0;
                    if (this.inH.booleanValue()) {
                        Ak(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Ak(String str) {
            l<String> sx;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (sx = com.baidu.tbadk.core.c.a.aBV().sx("tb.my_bookmarks")) != null) {
                sx.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.EO(str);
                if (this.inH.booleanValue()) {
                    a.this.aH(arrayList);
                } else {
                    a.this.aI(arrayList);
                }
            } else {
                a.this.aH(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.inE.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
            }
            a.this.iny = null;
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
            if (this.inF != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.inF.getErrorCode(), this.inF.getErrorString(), new Object[0]);
            }
            a.this.inC = aVar.getCount();
            ArrayList<MarkData> ceX = aVar.ceX();
            if (this.inH.booleanValue()) {
                if (ceX != null && ceX.size() != 0) {
                    a.this.aH(ceX);
                }
            } else {
                a.this.aI(ceX);
            }
            Iterator<MarkData> it = ceX.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.yb(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.inE != null) {
                String str = null;
                if (this.cHo.aDB().aEc().isRequestSuccess()) {
                    if (this.inF.getErrorCode() != 0) {
                        str = this.inF.getErrorString();
                    }
                    a.this.inE.callback(0, str, false);
                } else {
                    a.this.inE.callback(3, this.cHo.getErrorString());
                }
            }
            a.this.gTt = false;
        }
    }

    /* loaded from: classes8.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x cHo;
        private com.baidu.tieba.myCollection.baseEditMark.c inF;
        final /* synthetic */ a inG;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.inF = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.ceZ();
                this.cHo = new x();
                this.cHo.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cfa = this.inG.cfa();
                if (aVar.getCount() - 1 <= cfa) {
                    cfa = aVar.getCount() - 1;
                }
                while (cfa >= 0) {
                    String cm = aVar.cm(cfa, 20);
                    this.cHo.setPostData(new ArrayList<>());
                    this.cHo.addPostData("data", cm);
                    this.inF.parserJson(this.cHo.postNetData());
                    if (!this.cHo.aDB().aEc().isRequestSuccess() || this.inF.getErrorCode() != 0) {
                        break;
                    }
                    cfa -= 20;
                }
                this.inG.yd(cfa);
                if (cfa >= 0) {
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
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
            }
            this.inG.inz = null;
            if (this.inG.inE != null) {
                this.inG.inE.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.inG.inz = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cHo.aDB().aEc().isRequestSuccess()) {
                str = this.inF.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.inG.inE != null) {
                this.inG.inE.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yc(int i) {
        if (this.inA != null) {
            this.inA.cancel();
        }
        if (i >= this.inB.size() || this.inB.get(i) == null || this.inB.get(i).getId() == null) {
            return false;
        }
        this.inA = new C0550a(this.inB.get(i).getId(), i, this.inB.get(i).getForumId());
        this.inA.setPriority(2);
        this.inA.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0550a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cHo = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c inF;
        private int pos;
        private String tid;

        public C0550a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.inF = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.inF = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cHo.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cHo.addPostData("tid", this.tid);
            this.cHo.addPostData("fid", this.fid);
            this.inF.parserJson(this.cHo.postNetData());
            return this.cHo.aDB().aEc().isRequestSuccess() && this.inF.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
            }
            a.this.inA = null;
            if (a.this.inE != null) {
                a.this.inE.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.inA = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.inB.size()) {
                    a.this.inB.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cHo.aDB().aEc().isRequestSuccess()) {
                str = this.inF.getErrorString();
            } else {
                str = this.cHo.getErrorString();
            }
            if (a.this.inE != null) {
                a.this.inE.callback(2, bool, str);
            }
        }
    }

    public int cfa() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yd(int i) {
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.iny != null) {
            this.iny.cancel();
        }
        if (this.inz != null) {
            this.inz.cancel();
        }
        if (this.inA != null) {
            this.inA.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.inE = cVar;
    }

    private void cfb() {
        if (this.inB != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.inB.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bj(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bj(String str, int i) {
        if (this.inB != null && v.getCount(this.inB) > 0) {
            Iterator<MarkData> it = this.inB.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
