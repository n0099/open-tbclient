package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.myCollection.d;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean dCj;
    private b eTJ = null;
    private c eTK = null;
    private C0182a eTL = null;
    private int eTN = 0;
    private int eTO = 0;
    protected d eTP = null;
    private ArrayList<MarkData> eTM = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.eTO;
        aVar.eTO = i - 1;
        return i;
    }

    public a() {
        this.dCj = false;
        this.dCj = true;
    }

    public int getOffset() {
        if (this.eTM == null) {
            return 0;
        }
        return this.eTM.size();
    }

    public int aSX() {
        return this.eTO;
    }

    public void pL(int i) {
        this.eTO = i;
    }

    public boolean hasMore() {
        return this.eTN >= 20;
    }

    public void reset() {
        this.eTO = 0;
        this.eTN = 0;
        this.dCj = true;
    }

    public boolean isFirst() {
        return this.dCj;
    }

    public ArrayList<MarkData> aSY() {
        return this.eTM;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.eTM = arrayList;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        if (this.eTM != null && arrayList != null) {
            this.eTM.addAll(arrayList);
            aTc();
        }
    }

    public void f(MarkData markData) {
        this.eTM.add(markData);
    }

    public int getCount() {
        if (this.eTM == null) {
            return 0;
        }
        return this.eTM.size();
    }

    public int aSZ() {
        return this.eTN;
    }

    public void aTa() {
        ArrayList<MarkData> bsR = com.baidu.tieba.tbadkCore.util.a.bsR();
        if (bsR != null) {
            aj(bsR);
        }
    }

    public String bk(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.eTM == null) {
            return null;
        }
        if (i >= this.eTM.size()) {
            i2 -= (i - this.eTM.size()) - 1;
            i = this.eTM.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.eTM.get(i5).toJson();
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

    public void pS(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> pT(String str) {
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
                    this.eTM.add(markData);
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
        if (this.eTJ != null) {
            this.eTJ.cancel();
        }
        this.eTJ = new b(getOffset());
        this.eTJ.setPriority(3);
        this.eTJ.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c eTQ;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean eTS = false;

        public b(int i) {
            this.offset = 0;
            this.eTQ = null;
            this.offset = i;
            this.eTQ = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.eTS = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.eTS.booleanValue() && booleanValue) {
                l<String> cZ = com.baidu.tbadk.core.c.a.tz().cZ("tb.my_bookmarks");
                if (cZ != null) {
                    publishProgress(cZ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.eTM == null) {
                    a.this.eTM = new ArrayList();
                } else {
                    a.this.eTM.clear();
                }
                a.this.eTN = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dCj) {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.n(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.uL();
            this.eTQ.parserJson(this.data);
            if (this.mNetWork.vj().wj().isRequestSuccess()) {
                aVar.pS(this.data);
                if (this.offset == 0) {
                    if (a.this.eTM == null) {
                        a.this.eTM = new ArrayList();
                    } else {
                        a.this.eTM.clear();
                    }
                    a.this.eTN = 0;
                    if (this.eTS.booleanValue()) {
                        lp(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lp(String str) {
            l<String> cZ;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cZ = com.baidu.tbadk.core.c.a.tz().cZ("tb.my_bookmarks")) != null) {
                cZ.a(currentAccount, str, 604800000L);
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
                arrayList = a.this.pT(str);
                if (this.eTS.booleanValue()) {
                    a.this.aj(arrayList);
                } else {
                    a.this.ak(arrayList);
                }
            } else {
                a.this.aj(arrayList);
            }
            if (!v.w(arrayList)) {
                a.this.eTP.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            a.this.eTJ = null;
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
            if (this.eTQ != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.eTQ.getErrorCode(), this.eTQ.getErrorString(), new Object[0]);
            }
            a.this.eTN = aVar.getCount();
            ArrayList<MarkData> aSY = aVar.aSY();
            if (this.eTS.booleanValue()) {
                if (aSY != null && aSY.size() != 0) {
                    a.this.aj(aSY);
                }
            } else {
                a.this.ak(aSY);
            }
            Iterator<MarkData> it = aSY.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.pL(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.eTP != null) {
                String str = null;
                if (this.mNetWork.vj().wj().isRequestSuccess()) {
                    if (this.eTQ.getErrorCode() != 0) {
                        str = this.eTQ.getErrorString();
                    }
                    a.this.eTP.callback(0, str, false);
                } else {
                    a.this.eTP.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dCj = false;
        }
    }

    public void startSync() {
        if (this.eTK != null) {
            this.eTK.cancel();
        }
        this.eTK = new c();
        this.eTK.setPriority(2);
        this.eTK.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c eTQ;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.eTQ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eTQ = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aTa();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aTb = a.this.aTb();
                if (aVar.getCount() - 1 <= aTb) {
                    aTb = aVar.getCount() - 1;
                }
                while (aTb >= 0) {
                    String bk = aVar.bk(aTb, 20);
                    this.mNetWork.l(new ArrayList<>());
                    this.mNetWork.n("data", bk);
                    this.eTQ.parserJson(this.mNetWork.uL());
                    if (!this.mNetWork.vj().wj().isRequestSuccess() || this.eTQ.getErrorCode() != 0) {
                        break;
                    }
                    aTb -= 20;
                }
                a.this.pN(aTb);
                if (aTb >= 0) {
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
                this.mNetWork.eW();
            }
            a.this.eTK = null;
            if (a.this.eTP != null) {
                a.this.eTP.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.eTK = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.vj().wj().isRequestSuccess()) {
                str = this.eTQ.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.eTP != null) {
                a.this.eTP.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean pM(int i) {
        if (this.eTL != null) {
            this.eTL.cancel();
        }
        if (i >= this.eTM.size() || this.eTM.get(i) == null || this.eTM.get(i).getId() == null) {
            return false;
        }
        this.eTL = new C0182a(this.eTM.get(i).getId(), i, this.eTM.get(i).getForumId());
        this.eTL.setPriority(2);
        this.eTL.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0182a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c eTQ;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0182a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.eTQ = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.eTQ = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            this.mNetWork.n("tid", this.tid);
            this.mNetWork.n(ImageViewerConfig.FORUM_ID, this.fid);
            this.eTQ.parserJson(this.mNetWork.uL());
            return this.mNetWork.vj().wj().isRequestSuccess() && this.eTQ.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            a.this.eTL = null;
            if (a.this.eTP != null) {
                a.this.eTP.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.eTL = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.eTM.size()) {
                    a.this.eTM.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.vj().wj().isRequestSuccess()) {
                str = this.eTQ.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.eTP != null) {
                a.this.eTP.callback(2, bool, str);
            }
        }
    }

    public int aTb() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void pN(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.eTJ != null) {
            this.eTJ.cancel();
        }
        if (this.eTK != null) {
            this.eTK.cancel();
        }
        if (this.eTL != null) {
            this.eTL.cancel();
        }
    }

    public void a(d dVar) {
        this.eTP = dVar;
    }

    private void aTc() {
        if (this.eTM != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.eTM.iterator();
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
        if (this.eTM != null && v.v(this.eTM) > 0) {
            Iterator<MarkData> it = this.eTM.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
