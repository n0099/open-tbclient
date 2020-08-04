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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class a {
    private boolean itT;
    private b jUU = null;
    private c jUV = null;
    private C0697a jUW = null;
    private int jUY = 0;
    private int jUZ = 0;
    protected com.baidu.tieba.myCollection.c jVa = null;
    private ArrayList<MarkData> jUX = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.jUZ;
        aVar.jUZ = i - 1;
        return i;
    }

    public a() {
        this.itT = false;
        this.itT = true;
    }

    public int getOffset() {
        if (this.jUX == null) {
            return 0;
        }
        return this.jUX.size();
    }

    public int cHk() {
        return this.jUZ;
    }

    public void AR(int i) {
        this.jUZ = i;
    }

    public boolean hasMore() {
        return this.jUY > 0;
    }

    public void reset() {
        this.jUZ = 0;
        this.jUY = 0;
        this.itT = true;
    }

    public ArrayList<MarkData> cHl() {
        return this.jUX;
    }

    public void aL(ArrayList<MarkData> arrayList) {
        this.jUX = arrayList;
    }

    public void aM(ArrayList<MarkData> arrayList) {
        if (this.jUX != null && arrayList != null) {
            this.jUX.addAll(arrayList);
            cHp();
        }
    }

    public void f(MarkData markData) {
        this.jUX.add(markData);
    }

    public int getCount() {
        if (this.jUX == null) {
            return 0;
        }
        return this.jUX.size();
    }

    public int cHm() {
        return this.jUY;
    }

    public void cHn() {
        ArrayList<MarkData> dmd = com.baidu.tieba.tbadkCore.util.a.dmd();
        if (dmd != null) {
            aL(dmd);
        }
    }

    public String cH(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jUX == null) {
            return null;
        }
        if (i >= this.jUX.size()) {
            i2 -= (i - this.jUX.size()) - 1;
            i = this.jUX.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jUX.get(i5).toJson();
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

    public void JV(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> JW(String str) {
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
                    this.jUX.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void l(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.jUU != null) {
            this.jUU.cancel();
        }
        this.jUU = new b(getOffset());
        this.jUU.setPriority(3);
        this.jUU.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jVb;
        private int offset;
        private z byq = null;
        private String data = null;
        Boolean jVd = false;

        public b(int i) {
            this.offset = 0;
            this.jVb = null;
            this.offset = i;
            this.jVb = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jVd = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jVd.booleanValue() && booleanValue) {
                l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.my_bookmarks");
                if (xj != null) {
                    publishProgress(xj.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jUX == null) {
                    a.this.jUX = new ArrayList();
                } else {
                    a.this.jUX.clear();
                }
                a.this.jUY = 0;
            }
            this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.byq.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.itT) {
                this.byq.addPostData("offset", String.valueOf(0));
            } else {
                this.byq.addPostData("offset", String.valueOf(this.offset));
            }
            this.byq.addPostData("rn", String.valueOf(20));
            this.data = this.byq.postNetData();
            this.jVb.parserJson(this.data);
            if (this.byq.bav().baX().isRequestSuccess()) {
                aVar.JV(this.data);
                if (this.offset == 0) {
                    if (a.this.jUX == null) {
                        a.this.jUX = new ArrayList();
                    } else {
                        a.this.jUX.clear();
                    }
                    a.this.jUY = 0;
                    if (this.jVd.booleanValue()) {
                        Fv(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Fv(String str) {
            l<String> xj;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.my_bookmarks")) != null) {
                xj.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.JW(str);
                if (this.jVd.booleanValue()) {
                    a.this.aL(arrayList);
                } else {
                    a.this.aM(arrayList);
                }
            } else {
                a.this.aL(arrayList);
            }
            if (!x.isEmpty(arrayList)) {
                a.this.jVa.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            a.this.jUU = null;
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
            if (this.jVb != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jVb.getErrorCode(), this.jVb.getErrorString(), new Object[0]);
            }
            a.this.jUY = aVar.getCount();
            ArrayList<MarkData> cHl = aVar.cHl();
            if (this.jVd.booleanValue()) {
                if (cHl != null && cHl.size() != 0) {
                    a.this.aL(cHl);
                }
            } else {
                a.this.aM(cHl);
            }
            Iterator<MarkData> it = cHl.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.AR(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.jVa != null) {
                String str = null;
                if (this.byq.bav().baX().isRequestSuccess()) {
                    if (this.jVb.getErrorCode() != 0) {
                        str = this.jVb.getErrorString();
                    }
                    a.this.jVa.callback(0, str, false);
                } else {
                    a.this.jVa.callback(3, this.byq.getErrorString());
                }
            }
            a.this.itT = false;
        }
    }

    /* loaded from: classes18.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private z byq;
        private com.baidu.tieba.myCollection.baseEditMark.c jVb;
        final /* synthetic */ a jVc;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jVb = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cHn();
                this.byq = new z();
                this.byq.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cHo = this.jVc.cHo();
                if (aVar.getCount() - 1 <= cHo) {
                    cHo = aVar.getCount() - 1;
                }
                while (cHo >= 0) {
                    String cH = aVar.cH(cHo, 20);
                    this.byq.setPostData(new ArrayList<>());
                    this.byq.addPostData("data", cH);
                    this.jVb.parserJson(this.byq.postNetData());
                    if (!this.byq.bav().baX().isRequestSuccess() || this.jVb.getErrorCode() != 0) {
                        break;
                    }
                    cHo -= 20;
                }
                this.jVc.AT(cHo);
                if (cHo >= 0) {
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
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            this.jVc.jUV = null;
            if (this.jVc.jVa != null) {
                this.jVc.jVa.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.jVc.jUV = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.byq.bav().baX().isRequestSuccess()) {
                str = this.jVb.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.jVc.jVa != null) {
                this.jVc.jVa.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean AS(int i) {
        if (this.jUW != null) {
            this.jUW.cancel();
        }
        if (i >= this.jUX.size() || this.jUX.get(i) == null || this.jUX.get(i).getId() == null) {
            return false;
        }
        this.jUW = new C0697a(this.jUX.get(i).getId(), i, this.jUX.get(i).getForumId());
        this.jUW.setPriority(2);
        this.jUW.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0697a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z byq = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jVb;
        private int pos;
        private String tid;

        public C0697a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jVb = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jVb = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.byq.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.byq.addPostData("tid", this.tid);
            this.byq.addPostData("fid", this.fid);
            this.jVb.parserJson(this.byq.postNetData());
            return this.byq.bav().baX().isRequestSuccess() && this.jVb.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            a.this.jUW = null;
            if (a.this.jVa != null) {
                a.this.jVa.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jUW = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jUX.size()) {
                    a.this.jUX.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.byq.bav().baX().isRequestSuccess()) {
                str = this.jVb.getErrorString();
            } else {
                str = this.byq.getErrorString();
            }
            if (a.this.jVa != null) {
                a.this.jVa.callback(2, bool, str);
            }
        }
    }

    public int cHo() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void AT(int i) {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.jUU != null) {
            this.jUU.cancel();
        }
        if (this.jUV != null) {
            this.jUV.cancel();
        }
        if (this.jUW != null) {
            this.jUW.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jVa = cVar;
    }

    private void cHp() {
        if (this.jUX != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jUX.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bq(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bq(String str, int i) {
        if (this.jUX != null && x.getCount(this.jUX) > 0) {
            Iterator<MarkData> it = this.jUX.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
