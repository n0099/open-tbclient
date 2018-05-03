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
    private boolean dCg;
    private b eTG = null;
    private c eTH = null;
    private C0182a eTI = null;
    private int eTK = 0;
    private int eTL = 0;
    protected d eTM = null;
    private ArrayList<MarkData> eTJ = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.eTL;
        aVar.eTL = i - 1;
        return i;
    }

    public a() {
        this.dCg = false;
        this.dCg = true;
    }

    public int getOffset() {
        if (this.eTJ == null) {
            return 0;
        }
        return this.eTJ.size();
    }

    public int aSX() {
        return this.eTL;
    }

    public void pK(int i) {
        this.eTL = i;
    }

    public boolean hasMore() {
        return this.eTK >= 20;
    }

    public void reset() {
        this.eTL = 0;
        this.eTK = 0;
        this.dCg = true;
    }

    public boolean isFirst() {
        return this.dCg;
    }

    public ArrayList<MarkData> aSY() {
        return this.eTJ;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.eTJ = arrayList;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        if (this.eTJ != null && arrayList != null) {
            this.eTJ.addAll(arrayList);
            aTc();
        }
    }

    public void f(MarkData markData) {
        this.eTJ.add(markData);
    }

    public int getCount() {
        if (this.eTJ == null) {
            return 0;
        }
        return this.eTJ.size();
    }

    public int aSZ() {
        return this.eTK;
    }

    public void aTa() {
        ArrayList<MarkData> bsR = com.baidu.tieba.tbadkCore.util.a.bsR();
        if (bsR != null) {
            aj(bsR);
        }
    }

    public String bj(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.eTJ == null) {
            return null;
        }
        if (i >= this.eTJ.size()) {
            i2 -= (i - this.eTJ.size()) - 1;
            i = this.eTJ.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.eTJ.get(i5).toJson();
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
                    this.eTJ.add(markData);
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
        if (this.eTG != null) {
            this.eTG.cancel();
        }
        this.eTG = new b(getOffset());
        this.eTG.setPriority(3);
        this.eTG.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c eTN;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean eTP = false;

        public b(int i) {
            this.offset = 0;
            this.eTN = null;
            this.offset = i;
            this.eTN = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.eTP = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.eTP.booleanValue() && booleanValue) {
                l<String> cZ = com.baidu.tbadk.core.c.a.tz().cZ("tb.my_bookmarks");
                if (cZ != null) {
                    publishProgress(cZ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.eTJ == null) {
                    a.this.eTJ = new ArrayList();
                } else {
                    a.this.eTJ.clear();
                }
                a.this.eTK = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dCg) {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.n(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.uL();
            this.eTN.parserJson(this.data);
            if (this.mNetWork.vj().wj().isRequestSuccess()) {
                aVar.pS(this.data);
                if (this.offset == 0) {
                    if (a.this.eTJ == null) {
                        a.this.eTJ = new ArrayList();
                    } else {
                        a.this.eTJ.clear();
                    }
                    a.this.eTK = 0;
                    if (this.eTP.booleanValue()) {
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
                if (this.eTP.booleanValue()) {
                    a.this.aj(arrayList);
                } else {
                    a.this.ak(arrayList);
                }
            } else {
                a.this.aj(arrayList);
            }
            if (!v.w(arrayList)) {
                a.this.eTM.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            a.this.eTG = null;
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
            if (this.eTN != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.eTN.getErrorCode(), this.eTN.getErrorString(), new Object[0]);
            }
            a.this.eTK = aVar.getCount();
            ArrayList<MarkData> aSY = aVar.aSY();
            if (this.eTP.booleanValue()) {
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
                    a.this.pK(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.eTM != null) {
                String str = null;
                if (this.mNetWork.vj().wj().isRequestSuccess()) {
                    if (this.eTN.getErrorCode() != 0) {
                        str = this.eTN.getErrorString();
                    }
                    a.this.eTM.callback(0, str, false);
                } else {
                    a.this.eTM.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dCg = false;
        }
    }

    public void startSync() {
        if (this.eTH != null) {
            this.eTH.cancel();
        }
        this.eTH = new c();
        this.eTH.setPriority(2);
        this.eTH.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c eTN;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.eTN = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eTN = new com.baidu.tieba.myCollection.baseEditMark.c();
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
                    String bj = aVar.bj(aTb, 20);
                    this.mNetWork.l(new ArrayList<>());
                    this.mNetWork.n("data", bj);
                    this.eTN.parserJson(this.mNetWork.uL());
                    if (!this.mNetWork.vj().wj().isRequestSuccess() || this.eTN.getErrorCode() != 0) {
                        break;
                    }
                    aTb -= 20;
                }
                a.this.pM(aTb);
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
            a.this.eTH = null;
            if (a.this.eTM != null) {
                a.this.eTM.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.eTH = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.vj().wj().isRequestSuccess()) {
                str = this.eTN.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.eTM != null) {
                a.this.eTM.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean pL(int i) {
        if (this.eTI != null) {
            this.eTI.cancel();
        }
        if (i >= this.eTJ.size() || this.eTJ.get(i) == null || this.eTJ.get(i).getId() == null) {
            return false;
        }
        this.eTI = new C0182a(this.eTJ.get(i).getId(), i, this.eTJ.get(i).getForumId());
        this.eTI.setPriority(2);
        this.eTI.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0182a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c eTN;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0182a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.eTN = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.eTN = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.eTN.parserJson(this.mNetWork.uL());
            return this.mNetWork.vj().wj().isRequestSuccess() && this.eTN.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            a.this.eTI = null;
            if (a.this.eTM != null) {
                a.this.eTM.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.eTI = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.eTJ.size()) {
                    a.this.eTJ.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.vj().wj().isRequestSuccess()) {
                str = this.eTN.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.eTM != null) {
                a.this.eTM.callback(2, bool, str);
            }
        }
    }

    public int aTb() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void pM(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.eTG != null) {
            this.eTG.cancel();
        }
        if (this.eTH != null) {
            this.eTH.cancel();
        }
        if (this.eTI != null) {
            this.eTI.cancel();
        }
    }

    public void a(d dVar) {
        this.eTM = dVar;
    }

    private void aTc() {
        if (this.eTJ != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.eTJ.iterator();
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
        if (this.eTJ != null && v.v(this.eTJ) > 0) {
            Iterator<MarkData> it = this.eTJ.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
