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
    private boolean ehn;
    private b fyI = null;
    private c fyJ = null;
    private C0200a fyK = null;
    private int fyM = 0;
    private int fyN = 0;
    protected d fyO = null;
    private ArrayList<MarkData> fyL = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fyN;
        aVar.fyN = i - 1;
        return i;
    }

    public a() {
        this.ehn = false;
        this.ehn = true;
    }

    public int getOffset() {
        if (this.fyL == null) {
            return 0;
        }
        return this.fyL.size();
    }

    public int aYb() {
        return this.fyN;
    }

    public void sq(int i) {
        this.fyN = i;
    }

    public boolean hasMore() {
        return this.fyM >= 20;
    }

    public void reset() {
        this.fyN = 0;
        this.fyM = 0;
        this.ehn = true;
    }

    public boolean isFirst() {
        return this.ehn;
    }

    public ArrayList<MarkData> aYc() {
        return this.fyL;
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.fyL = arrayList;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        if (this.fyL != null && arrayList != null) {
            this.fyL.addAll(arrayList);
            aYg();
        }
    }

    public void f(MarkData markData) {
        this.fyL.add(markData);
    }

    public int getCount() {
        if (this.fyL == null) {
            return 0;
        }
        return this.fyL.size();
    }

    public int aYd() {
        return this.fyM;
    }

    public void aYe() {
        ArrayList<MarkData> bxM = com.baidu.tieba.tbadkCore.util.a.bxM();
        if (bxM != null) {
            ai(bxM);
        }
    }

    public String cj(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fyL == null) {
            return null;
        }
        if (i >= this.fyL.size()) {
            i2 -= (i - this.fyL.size()) - 1;
            i = this.fyL.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fyL.get(i5).toJson();
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

    public void pM(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> pN(String str) {
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
                    this.fyL.add(markData);
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
        if (this.fyI != null) {
            this.fyI.cancel();
        }
        this.fyI = new b(getOffset());
        this.fyI.setPriority(3);
        this.fyI.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fyP;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fyR = false;

        public b(int i) {
            this.offset = 0;
            this.fyP = null;
            this.offset = i;
            this.fyP = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fyR = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fyR.booleanValue() && booleanValue) {
                l<String> dh = com.baidu.tbadk.core.c.a.AQ().dh("tb.my_bookmarks");
                if (dh != null) {
                    publishProgress(dh.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fyL == null) {
                    a.this.fyL = new ArrayList();
                } else {
                    a.this.fyL.clear();
                }
                a.this.fyM = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ehn) {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.n(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.Ca();
            this.fyP.parserJson(this.data);
            if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                aVar.pM(this.data);
                if (this.offset == 0) {
                    if (a.this.fyL == null) {
                        a.this.fyL = new ArrayList();
                    } else {
                        a.this.fyL.clear();
                    }
                    a.this.fyM = 0;
                    if (this.fyR.booleanValue()) {
                        lm(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lm(String str) {
            l<String> dh;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dh = com.baidu.tbadk.core.c.a.AQ().dh("tb.my_bookmarks")) != null) {
                dh.a(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.pN(str);
                if (this.fyR.booleanValue()) {
                    a.this.ai(arrayList);
                } else {
                    a.this.aj(arrayList);
                }
            } else {
                a.this.ai(arrayList);
            }
            if (!v.E(arrayList)) {
                a.this.fyO.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            a.this.fyI = null;
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
            if (this.fyP != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fyP.getErrorCode(), this.fyP.getErrorString(), new Object[0]);
            }
            a.this.fyM = aVar.getCount();
            ArrayList<MarkData> aYc = aVar.aYc();
            if (this.fyR.booleanValue()) {
                if (aYc != null && aYc.size() != 0) {
                    a.this.ai(aYc);
                }
            } else {
                a.this.aj(aYc);
            }
            Iterator<MarkData> it = aYc.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.sq(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fyO != null) {
                String str = null;
                if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                    if (this.fyP.getErrorCode() != 0) {
                        str = this.fyP.getErrorString();
                    }
                    a.this.fyO.callback(0, str, false);
                } else {
                    a.this.fyO.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ehn = false;
        }
    }

    public void startSync() {
        if (this.fyJ != null) {
            this.fyJ.cancel();
        }
        this.fyJ = new c();
        this.fyJ.setPriority(2);
        this.fyJ.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fyP;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fyP = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fyP = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aYe();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aYf = a.this.aYf();
                if (aVar.getCount() - 1 <= aYf) {
                    aYf = aVar.getCount() - 1;
                }
                while (aYf >= 0) {
                    String cj = aVar.cj(aYf, 20);
                    this.mNetWork.m(new ArrayList<>());
                    this.mNetWork.n("data", cj);
                    this.fyP.parserJson(this.mNetWork.Ca());
                    if (!this.mNetWork.Cy().Dw().isRequestSuccess() || this.fyP.getErrorCode() != 0) {
                        break;
                    }
                    aYf -= 20;
                }
                a.this.ss(aYf);
                if (aYf >= 0) {
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
                this.mNetWork.mS();
            }
            a.this.fyJ = null;
            if (a.this.fyO != null) {
                a.this.fyO.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fyJ = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                str = this.fyP.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fyO != null) {
                a.this.fyO.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean sr(int i) {
        if (this.fyK != null) {
            this.fyK.cancel();
        }
        if (i >= this.fyL.size() || this.fyL.get(i) == null || this.fyL.get(i).getId() == null) {
            return false;
        }
        this.fyK = new C0200a(this.fyL.get(i).getId(), i, this.fyL.get(i).getForumId());
        this.fyK.setPriority(2);
        this.fyK.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0200a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fyP;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0200a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fyP = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fyP = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fyP.parserJson(this.mNetWork.Ca());
            return this.mNetWork.Cy().Dw().isRequestSuccess() && this.fyP.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            a.this.fyK = null;
            if (a.this.fyO != null) {
                a.this.fyO.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fyK = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fyL.size()) {
                    a.this.fyL.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                str = this.fyP.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fyO != null) {
                a.this.fyO.callback(2, bool, str);
            }
        }
    }

    public int aYf() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void ss(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fyI != null) {
            this.fyI.cancel();
        }
        if (this.fyJ != null) {
            this.fyJ.cancel();
        }
        if (this.fyK != null) {
            this.fyK.cancel();
        }
    }

    public void a(d dVar) {
        this.fyO = dVar;
    }

    private void aYg() {
        if (this.fyL != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fyL.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                String id = next.getId();
                int replyNum = next.getReplyNum();
                if (!hashSet.add(id)) {
                    ay(id, replyNum);
                    it.remove();
                }
            }
        }
    }

    private void ay(String str, int i) {
        if (this.fyL != null && v.D(this.fyL) > 0) {
            Iterator<MarkData> it = this.fyL.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
