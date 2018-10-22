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
    private boolean ekI;
    private b fzn = null;
    private c fzo = null;
    private C0235a fzp = null;
    private int fzr = 0;
    private int fzs = 0;
    protected d fzt = null;
    private ArrayList<MarkData> fzq = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fzs;
        aVar.fzs = i - 1;
        return i;
    }

    public a() {
        this.ekI = false;
        this.ekI = true;
    }

    public int getOffset() {
        if (this.fzq == null) {
            return 0;
        }
        return this.fzq.size();
    }

    public int bcr() {
        return this.fzs;
    }

    public void rb(int i) {
        this.fzs = i;
    }

    public boolean hasMore() {
        return this.fzr >= 20;
    }

    public void reset() {
        this.fzs = 0;
        this.fzr = 0;
        this.ekI = true;
    }

    public boolean isFirst() {
        return this.ekI;
    }

    public ArrayList<MarkData> bcs() {
        return this.fzq;
    }

    public void al(ArrayList<MarkData> arrayList) {
        this.fzq = arrayList;
    }

    public void am(ArrayList<MarkData> arrayList) {
        if (this.fzq != null && arrayList != null) {
            this.fzq.addAll(arrayList);
            bcw();
        }
    }

    public void f(MarkData markData) {
        this.fzq.add(markData);
    }

    public int getCount() {
        if (this.fzq == null) {
            return 0;
        }
        return this.fzq.size();
    }

    public int bct() {
        return this.fzr;
    }

    public void bcu() {
        ArrayList<MarkData> bCV = com.baidu.tieba.tbadkCore.util.a.bCV();
        if (bCV != null) {
            al(bCV);
        }
    }

    public String bs(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fzq == null) {
            return null;
        }
        if (i >= this.fzq.size()) {
            i2 -= (i - this.fzq.size()) - 1;
            i = this.fzq.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fzq.get(i5).toJson();
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

    public void rK(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> rL(String str) {
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
                    this.fzq.add(markData);
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
        if (this.fzn != null) {
            this.fzn.cancel();
        }
        this.fzn = new b(getOffset());
        this.fzn.setPriority(3);
        this.fzn.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fzu;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fzw = false;

        public b(int i) {
            this.offset = 0;
            this.fzu = null;
            this.offset = i;
            this.fzu = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fzw = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fzw.booleanValue() && booleanValue) {
                l<String> eg = com.baidu.tbadk.core.c.a.Aq().eg("tb.my_bookmarks");
                if (eg != null) {
                    publishProgress(eg.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fzq == null) {
                    a.this.fzq = new ArrayList();
                } else {
                    a.this.fzq.clear();
                }
                a.this.fzr = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ekI) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.BA();
            this.fzu.parserJson(this.data);
            if (this.mNetWork.BY().CX().isRequestSuccess()) {
                aVar.rK(this.data);
                if (this.offset == 0) {
                    if (a.this.fzq == null) {
                        a.this.fzq = new ArrayList();
                    } else {
                        a.this.fzq.clear();
                    }
                    a.this.fzr = 0;
                    if (this.fzw.booleanValue()) {
                        mZ(this.data);
                    }
                }
            }
            return aVar;
        }

        private void mZ(String str) {
            l<String> eg;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (eg = com.baidu.tbadk.core.c.a.Aq().eg("tb.my_bookmarks")) != null) {
                eg.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.rL(str);
                if (this.fzw.booleanValue()) {
                    a.this.al(arrayList);
                } else {
                    a.this.am(arrayList);
                }
            } else {
                a.this.al(arrayList);
            }
            if (!v.J(arrayList)) {
                a.this.fzt.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            a.this.fzn = null;
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
            if (this.fzu != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fzu.getErrorCode(), this.fzu.getErrorString(), new Object[0]);
            }
            a.this.fzr = aVar.getCount();
            ArrayList<MarkData> bcs = aVar.bcs();
            if (this.fzw.booleanValue()) {
                if (bcs != null && bcs.size() != 0) {
                    a.this.al(bcs);
                }
            } else {
                a.this.am(bcs);
            }
            Iterator<MarkData> it = bcs.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.rb(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fzt != null) {
                String str = null;
                if (this.mNetWork.BY().CX().isRequestSuccess()) {
                    if (this.fzu.getErrorCode() != 0) {
                        str = this.fzu.getErrorString();
                    }
                    a.this.fzt.callback(0, str, false);
                } else {
                    a.this.fzt.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ekI = false;
        }
    }

    public void startSync() {
        if (this.fzo != null) {
            this.fzo.cancel();
        }
        this.fzo = new c();
        this.fzo.setPriority(2);
        this.fzo.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fzu;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fzu = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fzu = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bcu();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bcv = a.this.bcv();
                if (aVar.getCount() - 1 <= bcv) {
                    bcv = aVar.getCount() - 1;
                }
                while (bcv >= 0) {
                    String bs = aVar.bs(bcv, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.x("data", bs);
                    this.fzu.parserJson(this.mNetWork.BA());
                    if (!this.mNetWork.BY().CX().isRequestSuccess() || this.fzu.getErrorCode() != 0) {
                        break;
                    }
                    bcv -= 20;
                }
                a.this.rd(bcv);
                if (bcv >= 0) {
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
            a.this.fzo = null;
            if (a.this.fzt != null) {
                a.this.fzt.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fzo = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.BY().CX().isRequestSuccess()) {
                str = this.fzu.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fzt != null) {
                a.this.fzt.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean rc(int i) {
        if (this.fzp != null) {
            this.fzp.cancel();
        }
        if (i >= this.fzq.size() || this.fzq.get(i) == null || this.fzq.get(i).getId() == null) {
            return false;
        }
        this.fzp = new C0235a(this.fzq.get(i).getId(), i, this.fzq.get(i).getForumId());
        this.fzp.setPriority(2);
        this.fzp.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0235a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fzu;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0235a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fzu = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fzu = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.x("tid", this.tid);
            this.mNetWork.x(ImageViewerConfig.FORUM_ID, this.fid);
            this.fzu.parserJson(this.mNetWork.BA());
            return this.mNetWork.BY().CX().isRequestSuccess() && this.fzu.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            a.this.fzp = null;
            if (a.this.fzt != null) {
                a.this.fzt.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fzp = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fzq.size()) {
                    a.this.fzq.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.BY().CX().isRequestSuccess()) {
                str = this.fzu.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fzt != null) {
                a.this.fzt.callback(2, bool, str);
            }
        }
    }

    public int bcv() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void rd(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fzn != null) {
            this.fzn.cancel();
        }
        if (this.fzo != null) {
            this.fzo.cancel();
        }
        if (this.fzp != null) {
            this.fzp.cancel();
        }
    }

    public void a(d dVar) {
        this.fzt = dVar;
    }

    private void bcw() {
        if (this.fzq != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fzq.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aJ(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aJ(String str, int i) {
        if (this.fzq != null && v.I(this.fzq) > 0) {
            Iterator<MarkData> it = this.fzq.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
