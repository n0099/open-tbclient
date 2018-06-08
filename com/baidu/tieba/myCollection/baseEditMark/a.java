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
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean dOx;
    private b fgh = null;
    private c fgi = null;
    private C0198a fgj = null;
    private int fgl = 0;
    private int fgm = 0;
    protected d fgn = null;
    private ArrayList<MarkData> fgk = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fgm;
        aVar.fgm = i - 1;
        return i;
    }

    public a() {
        this.dOx = false;
        this.dOx = true;
    }

    public int getOffset() {
        if (this.fgk == null) {
            return 0;
        }
        return this.fgk.size();
    }

    public int aXT() {
        return this.fgm;
    }

    public void pV(int i) {
        this.fgm = i;
    }

    public boolean hasMore() {
        return this.fgl >= 20;
    }

    public void reset() {
        this.fgm = 0;
        this.fgl = 0;
        this.dOx = true;
    }

    public boolean isFirst() {
        return this.dOx;
    }

    public ArrayList<MarkData> aXU() {
        return this.fgk;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fgk = arrayList;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        if (this.fgk != null && arrayList != null) {
            this.fgk.addAll(arrayList);
            aXY();
        }
    }

    public void f(MarkData markData) {
        this.fgk.add(markData);
    }

    public int getCount() {
        if (this.fgk == null) {
            return 0;
        }
        return this.fgk.size();
    }

    public int aXV() {
        return this.fgl;
    }

    public void aXW() {
        ArrayList<MarkData> bxU = com.baidu.tieba.tbadkCore.util.a.bxU();
        if (bxU != null) {
            aj(bxU);
        }
    }

    public String bl(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fgk == null) {
            return null;
        }
        if (i >= this.fgk.size()) {
            i2 -= (i - this.fgk.size()) - 1;
            i = this.fgk.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fgk.get(i5).toJson();
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

    public void qJ(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> qK(String str) {
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
                    this.fgk.add(markData);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void d(Boolean bool) {
        a(bool, true);
    }

    public void a(Boolean bool, boolean z) {
        if (this.fgh != null) {
            this.fgh.cancel();
        }
        this.fgh = new b(getOffset());
        this.fgh.setPriority(3);
        this.fgh.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fgo;
        private int offset;
        private y mNetWork = null;
        private String data = null;
        Boolean fgq = false;

        public b(int i) {
            this.offset = 0;
            this.fgo = null;
            this.offset = i;
            this.fgo = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fgq = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fgq.booleanValue() && booleanValue) {
                l<String> dy = com.baidu.tbadk.core.c.a.wW().dy("tb.my_bookmarks");
                if (dy != null) {
                    publishProgress(dy.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fgk == null) {
                    a.this.fgk = new ArrayList();
                } else {
                    a.this.fgk.clear();
                }
                a.this.fgl = 0;
            }
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dOx) {
                this.mNetWork.o(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.o(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.o(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.yl();
            this.fgo.parserJson(this.data);
            if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                aVar.qJ(this.data);
                if (this.offset == 0) {
                    if (a.this.fgk == null) {
                        a.this.fgk = new ArrayList();
                    } else {
                        a.this.fgk.clear();
                    }
                    a.this.fgl = 0;
                    if (this.fgq.booleanValue()) {
                        lY(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lY(String str) {
            l<String> dy;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dy = com.baidu.tbadk.core.c.a.wW().dy("tb.my_bookmarks")) != null) {
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
                arrayList = a.this.qK(str);
                if (this.fgq.booleanValue()) {
                    a.this.aj(arrayList);
                } else {
                    a.this.ak(arrayList);
                }
            } else {
                a.this.aj(arrayList);
            }
            if (!w.z(arrayList)) {
                a.this.fgn.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fgh = null;
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
            if (this.fgo != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fgo.getErrorCode(), this.fgo.getErrorString(), new Object[0]);
            }
            a.this.fgl = aVar.getCount();
            ArrayList<MarkData> aXU = aVar.aXU();
            if (this.fgq.booleanValue()) {
                if (aXU != null && aXU.size() != 0) {
                    a.this.aj(aXU);
                }
            } else {
                a.this.ak(aXU);
            }
            Iterator<MarkData> it = aXU.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.pV(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fgn != null) {
                String str = null;
                if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                    if (this.fgo.getErrorCode() != 0) {
                        str = this.fgo.getErrorString();
                    }
                    a.this.fgn.callback(0, str, false);
                } else {
                    a.this.fgn.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dOx = false;
        }
    }

    public void startSync() {
        if (this.fgi != null) {
            this.fgi.cancel();
        }
        this.fgi = new c();
        this.fgi.setPriority(2);
        this.fgi.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fgo;
        private y mNetWork;

        private c() {
            this.mNetWork = null;
            this.fgo = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fgo = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aXW();
                this.mNetWork = new y();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aXX = a.this.aXX();
                if (aVar.getCount() - 1 <= aXX) {
                    aXX = aVar.getCount() - 1;
                }
                while (aXX >= 0) {
                    String bl = aVar.bl(aXX, 20);
                    this.mNetWork.l(new ArrayList<>());
                    this.mNetWork.o("data", bl);
                    this.fgo.parserJson(this.mNetWork.yl());
                    if (!this.mNetWork.yJ().zJ().isRequestSuccess() || this.fgo.getErrorCode() != 0) {
                        break;
                    }
                    aXX -= 20;
                }
                a.this.pX(aXX);
                if (aXX >= 0) {
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
            a.this.fgi = null;
            if (a.this.fgn != null) {
                a.this.fgn.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fgi = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                str = this.fgo.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fgn != null) {
                a.this.fgn.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean pW(int i) {
        if (this.fgj != null) {
            this.fgj.cancel();
        }
        if (i >= this.fgk.size() || this.fgk.get(i) == null || this.fgk.get(i).getId() == null) {
            return false;
        }
        this.fgj = new C0198a(this.fgk.get(i).getId(), i, this.fgk.get(i).getForumId());
        this.fgj.setPriority(2);
        this.fgj.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0198a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fgo;
        private String fid;
        private y mNetWork = null;
        private int pos;
        private String tid;

        public C0198a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fgo = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fgo = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.o("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.o("tid", this.tid);
            this.mNetWork.o(ImageViewerConfig.FORUM_ID, this.fid);
            this.fgo.parserJson(this.mNetWork.yl());
            return this.mNetWork.yJ().zJ().isRequestSuccess() && this.fgo.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            a.this.fgj = null;
            if (a.this.fgn != null) {
                a.this.fgn.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fgj = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fgk.size()) {
                    a.this.fgk.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                str = this.fgo.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fgn != null) {
                a.this.fgn.callback(2, bool, str);
            }
        }
    }

    public int aXX() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void pX(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fgh != null) {
            this.fgh.cancel();
        }
        if (this.fgi != null) {
            this.fgi.cancel();
        }
        if (this.fgj != null) {
            this.fgj.cancel();
        }
    }

    public void a(d dVar) {
        this.fgn = dVar;
    }

    private void aXY() {
        if (this.fgk != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fgk.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aD(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aD(String str, int i) {
        if (this.fgk != null && w.y(this.fgk) > 0) {
            Iterator<MarkData> it = this.fgk.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
