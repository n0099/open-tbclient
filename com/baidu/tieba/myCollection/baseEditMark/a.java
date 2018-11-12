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
    private boolean emb;
    private b fAK = null;
    private c fAL = null;
    private C0261a fAM = null;
    private int fAO = 0;
    private int fAP = 0;
    protected d fAQ = null;
    private ArrayList<MarkData> fAN = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fAP;
        aVar.fAP = i - 1;
        return i;
    }

    public a() {
        this.emb = false;
        this.emb = true;
    }

    public int getOffset() {
        if (this.fAN == null) {
            return 0;
        }
        return this.fAN.size();
    }

    public int bbQ() {
        return this.fAP;
    }

    public void ru(int i) {
        this.fAP = i;
    }

    public boolean hasMore() {
        return this.fAO >= 20;
    }

    public void reset() {
        this.fAP = 0;
        this.fAO = 0;
        this.emb = true;
    }

    public boolean isFirst() {
        return this.emb;
    }

    public ArrayList<MarkData> bbR() {
        return this.fAN;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fAN = arrayList;
    }

    public void al(ArrayList<MarkData> arrayList) {
        if (this.fAN != null && arrayList != null) {
            this.fAN.addAll(arrayList);
            bbV();
        }
    }

    public void f(MarkData markData) {
        this.fAN.add(markData);
    }

    public int getCount() {
        if (this.fAN == null) {
            return 0;
        }
        return this.fAN.size();
    }

    public int bbS() {
        return this.fAO;
    }

    public void bbT() {
        ArrayList<MarkData> bCq = com.baidu.tieba.tbadkCore.util.a.bCq();
        if (bCq != null) {
            ak(bCq);
        }
    }

    public String bu(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fAN == null) {
            return null;
        }
        if (i >= this.fAN.size()) {
            i2 -= (i - this.fAN.size()) - 1;
            i = this.fAN.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fAN.get(i5).toJson();
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

    public void rL(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> rM(String str) {
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
                    this.fAN.add(markData);
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
        if (this.fAK != null) {
            this.fAK.cancel();
        }
        this.fAK = new b(getOffset());
        this.fAK.setPriority(3);
        this.fAK.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fAR;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fAT = false;

        public b(int i) {
            this.offset = 0;
            this.fAR = null;
            this.offset = i;
            this.fAR = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fAT = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fAT.booleanValue() && booleanValue) {
                l<String> eg = com.baidu.tbadk.core.c.a.Ax().eg("tb.my_bookmarks");
                if (eg != null) {
                    publishProgress(eg.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fAN == null) {
                    a.this.fAN = new ArrayList();
                } else {
                    a.this.fAN.clear();
                }
                a.this.fAO = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.emb) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.BH();
            this.fAR.parserJson(this.data);
            if (this.mNetWork.Cf().De().isRequestSuccess()) {
                aVar.rL(this.data);
                if (this.offset == 0) {
                    if (a.this.fAN == null) {
                        a.this.fAN = new ArrayList();
                    } else {
                        a.this.fAN.clear();
                    }
                    a.this.fAO = 0;
                    if (this.fAT.booleanValue()) {
                        na(this.data);
                    }
                }
            }
            return aVar;
        }

        private void na(String str) {
            l<String> eg;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (eg = com.baidu.tbadk.core.c.a.Ax().eg("tb.my_bookmarks")) != null) {
                eg.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.rM(str);
                if (this.fAT.booleanValue()) {
                    a.this.ak(arrayList);
                } else {
                    a.this.al(arrayList);
                }
            } else {
                a.this.ak(arrayList);
            }
            if (!v.I(arrayList)) {
                a.this.fAQ.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fAK = null;
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
            if (this.fAR != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fAR.getErrorCode(), this.fAR.getErrorString(), new Object[0]);
            }
            a.this.fAO = aVar.getCount();
            ArrayList<MarkData> bbR = aVar.bbR();
            if (this.fAT.booleanValue()) {
                if (bbR != null && bbR.size() != 0) {
                    a.this.ak(bbR);
                }
            } else {
                a.this.al(bbR);
            }
            Iterator<MarkData> it = bbR.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.ru(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fAQ != null) {
                String str = null;
                if (this.mNetWork.Cf().De().isRequestSuccess()) {
                    if (this.fAR.getErrorCode() != 0) {
                        str = this.fAR.getErrorString();
                    }
                    a.this.fAQ.callback(0, str, false);
                } else {
                    a.this.fAQ.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.emb = false;
        }
    }

    public void startSync() {
        if (this.fAL != null) {
            this.fAL.cancel();
        }
        this.fAL = new c();
        this.fAL.setPriority(2);
        this.fAL.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fAR;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fAR = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fAR = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bbT();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bbU = a.this.bbU();
                if (aVar.getCount() - 1 <= bbU) {
                    bbU = aVar.getCount() - 1;
                }
                while (bbU >= 0) {
                    String bu = aVar.bu(bbU, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.x("data", bu);
                    this.fAR.parserJson(this.mNetWork.BH());
                    if (!this.mNetWork.Cf().De().isRequestSuccess() || this.fAR.getErrorCode() != 0) {
                        break;
                    }
                    bbU -= 20;
                }
                a.this.rw(bbU);
                if (bbU >= 0) {
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
            a.this.fAL = null;
            if (a.this.fAQ != null) {
                a.this.fAQ.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fAL = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Cf().De().isRequestSuccess()) {
                str = this.fAR.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fAQ != null) {
                a.this.fAQ.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean rv(int i) {
        if (this.fAM != null) {
            this.fAM.cancel();
        }
        if (i >= this.fAN.size() || this.fAN.get(i) == null || this.fAN.get(i).getId() == null) {
            return false;
        }
        this.fAM = new C0261a(this.fAN.get(i).getId(), i, this.fAN.get(i).getForumId());
        this.fAM.setPriority(2);
        this.fAM.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0261a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fAR;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0261a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fAR = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fAR = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fAR.parserJson(this.mNetWork.BH());
            return this.mNetWork.Cf().De().isRequestSuccess() && this.fAR.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fAM = null;
            if (a.this.fAQ != null) {
                a.this.fAQ.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fAM = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fAN.size()) {
                    a.this.fAN.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Cf().De().isRequestSuccess()) {
                str = this.fAR.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fAQ != null) {
                a.this.fAQ.callback(2, bool, str);
            }
        }
    }

    public int bbU() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void rw(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fAK != null) {
            this.fAK.cancel();
        }
        if (this.fAL != null) {
            this.fAL.cancel();
        }
        if (this.fAM != null) {
            this.fAM.cancel();
        }
    }

    public void a(d dVar) {
        this.fAQ = dVar;
    }

    private void bbV() {
        if (this.fAN != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fAN.iterator();
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
        if (this.fAN != null && v.H(this.fAN) > 0) {
            Iterator<MarkData> it = this.fAN.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
