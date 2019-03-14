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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private boolean fIU;
    private b hbt = null;
    private c hbu = null;
    private C0341a hbv = null;
    private int hbx = 0;
    private int hby = 0;
    protected com.baidu.tieba.myCollection.c hbz = null;
    private ArrayList<MarkData> hbw = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hby;
        aVar.hby = i - 1;
        return i;
    }

    public a() {
        this.fIU = false;
        this.fIU = true;
    }

    public int getOffset() {
        if (this.hbw == null) {
            return 0;
        }
        return this.hbw.size();
    }

    public int bFs() {
        return this.hby;
    }

    public void vM(int i) {
        this.hby = i;
    }

    public boolean hasMore() {
        return this.hbx >= 20;
    }

    public void reset() {
        this.hby = 0;
        this.hbx = 0;
        this.fIU = true;
    }

    public ArrayList<MarkData> bFt() {
        return this.hbw;
    }

    public void ao(ArrayList<MarkData> arrayList) {
        this.hbw = arrayList;
    }

    public void ap(ArrayList<MarkData> arrayList) {
        if (this.hbw != null && arrayList != null) {
            this.hbw.addAll(arrayList);
            bFx();
        }
    }

    public void f(MarkData markData) {
        this.hbw.add(markData);
    }

    public int getCount() {
        if (this.hbw == null) {
            return 0;
        }
        return this.hbw.size();
    }

    public int bFu() {
        return this.hbx;
    }

    public void bFv() {
        ArrayList<MarkData> cfn = com.baidu.tieba.tbadkCore.util.a.cfn();
        if (cfn != null) {
            ao(cfn);
        }
    }

    public String bP(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.hbw == null) {
            return null;
        }
        if (i >= this.hbw.size()) {
            i2 -= (i - this.hbw.size()) - 1;
            i = this.hbw.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.hbw.get(i5).toJson();
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

    public void zj(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> zk(String str) {
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
                    this.hbw.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void g(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.hbt != null) {
            this.hbt.cancel();
        }
        this.hbt = new b(getOffset());
        this.hbt.setPriority(3);
        this.hbt.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c hbA;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean hbC = false;

        public b(int i) {
            this.offset = 0;
            this.hbA = null;
            this.offset = i;
            this.hbA = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.hbC = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.hbC.booleanValue() && booleanValue) {
                l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.my_bookmarks");
                if (lv != null) {
                    publishProgress(lv.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.hbw == null) {
                    a.this.hbw = new ArrayList();
                } else {
                    a.this.hbw.clear();
                }
                a.this.hbx = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.fIU) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.acj();
            this.hbA.parserJson(this.data);
            if (this.mNetWork.acH().adG().isRequestSuccess()) {
                aVar.zj(this.data);
                if (this.offset == 0) {
                    if (a.this.hbw == null) {
                        a.this.hbw = new ArrayList();
                    } else {
                        a.this.hbw.clear();
                    }
                    a.this.hbx = 0;
                    if (this.hbC.booleanValue()) {
                        ux(this.data);
                    }
                }
            }
            return aVar;
        }

        private void ux(String str) {
            l<String> lv;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.my_bookmarks")) != null) {
                lv.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.zk(str);
                if (this.hbC.booleanValue()) {
                    a.this.ao(arrayList);
                } else {
                    a.this.ap(arrayList);
                }
            } else {
                a.this.ao(arrayList);
            }
            if (!v.T(arrayList)) {
                a.this.hbz.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            a.this.hbt = null;
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
            if (this.hbA != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.hbA.getErrorCode(), this.hbA.getErrorString(), new Object[0]);
            }
            a.this.hbx = aVar.getCount();
            ArrayList<MarkData> bFt = aVar.bFt();
            if (this.hbC.booleanValue()) {
                if (bFt != null && bFt.size() != 0) {
                    a.this.ao(bFt);
                }
            } else {
                a.this.ap(bFt);
            }
            Iterator<MarkData> it = bFt.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.vM(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.hbz != null) {
                String str = null;
                if (this.mNetWork.acH().adG().isRequestSuccess()) {
                    if (this.hbA.getErrorCode() != 0) {
                        str = this.hbA.getErrorString();
                    }
                    a.this.hbz.callback(0, str, false);
                } else {
                    a.this.hbz.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.fIU = false;
        }
    }

    /* loaded from: classes6.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c hbA;
        final /* synthetic */ a hbB;
        private x mNetWork;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.hbA = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bFv();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bFw = this.hbB.bFw();
                if (aVar.getCount() - 1 <= bFw) {
                    bFw = aVar.getCount() - 1;
                }
                while (bFw >= 0) {
                    String bP = aVar.bP(bFw, 20);
                    this.mNetWork.r(new ArrayList<>());
                    this.mNetWork.x("data", bP);
                    this.hbA.parserJson(this.mNetWork.acj());
                    if (!this.mNetWork.acH().adG().isRequestSuccess() || this.hbA.getErrorCode() != 0) {
                        break;
                    }
                    bFw -= 20;
                }
                this.hbB.vO(bFw);
                if (bFw >= 0) {
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
                this.mNetWork.ji();
            }
            this.hbB.hbu = null;
            if (this.hbB.hbz != null) {
                this.hbB.hbz.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            this.hbB.hbu = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.acH().adG().isRequestSuccess()) {
                str = this.hbA.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (this.hbB.hbz != null) {
                this.hbB.hbz.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean vN(int i) {
        if (this.hbv != null) {
            this.hbv.cancel();
        }
        if (i >= this.hbw.size() || this.hbw.get(i) == null || this.hbw.get(i).getId() == null) {
            return false;
        }
        this.hbv = new C0341a(this.hbw.get(i).getId(), i, this.hbw.get(i).getForumId());
        this.hbv.setPriority(2);
        this.hbv.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0341a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c hbA;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0341a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.hbA = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.hbA = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.x("tid", this.tid);
            this.mNetWork.x(ImageViewerConfig.FORUM_ID, this.fid);
            this.hbA.parserJson(this.mNetWork.acj());
            return this.mNetWork.acH().adG().isRequestSuccess() && this.hbA.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            a.this.hbv = null;
            if (a.this.hbz != null) {
                a.this.hbz.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.hbv = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.hbw.size()) {
                    a.this.hbw.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.acH().adG().isRequestSuccess()) {
                str = this.hbA.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.hbz != null) {
                a.this.hbz.callback(2, bool, str);
            }
        }
    }

    public int bFw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void vO(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.hbt != null) {
            this.hbt.cancel();
        }
        if (this.hbu != null) {
            this.hbu.cancel();
        }
        if (this.hbv != null) {
            this.hbv.cancel();
        }
    }

    public void a(com.baidu.tieba.myCollection.c cVar) {
        this.hbz = cVar;
    }

    private void bFx() {
        if (this.hbw != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.hbw.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    bg(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void bg(String str, int i) {
        if (this.hbw != null && v.S(this.hbw) > 0) {
            Iterator<MarkData> it = this.hbw.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
