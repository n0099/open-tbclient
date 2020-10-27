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
/* loaded from: classes24.dex */
public class a {
    private boolean jsh;
    private b kUF = null;
    private c kUG = null;
    private C0778a kUH = null;
    private int kUJ = 0;
    private int kUK = 0;
    protected com.baidu.tieba.myCollection.c kUL = null;
    private ArrayList<MarkData> kUI = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.kUK;
        aVar.kUK = i - 1;
        return i;
    }

    public a() {
        this.jsh = false;
        this.jsh = true;
    }

    public int getOffset() {
        if (this.kUI == null) {
            return 0;
        }
        return this.kUI.size();
    }

    public int dcw() {
        return this.kUK;
    }

    public void EK(int i) {
        this.kUK = i;
    }

    public boolean hasMore() {
        return this.kUJ > 0;
    }

    public void reset() {
        this.kUK = 0;
        this.kUJ = 0;
        this.jsh = true;
    }

    public ArrayList<MarkData> dcx() {
        return this.kUI;
    }

    public void aW(ArrayList<MarkData> arrayList) {
        this.kUI = arrayList;
    }

    public void aX(ArrayList<MarkData> arrayList) {
        if (this.kUI != null && arrayList != null) {
            this.kUI.addAll(arrayList);
            dcB();
        }
    }

    public void f(MarkData markData) {
        this.kUI.add(markData);
    }

    public int getCount() {
        if (this.kUI == null) {
            return 0;
        }
        return this.kUI.size();
    }

    public int dcy() {
        return this.kUJ;
    }

    public void dcz() {
        ArrayList<MarkData> dIq = com.baidu.tieba.tbadkCore.util.a.dIq();
        if (dIq != null) {
            aW(dIq);
        }
    }

    public String cU(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.kUI == null) {
            return null;
        }
        if (i >= this.kUI.size()) {
            i2 -= (i - this.kUI.size()) - 1;
            i = this.kUI.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.kUI.get(i5).toJson();
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

    public void OD(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> OE(String str) {
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
                    this.kUI.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void p(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.kUF != null) {
            this.kUF.cancel();
        }
        this.kUF = new b(getOffset());
        this.kUF.setPriority(3);
        this.kUF.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c kUM;
        private int offset;
        private aa bVi = null;
        private String data = null;
        Boolean kUO = false;

        public b(int i) {
            this.offset = 0;
            this.kUM = null;
            this.offset = i;
            this.kUM = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.kUO = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.kUO.booleanValue() && booleanValue) {
                l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.my_bookmarks");
                if (AY != null) {
                    publishProgress(AY.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.kUI == null) {
                    a.this.kUI = new ArrayList();
                } else {
                    a.this.kUI.clear();
                }
                a.this.kUJ = 0;
            }
            this.bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bVi.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jsh) {
                this.bVi.addPostData("offset", String.valueOf(0));
            } else {
                this.bVi.addPostData("offset", String.valueOf(this.offset));
            }
            this.bVi.addPostData("rn", String.valueOf(20));
            this.data = this.bVi.postNetData();
            this.kUM.parserJson(this.data);
            if (this.bVi.bon().boU().isRequestSuccess()) {
                aVar.OD(this.data);
                if (this.offset == 0) {
                    if (a.this.kUI == null) {
                        a.this.kUI = new ArrayList();
                    } else {
                        a.this.kUI.clear();
                    }
                    a.this.kUJ = 0;
                    if (this.kUO.booleanValue()) {
                        JG(this.data);
                    }
                }
            }
            return aVar;
        }

        private void JG(String str) {
            l<String> AY;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.my_bookmarks")) != null) {
                AY.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.OE(str);
                if (this.kUO.booleanValue()) {
                    a.this.aW(arrayList);
                } else {
                    a.this.aX(arrayList);
                }
            } else {
                a.this.aW(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.kUL.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            a.this.kUF = null;
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
            if (this.kUM != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.kUM.getErrorCode(), this.kUM.getErrorString(), new Object[0]);
            }
            a.this.kUJ = aVar.getCount();
            ArrayList<MarkData> dcx = aVar.dcx();
            if (this.kUO.booleanValue()) {
                if (dcx != null && dcx.size() != 0) {
                    a.this.aW(dcx);
                }
            } else {
                a.this.aX(dcx);
            }
            Iterator<MarkData> it = dcx.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.EK(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.kUL != null) {
                String str = null;
                if (this.bVi.bon().boU().isRequestSuccess()) {
                    if (this.kUM.getErrorCode() != 0) {
                        str = this.kUM.getErrorString();
                    }
                    a.this.kUL.callback(0, str, false);
                } else {
                    a.this.kUL.callback(3, this.bVi.getErrorString());
                }
            }
            a.this.jsh = false;
        }
    }

    /* loaded from: classes24.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa bVi;
        private com.baidu.tieba.myCollection.baseEditMark.c kUM;
        final /* synthetic */ a kUN;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.kUM = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dcz();
                this.bVi = new aa();
                this.bVi.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dcA = this.kUN.dcA();
                if (aVar.getCount() - 1 <= dcA) {
                    dcA = aVar.getCount() - 1;
                }
                while (dcA >= 0) {
                    String cU = aVar.cU(dcA, 20);
                    this.bVi.setPostData(new ArrayList<>());
                    this.bVi.addPostData("data", cU);
                    this.kUM.parserJson(this.bVi.postNetData());
                    if (!this.bVi.bon().boU().isRequestSuccess() || this.kUM.getErrorCode() != 0) {
                        break;
                    }
                    dcA -= 20;
                }
                this.kUN.EM(dcA);
                if (dcA >= 0) {
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
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            this.kUN.kUG = null;
            if (this.kUN.kUL != null) {
                this.kUN.kUL.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.kUN.kUG = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bVi.bon().boU().isRequestSuccess()) {
                str = this.kUM.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.kUN.kUL != null) {
                this.kUN.kUL.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean EL(int i) {
        if (this.kUH != null) {
            this.kUH.cancel();
        }
        if (i >= this.kUI.size() || this.kUI.get(i) == null || this.kUI.get(i).getId() == null) {
            return false;
        }
        this.kUH = new C0778a(this.kUI.get(i).getId(), i, this.kUI.get(i).getForumId());
        this.kUH.setPriority(2);
        this.kUH.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0778a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bVi = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c kUM;
        private int pos;
        private String tid;

        public C0778a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.kUM = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.kUM = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bVi.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bVi.addPostData("tid", this.tid);
            this.bVi.addPostData("fid", this.fid);
            this.kUM.parserJson(this.bVi.postNetData());
            return this.bVi.bon().boU().isRequestSuccess() && this.kUM.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            a.this.kUH = null;
            if (a.this.kUL != null) {
                a.this.kUL.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.kUH = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.kUI.size()) {
                    a.this.kUI.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bVi.bon().boU().isRequestSuccess()) {
                str = this.kUM.getErrorString();
            } else {
                str = this.bVi.getErrorString();
            }
            if (a.this.kUL != null) {
                a.this.kUL.callback(2, bool, str);
            }
        }
    }

    public int dcA() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void EM(int i) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.kUF != null) {
            this.kUF.cancel();
        }
        if (this.kUG != null) {
            this.kUG.cancel();
        }
        if (this.kUH != null) {
            this.kUH.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.kUL = cVar;
    }

    private void dcB() {
        if (this.kUI != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.kUI.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bw(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bw(String str, int i) {
        if (this.kUI != null && y.getCount(this.kUI) > 0) {
            Iterator<MarkData> it = this.kUI.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
