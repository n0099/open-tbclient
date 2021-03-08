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
import com.baidu.tieba.myCollection.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private boolean kfa;
    private b lzB = null;
    private c lzC = null;
    private C0806a lzD = null;
    private int lzF = 0;
    private int lzG = 0;
    protected d lzH = null;
    private ArrayList<MarkData> lzE = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.lzG;
        aVar.lzG = i - 1;
        return i;
    }

    public a() {
        this.kfa = false;
        this.kfa = true;
    }

    public int getOffset() {
        if (this.lzE == null) {
            return 0;
        }
        return this.lzE.size();
    }

    public int dhW() {
        return this.lzG;
    }

    public void ER(int i) {
        this.lzG = i;
    }

    public boolean hasMore() {
        return this.lzF > 0;
    }

    public void reset() {
        this.lzG = 0;
        this.lzF = 0;
        this.kfa = true;
    }

    public ArrayList<MarkData> dhX() {
        return this.lzE;
    }

    public void aT(ArrayList<MarkData> arrayList) {
        this.lzE = arrayList;
    }

    public void aU(ArrayList<MarkData> arrayList) {
        if (this.lzE != null && arrayList != null) {
            this.lzE.addAll(arrayList);
            dib();
        }
    }

    public void f(MarkData markData) {
        this.lzE.add(markData);
    }

    public int getCount() {
        if (this.lzE == null) {
            return 0;
        }
        return this.lzE.size();
    }

    public int dhY() {
        return this.lzF;
    }

    public void dhZ() {
        ArrayList<MarkData> dOR = com.baidu.tieba.tbadkCore.util.a.dOR();
        if (dOR != null) {
            aT(dOR);
        }
    }

    public String cV(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.lzE == null) {
            return null;
        }
        if (i >= this.lzE.size()) {
            i2 -= (i - this.lzE.size()) - 1;
            i = this.lzE.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.lzE.get(i5).toJson();
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

    public void OS(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> OT(String str) {
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
                    this.lzE.add(markData);
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
        if (this.lzB != null) {
            this.lzB.cancel();
        }
        this.lzB = new b(getOffset());
        this.lzB.setPriority(3);
        this.lzB.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c lzI;
        private int offset;
        private aa cnM = null;
        private String data = null;
        Boolean lzK = false;

        public b(int i) {
            this.offset = 0;
            this.lzI = null;
            this.offset = i;
            this.lzI = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.lzK = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.lzK.booleanValue() && booleanValue) {
                l<String> Az = com.baidu.tbadk.core.c.a.bqt().Az("tb.my_bookmarks");
                if (Az != null) {
                    publishProgress(Az.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.lzE == null) {
                    a.this.lzE = new ArrayList();
                } else {
                    a.this.lzE.clear();
                }
                a.this.lzF = 0;
            }
            this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cnM.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.kfa) {
                this.cnM.addPostData("offset", String.valueOf(0));
            } else {
                this.cnM.addPostData("offset", String.valueOf(this.offset));
            }
            this.cnM.addPostData("rn", String.valueOf(20));
            this.data = this.cnM.postNetData();
            this.lzI.parserJson(this.data);
            if (this.cnM.bsu().bte().isRequestSuccess()) {
                aVar.OS(this.data);
                if (this.offset == 0) {
                    if (a.this.lzE == null) {
                        a.this.lzE = new ArrayList();
                    } else {
                        a.this.lzE.clear();
                    }
                    a.this.lzF = 0;
                    if (this.lzK.booleanValue()) {
                        JV(this.data);
                    }
                }
            }
            return aVar;
        }

        private void JV(String str) {
            l<String> Az;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (Az = com.baidu.tbadk.core.c.a.bqt().Az("tb.my_bookmarks")) != null) {
                Az.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.OT(str);
                if (this.lzK.booleanValue()) {
                    a.this.aT(arrayList);
                } else {
                    a.this.aU(arrayList);
                }
            } else {
                a.this.aT(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.lzH.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            a.this.lzB = null;
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
            if (this.lzI != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.lzI.getErrorCode(), this.lzI.getErrorString(), new Object[0]);
            }
            a.this.lzF = aVar.getCount();
            ArrayList<MarkData> dhX = aVar.dhX();
            if (this.lzK.booleanValue()) {
                if (dhX != null && dhX.size() != 0) {
                    a.this.aT(dhX);
                }
            } else {
                a.this.aU(dhX);
            }
            Iterator<MarkData> it = dhX.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.ER(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.lzH != null) {
                String str = null;
                if (this.cnM.bsu().bte().isRequestSuccess()) {
                    if (this.lzI.getErrorCode() != 0) {
                        str = this.lzI.getErrorString();
                    }
                    a.this.lzH.callback(0, str, false);
                } else {
                    a.this.lzH.callback(3, this.cnM.getErrorString());
                }
            }
            a.this.kfa = false;
        }
    }

    /* loaded from: classes7.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa cnM;
        private com.baidu.tieba.myCollection.baseEditMark.c lzI;
        final /* synthetic */ a lzJ;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.lzI = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dhZ();
                this.cnM = new aa();
                this.cnM.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dia = this.lzJ.dia();
                if (aVar.getCount() - 1 <= dia) {
                    dia = aVar.getCount() - 1;
                }
                while (dia >= 0) {
                    String cV = aVar.cV(dia, 20);
                    this.cnM.setPostData(new ArrayList<>());
                    this.cnM.addPostData("data", cV);
                    this.lzI.parserJson(this.cnM.postNetData());
                    if (!this.cnM.bsu().bte().isRequestSuccess() || this.lzI.getErrorCode() != 0) {
                        break;
                    }
                    dia -= 20;
                }
                this.lzJ.ET(dia);
                if (dia >= 0) {
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
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            this.lzJ.lzC = null;
            if (this.lzJ.lzH != null) {
                this.lzJ.lzH.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean z;
            String str = null;
            this.lzJ.lzC = null;
            if (bool.booleanValue()) {
                z = false;
            } else if (this.cnM.bsu().bte().isRequestSuccess()) {
                str = this.lzI.getErrorString();
                z = false;
            } else {
                z = true;
            }
            if (this.lzJ.lzH != null) {
                this.lzJ.lzH.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean ES(int i) {
        if (this.lzD != null) {
            this.lzD.cancel();
        }
        if (i >= this.lzE.size() || this.lzE.get(i) == null || this.lzE.get(i).getId() == null) {
            return false;
        }
        this.lzD = new C0806a(this.lzE.get(i).getId(), i, this.lzE.get(i).getForumId());
        this.lzD.setPriority(2);
        this.lzD.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0806a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa cnM = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c lzI;
        private int pos;
        private String tid;

        public C0806a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.lzI = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.lzI = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cnM.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cnM.addPostData("tid", this.tid);
            this.cnM.addPostData("fid", this.fid);
            this.lzI.parserJson(this.cnM.postNetData());
            return this.cnM.bsu().bte().isRequestSuccess() && this.lzI.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            a.this.lzD = null;
            if (a.this.lzH != null) {
                a.this.lzH.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.lzD = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.lzE.size()) {
                    a.this.lzE.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cnM.bsu().bte().isRequestSuccess()) {
                str = this.lzI.getErrorString();
            } else {
                str = this.cnM.getErrorString();
            }
            if (a.this.lzH != null) {
                a.this.lzH.callback(2, bool, str);
            }
        }
    }

    public int dia() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void ET(int i) {
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.lzB != null) {
            this.lzB.cancel();
        }
        if (this.lzC != null) {
            this.lzC.cancel();
        }
        if (this.lzD != null) {
            this.lzD.cancel();
        }
    }

    public void a(d dVar) {
        this.lzH = dVar;
    }

    private void dib() {
        if (this.lzE != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.lzE.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bG(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bG(String str, int i) {
        if (this.lzE != null && y.getCount(this.lzE) > 0) {
            Iterator<MarkData> it = this.lzE.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
