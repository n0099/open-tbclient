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
/* loaded from: classes6.dex */
public class a {
    private boolean ggI;
    private b hAl = null;
    private c hAm = null;
    private C0469a hAn = null;
    private int hAp = 0;
    private int hAq = 0;
    protected com.baidu.tieba.myCollection.c hAr = null;
    private ArrayList<MarkData> hAo = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hAq;
        aVar.hAq = i - 1;
        return i;
    }

    public a() {
        this.ggI = false;
        this.ggI = true;
    }

    public int getOffset() {
        if (this.hAo == null) {
            return 0;
        }
        return this.hAo.size();
    }

    public int bNM() {
        return this.hAq;
    }

    public void wb(int i) {
        this.hAq = i;
    }

    public boolean hasMore() {
        return this.hAp > 0;
    }

    public void reset() {
        this.hAq = 0;
        this.hAp = 0;
        this.ggI = true;
    }

    public ArrayList<MarkData> bNN() {
        return this.hAo;
    }

    public void aw(ArrayList<MarkData> arrayList) {
        this.hAo = arrayList;
    }

    public void ax(ArrayList<MarkData> arrayList) {
        if (this.hAo != null && arrayList != null) {
            this.hAo.addAll(arrayList);
            bNR();
        }
    }

    public void f(MarkData markData) {
        this.hAo.add(markData);
    }

    public int getCount() {
        if (this.hAo == null) {
            return 0;
        }
        return this.hAo.size();
    }

    public int bNO() {
        return this.hAp;
    }

    public void bNP() {
        ArrayList<MarkData> cpm = com.baidu.tieba.tbadkCore.util.a.cpm();
        if (cpm != null) {
            aw(cpm);
        }
    }

    public String bV(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hAo == null) {
            return null;
        }
        if (i >= this.hAo.size()) {
            i2 -= (i - this.hAo.size()) - 1;
            i = this.hAo.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hAo.get(i5).toJson();
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

    public void Af(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Ag(String str) {
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
                    this.hAo.add(markData);
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
        if (this.hAl != null) {
            this.hAl.cancel();
        }
        this.hAl = new b(getOffset());
        this.hAl.setPriority(3);
        this.hAl.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hAs;
        private int offset;
        private x bVP = null;
        private String data = null;
        Boolean hAu = false;

        public b(int i) {
            this.offset = 0;
            this.hAs = null;
            this.offset = i;
            this.hAs = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.hAu = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hAu.booleanValue() && booleanValue) {
                l<String> nl = com.baidu.tbadk.core.d.a.akN().nl("tb.my_bookmarks");
                if (nl != null) {
                    publishProgress(nl.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hAo == null) {
                    a.this.hAo = new ArrayList();
                } else {
                    a.this.hAo.clear();
                }
                a.this.hAp = 0;
            }
            this.bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bVP.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ggI) {
                this.bVP.addPostData("offset", String.valueOf(0));
            } else {
                this.bVP.addPostData("offset", String.valueOf(this.offset));
            }
            this.bVP.addPostData("rn", String.valueOf(20));
            this.data = this.bVP.postNetData();
            this.hAs.parserJson(this.data);
            if (this.bVP.amr().amS().isRequestSuccess()) {
                aVar.Af(this.data);
                if (this.offset == 0) {
                    if (a.this.hAo == null) {
                        a.this.hAo = new ArrayList();
                    } else {
                        a.this.hAo.clear();
                    }
                    a.this.hAp = 0;
                    if (this.hAu.booleanValue()) {
                        vs(this.data);
                    }
                }
            }
            return aVar;
        }

        private void vs(String str) {
            l<String> nl;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (nl = com.baidu.tbadk.core.d.a.akN().nl("tb.my_bookmarks")) != null) {
                nl.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Ag(str);
                if (this.hAu.booleanValue()) {
                    a.this.aw(arrayList);
                } else {
                    a.this.ax(arrayList);
                }
            } else {
                a.this.aw(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.hAr.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
            }
            a.this.hAl = null;
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
            if (this.hAs != null) {
                com.baidu.tbadk.core.e.a.a("collection", 0L, 0, "collection_thread_list_result", this.hAs.getErrorCode(), this.hAs.getErrorString(), new Object[0]);
            }
            a.this.hAp = aVar.getCount();
            ArrayList<MarkData> bNN = aVar.bNN();
            if (this.hAu.booleanValue()) {
                if (bNN != null && bNN.size() != 0) {
                    a.this.aw(bNN);
                }
            } else {
                a.this.ax(bNN);
            }
            Iterator<MarkData> it = bNN.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.wb(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hAr != null) {
                String str = null;
                if (this.bVP.amr().amS().isRequestSuccess()) {
                    if (this.hAs.getErrorCode() != 0) {
                        str = this.hAs.getErrorString();
                    }
                    a.this.hAr.callback(0, str, false);
                } else {
                    a.this.hAr.callback(3, this.bVP.getErrorString());
                }
            }
            a.this.ggI = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x bVP;
        private com.baidu.tieba.myCollection.baseEditMark.c hAs;
        final /* synthetic */ a hAt;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hAs = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bNP();
                this.bVP = new x();
                this.bVP.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bNQ = this.hAt.bNQ();
                if (aVar.getCount() - 1 <= bNQ) {
                    bNQ = aVar.getCount() - 1;
                }
                while (bNQ >= 0) {
                    String bV = aVar.bV(bNQ, 20);
                    this.bVP.setPostData(new ArrayList<>());
                    this.bVP.addPostData("data", bV);
                    this.hAs.parserJson(this.bVP.postNetData());
                    if (!this.bVP.amr().amS().isRequestSuccess() || this.hAs.getErrorCode() != 0) {
                        break;
                    }
                    bNQ -= 20;
                }
                this.hAt.wd(bNQ);
                if (bNQ >= 0) {
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
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
            }
            this.hAt.hAm = null;
            if (this.hAt.hAr != null) {
                this.hAt.hAr.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hAt.hAm = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bVP.amr().amS().isRequestSuccess()) {
                str = this.hAs.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hAt.hAr != null) {
                this.hAt.hAr.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean wc(int i) {
        if (this.hAn != null) {
            this.hAn.cancel();
        }
        if (i >= this.hAo.size() || this.hAo.get(i) == null || this.hAo.get(i).getId() == null) {
            return false;
        }
        this.hAn = new C0469a(this.hAo.get(i).getId(), i, this.hAo.get(i).getForumId());
        this.hAn.setPriority(2);
        this.hAn.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0469a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x bVP = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hAs;
        private int pos;
        private String tid;

        public C0469a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hAs = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hAs = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bVP.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bVP.addPostData("tid", this.tid);
            this.bVP.addPostData("fid", this.fid);
            this.hAs.parserJson(this.bVP.postNetData());
            return this.bVP.amr().amS().isRequestSuccess() && this.hAs.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
            }
            a.this.hAn = null;
            if (a.this.hAr != null) {
                a.this.hAr.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hAn = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hAo.size()) {
                    a.this.hAo.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bVP.amr().amS().isRequestSuccess()) {
                str = this.hAs.getErrorString();
            } else {
                str = this.bVP.getErrorString();
            }
            if (a.this.hAr != null) {
                a.this.hAr.callback(2, bool, str);
            }
        }
    }

    public int bNQ() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void wd(int i) {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.hAl != null) {
            this.hAl.cancel();
        }
        if (this.hAm != null) {
            this.hAm.cancel();
        }
        if (this.hAn != null) {
            this.hAn.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hAr = cVar;
    }

    private void bNR() {
        if (this.hAo != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hAo.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    ba(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void ba(String str, int i) {
        if (this.hAo != null && v.getCount(this.hAo) > 0) {
            Iterator<MarkData> it = this.hAo.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
