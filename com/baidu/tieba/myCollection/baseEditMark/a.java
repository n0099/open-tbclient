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
    private boolean gYQ;
    private b isZ = null;
    private c ita = null;
    private C0562a itb = null;
    private int itd = 0;
    private int ite = 0;
    protected com.baidu.tieba.myCollection.c itf = null;
    private ArrayList<MarkData> itc = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.ite;
        aVar.ite = i - 1;
        return i;
    }

    public a() {
        this.gYQ = false;
        this.gYQ = true;
    }

    public int getOffset() {
        if (this.itc == null) {
            return 0;
        }
        return this.itc.size();
    }

    public int chL() {
        return this.ite;
    }

    public void yn(int i) {
        this.ite = i;
    }

    public boolean hasMore() {
        return this.itd > 0;
    }

    public void reset() {
        this.ite = 0;
        this.itd = 0;
        this.gYQ = true;
    }

    public ArrayList<MarkData> chM() {
        return this.itc;
    }

    public void aH(ArrayList<MarkData> arrayList) {
        this.itc = arrayList;
    }

    public void aI(ArrayList<MarkData> arrayList) {
        if (this.itc != null && arrayList != null) {
            this.itc.addAll(arrayList);
            chQ();
        }
    }

    public void f(MarkData markData) {
        this.itc.add(markData);
    }

    public int getCount() {
        if (this.itc == null) {
            return 0;
        }
        return this.itc.size();
    }

    public int chN() {
        return this.itd;
    }

    public void chO() {
        ArrayList<MarkData> cLW = com.baidu.tieba.tbadkCore.util.a.cLW();
        if (cLW != null) {
            aH(cLW);
        }
    }

    public String cm(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.itc == null) {
            return null;
        }
        if (i >= this.itc.size()) {
            i2 -= (i - this.itc.size()) - 1;
            i = this.itc.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.itc.get(i5).toJson();
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
                    this.itc.add(markData);
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
        if (this.isZ != null) {
            this.isZ.cancel();
        }
        this.isZ = new b(getOffset());
        this.isZ.setPriority(3);
        this.isZ.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c itg;
        private int offset;
        private x cLE = null;
        private String data = null;
        Boolean iti = false;

        public b(int i) {
            this.offset = 0;
            this.itg = null;
            this.offset = i;
            this.itg = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.iti = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.iti.booleanValue() && booleanValue) {
                l<String> sQ = com.baidu.tbadk.core.c.a.aEB().sQ("tb.my_bookmarks");
                if (sQ != null) {
                    publishProgress(sQ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.itc == null) {
                    a.this.itc = new ArrayList();
                } else {
                    a.this.itc.clear();
                }
                a.this.itd = 0;
            }
            this.cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cLE.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gYQ) {
                this.cLE.addPostData("offset", String.valueOf(0));
            } else {
                this.cLE.addPostData("offset", String.valueOf(this.offset));
            }
            this.cLE.addPostData("rn", String.valueOf(20));
            this.data = this.cLE.postNetData();
            this.itg.parserJson(this.data);
            if (this.cLE.aGg().aGI().isRequestSuccess()) {
                aVar.Fm(this.data);
                if (this.offset == 0) {
                    if (a.this.itc == null) {
                        a.this.itc = new ArrayList();
                    } else {
                        a.this.itc.clear();
                    }
                    a.this.itd = 0;
                    if (this.iti.booleanValue()) {
                        AK(this.data);
                    }
                }
            }
            return aVar;
        }

        private void AK(String str) {
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
                arrayList = a.this.Fn(str);
                if (this.iti.booleanValue()) {
                    a.this.aH(arrayList);
                } else {
                    a.this.aI(arrayList);
                }
            } else {
                a.this.aH(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.itf.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
            }
            a.this.isZ = null;
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
            if (this.itg != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.itg.getErrorCode(), this.itg.getErrorString(), new Object[0]);
            }
            a.this.itd = aVar.getCount();
            ArrayList<MarkData> chM = aVar.chM();
            if (this.iti.booleanValue()) {
                if (chM != null && chM.size() != 0) {
                    a.this.aH(chM);
                }
            } else {
                a.this.aI(chM);
            }
            Iterator<MarkData> it = chM.iterator();
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
            if (a.this.itf != null) {
                String str = null;
                if (this.cLE.aGg().aGI().isRequestSuccess()) {
                    if (this.itg.getErrorCode() != 0) {
                        str = this.itg.getErrorString();
                    }
                    a.this.itf.callback(0, str, false);
                } else {
                    a.this.itf.callback(3, this.cLE.getErrorString());
                }
            }
            a.this.gYQ = false;
        }
    }

    /* loaded from: classes11.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x cLE;
        private com.baidu.tieba.myCollection.baseEditMark.c itg;
        final /* synthetic */ a ith;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.itg = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.chO();
                this.cLE = new x();
                this.cLE.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int chP = this.ith.chP();
                if (aVar.getCount() - 1 <= chP) {
                    chP = aVar.getCount() - 1;
                }
                while (chP >= 0) {
                    String cm = aVar.cm(chP, 20);
                    this.cLE.setPostData(new ArrayList<>());
                    this.cLE.addPostData("data", cm);
                    this.itg.parserJson(this.cLE.postNetData());
                    if (!this.cLE.aGg().aGI().isRequestSuccess() || this.itg.getErrorCode() != 0) {
                        break;
                    }
                    chP -= 20;
                }
                this.ith.yp(chP);
                if (chP >= 0) {
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
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
            }
            this.ith.ita = null;
            if (this.ith.itf != null) {
                this.ith.itf.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.ith.ita = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cLE.aGg().aGI().isRequestSuccess()) {
                str = this.itg.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.ith.itf != null) {
                this.ith.itf.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yo(int i) {
        if (this.itb != null) {
            this.itb.cancel();
        }
        if (i >= this.itc.size() || this.itc.get(i) == null || this.itc.get(i).getId() == null) {
            return false;
        }
        this.itb = new C0562a(this.itc.get(i).getId(), i, this.itc.get(i).getForumId());
        this.itb.setPriority(2);
        this.itb.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0562a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cLE = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c itg;
        private int pos;
        private String tid;

        public C0562a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.itg = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.itg = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cLE.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cLE.addPostData("tid", this.tid);
            this.cLE.addPostData("fid", this.fid);
            this.itg.parserJson(this.cLE.postNetData());
            return this.cLE.aGg().aGI().isRequestSuccess() && this.itg.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
            }
            a.this.itb = null;
            if (a.this.itf != null) {
                a.this.itf.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.itb = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.itc.size()) {
                    a.this.itc.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cLE.aGg().aGI().isRequestSuccess()) {
                str = this.itg.getErrorString();
            } else {
                str = this.cLE.getErrorString();
            }
            if (a.this.itf != null) {
                a.this.itf.callback(2, bool, str);
            }
        }
    }

    public int chP() {
        return com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yp(int i) {
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.isZ != null) {
            this.isZ.cancel();
        }
        if (this.ita != null) {
            this.ita.cancel();
        }
        if (this.itb != null) {
            this.itb.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.itf = cVar;
    }

    private void chQ() {
        if (this.itc != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.itc.iterator();
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
        if (this.itc != null && v.getCount(this.itc) > 0) {
            Iterator<MarkData> it = this.itc.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
