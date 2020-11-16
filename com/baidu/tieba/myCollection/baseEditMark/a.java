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
/* loaded from: classes23.dex */
public class a {
    private boolean jyV;
    private b laV = null;
    private c laW = null;
    private C0795a laX = null;
    private int laZ = 0;
    private int lba = 0;
    protected com.baidu.tieba.myCollection.c lbb = null;
    private ArrayList<MarkData> laY = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.lba;
        aVar.lba = i - 1;
        return i;
    }

    public a() {
        this.jyV = false;
        this.jyV = true;
    }

    public int getOffset() {
        if (this.laY == null) {
            return 0;
        }
        return this.laY.size();
    }

    public int dev() {
        return this.lba;
    }

    public void Fv(int i) {
        this.lba = i;
    }

    public boolean hasMore() {
        return this.laZ > 0;
    }

    public void reset() {
        this.lba = 0;
        this.laZ = 0;
        this.jyV = true;
    }

    public ArrayList<MarkData> dew() {
        return this.laY;
    }

    public void aX(ArrayList<MarkData> arrayList) {
        this.laY = arrayList;
    }

    public void aY(ArrayList<MarkData> arrayList) {
        if (this.laY != null && arrayList != null) {
            this.laY.addAll(arrayList);
            deA();
        }
    }

    public void f(MarkData markData) {
        this.laY.add(markData);
    }

    public int getCount() {
        if (this.laY == null) {
            return 0;
        }
        return this.laY.size();
    }

    public int dex() {
        return this.laZ;
    }

    public void dey() {
        ArrayList<MarkData> dKR = com.baidu.tieba.tbadkCore.util.a.dKR();
        if (dKR != null) {
            aX(dKR);
        }
    }

    public String cW(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.laY == null) {
            return null;
        }
        if (i >= this.laY.size()) {
            i2 -= (i - this.laY.size()) - 1;
            i = this.laY.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.laY.get(i5).toJson();
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

    public void Oq(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Or(String str) {
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
                    this.laY.add(markData);
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
        if (this.laV != null) {
            this.laV.cancel();
        }
        this.laV = new b(getOffset());
        this.laV.setPriority(3);
        this.laV.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c lbc;
        private int offset;
        private aa bZh = null;
        private String data = null;
        Boolean lbe = false;

        public b(int i) {
            this.offset = 0;
            this.lbc = null;
            this.offset = i;
            this.lbc = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.lbe = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.lbe.booleanValue() && booleanValue) {
                l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.my_bookmarks");
                if (AH != null) {
                    publishProgress(AH.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.laY == null) {
                    a.this.laY = new ArrayList();
                } else {
                    a.this.laY.clear();
                }
                a.this.laZ = 0;
            }
            this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.bZh.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.jyV) {
                this.bZh.addPostData("offset", String.valueOf(0));
            } else {
                this.bZh.addPostData("offset", String.valueOf(this.offset));
            }
            this.bZh.addPostData("rn", String.valueOf(20));
            this.data = this.bZh.postNetData();
            this.lbc.parserJson(this.data);
            if (this.bZh.bqa().bqI().isRequestSuccess()) {
                aVar.Oq(this.data);
                if (this.offset == 0) {
                    if (a.this.laY == null) {
                        a.this.laY = new ArrayList();
                    } else {
                        a.this.laY.clear();
                    }
                    a.this.laZ = 0;
                    if (this.lbe.booleanValue()) {
                        Jy(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Jy(String str) {
            l<String> AH;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (AH = com.baidu.tbadk.core.c.a.bob().AH("tb.my_bookmarks")) != null) {
                AH.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.Or(str);
                if (this.lbe.booleanValue()) {
                    a.this.aX(arrayList);
                } else {
                    a.this.aY(arrayList);
                }
            } else {
                a.this.aX(arrayList);
            }
            if (!y.isEmpty(arrayList)) {
                a.this.lbb.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            a.this.laV = null;
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
            if (this.lbc != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.lbc.getErrorCode(), this.lbc.getErrorString(), new Object[0]);
            }
            a.this.laZ = aVar.getCount();
            ArrayList<MarkData> dew = aVar.dew();
            if (this.lbe.booleanValue()) {
                if (dew != null && dew.size() != 0) {
                    a.this.aX(dew);
                }
            } else {
                a.this.aY(dew);
            }
            Iterator<MarkData> it = dew.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.Fv(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.lbb != null) {
                String str = null;
                if (this.bZh.bqa().bqI().isRequestSuccess()) {
                    if (this.lbc.getErrorCode() != 0) {
                        str = this.lbc.getErrorString();
                    }
                    a.this.lbb.callback(0, str, false);
                } else {
                    a.this.lbb.callback(3, this.bZh.getErrorString());
                }
            }
            a.this.jyV = false;
        }
    }

    /* loaded from: classes23.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private aa bZh;
        private com.baidu.tieba.myCollection.baseEditMark.c lbc;
        final /* synthetic */ a lbd;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.lbc = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.dey();
                this.bZh = new aa();
                this.bZh.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int dez = this.lbd.dez();
                if (aVar.getCount() - 1 <= dez) {
                    dez = aVar.getCount() - 1;
                }
                while (dez >= 0) {
                    String cW = aVar.cW(dez, 20);
                    this.bZh.setPostData(new ArrayList<>());
                    this.bZh.addPostData("data", cW);
                    this.lbc.parserJson(this.bZh.postNetData());
                    if (!this.bZh.bqa().bqI().isRequestSuccess() || this.lbc.getErrorCode() != 0) {
                        break;
                    }
                    dez -= 20;
                }
                this.lbd.Fx(dez);
                if (dez >= 0) {
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
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            this.lbd.laW = null;
            if (this.lbd.lbb != null) {
                this.lbd.lbb.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.lbd.laW = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.bZh.bqa().bqI().isRequestSuccess()) {
                str = this.lbc.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.lbd.lbb != null) {
                this.lbd.lbb.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean Fw(int i) {
        if (this.laX != null) {
            this.laX.cancel();
        }
        if (i >= this.laY.size() || this.laY.get(i) == null || this.laY.get(i).getId() == null) {
            return false;
        }
        this.laX = new C0795a(this.laY.get(i).getId(), i, this.laY.get(i).getForumId());
        this.laX.setPriority(2);
        this.laX.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0795a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private aa bZh = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c lbc;
        private int pos;
        private String tid;

        public C0795a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.lbc = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.lbc = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.bZh.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.bZh.addPostData("tid", this.tid);
            this.bZh.addPostData("fid", this.fid);
            this.lbc.parserJson(this.bZh.postNetData());
            return this.bZh.bqa().bqI().isRequestSuccess() && this.lbc.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            a.this.laX = null;
            if (a.this.lbb != null) {
                a.this.lbb.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.laX = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.laY.size()) {
                    a.this.laY.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.bZh.bqa().bqI().isRequestSuccess()) {
                str = this.lbc.getErrorString();
            } else {
                str = this.bZh.getErrorString();
            }
            if (a.this.lbb != null) {
                a.this.lbb.callback(2, bool, str);
            }
        }
    }

    public int dez() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void Fx(int i) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.laV != null) {
            this.laV.cancel();
        }
        if (this.laW != null) {
            this.laW.cancel();
        }
        if (this.laX != null) {
            this.laX.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.lbb = cVar;
    }

    private void deA() {
        if (this.laY != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.laY.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bx(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bx(String str, int i) {
        if (this.laY != null && y.getCount(this.laY) > 0) {
            Iterator<MarkData> it = this.laY.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
