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
    private boolean dDm;
    private b eUN = null;
    private c eUO = null;
    private C0182a eUP = null;
    private int eUR = 0;
    private int eUS = 0;
    protected d eUT = null;
    private ArrayList<MarkData> eUQ = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.eUS;
        aVar.eUS = i - 1;
        return i;
    }

    public a() {
        this.dDm = false;
        this.dDm = true;
    }

    public int getOffset() {
        if (this.eUQ == null) {
            return 0;
        }
        return this.eUQ.size();
    }

    public int aSX() {
        return this.eUS;
    }

    public void pJ(int i) {
        this.eUS = i;
    }

    public boolean hasMore() {
        return this.eUR >= 20;
    }

    public void reset() {
        this.eUS = 0;
        this.eUR = 0;
        this.dDm = true;
    }

    public boolean isFirst() {
        return this.dDm;
    }

    public ArrayList<MarkData> aSY() {
        return this.eUQ;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.eUQ = arrayList;
    }

    public void ak(ArrayList<MarkData> arrayList) {
        if (this.eUQ != null && arrayList != null) {
            this.eUQ.addAll(arrayList);
            aTc();
        }
    }

    public void f(MarkData markData) {
        this.eUQ.add(markData);
    }

    public int getCount() {
        if (this.eUQ == null) {
            return 0;
        }
        return this.eUQ.size();
    }

    public int aSZ() {
        return this.eUR;
    }

    public void aTa() {
        ArrayList<MarkData> bsP = com.baidu.tieba.tbadkCore.util.a.bsP();
        if (bsP != null) {
            aj(bsP);
        }
    }

    public String bj(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.eUQ == null) {
            return null;
        }
        if (i >= this.eUQ.size()) {
            i2 -= (i - this.eUQ.size()) - 1;
            i = this.eUQ.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.eUQ.get(i5).toJson();
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

    public void pV(String str) {
        try {
            paserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> pW(String str) {
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
                    this.eUQ.add(markData);
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
        if (this.eUN != null) {
            this.eUN.cancel();
        }
        this.eUN = new b(getOffset());
        this.eUN.setPriority(3);
        this.eUN.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c eUU;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean eUW = false;

        public b(int i) {
            this.offset = 0;
            this.eUU = null;
            this.offset = i;
            this.eUU = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.eUW = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.eUW.booleanValue() && booleanValue) {
                l<String> cZ = com.baidu.tbadk.core.c.a.ty().cZ("tb.my_bookmarks");
                if (cZ != null) {
                    publishProgress(cZ.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.eUQ == null) {
                    a.this.eUQ = new ArrayList();
                } else {
                    a.this.eUQ.clear();
                }
                a.this.eUR = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.dDm) {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.n(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.uK();
            this.eUU.parserJson(this.data);
            if (this.mNetWork.vi().wi().isRequestSuccess()) {
                aVar.pV(this.data);
                if (this.offset == 0) {
                    if (a.this.eUQ == null) {
                        a.this.eUQ = new ArrayList();
                    } else {
                        a.this.eUQ.clear();
                    }
                    a.this.eUR = 0;
                    if (this.eUW.booleanValue()) {
                        ls(this.data);
                    }
                }
            }
            return aVar;
        }

        private void ls(String str) {
            l<String> cZ;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (cZ = com.baidu.tbadk.core.c.a.ty().cZ("tb.my_bookmarks")) != null) {
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
                arrayList = a.this.pW(str);
                if (this.eUW.booleanValue()) {
                    a.this.aj(arrayList);
                } else {
                    a.this.ak(arrayList);
                }
            } else {
                a.this.aj(arrayList);
            }
            if (!v.w(arrayList)) {
                a.this.eUT.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            a.this.eUN = null;
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
            if (this.eUU != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.eUU.getErrorCode(), this.eUU.getErrorString(), new Object[0]);
            }
            a.this.eUR = aVar.getCount();
            ArrayList<MarkData> aSY = aVar.aSY();
            if (this.eUW.booleanValue()) {
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
                    a.this.pJ(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.eUT != null) {
                String str = null;
                if (this.mNetWork.vi().wi().isRequestSuccess()) {
                    if (this.eUU.getErrorCode() != 0) {
                        str = this.eUU.getErrorString();
                    }
                    a.this.eUT.callback(0, str, false);
                } else {
                    a.this.eUT.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.dDm = false;
        }
    }

    public void startSync() {
        if (this.eUO != null) {
            this.eUO.cancel();
        }
        this.eUO = new c();
        this.eUO.setPriority(2);
        this.eUO.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c eUU;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.eUU = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eUU = new com.baidu.tieba.myCollection.baseEditMark.c();
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
                    this.eUU.parserJson(this.mNetWork.uK());
                    if (!this.mNetWork.vi().wi().isRequestSuccess() || this.eUU.getErrorCode() != 0) {
                        break;
                    }
                    aTb -= 20;
                }
                a.this.pL(aTb);
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
            a.this.eUO = null;
            if (a.this.eUT != null) {
                a.this.eUT.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.eUO = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.vi().wi().isRequestSuccess()) {
                str = this.eUU.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.eUT != null) {
                a.this.eUT.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean pK(int i) {
        if (this.eUP != null) {
            this.eUP.cancel();
        }
        if (i >= this.eUQ.size() || this.eUQ.get(i) == null || this.eUQ.get(i).getId() == null) {
            return false;
        }
        this.eUP = new C0182a(this.eUQ.get(i).getId(), i, this.eUQ.get(i).getForumId());
        this.eUP.setPriority(2);
        this.eUP.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0182a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c eUU;
        private String fid;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0182a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.eUU = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.eUU = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.eUU.parserJson(this.mNetWork.uK());
            return this.mNetWork.vi().wi().isRequestSuccess() && this.eUU.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            a.this.eUP = null;
            if (a.this.eUT != null) {
                a.this.eUT.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.eUP = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.eUQ.size()) {
                    a.this.eUQ.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.vi().wi().isRequestSuccess()) {
                str = this.eUU.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.eUT != null) {
                a.this.eUT.callback(2, bool, str);
            }
        }
    }

    public int aTb() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void pL(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.eUN != null) {
            this.eUN.cancel();
        }
        if (this.eUO != null) {
            this.eUO.cancel();
        }
        if (this.eUP != null) {
            this.eUP.cancel();
        }
    }

    public void a(d dVar) {
        this.eUT = dVar;
    }

    private void aTc() {
        if (this.eUQ != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.eUQ.iterator();
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
        if (this.eUQ != null && v.v(this.eUQ) > 0) {
            Iterator<MarkData> it = this.eUQ.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
