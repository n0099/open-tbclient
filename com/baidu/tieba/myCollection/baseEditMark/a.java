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
    private boolean ehz;
    private b fyU = null;
    private c fyV = null;
    private C0199a fyW = null;
    private int fyY = 0;
    private int fyZ = 0;
    protected d fza = null;
    private ArrayList<MarkData> fyX = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fyZ;
        aVar.fyZ = i - 1;
        return i;
    }

    public a() {
        this.ehz = false;
        this.ehz = true;
    }

    public int getOffset() {
        if (this.fyX == null) {
            return 0;
        }
        return this.fyX.size();
    }

    public int aYc() {
        return this.fyZ;
    }

    public void sp(int i) {
        this.fyZ = i;
    }

    public boolean hasMore() {
        return this.fyY >= 20;
    }

    public void reset() {
        this.fyZ = 0;
        this.fyY = 0;
        this.ehz = true;
    }

    public boolean isFirst() {
        return this.ehz;
    }

    public ArrayList<MarkData> aYd() {
        return this.fyX;
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.fyX = arrayList;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        if (this.fyX != null && arrayList != null) {
            this.fyX.addAll(arrayList);
            aYh();
        }
    }

    public void f(MarkData markData) {
        this.fyX.add(markData);
    }

    public int getCount() {
        if (this.fyX == null) {
            return 0;
        }
        return this.fyX.size();
    }

    public int aYe() {
        return this.fyY;
    }

    public void aYf() {
        ArrayList<MarkData> bxN = com.baidu.tieba.tbadkCore.util.a.bxN();
        if (bxN != null) {
            ai(bxN);
        }
    }

    public String cj(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fyX == null) {
            return null;
        }
        if (i >= this.fyX.size()) {
            i2 -= (i - this.fyX.size()) - 1;
            i = this.fyX.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fyX.get(i5).toJson();
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
                    this.fyX.add(markData);
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
        if (this.fyU != null) {
            this.fyU.cancel();
        }
        this.fyU = new b(getOffset());
        this.fyU.setPriority(3);
        this.fyU.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fzb;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fzd = false;

        public b(int i) {
            this.offset = 0;
            this.fzb = null;
            this.offset = i;
            this.fzb = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fzd = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fzd.booleanValue() && booleanValue) {
                l<String> dh = com.baidu.tbadk.core.c.a.AQ().dh("tb.my_bookmarks");
                if (dh != null) {
                    publishProgress(dh.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fyX == null) {
                    a.this.fyX = new ArrayList();
                } else {
                    a.this.fyX.clear();
                }
                a.this.fyY = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ehz) {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.n(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.Cb();
            this.fzb.parserJson(this.data);
            if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                aVar.pM(this.data);
                if (this.offset == 0) {
                    if (a.this.fyX == null) {
                        a.this.fyX = new ArrayList();
                    } else {
                        a.this.fyX.clear();
                    }
                    a.this.fyY = 0;
                    if (this.fzd.booleanValue()) {
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
                if (this.fzd.booleanValue()) {
                    a.this.ai(arrayList);
                } else {
                    a.this.aj(arrayList);
                }
            } else {
                a.this.ai(arrayList);
            }
            if (!v.E(arrayList)) {
                a.this.fza.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            a.this.fyU = null;
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
            if (this.fzb != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fzb.getErrorCode(), this.fzb.getErrorString(), new Object[0]);
            }
            a.this.fyY = aVar.getCount();
            ArrayList<MarkData> aYd = aVar.aYd();
            if (this.fzd.booleanValue()) {
                if (aYd != null && aYd.size() != 0) {
                    a.this.ai(aYd);
                }
            } else {
                a.this.aj(aYd);
            }
            Iterator<MarkData> it = aYd.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i = i2 + 1;
                    a.this.sp(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fza != null) {
                String str = null;
                if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                    if (this.fzb.getErrorCode() != 0) {
                        str = this.fzb.getErrorString();
                    }
                    a.this.fza.callback(0, str, false);
                } else {
                    a.this.fza.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ehz = false;
        }
    }

    public void startSync() {
        if (this.fyV != null) {
            this.fyV.cancel();
        }
        this.fyV = new c();
        this.fyV.setPriority(2);
        this.fyV.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fzb;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fzb = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fzb = new com.baidu.tieba.myCollection.baseEditMark.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(a... aVarArr) {
            a aVar = new a();
            try {
                aVar.aYf();
                this.mNetWork = new x();
                this.mNetWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                int aYg = a.this.aYg();
                if (aVar.getCount() - 1 <= aYg) {
                    aYg = aVar.getCount() - 1;
                }
                while (aYg >= 0) {
                    String cj = aVar.cj(aYg, 20);
                    this.mNetWork.m(new ArrayList<>());
                    this.mNetWork.n("data", cj);
                    this.fzb.parserJson(this.mNetWork.Cb());
                    if (!this.mNetWork.Cz().Dx().isRequestSuccess() || this.fzb.getErrorCode() != 0) {
                        break;
                    }
                    aYg -= 20;
                }
                a.this.sr(aYg);
                if (aYg >= 0) {
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
            a.this.fyV = null;
            if (a.this.fza != null) {
                a.this.fza.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fyV = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                str = this.fzb.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fza != null) {
                a.this.fza.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean sq(int i) {
        if (this.fyW != null) {
            this.fyW.cancel();
        }
        if (i >= this.fyX.size() || this.fyX.get(i) == null || this.fyX.get(i).getId() == null) {
            return false;
        }
        this.fyW = new C0199a(this.fyX.get(i).getId(), i, this.fyX.get(i).getForumId());
        this.fyW.setPriority(2);
        this.fyW.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0199a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fzb;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0199a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fzb = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fzb = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fzb.parserJson(this.mNetWork.Cb());
            return this.mNetWork.Cz().Dx().isRequestSuccess() && this.fzb.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            a.this.fyW = null;
            if (a.this.fza != null) {
                a.this.fza.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fyW = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fyX.size()) {
                    a.this.fyX.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                str = this.fzb.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fza != null) {
                a.this.fza.callback(2, bool, str);
            }
        }
    }

    public int aYg() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void sr(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fyU != null) {
            this.fyU.cancel();
        }
        if (this.fyV != null) {
            this.fyV.cancel();
        }
        if (this.fyW != null) {
            this.fyW.cancel();
        }
    }

    public void a(d dVar) {
        this.fza = dVar;
    }

    private void aYh() {
        if (this.fyX != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fyX.iterator();
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
        if (this.fyX != null && v.D(this.fyX) > 0) {
            Iterator<MarkData> it = this.fyX.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
