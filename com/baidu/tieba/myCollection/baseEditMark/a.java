package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
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
    private boolean evN;
    private b fKs = null;
    private c fKt = null;
    private C0272a fKu = null;
    private int fKw = 0;
    private int fKx = 0;
    protected d fKy = null;
    private ArrayList<MarkData> fKv = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fKx;
        aVar.fKx = i - 1;
        return i;
    }

    public a() {
        this.evN = false;
        this.evN = true;
    }

    public int getOffset() {
        if (this.fKv == null) {
            return 0;
        }
        return this.fKv.size();
    }

    public int bes() {
        return this.fKx;
    }

    public void sb(int i) {
        this.fKx = i;
    }

    public boolean hasMore() {
        return this.fKw >= 20;
    }

    public void reset() {
        this.fKx = 0;
        this.fKw = 0;
        this.evN = true;
    }

    public boolean isFirst() {
        return this.evN;
    }

    public ArrayList<MarkData> bet() {
        return this.fKv;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fKv = arrayList;
    }

    public void al(ArrayList<MarkData> arrayList) {
        if (this.fKv != null && arrayList != null) {
            this.fKv.addAll(arrayList);
            bex();
        }
    }

    public void f(MarkData markData) {
        this.fKv.add(markData);
    }

    public int getCount() {
        if (this.fKv == null) {
            return 0;
        }
        return this.fKv.size();
    }

    public int beu() {
        return this.fKw;
    }

    public void bev() {
        ArrayList<MarkData> bFc = com.baidu.tieba.tbadkCore.util.a.bFc();
        if (bFc != null) {
            ak(bFc);
        }
    }

    public String bt(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fKv == null) {
            return null;
        }
        if (i >= this.fKv.size()) {
            i2 -= (i - this.fKv.size()) - 1;
            i = this.fKv.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fKv.get(i5).toJson();
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

    public void sq(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> ss(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR).optString("errno").equals("0")) {
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
            if (jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR).optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.fKv.add(markData);
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
        if (this.fKs != null) {
            this.fKs.cancel();
        }
        this.fKs = new b(getOffset());
        this.fKs.setPriority(3);
        this.fKs.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fKz;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fKB = false;

        public b(int i) {
            this.offset = 0;
            this.fKz = null;
            this.offset = i;
            this.fKz = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fKB = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fKB.booleanValue() && booleanValue) {
                l<String> ey = com.baidu.tbadk.core.c.a.BB().ey("tb.my_bookmarks");
                if (ey != null) {
                    publishProgress(ey.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fKv == null) {
                    a.this.fKv = new ArrayList();
                } else {
                    a.this.fKv.clear();
                }
                a.this.fKw = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.evN) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.CL();
            this.fKz.parserJson(this.data);
            if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                aVar.sq(this.data);
                if (this.offset == 0) {
                    if (a.this.fKv == null) {
                        a.this.fKv = new ArrayList();
                    } else {
                        a.this.fKv.clear();
                    }
                    a.this.fKw = 0;
                    if (this.fKB.booleanValue()) {
                        nC(this.data);
                    }
                }
            }
            return aVar;
        }

        private void nC(String str) {
            l<String> ey;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (ey = com.baidu.tbadk.core.c.a.BB().ey("tb.my_bookmarks")) != null) {
                ey.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.ss(str);
                if (this.fKB.booleanValue()) {
                    a.this.ak(arrayList);
                } else {
                    a.this.al(arrayList);
                }
            } else {
                a.this.ak(arrayList);
            }
            if (!v.I(arrayList)) {
                a.this.fKy.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fKs = null;
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
            if (this.fKz != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fKz.getErrorCode(), this.fKz.getErrorString(), new Object[0]);
            }
            a.this.fKw = aVar.getCount();
            ArrayList<MarkData> bet = aVar.bet();
            if (this.fKB.booleanValue()) {
                if (bet != null && bet.size() != 0) {
                    a.this.ak(bet);
                }
            } else {
                a.this.al(bet);
            }
            Iterator<MarkData> it = bet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.sb(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fKy != null) {
                String str = null;
                if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                    if (this.fKz.getErrorCode() != 0) {
                        str = this.fKz.getErrorString();
                    }
                    a.this.fKy.callback(0, str, false);
                } else {
                    a.this.fKy.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.evN = false;
        }
    }

    public void startSync() {
        if (this.fKt != null) {
            this.fKt.cancel();
        }
        this.fKt = new c();
        this.fKt.setPriority(2);
        this.fKt.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fKz;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fKz = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fKz = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bev();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bew = a.this.bew();
                if (aVar.getCount() - 1 <= bew) {
                    bew = aVar.getCount() - 1;
                }
                while (bew >= 0) {
                    String bt = aVar.bt(bew, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.x("data", bt);
                    this.fKz.parserJson(this.mNetWork.CL());
                    if (!this.mNetWork.Dj().Ei().isRequestSuccess() || this.fKz.getErrorCode() != 0) {
                        break;
                    }
                    bew -= 20;
                }
                a.this.sd(bew);
                if (bew >= 0) {
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
                this.mNetWork.jg();
            }
            a.this.fKt = null;
            if (a.this.fKy != null) {
                a.this.fKy.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fKt = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                str = this.fKz.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fKy != null) {
                a.this.fKy.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean sc(int i) {
        if (this.fKu != null) {
            this.fKu.cancel();
        }
        if (i >= this.fKv.size() || this.fKv.get(i) == null || this.fKv.get(i).getId() == null) {
            return false;
        }
        this.fKu = new C0272a(this.fKv.get(i).getId(), i, this.fKv.get(i).getForumId());
        this.fKu.setPriority(2);
        this.fKu.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0272a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fKz;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0272a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fKz = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fKz = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fKz.parserJson(this.mNetWork.CL());
            return this.mNetWork.Dj().Ei().isRequestSuccess() && this.fKz.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fKu = null;
            if (a.this.fKy != null) {
                a.this.fKy.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fKu = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fKv.size()) {
                    a.this.fKv.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                str = this.fKz.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fKy != null) {
                a.this.fKy.callback(2, bool, str);
            }
        }
    }

    public int bew() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void sd(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fKs != null) {
            this.fKs.cancel();
        }
        if (this.fKt != null) {
            this.fKt.cancel();
        }
        if (this.fKu != null) {
            this.fKu.cancel();
        }
    }

    public void a(d dVar) {
        this.fKy = dVar;
    }

    private void bex() {
        if (this.fKv != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fKv.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aL(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aL(String str, int i) {
        if (this.fKv != null && v.H(this.fKv) > 0) {
            Iterator<MarkData> it = this.fKv.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
