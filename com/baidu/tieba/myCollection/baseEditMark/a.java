package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.myCollection.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean dVv;
    private b fkl = null;
    private c fkm = null;
    private C0199a fkn = null;
    private int fkp = 0;
    private int fkq = 0;
    protected d fkr = null;
    private ArrayList<MarkData> fko = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fkq;
        aVar.fkq = i - 1;
        return i;
    }

    public a() {
        this.dVv = false;
        this.dVv = true;
    }

    public int getOffset() {
        if (this.fko == null) {
            return 0;
        }
        return this.fko.size();
    }

    public int aWS() {
        return this.fkq;
    }

    public void pZ(int i) {
        this.fkq = i;
    }

    public boolean hasMore() {
        return this.fkp >= 20;
    }

    public void reset() {
        this.fkq = 0;
        this.fkp = 0;
        this.dVv = true;
    }

    public boolean isFirst() {
        return this.dVv;
    }

    public ArrayList<MarkData> aWT() {
        return this.fko;
    }

    public void al(ArrayList<MarkData> arrayList) {
        this.fko = arrayList;
    }

    public void am(ArrayList<MarkData> arrayList) {
        if (this.fko != null && arrayList != null) {
            this.fko.addAll(arrayList);
            aWX();
        }
    }

    public void f(MarkData markData) {
        this.fko.add(markData);
    }

    public int getCount() {
        if (this.fko == null) {
            return 0;
        }
        return this.fko.size();
    }

    public int aWU() {
        return this.fkp;
    }

    public void aWV() {
        ArrayList<MarkData> bxc = com.baidu.tieba.tbadkCore.util.a.bxc();
        if (bxc != null) {
            al(bxc);
        }
    }

    public String bl(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fko == null) {
            return null;
        }
        if (i >= this.fko.size()) {
            i2 -= (i - this.fko.size()) - 1;
            i = this.fko.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fko.get(i5).toJson();
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

    public void qF(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> qG(String str) {
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
                    this.fko.add(markData);
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
        if (this.fkl != null) {
            this.fkl.cancel();
        }
        this.fkl = new b(getOffset());
        this.fkl.setPriority(3);
        this.fkl.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fks;
        private int offset;
        private y mNetWork = null;
        private String data = null;
        Boolean fku = false;

        public b(int i) {
            this.offset = 0;
            this.fks = null;
            this.offset = i;
            this.fks = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fku = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fku.booleanValue() && booleanValue) {
                l<String> dy = com.baidu.tbadk.core.c.a.xa().dy("tb.my_bookmarks");
                if (dy != null) {
                    publishProgress(dy.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fko == null) {
                    a.this.fko = new ArrayList();
                } else {
                    a.this.fko.clear();
                }
                a.this.fkp = 0;
            }
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dVv) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.yo();
            this.fks.parserJson(this.data);
            if (this.mNetWork.yM().zL().isRequestSuccess()) {
                aVar.qF(this.data);
                if (this.offset == 0) {
                    if (a.this.fko == null) {
                        a.this.fko = new ArrayList();
                    } else {
                        a.this.fko.clear();
                    }
                    a.this.fkp = 0;
                    if (this.fku.booleanValue()) {
                        lV(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lV(String str) {
            l<String> dy;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dy = com.baidu.tbadk.core.c.a.xa().dy("tb.my_bookmarks")) != null) {
                dy.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.qG(str);
                if (this.fku.booleanValue()) {
                    a.this.al(arrayList);
                } else {
                    a.this.am(arrayList);
                }
            } else {
                a.this.al(arrayList);
            }
            if (!w.z(arrayList)) {
                a.this.fkr.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkl = null;
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
            if (this.fks != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fks.getErrorCode(), this.fks.getErrorString(), new Object[0]);
            }
            a.this.fkp = aVar.getCount();
            ArrayList<MarkData> aWT = aVar.aWT();
            if (this.fku.booleanValue()) {
                if (aWT != null && aWT.size() != 0) {
                    a.this.al(aWT);
                }
            } else {
                a.this.am(aWT);
            }
            Iterator<MarkData> it = aWT.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.pZ(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fkr != null) {
                String str = null;
                if (this.mNetWork.yM().zL().isRequestSuccess()) {
                    if (this.fks.getErrorCode() != 0) {
                        str = this.fks.getErrorString();
                    }
                    a.this.fkr.callback(0, str, false);
                } else {
                    a.this.fkr.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dVv = false;
        }
    }

    public void startSync() {
        if (this.fkm != null) {
            this.fkm.cancel();
        }
        this.fkm = new c();
        this.fkm.setPriority(2);
        this.fkm.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fks;
        private y mNetWork;

        private c() {
            this.mNetWork = null;
            this.fks = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fks = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aWV();
                this.mNetWork = new y();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aWW = a.this.aWW();
                if (aVar.getCount() - 1 <= aWW) {
                    aWW = aVar.getCount() - 1;
                }
                while (aWW >= 0) {
                    String bl = aVar.bl(aWW, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.o("data", bl);
                    this.fks.parserJson(this.mNetWork.yo());
                    if (!this.mNetWork.yM().zL().isRequestSuccess() || this.fks.getErrorCode() != 0) {
                        break;
                    }
                    aWW -= 20;
                }
                a.this.qb(aWW);
                if (aWW >= 0) {
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
                this.mNetWork.hN();
            }
            a.this.fkm = null;
            if (a.this.fkr != null) {
                a.this.fkr.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fkm = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.yM().zL().isRequestSuccess()) {
                str = this.fks.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fkr != null) {
                a.this.fkr.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean qa(int i) {
        if (this.fkn != null) {
            this.fkn.cancel();
        }
        if (i >= this.fko.size() || this.fko.get(i) == null || this.fko.get(i).getId() == null) {
            return false;
        }
        this.fkn = new C0199a(this.fko.get(i).getId(), i, this.fko.get(i).getForumId());
        this.fkn.setPriority(2);
        this.fkn.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0199a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fks;
        private y mNetWork = null;
        private int pos;
        private String tid;

        public C0199a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fks = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fks = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.o("tid", this.tid);
            this.mNetWork.o(ImageViewerConfig.FORUM_ID, this.fid);
            this.fks.parserJson(this.mNetWork.yo());
            return this.mNetWork.yM().zL().isRequestSuccess() && this.fks.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkn = null;
            if (a.this.fkr != null) {
                a.this.fkr.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fkn = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fko.size()) {
                    a.this.fko.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.yM().zL().isRequestSuccess()) {
                str = this.fks.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fkr != null) {
                a.this.fkr.callback(2, bool, str);
            }
        }
    }

    public int aWW() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void qb(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fkl != null) {
            this.fkl.cancel();
        }
        if (this.fkm != null) {
            this.fkm.cancel();
        }
        if (this.fkn != null) {
            this.fkn.cancel();
        }
    }

    public void a(d dVar) {
        this.fkr = dVar;
    }

    private void aWX() {
        if (this.fko != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fko.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aA(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aA(String str, int i) {
        if (this.fko != null && w.y(this.fko) > 0) {
            Iterator<MarkData> it = this.fko.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
