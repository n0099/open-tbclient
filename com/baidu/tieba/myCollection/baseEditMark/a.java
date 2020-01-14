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
/* loaded from: classes9.dex */
public class a {
    private boolean gWN;
    private b irc = null;
    private c ird = null;
    private C0555a ire = null;
    private int irg = 0;
    private int irh = 0;
    protected com.baidu.tieba.myCollection.c iri = null;
    private ArrayList<MarkData> irf = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.irh;
        aVar.irh = i - 1;
        return i;
    }

    public a() {
        this.gWN = false;
        this.gWN = true;
    }

    public int getOffset() {
        if (this.irf == null) {
            return 0;
        }
        return this.irf.size();
    }

    public int cge() {
        return this.irh;
    }

    public void yg(int i) {
        this.irh = i;
    }

    public boolean hasMore() {
        return this.irg > 0;
    }

    public void reset() {
        this.irh = 0;
        this.irg = 0;
        this.gWN = true;
    }

    public ArrayList<MarkData> cgf() {
        return this.irf;
    }

    public void aH(ArrayList<MarkData> arrayList) {
        this.irf = arrayList;
    }

    public void aI(ArrayList<MarkData> arrayList) {
        if (this.irf != null && arrayList != null) {
            this.irf.addAll(arrayList);
            cgj();
        }
    }

    public void f(MarkData markData) {
        this.irf.add(markData);
    }

    public int getCount() {
        if (this.irf == null) {
            return 0;
        }
        return this.irf.size();
    }

    public int cgg() {
        return this.irg;
    }

    public void cgh() {
        ArrayList<MarkData> cKw = com.baidu.tieba.tbadkCore.util.a.cKw();
        if (cKw != null) {
            aH(cKw);
        }
    }

    public String cl(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.irf == null) {
            return null;
        }
        if (i >= this.irf.size()) {
            i2 -= (i - this.irf.size()) - 1;
            i = this.irf.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.irf.get(i5).toJson();
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

    public void EX(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> EY(String str) {
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
                    this.irf.add(markData);
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
        if (this.irc != null) {
            this.irc.cancel();
        }
        this.irc = new b(getOffset());
        this.irc.setPriority(3);
        this.irc.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c irj;
        private int offset;
        private x cHA = null;
        private String data = null;
        Boolean irl = false;

        public b(int i) {
            this.offset = 0;
            this.irj = null;
            this.offset = i;
            this.irj = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.irl = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.irl.booleanValue() && booleanValue) {
                l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.my_bookmarks");
                if (sA != null) {
                    publishProgress(sA.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.irf == null) {
                    a.this.irf = new ArrayList();
                } else {
                    a.this.irf.clear();
                }
                a.this.irg = 0;
            }
            this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.cHA.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.gWN) {
                this.cHA.addPostData("offset", String.valueOf(0));
            } else {
                this.cHA.addPostData("offset", String.valueOf(this.offset));
            }
            this.cHA.addPostData("rn", String.valueOf(20));
            this.data = this.cHA.postNetData();
            this.irj.parserJson(this.data);
            if (this.cHA.aDU().aEv().isRequestSuccess()) {
                aVar.EX(this.data);
                if (this.offset == 0) {
                    if (a.this.irf == null) {
                        a.this.irf = new ArrayList();
                    } else {
                        a.this.irf.clear();
                    }
                    a.this.irg = 0;
                    if (this.irl.booleanValue()) {
                        Au(this.data);
                    }
                }
            }
            return aVar;
        }

        private void Au(String str) {
            l<String> sA;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.my_bookmarks")) != null) {
                sA.set(currentAccount, str, 604800000L);
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
                arrayList = a.this.EY(str);
                if (this.irl.booleanValue()) {
                    a.this.aH(arrayList);
                } else {
                    a.this.aI(arrayList);
                }
            } else {
                a.this.aH(arrayList);
            }
            if (!v.isEmpty(arrayList)) {
                a.this.iri.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            a.this.irc = null;
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
            if (this.irj != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.irj.getErrorCode(), this.irj.getErrorString(), new Object[0]);
            }
            a.this.irg = aVar.getCount();
            ArrayList<MarkData> cgf = aVar.cgf();
            if (this.irl.booleanValue()) {
                if (cgf != null && cgf.size() != 0) {
                    a.this.aH(cgf);
                }
            } else {
                a.this.aI(cgf);
            }
            Iterator<MarkData> it = cgf.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.yg(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.iri != null) {
                String str = null;
                if (this.cHA.aDU().aEv().isRequestSuccess()) {
                    if (this.irj.getErrorCode() != 0) {
                        str = this.irj.getErrorString();
                    }
                    a.this.iri.callback(0, str, false);
                } else {
                    a.this.iri.callback(3, this.cHA.getErrorString());
                }
            }
            a.this.gWN = false;
        }
    }

    /* loaded from: classes9.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private x cHA;
        private com.baidu.tieba.myCollection.baseEditMark.c irj;
        final /* synthetic */ a irk;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.irj = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.cgh();
                this.cHA = new x();
                this.cHA.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int cgi = this.irk.cgi();
                if (aVar.getCount() - 1 <= cgi) {
                    cgi = aVar.getCount() - 1;
                }
                while (cgi >= 0) {
                    String cl = aVar.cl(cgi, 20);
                    this.cHA.setPostData(new ArrayList<>());
                    this.cHA.addPostData("data", cl);
                    this.irj.parserJson(this.cHA.postNetData());
                    if (!this.cHA.aDU().aEv().isRequestSuccess() || this.irj.getErrorCode() != 0) {
                        break;
                    }
                    cgi -= 20;
                }
                this.irk.yi(cgi);
                if (cgi >= 0) {
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
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            this.irk.ird = null;
            if (this.irk.iri != null) {
                this.irk.iri.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.irk.ird = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.cHA.aDU().aEv().isRequestSuccess()) {
                str = this.irj.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.irk.iri != null) {
                this.irk.iri.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean yh(int i) {
        if (this.ire != null) {
            this.ire.cancel();
        }
        if (i >= this.irf.size() || this.irf.get(i) == null || this.irf.get(i).getId() == null) {
            return false;
        }
        this.ire = new C0555a(this.irf.get(i).getId(), i, this.irf.get(i).getForumId());
        this.ire.setPriority(2);
        this.ire.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0555a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private x cHA = null;
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c irj;
        private int pos;
        private String tid;

        public C0555a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.irj = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.irj = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.cHA.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.cHA.addPostData("tid", this.tid);
            this.cHA.addPostData("fid", this.fid);
            this.irj.parserJson(this.cHA.postNetData());
            return this.cHA.aDU().aEv().isRequestSuccess() && this.irj.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            a.this.ire = null;
            if (a.this.iri != null) {
                a.this.iri.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.ire = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.irf.size()) {
                    a.this.irf.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.cHA.aDU().aEv().isRequestSuccess()) {
                str = this.irj.getErrorString();
            } else {
                str = this.cHA.getErrorString();
            }
            if (a.this.iri != null) {
                a.this.iri.callback(2, bool, str);
            }
        }
    }

    public int cgi() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, 399);
    }

    public void yi(int i) {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.UPLOAD_MARK_OFFSET, i);
    }

    public void onDestroy() {
        if (this.irc != null) {
            this.irc.cancel();
        }
        if (this.ird != null) {
            this.ird.cancel();
        }
        if (this.ire != null) {
            this.ire.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.iri = cVar;
    }

    private void cgj() {
        if (this.irf != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.irf.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bk(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bk(String str, int i) {
        if (this.irf != null && v.getCount(this.irf) > 0) {
            Iterator<MarkData> it = this.irf.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
