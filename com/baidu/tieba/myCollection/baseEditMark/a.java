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
    private boolean esW;
    private b fHA = null;
    private c fHB = null;
    private C0272a fHC = null;
    private int fHE = 0;
    private int fHF = 0;
    protected d fHG = null;
    private ArrayList<MarkData> fHD = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fHF;
        aVar.fHF = i - 1;
        return i;
    }

    public a() {
        this.esW = false;
        this.esW = true;
    }

    public int getOffset() {
        if (this.fHD == null) {
            return 0;
        }
        return this.fHD.size();
    }

    public int bdG() {
        return this.fHF;
    }

    public void rO(int i) {
        this.fHF = i;
    }

    public boolean hasMore() {
        return this.fHE >= 20;
    }

    public void reset() {
        this.fHF = 0;
        this.fHE = 0;
        this.esW = true;
    }

    public boolean isFirst() {
        return this.esW;
    }

    public ArrayList<MarkData> bdH() {
        return this.fHD;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fHD = arrayList;
    }

    public void al(ArrayList<MarkData> arrayList) {
        if (this.fHD != null && arrayList != null) {
            this.fHD.addAll(arrayList);
            bdL();
        }
    }

    public void f(MarkData markData) {
        this.fHD.add(markData);
    }

    public int getCount() {
        if (this.fHD == null) {
            return 0;
        }
        return this.fHD.size();
    }

    public int bdI() {
        return this.fHE;
    }

    public void bdJ() {
        ArrayList<MarkData> bEk = com.baidu.tieba.tbadkCore.util.a.bEk();
        if (bEk != null) {
            ak(bEk);
        }
    }

    public String bs(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fHD == null) {
            return null;
        }
        if (i >= this.fHD.size()) {
            i2 -= (i - this.fHD.size()) - 1;
            i = this.fHD.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fHD.get(i5).toJson();
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

    public void sn(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> so(String str) {
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
                    this.fHD.add(markData);
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
        if (this.fHA != null) {
            this.fHA.cancel();
        }
        this.fHA = new b(getOffset());
        this.fHA.setPriority(3);
        this.fHA.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fHH;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fHJ = false;

        public b(int i) {
            this.offset = 0;
            this.fHH = null;
            this.offset = i;
            this.fHH = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fHJ = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fHJ.booleanValue() && booleanValue) {
                l<String> ey = com.baidu.tbadk.core.c.a.BB().ey("tb.my_bookmarks");
                if (ey != null) {
                    publishProgress(ey.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fHD == null) {
                    a.this.fHD = new ArrayList();
                } else {
                    a.this.fHD.clear();
                }
                a.this.fHE = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.x("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.esW) {
                this.mNetWork.x("offset", String.valueOf(0));
            } else {
                this.mNetWork.x("offset", String.valueOf(this.offset));
            }
            this.mNetWork.x("rn", String.valueOf(20));
            this.data = this.mNetWork.CL();
            this.fHH.parserJson(this.data);
            if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                aVar.sn(this.data);
                if (this.offset == 0) {
                    if (a.this.fHD == null) {
                        a.this.fHD = new ArrayList();
                    } else {
                        a.this.fHD.clear();
                    }
                    a.this.fHE = 0;
                    if (this.fHJ.booleanValue()) {
                        nz(this.data);
                    }
                }
            }
            return aVar;
        }

        private void nz(String str) {
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
                arrayList = a.this.so(str);
                if (this.fHJ.booleanValue()) {
                    a.this.ak(arrayList);
                } else {
                    a.this.al(arrayList);
                }
            } else {
                a.this.ak(arrayList);
            }
            if (!v.I(arrayList)) {
                a.this.fHG.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fHA = null;
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
            if (this.fHH != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fHH.getErrorCode(), this.fHH.getErrorString(), new Object[0]);
            }
            a.this.fHE = aVar.getCount();
            ArrayList<MarkData> bdH = aVar.bdH();
            if (this.fHJ.booleanValue()) {
                if (bdH != null && bdH.size() != 0) {
                    a.this.ak(bdH);
                }
            } else {
                a.this.al(bdH);
            }
            Iterator<MarkData> it = bdH.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.rO(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fHG != null) {
                String str = null;
                if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                    if (this.fHH.getErrorCode() != 0) {
                        str = this.fHH.getErrorString();
                    }
                    a.this.fHG.callback(0, str, false);
                } else {
                    a.this.fHG.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.esW = false;
        }
    }

    public void startSync() {
        if (this.fHB != null) {
            this.fHB.cancel();
        }
        this.fHB = new c();
        this.fHB.setPriority(2);
        this.fHB.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fHH;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fHH = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fHH = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.bdJ();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int bdK = a.this.bdK();
                if (aVar.getCount() - 1 <= bdK) {
                    bdK = aVar.getCount() - 1;
                }
                while (bdK >= 0) {
                    String bs = aVar.bs(bdK, 20);
                    this.mNetWork.p(new ArrayList<>());
                    this.mNetWork.x("data", bs);
                    this.fHH.parserJson(this.mNetWork.CL());
                    if (!this.mNetWork.Dj().Ei().isRequestSuccess() || this.fHH.getErrorCode() != 0) {
                        break;
                    }
                    bdK -= 20;
                }
                a.this.rQ(bdK);
                if (bdK >= 0) {
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
            a.this.fHB = null;
            if (a.this.fHG != null) {
                a.this.fHG.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fHB = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                str = this.fHH.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fHG != null) {
                a.this.fHG.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean rP(int i) {
        if (this.fHC != null) {
            this.fHC.cancel();
        }
        if (i >= this.fHD.size() || this.fHD.get(i) == null || this.fHD.get(i).getId() == null) {
            return false;
        }
        this.fHC = new C0272a(this.fHD.get(i).getId(), i, this.fHD.get(i).getForumId());
        this.fHC.setPriority(2);
        this.fHC.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0272a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fHH;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0272a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fHH = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fHH = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fHH.parserJson(this.mNetWork.CL());
            return this.mNetWork.Dj().Ei().isRequestSuccess() && this.fHH.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            a.this.fHC = null;
            if (a.this.fHG != null) {
                a.this.fHG.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fHC = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fHD.size()) {
                    a.this.fHD.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                str = this.fHH.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fHG != null) {
                a.this.fHG.callback(2, bool, str);
            }
        }
    }

    public int bdK() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void rQ(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fHA != null) {
            this.fHA.cancel();
        }
        if (this.fHB != null) {
            this.fHB.cancel();
        }
        if (this.fHC != null) {
            this.fHC.cancel();
        }
    }

    public void a(d dVar) {
        this.fHG = dVar;
    }

    private void bdL() {
        if (this.fHD != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fHD.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    aK(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void aK(String str, int i) {
        if (this.fHD != null && v.H(this.fHD) > 0) {
            Iterator<MarkData> it = this.fHD.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
