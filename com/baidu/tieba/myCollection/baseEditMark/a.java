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
    private boolean itR;
    private b jUS = null;
    private c jUT = null;
    private C0697a jUU = null;
    private int jUW = 0;
    private int jUX = 0;
    protected com.baidu.tieba.myCollection.c jUY = null;
    private ArrayList<MarkData> jUV = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.jUX;
        aVar.jUX = i - 1;
        return i;
    }

    public a() {
        this.itR = false;
        this.itR = true;
    }

    public int getOffset() {
        if (this.jUV == null) {
            return 0;
        }
        return this.jUV.size();
    }

    public int cHk() {
        return this.jUX;
    }

    public void AR(int i) {
        this.jUX = i;
    }

    public boolean hasMore() {
        return this.jUW > 0;
    }

    public void reset() {
        this.jUX = 0;
        this.jUW = 0;
        this.itR = true;
    }

    public ArrayList<MarkData> cHl() {
        return this.jUV;
    }

    public void aL(ArrayList<MarkData> arrayList) {
        this.jUV = arrayList;
    }

    public void aM(ArrayList<MarkData> arrayList) {
        if (this.jUV != null && arrayList != null) {
            this.jUV.addAll(arrayList);
            cHp();
        }
    }

    public void f(MarkData markData) {
        this.jUV.add(markData);
    }

    public int getCount() {
        if (this.jUV == null) {
            return 0;
        }
        return this.jUV.size();
    }

    public int cHm() {
        return this.jUW;
    }

    public void cHn() {
        ArrayList<MarkData> dmc = com.baidu.tieba.tbadkCore.util.a.dmc();
        if (dmc != null) {
            aL(dmc);
        }
    }

    public String cH(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.jUV == null) {
            return null;
        }
        if (i >= this.jUV.size()) {
            i2 -= (i - this.jUV.size()) - 1;
            i = this.jUV.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.jUV.get(i5).toJson();
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
                    this.jUV.add(markData);
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
        if (this.jUS != null) {
            this.jUS.cancel();
        }
        this.jUS = new b(getOffset());
        this.jUS.setPriority(3);
        this.jUS.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c jUZ;
        private int offset;
        private z byq = null;
        private String data = null;
        Boolean jVb = false;

        public b(int i) {
            this.offset = 0;
            this.jUZ = null;
            this.offset = i;
            this.jUZ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jVb = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.jVb.booleanValue() && booleanValue) {
                l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.my_bookmarks");
                if (xj != null) {
                    publishProgress(xj.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.jUV == null) {
                    a.this.jUV = new ArrayList();
                } else {
                    a.this.jUV.clear();
                }
                a.this.jUW = 0;
            }
            this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.byq.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.itR) {
                this.byq.addPostData("offset", String.valueOf(0));
            } else {
                this.byq.addPostData("offset", String.valueOf(this.offset));
            }
            this.byq.addPostData("rn", String.valueOf(20));
            this.data = this.byq.postNetData();
            this.jUZ.parserJson(this.data);
            if (this.byq.bav().baX().isRequestSuccess()) {
                aVar.JV(this.data);
                if (this.offset == 0) {
                    if (a.this.jUV == null) {
                        a.this.jUV = new ArrayList();
                    } else {
                        a.this.jUV.clear();
                    }
                    a.this.jUW = 0;
                    if (this.jVb.booleanValue()) {
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
                if (this.jVb.booleanValue()) {
                    a.this.aL(arrayList);
                } else {
                    a.this.aM(arrayList);
                }
            } else {
                a.this.aL(arrayList);
            }
            if (!x.isEmpty(arrayList)) {
                a.this.jUY.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            a.this.jUS = null;
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
            if (this.jUZ != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.jUZ.getErrorCode(), this.jUZ.getErrorString(), new Object[0]);
            }
            a.this.jUW = aVar.getCount();
            ArrayList<MarkData> cHl = aVar.cHl();
            if (this.jVb.booleanValue()) {
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
            if (a.this.jUY != null) {
                String str = null;
                if (this.byq.bav().baX().isRequestSuccess()) {
                    if (this.jUZ.getErrorCode() != 0) {
                        str = this.jUZ.getErrorString();
                    }
                    a.this.jUY.callback(0, str, false);
                } else {
                    a.this.jUY.callback(3, this.byq.getErrorString());
                }
            }
            a.this.itR = false;
        }
    }

    /* loaded from: classes18.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private z byq;
        private com.baidu.tieba.myCollection.baseEditMark.c jUZ;
        final /* synthetic */ a jVa;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.jUZ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
                int cHo = this.jVa.cHo();
                if (aVar.getCount() - 1 <= cHo) {
                    cHo = aVar.getCount() - 1;
                }
                while (cHo >= 0) {
                    String cH = aVar.cH(cHo, 20);
                    this.byq.setPostData(new ArrayList<>());
                    this.byq.addPostData("data", cH);
                    this.jUZ.parserJson(this.byq.postNetData());
                    if (!this.byq.bav().baX().isRequestSuccess() || this.jUZ.getErrorCode() != 0) {
                        break;
                    }
                    cHo -= 20;
                }
                this.jVa.AT(cHo);
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
            this.jVa.jUT = null;
            if (this.jVa.jUY != null) {
                this.jVa.jUY.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.jVa.jUT = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.byq.bav().baX().isRequestSuccess()) {
                str = this.jUZ.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.jVa.jUY != null) {
                this.jVa.jUY.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean AS(int i) {
        if (this.jUU != null) {
            this.jUU.cancel();
        }
        if (i >= this.jUV.size() || this.jUV.get(i) == null || this.jUV.get(i).getId() == null) {
            return false;
        }
        this.jUU = new C0697a(this.jUV.get(i).getId(), i, this.jUV.get(i).getForumId());
        this.jUU.setPriority(2);
        this.jUU.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0697a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private z byq = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c jUZ;
        private int pos;
        private String tid;

        public C0697a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.jUZ = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.jUZ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.jUZ.parserJson(this.byq.postNetData());
            return this.byq.bav().baX().isRequestSuccess() && this.jUZ.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            a.this.jUU = null;
            if (a.this.jUY != null) {
                a.this.jUY.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.jUU = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.jUV.size()) {
                    a.this.jUV.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.byq.bav().baX().isRequestSuccess()) {
                str = this.jUZ.getErrorString();
            } else {
                str = this.byq.getErrorString();
            }
            if (a.this.jUY != null) {
                a.this.jUY.callback(2, bool, str);
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
        if (this.jUS != null) {
            this.jUS.cancel();
        }
        if (this.jUT != null) {
            this.jUT.cancel();
        }
        if (this.jUU != null) {
            this.jUU.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.jUY = cVar;
    }

    private void cHp() {
        if (this.jUV != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.jUV.iterator();
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
        if (this.jUV != null && x.getCount(this.jUV) > 0) {
            Iterator<MarkData> it = this.jUV.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
