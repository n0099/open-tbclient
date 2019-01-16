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
    private boolean ewt;
    private b fLm = null;
    private c fLn = null;
    private C0272a fLo = null;
    private int fLq = 0;
    private int fLr = 0;
    protected d fLs = null;
    private ArrayList<MarkData> fLp = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fLr;
        aVar.fLr = i - 1;
        return i;
    }

    public a() {
        this.ewt = false;
        this.ewt = true;
    }

    public int getOffset() {
        if (this.fLp == null) {
            return 0;
        }
        return this.fLp.size();
    }

    public int beS() {
        return this.fLr;
    }

    public void sd(int i) {
        this.fLr = i;
    }

    public boolean hasMore() {
        return this.fLq >= 20;
    }

    public void reset() {
        this.fLr = 0;
        this.fLq = 0;
        this.ewt = true;
    }

    public boolean isFirst() {
        return this.ewt;
    }

    public ArrayList<MarkData> beT() {
        return this.fLp;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fLp = arrayList;
    }

    public void al(ArrayList<MarkData> arrayList) {
        if (this.fLp != null && arrayList != null) {
            this.fLp.addAll(arrayList);
            beX();
        }
    }

    public void f(MarkData markData) {
        this.fLp.add(markData);
    }

    public int getCount() {
        if (this.fLp == null) {
            return 0;
        }
        return this.fLp.size();
    }

    public int beU() {
        return this.fLq;
    }

    public void beV() {
        ArrayList<MarkData> bFL = com.baidu.tieba.tbadkCore.util.a.bFL();
        if (bFL != null) {
            ak(bFL);
        }
    }

    public String bt(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fLp == null) {
            return null;
        }
        if (i >= this.fLp.size()) {
            i2 -= (i - this.fLp.size()) - 1;
            i = this.fLp.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fLp.get(i5).toJson();
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

    public void sH(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> sI(String str) {
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
                    this.fLp.add(markData);
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
        if (this.fLm != null) {
            this.fLm.cancel();
        }
        this.fLm = new b(getOffset());
        this.fLm.setPriority(3);
        this.fLm.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fLt;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fLv = false;

        public b(int i) {
            this.offset = 0;
            this.fLt = null;
            this.offset = i;
            this.fLt = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fLv = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fLv.booleanValue() && booleanValue) {
                l<String> eH = com.baidu.tbadk.core.c.a.BO().eH("tb.my_bookmarks");
                if (eH != null) {
                    publishProgress(eH.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fLp == null) {
                    a.this.fLp = new ArrayList();
                } else {
                    a.this.fLp.clear();
                }
                a.this.fLq = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ewt) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.CY();
            this.fLt.parserJson(this.data);
            if (this.mNetWork.Dw().Ev().isRequestSuccess()) {
                aVar.sH(this.data);
                if (this.offset == 0) {
                    if (a.this.fLp == null) {
                        a.this.fLp = new ArrayList();
                    } else {
                        a.this.fLp.clear();
                    }
                    a.this.fLq = 0;
                    if (this.fLv.booleanValue()) {
                        nS(this.data);
                    }
                }
            }
            return aVar;
        }

        private void nS(String str) {
            l<String> eH;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (eH = com.baidu.tbadk.core.c.a.BO().eH("tb.my_bookmarks")) != null) {
                eH.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.sI(str);
                if (this.fLv.booleanValue()) {
                    a.this.ak(arrayList);
                } else {
                    a.this.al(arrayList);
                }
            } else {
                a.this.ak(arrayList);
            }
            if (!v.I(arrayList)) {
                a.this.fLs.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fLm = null;
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
            if (this.fLt != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fLt.getErrorCode(), this.fLt.getErrorString(), new Object[0]);
            }
            a.this.fLq = aVar.getCount();
            ArrayList<MarkData> beT = aVar.beT();
            if (this.fLv.booleanValue()) {
                if (beT != null && beT.size() != 0) {
                    a.this.ak(beT);
                }
            } else {
                a.this.al(beT);
            }
            Iterator<MarkData> it = beT.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.sd(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fLs != null) {
                String str = null;
                if (this.mNetWork.Dw().Ev().isRequestSuccess()) {
                    if (this.fLt.getErrorCode() != 0) {
                        str = this.fLt.getErrorString();
                    }
                    a.this.fLs.callback(0, str, false);
                } else {
                    a.this.fLs.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ewt = false;
        }
    }

    public void startSync() {
        if (this.fLn != null) {
            this.fLn.cancel();
        }
        this.fLn = new c();
        this.fLn.setPriority(2);
        this.fLn.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fLt;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fLt = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fLt = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.beV();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int beW = a.this.beW();
                if (aVar.getCount() - 1 <= beW) {
                    beW = aVar.getCount() - 1;
                }
                while (beW >= 0) {
                    String bt = aVar.bt(beW, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.x("data", bt);
                    this.fLt.parserJson(this.mNetWork.CY());
                    if (!this.mNetWork.Dw().Ev().isRequestSuccess() || this.fLt.getErrorCode() != 0) {
                        break;
                    }
                    beW -= 20;
                }
                a.this.sf(beW);
                if (beW >= 0) {
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
            a.this.fLn = null;
            if (a.this.fLs != null) {
                a.this.fLs.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fLn = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Dw().Ev().isRequestSuccess()) {
                str = this.fLt.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fLs != null) {
                a.this.fLs.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean se(int i) {
        if (this.fLo != null) {
            this.fLo.cancel();
        }
        if (i >= this.fLp.size() || this.fLp.get(i) == null || this.fLp.get(i).getId() == null) {
            return false;
        }
        this.fLo = new C0272a(this.fLp.get(i).getId(), i, this.fLp.get(i).getForumId());
        this.fLo.setPriority(2);
        this.fLo.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0272a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fLt;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0272a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fLt = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fLt = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fLt.parserJson(this.mNetWork.CY());
            return this.mNetWork.Dw().Ev().isRequestSuccess() && this.fLt.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fLo = null;
            if (a.this.fLs != null) {
                a.this.fLs.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fLo = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fLp.size()) {
                    a.this.fLp.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Dw().Ev().isRequestSuccess()) {
                str = this.fLt.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fLs != null) {
                a.this.fLs.callback(2, bool, str);
            }
        }
    }

    public int beW() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void sf(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fLm != null) {
            this.fLm.cancel();
        }
        if (this.fLn != null) {
            this.fLn.cancel();
        }
        if (this.fLo != null) {
            this.fLo.cancel();
        }
    }

    public void a(d dVar) {
        this.fLs = dVar;
    }

    private void beX() {
        if (this.fLp != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fLp.iterator();
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
        if (this.fLp != null && v.H(this.fLp) > 0) {
            Iterator<MarkData> it = this.fLp.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
