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
    private boolean dVA;
    private b fkr = null;
    private c fks = null;
    private C0199a fkt = null;
    private int fkv = 0;
    private int fkw = 0;
    protected d fkx = null;
    private ArrayList<MarkData> fku = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fkw;
        aVar.fkw = i - 1;
        return i;
    }

    public a() {
        this.dVA = false;
        this.dVA = true;
    }

    public int getOffset() {
        if (this.fku == null) {
            return 0;
        }
        return this.fku.size();
    }

    public int aWW() {
        return this.fkw;
    }

    public void pZ(int i) {
        this.fkw = i;
    }

    public boolean hasMore() {
        return this.fkv >= 20;
    }

    public void reset() {
        this.fkw = 0;
        this.fkv = 0;
        this.dVA = true;
    }

    public boolean isFirst() {
        return this.dVA;
    }

    public ArrayList<MarkData> aWX() {
        return this.fku;
    }

    public void al(ArrayList<MarkData> arrayList) {
        this.fku = arrayList;
    }

    public void am(ArrayList<MarkData> arrayList) {
        if (this.fku != null && arrayList != null) {
            this.fku.addAll(arrayList);
            aXb();
        }
    }

    public void f(MarkData markData) {
        this.fku.add(markData);
    }

    public int getCount() {
        if (this.fku == null) {
            return 0;
        }
        return this.fku.size();
    }

    public int aWY() {
        return this.fkv;
    }

    public void aWZ() {
        ArrayList<MarkData> bxb = com.baidu.tieba.tbadkCore.util.a.bxb();
        if (bxb != null) {
            al(bxb);
        }
    }

    public String bl(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fku == null) {
            return null;
        }
        if (i >= this.fku.size()) {
            i2 -= (i - this.fku.size()) - 1;
            i = this.fku.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fku.get(i5).toJson();
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

    public void qC(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> qD(String str) {
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
                    this.fku.add(markData);
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
        if (this.fkr != null) {
            this.fkr.cancel();
        }
        this.fkr = new b(getOffset());
        this.fkr.setPriority(3);
        this.fkr.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fky;
        private int offset;
        private y mNetWork = null;
        private String data = null;
        Boolean fkA = false;

        public b(int i) {
            this.offset = 0;
            this.fky = null;
            this.offset = i;
            this.fky = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fkA = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fkA.booleanValue() && booleanValue) {
                l<String> dy = com.baidu.tbadk.core.c.a.xb().dy("tb.my_bookmarks");
                if (dy != null) {
                    publishProgress(dy.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fku == null) {
                    a.this.fku = new ArrayList();
                } else {
                    a.this.fku.clear();
                }
                a.this.fkv = 0;
            }
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dVA) {
                this.mNetWork.o("offset", String.valueOf(0));
            } else {
                this.mNetWork.o("offset", String.valueOf(this.offset));
            }
            this.mNetWork.o(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.yq();
            this.fky.parserJson(this.data);
            if (this.mNetWork.yO().zN().isRequestSuccess()) {
                aVar.qC(this.data);
                if (this.offset == 0) {
                    if (a.this.fku == null) {
                        a.this.fku = new ArrayList();
                    } else {
                        a.this.fku.clear();
                    }
                    a.this.fkv = 0;
                    if (this.fkA.booleanValue()) {
                        lT(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lT(String str) {
            l<String> dy;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dy = com.baidu.tbadk.core.c.a.xb().dy("tb.my_bookmarks")) != null) {
                dy.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.qD(str);
                if (this.fkA.booleanValue()) {
                    a.this.al(arrayList);
                } else {
                    a.this.am(arrayList);
                }
            } else {
                a.this.al(arrayList);
            }
            if (!w.z(arrayList)) {
                a.this.fkx.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkr = null;
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
            if (this.fky != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fky.getErrorCode(), this.fky.getErrorString(), new Object[0]);
            }
            a.this.fkv = aVar.getCount();
            ArrayList<MarkData> aWX = aVar.aWX();
            if (this.fkA.booleanValue()) {
                if (aWX != null && aWX.size() != 0) {
                    a.this.al(aWX);
                }
            } else {
                a.this.am(aWX);
            }
            Iterator<MarkData> it = aWX.iterator();
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
            if (a.this.fkx != null) {
                String str = null;
                if (this.mNetWork.yO().zN().isRequestSuccess()) {
                    if (this.fky.getErrorCode() != 0) {
                        str = this.fky.getErrorString();
                    }
                    a.this.fkx.callback(0, str, false);
                } else {
                    a.this.fkx.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dVA = false;
        }
    }

    public void startSync() {
        if (this.fks != null) {
            this.fks.cancel();
        }
        this.fks = new c();
        this.fks.setPriority(2);
        this.fks.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fky;
        private y mNetWork;

        private c() {
            this.mNetWork = null;
            this.fky = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fky = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aWZ();
                this.mNetWork = new y();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aXa = a.this.aXa();
                if (aVar.getCount() - 1 <= aXa) {
                    aXa = aVar.getCount() - 1;
                }
                while (aXa >= 0) {
                    String bl = aVar.bl(aXa, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.o("data", bl);
                    this.fky.parserJson(this.mNetWork.yq());
                    if (!this.mNetWork.yO().zN().isRequestSuccess() || this.fky.getErrorCode() != 0) {
                        break;
                    }
                    aXa -= 20;
                }
                a.this.qb(aXa);
                if (aXa >= 0) {
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
            a.this.fks = null;
            if (a.this.fkx != null) {
                a.this.fkx.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fks = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.yO().zN().isRequestSuccess()) {
                str = this.fky.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fkx != null) {
                a.this.fkx.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean qa(int i) {
        if (this.fkt != null) {
            this.fkt.cancel();
        }
        if (i >= this.fku.size() || this.fku.get(i) == null || this.fku.get(i).getId() == null) {
            return false;
        }
        this.fkt = new C0199a(this.fku.get(i).getId(), i, this.fku.get(i).getForumId());
        this.fkt.setPriority(2);
        this.fkt.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0199a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fky;
        private y mNetWork = null;
        private int pos;
        private String tid;

        public C0199a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fky = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fky = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fky.parserJson(this.mNetWork.yq());
            return this.mNetWork.yO().zN().isRequestSuccess() && this.fky.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fkt = null;
            if (a.this.fkx != null) {
                a.this.fkx.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fkt = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fku.size()) {
                    a.this.fku.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.yO().zN().isRequestSuccess()) {
                str = this.fky.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fkx != null) {
                a.this.fkx.callback(2, bool, str);
            }
        }
    }

    public int aXa() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void qb(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fkr != null) {
            this.fkr.cancel();
        }
        if (this.fks != null) {
            this.fks.cancel();
        }
        if (this.fkt != null) {
            this.fkt.cancel();
        }
    }

    public void a(d dVar) {
        this.fkx = dVar;
    }

    private void aXb() {
        if (this.fku != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fku.iterator();
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
        if (this.fku != null && w.y(this.fku) > 0) {
            Iterator<MarkData> it = this.fku.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
