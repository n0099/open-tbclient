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
    private boolean gYO;
    private b isX = null;
    private c isY = null;
    private C0562a isZ = null;
    private int itb = 0;
    private int itc = 0;
    protected com.baidu.tieba.myCollection.c itd = null;
    private ArrayList<MarkData> ita = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.itc;
        aVar.itc = i - 1;
        return i;
    }

    public a() {
        this.gYO = false;
        this.gYO = true;
    }

    public int getOffset() {
        if (this.ita == null) {
            return 0;
        }
        return this.ita.size();
    }

    public int chJ() {
        return this.itc;
    }

    public void yn(int i) {
        this.itc = i;
    }

    public boolean hasMore() {
        return this.itb > 0;
    }

    public void reset() {
        this.itc = 0;
        this.itb = 0;
        this.gYO = true;
    }

    public ArrayList<MarkData> chK() {
        return this.ita;
    }

    public void aH(ArrayList<MarkData> arrayList) {
        this.ita = arrayList;
    }

    public void aI(ArrayList<MarkData> arrayList) {
        if (this.ita != null && arrayList != null) {
            this.ita.addAll(arrayList);
            chO();
        }
    }

    public void f(MarkData markData) {
        this.ita.add(markData);
    }

    public int getCount() {
        if (this.ita == null) {
            return 0;
        }
        return this.ita.size();
    }

    public int chL() {
        return this.itb;
    }

    public void chM() {
        ArrayList<MarkData> cLU = com.baidu.tieba.tbadkCore.util.a.cLU();
        if (cLU != null) {
            aH(cLU);
        }
    }

    public String cm(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.ita == null) {
            return null;
        }
        if (i >= this.ita.size()) {
            i2 -= (i - this.ita.size()) - 1;
            i = this.ita.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.ita.get(i5).toJson();
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
                    this.ita.add(markData);
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
        if (this.isX != null) {
            this.isX.cancel();
        }
        this.isX = new b(getOffset());
        this.isX.setPriority(3);
        this.isX.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c ite;
        private int offset;
        private x cLD = null;
        private String data = null;
        Boolean itg = false;

        public b(int i) {
            this.offset = 0;
            this.ite = null;
            this.offset = i;
            this.ite = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.itg = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.itg.booleanValue() && booleanValue) {
                l<String> sQ = com.baidu.tbadk.core.c.a.aEz().sQ("tb.my_bookmarks");
                if (sQ != null) {
                    publishProgress(sQ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.ita == null) {
                    a.this.ita = new ArrayList();
                } else {
                    a.this.ita.clear();
                }
                a.this.itb = 0;
            }
            this.cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cLD.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gYO) {
                this.cLD.addPostData("offset", String.valueOf(0));
            } else {
                this.cLD.addPostData("offset", String.valueOf(this.offset));
            }
            this.cLD.addPostData("rn", String.valueOf(20));
            this.data = this.cLD.postNetData();
            this.ite.parserJson(this.data);
            if (this.cLD.aGe().aGG().isRequestSuccess()) {
                aVar.Fm(this.data);
                if (this.offset == 0) {
                    if (a.this.ita == null) {
                        a.this.ita = new ArrayList();
                    } else {
                        a.this.ita.clear();
                    }
                    a.this.itb = 0;
                    if (this.itg.booleanValue()) {
                        AK(this.data);
                    }
                }
            }
            return aVar;
        }

        private void AK(String str) {
            l<String> sQ;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (sQ = com.baidu.tbadk.core.c.a.aEz().sQ("tb.my_bookmarks")) != null) {
                sQ.set(currentAccount, str, 604800000L);
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
                if (this.itg.booleanValue()) {
                    a.this.aH(arrayList);
                } else {
                    a.this.aI(arrayList);
                }
            } else {
                a.this.aH(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.itd.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
            }
            a.this.isX = null;
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
            if (this.ite != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.ite.getErrorCode(), this.ite.getErrorString(), new Object[0]);
            }
            a.this.itb = aVar.getCount();
            ArrayList<MarkData> chK = aVar.chK();
            if (this.itg.booleanValue()) {
                if (chK != null && chK.size() != 0) {
                    a.this.aH(chK);
                }
            } else {
                a.this.aI(chK);
            }
            Iterator<MarkData> it = chK.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.yn(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.itd != null) {
                String str = null;
                if (this.cLD.aGe().aGG().isRequestSuccess()) {
                    if (this.ite.getErrorCode() != 0) {
                        str = this.ite.getErrorString();
                    }
                    a.this.itd.callback(0, str, false);
                } else {
                    a.this.itd.callback(3, this.cLD.getErrorString());
                }
            }
            a.this.gYO = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x cLD;
        private com.baidu.tieba.myCollection.baseEditMark.c ite;
        final /* synthetic */ a itf;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ite = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.chM();
                this.cLD = new x();
                this.cLD.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int chN = this.itf.chN();
                if (aVar.getCount() - 1 <= chN) {
                    chN = aVar.getCount() - 1;
                }
                while (chN >= 0) {
                    String cm = aVar.cm(chN, 20);
                    this.cLD.setPostData(new ArrayList<>());
                    this.cLD.addPostData("data", cm);
                    this.ite.parserJson(this.cLD.postNetData());
                    if (!this.cLD.aGe().aGG().isRequestSuccess() || this.ite.getErrorCode() != 0) {
                        break;
                    }
                    chN -= 20;
                }
                this.itf.yp(chN);
                if (chN >= 0) {
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
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
            }
            this.itf.isY = null;
            if (this.itf.itd != null) {
                this.itf.itd.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.itf.isY = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cLD.aGe().aGG().isRequestSuccess()) {
                str = this.ite.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.itf.itd != null) {
                this.itf.itd.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yo(int i) {
        if (this.isZ != null) {
            this.isZ.cancel();
        }
        if (i >= this.ita.size() || this.ita.get(i) == null || this.ita.get(i).getId() == null) {
            return false;
        }
        this.isZ = new C0562a(this.ita.get(i).getId(), i, this.ita.get(i).getForumId());
        this.isZ.setPriority(2);
        this.isZ.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0562a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLD = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c ite;
        private int pos;
        private String tid;

        public C0562a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.ite = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.ite = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cLD.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cLD.addPostData("tid", this.tid);
            this.cLD.addPostData("fid", this.fid);
            this.ite.parserJson(this.cLD.postNetData());
            return this.cLD.aGe().aGG().isRequestSuccess() && this.ite.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
            }
            a.this.isZ = null;
            if (a.this.itd != null) {
                a.this.itd.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.isZ = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.ita.size()) {
                    a.this.ita.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cLD.aGe().aGG().isRequestSuccess()) {
                str = this.ite.getErrorString();
            } else {
                str = this.cLD.getErrorString();
            }
            if (a.this.itd != null) {
                a.this.itd.callback(2, bool, str);
            }
        }
    }

    public int chN() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yp(int i) {
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.isX != null) {
            this.isX.cancel();
        }
        if (this.isY != null) {
            this.isY.cancel();
        }
        if (this.isZ != null) {
            this.isZ.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.itd = cVar;
    }

    private void chO() {
        if (this.ita != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.ita.iterator();
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
        if (this.ita != null && v.getCount(this.ita) > 0) {
            Iterator<MarkData> it = this.ita.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
