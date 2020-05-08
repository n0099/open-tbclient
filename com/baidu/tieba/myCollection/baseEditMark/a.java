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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean hKe;
    private b jeU = null;
    private c jeV = null;
    private C0622a jeW = null;
    private int jeY = 0;
    private int jeZ = 0;
    protected com.baidu.tieba.myCollection.c jfa = null;
    private ArrayList<MarkData> jeX = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.jeZ;
        aVar.jeZ = i - 1;
        return i;
    }

    public a() {
        this.hKe = false;
        this.hKe = true;
    }

    public int getOffset() {
        if (this.jeX == null) {
            return 0;
        }
        return this.jeX.size();
    }

    public int csK() {
        return this.jeZ;
    }

    public void yW(int i) {
        this.jeZ = i;
    }

    public boolean hasMore() {
        return this.jeY > 0;
    }

    public void reset() {
        this.jeZ = 0;
        this.jeY = 0;
        this.hKe = true;
    }

    public ArrayList<MarkData> csL() {
        return this.jeX;
    }

    public void aJ(ArrayList<MarkData> arrayList) {
        this.jeX = arrayList;
    }

    public void aK(ArrayList<MarkData> arrayList) {
        if (this.jeX != null && arrayList != null) {
            this.jeX.addAll(arrayList);
            csP();
        }
    }

    public void f(MarkData markData) {
        this.jeX.add(markData);
    }

    public int getCount() {
        if (this.jeX == null) {
            return 0;
        }
        return this.jeX.size();
    }

    public int csM() {
        return this.jeY;
    }

    public void csN() {
        ArrayList<MarkData> cXk = com.baidu.tieba.tbadkCore.util.a.cXk();
        if (cXk != null) {
            aJ(cXk);
        }
    }

    public String ct(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jeX == null) {
            return null;
        }
        if (i >= this.jeX.size()) {
            i2 -= (i - this.jeX.size()) - 1;
            i = this.jeX.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jeX.get(i5).toJson();
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

    public void GX(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> GY(String str) {
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
                    this.jeX.add(markData);
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
        if (this.jeU != null) {
            this.jeU.cancel();
        }
        this.jeU = new b(getOffset());
        this.jeU.setPriority(3);
        this.jeU.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jfb;
        private int offset;
        private x blK = null;
        private String data = null;
        Boolean jfd = false;

        public b(int i) {
            this.offset = 0;
            this.jfb = null;
            this.offset = i;
            this.jfb = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jfd = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jfd.booleanValue() && booleanValue) {
                l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.my_bookmarks");
                if (ug != null) {
                    publishProgress(ug.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jeX == null) {
                    a.this.jeX = new ArrayList();
                } else {
                    a.this.jeX.clear();
                }
                a.this.jeY = 0;
            }
            this.blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.blK.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.hKe) {
                this.blK.addPostData("offset", String.valueOf(0));
            } else {
                this.blK.addPostData("offset", String.valueOf(this.offset));
            }
            this.blK.addPostData("rn", String.valueOf(20));
            this.data = this.blK.postNetData();
            this.jfb.parserJson(this.data);
            if (this.blK.aOw().aOX().isRequestSuccess()) {
                aVar.GX(this.data);
                if (this.offset == 0) {
                    if (a.this.jeX == null) {
                        a.this.jeX = new ArrayList();
                    } else {
                        a.this.jeX.clear();
                    }
                    a.this.jeY = 0;
                    if (this.jfd.booleanValue()) {
                        CA(this.data);
                    }
                }
            }
            return aVar;
        }

        private void CA(String str) {
            l<String> ug;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.my_bookmarks")) != null) {
                ug.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.GY(str);
                if (this.jfd.booleanValue()) {
                    a.this.aJ(arrayList);
                } else {
                    a.this.aK(arrayList);
                }
            } else {
                a.this.aJ(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.jfa.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            a.this.jeU = null;
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
            if (this.jfb != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jfb.getErrorCode(), this.jfb.getErrorString(), new Object[0]);
            }
            a.this.jeY = aVar.getCount();
            ArrayList<MarkData> csL = aVar.csL();
            if (this.jfd.booleanValue()) {
                if (csL != null && csL.size() != 0) {
                    a.this.aJ(csL);
                }
            } else {
                a.this.aK(csL);
            }
            Iterator<MarkData> it = csL.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.yW(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.jfa != null) {
                String str = null;
                if (this.blK.aOw().aOX().isRequestSuccess()) {
                    if (this.jfb.getErrorCode() != 0) {
                        str = this.jfb.getErrorString();
                    }
                    a.this.jfa.callback(0, str, false);
                } else {
                    a.this.jfa.callback(3, this.blK.getErrorString());
                }
            }
            a.this.hKe = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x blK;
        private com.baidu.tieba.myCollection.baseEditMark.c jfb;
        final /* synthetic */ a jfc;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jfb = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.csN();
                this.blK = new x();
                this.blK.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int csO = this.jfc.csO();
                if (aVar.getCount() - 1 <= csO) {
                    csO = aVar.getCount() - 1;
                }
                while (csO >= 0) {
                    String ct = aVar.ct(csO, 20);
                    this.blK.setPostData(new ArrayList<>());
                    this.blK.addPostData("data", ct);
                    this.jfb.parserJson(this.blK.postNetData());
                    if (!this.blK.aOw().aOX().isRequestSuccess() || this.jfb.getErrorCode() != 0) {
                        break;
                    }
                    csO -= 20;
                }
                this.jfc.yY(csO);
                if (csO >= 0) {
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
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            this.jfc.jeV = null;
            if (this.jfc.jfa != null) {
                this.jfc.jfa.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.jfc.jeV = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.blK.aOw().aOX().isRequestSuccess()) {
                str = this.jfb.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.jfc.jfa != null) {
                this.jfc.jfa.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yX(int i) {
        if (this.jeW != null) {
            this.jeW.cancel();
        }
        if (i >= this.jeX.size() || this.jeX.get(i) == null || this.jeX.get(i).getId() == null) {
            return false;
        }
        this.jeW = new C0622a(this.jeX.get(i).getId(), i, this.jeX.get(i).getForumId());
        this.jeW.setPriority(2);
        this.jeW.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0622a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x blK = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jfb;
        private int pos;
        private String tid;

        public C0622a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jfb = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jfb = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.blK.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.blK.addPostData("tid", this.tid);
            this.blK.addPostData("fid", this.fid);
            this.jfb.parserJson(this.blK.postNetData());
            return this.blK.aOw().aOX().isRequestSuccess() && this.jfb.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            a.this.jeW = null;
            if (a.this.jfa != null) {
                a.this.jfa.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jeW = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jeX.size()) {
                    a.this.jeX.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.blK.aOw().aOX().isRequestSuccess()) {
                str = this.jfb.getErrorString();
            } else {
                str = this.blK.getErrorString();
            }
            if (a.this.jfa != null) {
                a.this.jfa.callback(2, bool, str);
            }
        }
    }

    public int csO() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yY(int i) {
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.jeU != null) {
            this.jeU.cancel();
        }
        if (this.jeV != null) {
            this.jeV.cancel();
        }
        if (this.jeW != null) {
            this.jeW.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jfa = cVar;
    }

    private void csP() {
        if (this.jeX != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jeX.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bs(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bs(String str, int i) {
        if (this.jeX != null && v.getCount(this.jeX) > 0) {
            Iterator<MarkData> it = this.jeX.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
