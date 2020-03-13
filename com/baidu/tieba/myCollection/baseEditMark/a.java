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
    private boolean gZc;
    private b itl = null;
    private c itm = null;
    private C0562a itn = null;
    private int itp = 0;
    private int itq = 0;
    protected com.baidu.tieba.myCollection.c itr = null;
    private ArrayList<MarkData> ito = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.itq;
        aVar.itq = i - 1;
        return i;
    }

    public a() {
        this.gZc = false;
        this.gZc = true;
    }

    public int getOffset() {
        if (this.ito == null) {
            return 0;
        }
        return this.ito.size();
    }

    public int chM() {
        return this.itq;
    }

    public void yn(int i) {
        this.itq = i;
    }

    public boolean hasMore() {
        return this.itp > 0;
    }

    public void reset() {
        this.itq = 0;
        this.itp = 0;
        this.gZc = true;
    }

    public ArrayList<MarkData> chN() {
        return this.ito;
    }

    public void aH(ArrayList<MarkData> arrayList) {
        this.ito = arrayList;
    }

    public void aI(ArrayList<MarkData> arrayList) {
        if (this.ito != null && arrayList != null) {
            this.ito.addAll(arrayList);
            chR();
        }
    }

    public void f(MarkData markData) {
        this.ito.add(markData);
    }

    public int getCount() {
        if (this.ito == null) {
            return 0;
        }
        return this.ito.size();
    }

    public int chO() {
        return this.itp;
    }

    public void chP() {
        ArrayList<MarkData> cLX = com.baidu.tieba.tbadkCore.util.a.cLX();
        if (cLX != null) {
            aH(cLX);
        }
    }

    public String cm(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.ito == null) {
            return null;
        }
        if (i >= this.ito.size()) {
            i2 -= (i - this.ito.size()) - 1;
            i = this.ito.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.ito.get(i5).toJson();
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

    public void Fn(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> Fo(String str) {
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
                    this.ito.add(markData);
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
        if (this.itl != null) {
            this.itl.cancel();
        }
        this.itl = new b(getOffset());
        this.itl.setPriority(3);
        this.itl.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c its;
        private int offset;
        private x cLF = null;
        private String data = null;
        Boolean itu = false;

        public b(int i) {
            this.offset = 0;
            this.its = null;
            this.offset = i;
            this.its = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.itu = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.itu.booleanValue() && booleanValue) {
                l<String> sQ = com.baidu.tbadk.core.c.a.aEB().sQ("tb.my_bookmarks");
                if (sQ != null) {
                    publishProgress(sQ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.ito == null) {
                    a.this.ito = new ArrayList();
                } else {
                    a.this.ito.clear();
                }
                a.this.itp = 0;
            }
            this.cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cLF.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gZc) {
                this.cLF.addPostData("offset", String.valueOf(0));
            } else {
                this.cLF.addPostData("offset", String.valueOf(this.offset));
            }
            this.cLF.addPostData("rn", String.valueOf(20));
            this.data = this.cLF.postNetData();
            this.its.parserJson(this.data);
            if (this.cLF.aGg().aGI().isRequestSuccess()) {
                aVar.Fn(this.data);
                if (this.offset == 0) {
                    if (a.this.ito == null) {
                        a.this.ito = new ArrayList();
                    } else {
                        a.this.ito.clear();
                    }
                    a.this.itp = 0;
                    if (this.itu.booleanValue()) {
                        AL(this.data);
                    }
                }
            }
            return aVar;
        }

        private void AL(String str) {
            l<String> sQ;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (sQ = com.baidu.tbadk.core.c.a.aEB().sQ("tb.my_bookmarks")) != null) {
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
                arrayList = a.this.Fo(str);
                if (this.itu.booleanValue()) {
                    a.this.aH(arrayList);
                } else {
                    a.this.aI(arrayList);
                }
            } else {
                a.this.aH(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.itr.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            a.this.itl = null;
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
            if (this.its != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.its.getErrorCode(), this.its.getErrorString(), new Object[0]);
            }
            a.this.itp = aVar.getCount();
            ArrayList<MarkData> chN = aVar.chN();
            if (this.itu.booleanValue()) {
                if (chN != null && chN.size() != 0) {
                    a.this.aH(chN);
                }
            } else {
                a.this.aI(chN);
            }
            Iterator<MarkData> it = chN.iterator();
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
            if (a.this.itr != null) {
                String str = null;
                if (this.cLF.aGg().aGI().isRequestSuccess()) {
                    if (this.its.getErrorCode() != 0) {
                        str = this.its.getErrorString();
                    }
                    a.this.itr.callback(0, str, false);
                } else {
                    a.this.itr.callback(3, this.cLF.getErrorString());
                }
            }
            a.this.gZc = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x cLF;
        private com.baidu.tieba.myCollection.baseEditMark.c its;
        final /* synthetic */ a itt;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.its = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.chP();
                this.cLF = new x();
                this.cLF.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int chQ = this.itt.chQ();
                if (aVar.getCount() - 1 <= chQ) {
                    chQ = aVar.getCount() - 1;
                }
                while (chQ >= 0) {
                    String cm = aVar.cm(chQ, 20);
                    this.cLF.setPostData(new ArrayList<>());
                    this.cLF.addPostData("data", cm);
                    this.its.parserJson(this.cLF.postNetData());
                    if (!this.cLF.aGg().aGI().isRequestSuccess() || this.its.getErrorCode() != 0) {
                        break;
                    }
                    chQ -= 20;
                }
                this.itt.yp(chQ);
                if (chQ >= 0) {
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
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            this.itt.itm = null;
            if (this.itt.itr != null) {
                this.itt.itr.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.itt.itm = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cLF.aGg().aGI().isRequestSuccess()) {
                str = this.its.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.itt.itr != null) {
                this.itt.itr.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yo(int i) {
        if (this.itn != null) {
            this.itn.cancel();
        }
        if (i >= this.ito.size() || this.ito.get(i) == null || this.ito.get(i).getId() == null) {
            return false;
        }
        this.itn = new C0562a(this.ito.get(i).getId(), i, this.ito.get(i).getForumId());
        this.itn.setPriority(2);
        this.itn.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0562a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLF = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c its;
        private int pos;
        private String tid;

        public C0562a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.its = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.its = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cLF.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cLF.addPostData("tid", this.tid);
            this.cLF.addPostData("fid", this.fid);
            this.its.parserJson(this.cLF.postNetData());
            return this.cLF.aGg().aGI().isRequestSuccess() && this.its.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            a.this.itn = null;
            if (a.this.itr != null) {
                a.this.itr.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.itn = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.ito.size()) {
                    a.this.ito.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cLF.aGg().aGI().isRequestSuccess()) {
                str = this.its.getErrorString();
            } else {
                str = this.cLF.getErrorString();
            }
            if (a.this.itr != null) {
                a.this.itr.callback(2, bool, str);
            }
        }
    }

    public int chQ() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yp(int i) {
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.itl != null) {
            this.itl.cancel();
        }
        if (this.itm != null) {
            this.itm.cancel();
        }
        if (this.itn != null) {
            this.itn.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.itr = cVar;
    }

    private void chR() {
        if (this.ito != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.ito.iterator();
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
        if (this.ito != null && v.getCount(this.ito) > 0) {
            Iterator<MarkData> it = this.ito.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
