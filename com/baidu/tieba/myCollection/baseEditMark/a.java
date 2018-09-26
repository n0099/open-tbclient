package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.myCollection.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean ecO;
    private b frI = null;
    private c frJ = null;
    private C0201a frK = null;
    private int frM = 0;
    private int frN = 0;
    protected d frO = null;
    private ArrayList<MarkData> frL = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.frN;
        aVar.frN = i - 1;
        return i;
    }

    public a() {
        this.ecO = false;
        this.ecO = true;
    }

    public int getOffset() {
        if (this.frL == null) {
            return 0;
        }
        return this.frL.size();
    }

    public int aZf() {
        return this.frN;
    }

    public void qD(int i) {
        this.frN = i;
    }

    public boolean hasMore() {
        return this.frM >= 20;
    }

    public void reset() {
        this.frN = 0;
        this.frM = 0;
        this.ecO = true;
    }

    public boolean isFirst() {
        return this.ecO;
    }

    public ArrayList<MarkData> aZg() {
        return this.frL;
    }

    public void al(ArrayList<MarkData> arrayList) {
        this.frL = arrayList;
    }

    public void am(ArrayList<MarkData> arrayList) {
        if (this.frL != null && arrayList != null) {
            this.frL.addAll(arrayList);
            aZk();
        }
    }

    public void f(MarkData markData) {
        this.frL.add(markData);
    }

    public int getCount() {
        if (this.frL == null) {
            return 0;
        }
        return this.frL.size();
    }

    public int aZh() {
        return this.frM;
    }

    public void aZi() {
        ArrayList<MarkData> bzG = com.baidu.tieba.tbadkCore.util.a.bzG();
        if (bzG != null) {
            al(bzG);
        }
    }

    public String bp(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.frL == null) {
            return null;
        }
        if (i >= this.frL.size()) {
            i2 -= (i - this.frL.size()) - 1;
            i = this.frL.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.frL.get(i5).toJson();
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

    public void rk(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> rl(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
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
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.frL.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void e(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.frI != null) {
            this.frI.cancel();
        }
        this.frI = new b(getOffset());
        this.frI.setPriority(3);
        this.frI.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c frP;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean frR = false;

        public b(int i) {
            this.offset = 0;
            this.frP = null;
            this.offset = i;
            this.frP = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.frR = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.frR.booleanValue() && booleanValue) {
                l<String> dQ = com.baidu.tbadk.core.c.a.yh().dQ("tb.my_bookmarks");
                if (dQ != null) {
                    publishProgress(dQ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.frL == null) {
                    a.this.frL = new ArrayList();
                } else {
                    a.this.frL.clear();
                }
                a.this.frM = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.u("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ecO) {
                this.mNetWork.u("offset", String.valueOf(0));
            } else {
                this.mNetWork.u("offset", String.valueOf(this.offset));
            }
            this.mNetWork.u("rn", String.valueOf(20));
            this.data = this.mNetWork.zt();
            this.frP.parserJson(this.data);
            if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                aVar.rk(this.data);
                if (this.offset == 0) {
                    if (a.this.frL == null) {
                        a.this.frL = new ArrayList();
                    } else {
                        a.this.frL.clear();
                    }
                    a.this.frM = 0;
                    if (this.frR.booleanValue()) {
                        mx(this.data);
                    }
                }
            }
            return aVar;
        }

        private void mx(String str) {
            l<String> dQ;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dQ = com.baidu.tbadk.core.c.a.yh().dQ("tb.my_bookmarks")) != null) {
                dQ.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.rl(str);
                if (this.frR.booleanValue()) {
                    a.this.al(arrayList);
                } else {
                    a.this.am(arrayList);
                }
            } else {
                a.this.al(arrayList);
            }
            if (!v.z(arrayList)) {
                a.this.frO.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            a.this.frI = null;
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
            if (this.frP != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.frP.getErrorCode(), this.frP.getErrorString(), new Object[0]);
            }
            a.this.frM = aVar.getCount();
            ArrayList<MarkData> aZg = aVar.aZg();
            if (this.frR.booleanValue()) {
                if (aZg != null && aZg.size() != 0) {
                    a.this.al(aZg);
                }
            } else {
                a.this.am(aZg);
            }
            Iterator<MarkData> it = aZg.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.qD(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.frO != null) {
                String str = null;
                if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                    if (this.frP.getErrorCode() != 0) {
                        str = this.frP.getErrorString();
                    }
                    a.this.frO.callback(0, str, false);
                } else {
                    a.this.frO.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ecO = false;
        }
    }

    public void startSync() {
        if (this.frJ != null) {
            this.frJ.cancel();
        }
        this.frJ = new c();
        this.frJ.setPriority(2);
        this.frJ.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c frP;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.frP = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.frP = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aZi();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aZj = a.this.aZj();
                if (aVar.getCount() - 1 <= aZj) {
                    aZj = aVar.getCount() - 1;
                }
                while (aZj >= 0) {
                    String bp = aVar.bp(aZj, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.u("data", bp);
                    this.frP.parserJson(this.mNetWork.zt());
                    if (!this.mNetWork.zR().AQ().isRequestSuccess() || this.frP.getErrorCode() != 0) {
                        break;
                    }
                    aZj -= 20;
                }
                a.this.qF(aZj);
                if (aZj >= 0) {
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
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            a.this.frJ = null;
            if (a.this.frO != null) {
                a.this.frO.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.frJ = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                str = this.frP.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.frO != null) {
                a.this.frO.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean qE(int i) {
        if (this.frK != null) {
            this.frK.cancel();
        }
        if (i >= this.frL.size() || this.frL.get(i) == null || this.frL.get(i).getId() == null) {
            return false;
        }
        this.frK = new C0201a(this.frL.get(i).getId(), i, this.frL.get(i).getForumId());
        this.frK.setPriority(2);
        this.frK.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0201a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c frP;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0201a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.frP = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.frP = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.u("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.u("tid", this.tid);
            this.mNetWork.u(ImageViewerConfig.FORUM_ID, this.fid);
            this.frP.parserJson(this.mNetWork.zt());
            return this.mNetWork.zR().AQ().isRequestSuccess() && this.frP.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            a.this.frK = null;
            if (a.this.frO != null) {
                a.this.frO.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.frK = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.frL.size()) {
                    a.this.frL.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                str = this.frP.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.frO != null) {
                a.this.frO.callback(2, bool, str);
            }
        }
    }

    public int aZj() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void qF(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.frI != null) {
            this.frI.cancel();
        }
        if (this.frJ != null) {
            this.frJ.cancel();
        }
        if (this.frK != null) {
            this.frK.cancel();
        }
    }

    public void a(d dVar) {
        this.frO = dVar;
    }

    private void aZk() {
        if (this.frL != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.frL.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aF(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aF(String str, int i) {
        if (this.frL != null && v.y(this.frL) > 0) {
            Iterator<MarkData> it = this.frL.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
