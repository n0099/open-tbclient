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
    private boolean iIi;
    private b kkq = null;
    private c kkr = null;
    private C0748a kks = null;
    private int kku = 0;
    private int kkv = 0;
    protected com.baidu.tieba.myCollection.c kkw = null;
    private ArrayList<MarkData> kkt = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.kkv;
        aVar.kkv = i - 1;
        return i;
    }

    public a() {
        this.iIi = false;
        this.iIi = true;
    }

    public int getOffset() {
        if (this.kkt == null) {
            return 0;
        }
        return this.kkt.size();
    }

    public int cRZ() {
        return this.kkv;
    }

    public void Dk(int i) {
        this.kkv = i;
    }

    public boolean hasMore() {
        return this.kku > 0;
    }

    public void reset() {
        this.kkv = 0;
        this.kku = 0;
        this.iIi = true;
    }

    public ArrayList<MarkData> cSa() {
        return this.kkt;
    }

    public void aR(ArrayList<MarkData> arrayList) {
        this.kkt = arrayList;
    }

    public void aS(ArrayList<MarkData> arrayList) {
        if (this.kkt != null && arrayList != null) {
            this.kkt.addAll(arrayList);
            cSe();
        }
    }

    public void f(MarkData markData) {
        this.kkt.add(markData);
    }

    public int getCount() {
        if (this.kkt == null) {
            return 0;
        }
        return this.kkt.size();
    }

    public int cSb() {
        return this.kku;
    }

    public void cSc() {
        ArrayList<MarkData> dxy = com.baidu.tieba.tbadkCore.util.a.dxy();
        if (dxy != null) {
            aR(dxy);
        }
    }

    public String cP(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.kkt == null) {
            return null;
        }
        if (i >= this.kkt.size()) {
            i2 -= (i - this.kkt.size()) - 1;
            i = this.kkt.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.kkt.get(i5).toJson();
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

    public void MN(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> MO(String str) {
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
                    this.kkt.add(markData);
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
        if (this.kkq != null) {
            this.kkq.cancel();
        }
        this.kkq = new b(getOffset());
        this.kkq.setPriority(3);
        this.kkq.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c kkx;
        private int offset;
        private aa bDY = null;
        private String data = null;
        Boolean kkz = false;

        public b(int i) {
            this.offset = 0;
            this.kkx = null;
            this.offset = i;
            this.kkx = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.kkz = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.kkz.booleanValue() && booleanValue) {
                l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.my_bookmarks");
                if (zx != null) {
                    publishProgress(zx.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.kkt == null) {
                    a.this.kkt = new ArrayList();
                } else {
                    a.this.kkt.clear();
                }
                a.this.kku = 0;
            }
            this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bDY.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.iIi) {
                this.bDY.addPostData("offset", String.valueOf(0));
            } else {
                this.bDY.addPostData("offset", String.valueOf(this.offset));
            }
            this.bDY.addPostData("rn", String.valueOf(20));
            this.data = this.bDY.postNetData();
            this.kkx.parserJson(this.data);
            if (this.bDY.biQ().bjw().isRequestSuccess()) {
                aVar.MN(this.data);
                if (this.offset == 0) {
                    if (a.this.kkt == null) {
                        a.this.kkt = new ArrayList();
                    } else {
                        a.this.kkt.clear();
                    }
                    a.this.kku = 0;
                    if (this.kkz.booleanValue()) {
                        HW(this.data);
                    }
                }
            }
            return aVar;
        }

        private void HW(String str) {
            l<String> zx;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.my_bookmarks")) != null) {
                zx.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.MO(str);
                if (this.kkz.booleanValue()) {
                    a.this.aR(arrayList);
                } else {
                    a.this.aS(arrayList);
                }
            } else {
                a.this.aR(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.kkw.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            a.this.kkq = null;
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
            if (this.kkx != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.kkx.getErrorCode(), this.kkx.getErrorString(), new Object[0]);
            }
            a.this.kku = aVar.getCount();
            ArrayList<MarkData> cSa = aVar.cSa();
            if (this.kkz.booleanValue()) {
                if (cSa != null && cSa.size() != 0) {
                    a.this.aR(cSa);
                }
            } else {
                a.this.aS(cSa);
            }
            Iterator<MarkData> it = cSa.iterator();
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
            if (a.this.kkw != null) {
                String str = null;
                if (this.bDY.biQ().bjw().isRequestSuccess()) {
                    if (this.kkx.getErrorCode() != 0) {
                        str = this.kkx.getErrorString();
                    }
                    a.this.kkw.callback(0, str, false);
                } else {
                    a.this.kkw.callback(3, this.bDY.getErrorString());
                }
            }
            a.this.iIi = false;
        }
    }

    /* loaded from: classes18.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa bDY;
        private com.baidu.tieba.myCollection.baseEditMark.c kkx;
        final /* synthetic */ a kky;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.kkx = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cSc();
                this.bDY = new aa();
                this.bDY.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cSd = this.kky.cSd();
                if (aVar.getCount() - 1 <= cSd) {
                    cSd = aVar.getCount() - 1;
                }
                while (cSd >= 0) {
                    String cP = aVar.cP(cSd, 20);
                    this.bDY.setPostData(new ArrayList<>());
                    this.bDY.addPostData("data", cP);
                    this.kkx.parserJson(this.bDY.postNetData());
                    if (!this.bDY.biQ().bjw().isRequestSuccess() || this.kkx.getErrorCode() != 0) {
                        break;
                    }
                    cSd -= 20;
                }
                this.kky.Dm(cSd);
                if (cSd >= 0) {
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
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            this.kky.kkr = null;
            if (this.kky.kkw != null) {
                this.kky.kkw.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.kky.kkr = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bDY.biQ().bjw().isRequestSuccess()) {
                str = this.kkx.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.kky.kkw != null) {
                this.kky.kkw.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Dl(int i) {
        if (this.kks != null) {
            this.kks.cancel();
        }
        if (i >= this.kkt.size() || this.kkt.get(i) == null || this.kkt.get(i).getId() == null) {
            return false;
        }
        this.kks = new C0748a(this.kkt.get(i).getId(), i, this.kkt.get(i).getForumId());
        this.kks.setPriority(2);
        this.kks.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0748a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bDY = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c kkx;
        private int pos;
        private String tid;

        public C0748a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.kkx = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.kkx = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bDY.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bDY.addPostData("tid", this.tid);
            this.bDY.addPostData("fid", this.fid);
            this.kkx.parserJson(this.bDY.postNetData());
            return this.bDY.biQ().bjw().isRequestSuccess() && this.kkx.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            a.this.kks = null;
            if (a.this.kkw != null) {
                a.this.kkw.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.kks = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.kkt.size()) {
                    a.this.kkt.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bDY.biQ().bjw().isRequestSuccess()) {
                str = this.kkx.getErrorString();
            } else {
                str = this.bDY.getErrorString();
            }
            if (a.this.kkw != null) {
                a.this.kkw.callback(2, bool, str);
            }
        }
    }

    public int cSd() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Dm(int i) {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.kkq != null) {
            this.kkq.cancel();
        }
        if (this.kkr != null) {
            this.kkr.cancel();
        }
        if (this.kks != null) {
            this.kks.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.kkw = cVar;
    }

    private void cSe() {
        if (this.kkt != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.kkt.iterator();
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
        if (this.kkt != null && y.getCount(this.kkt) > 0) {
            Iterator<MarkData> it = this.kkt.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
