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
    private boolean ehD;
    private b fyY = null;
    private c fyZ = null;
    private C0200a fza = null;
    private int fzc = 0;
    private int fzd = 0;
    protected d fze = null;
    private ArrayList<MarkData> fzb = new ArrayList<>();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.fzd;
        aVar.fzd = i - 1;
        return i;
    }

    public a() {
        this.ehD = false;
        this.ehD = true;
    }

    public int getOffset() {
        if (this.fzb == null) {
            return 0;
        }
        return this.fzb.size();
    }

    public int aYc() {
        return this.fzd;
    }

    public void sq(int i) {
        this.fzd = i;
    }

    public boolean hasMore() {
        return this.fzc >= 20;
    }

    public void reset() {
        this.fzd = 0;
        this.fzc = 0;
        this.ehD = true;
    }

    public boolean isFirst() {
        return this.ehD;
    }

    public ArrayList<MarkData> aYd() {
        return this.fzb;
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.fzb = arrayList;
    }

    public void aj(ArrayList<MarkData> arrayList) {
        if (this.fzb != null && arrayList != null) {
            this.fzb.addAll(arrayList);
            aYh();
        }
    }

    public void f(MarkData markData) {
        this.fzb.add(markData);
    }

    public int getCount() {
        if (this.fzb == null) {
            return 0;
        }
        return this.fzb.size();
    }

    public int aYe() {
        return this.fzc;
    }

    public void aYf() {
        ArrayList<MarkData> bxR = com.baidu.tieba.tbadkCore.util.a.bxR();
        if (bxR != null) {
            ai(bxR);
        }
    }

    public String cj(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.fzb == null) {
            return null;
        }
        if (i >= this.fzb.size()) {
            i2 -= (i - this.fzb.size()) - 1;
            i = this.fzb.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.fzb.get(i5).toJson();
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
                    this.fzb.add(markData);
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
        if (this.fyY != null) {
            this.fyY.cancel();
        }
        this.fyY = new b(getOffset());
        this.fyY.setPriority(3);
        this.fyY.execute(bool, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        private com.baidu.tieba.myCollection.baseEditMark.c fzf;
        private int offset;
        private x mNetWork = null;
        private String data = null;
        Boolean fzh = false;

        public b(int i) {
            this.offset = 0;
            this.fzf = null;
            this.offset = i;
            this.fzf = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fzh = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.fzh.booleanValue() && booleanValue) {
                l<String> dh = com.baidu.tbadk.core.c.a.AR().dh("tb.my_bookmarks");
                if (dh != null) {
                    publishProgress(dh.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.fzb == null) {
                    a.this.fzb = new ArrayList();
                } else {
                    a.this.fzb.clear();
                }
                a.this.fzc = 0;
            }
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.mNetWork.n("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.ehD) {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(0));
            } else {
                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            }
            this.mNetWork.n(LegoListActivityConfig.RN, String.valueOf(20));
            this.data = this.mNetWork.Cb();
            this.fzf.parserJson(this.data);
            if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                aVar.pM(this.data);
                if (this.offset == 0) {
                    if (a.this.fzb == null) {
                        a.this.fzb = new ArrayList();
                    } else {
                        a.this.fzb.clear();
                    }
                    a.this.fzc = 0;
                    if (this.fzh.booleanValue()) {
                        lm(this.data);
                    }
                }
            }
            return aVar;
        }

        private void lm(String str) {
            l<String> dh;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (dh = com.baidu.tbadk.core.c.a.AR().dh("tb.my_bookmarks")) != null) {
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
                if (this.fzh.booleanValue()) {
                    a.this.ai(arrayList);
                } else {
                    a.this.aj(arrayList);
                }
            } else {
                a.this.ai(arrayList);
            }
            if (!v.E(arrayList)) {
                a.this.fze.callback(0, null, true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            a.this.fyY = null;
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
            if (this.fzf != null) {
                com.baidu.tbadk.core.d.a.a("collection", 0L, 0, "collection_thread_list_result", this.fzf.getErrorCode(), this.fzf.getErrorString(), new Object[0]);
            }
            a.this.fzc = aVar.getCount();
            ArrayList<MarkData> aYd = aVar.aYd();
            if (this.fzh.booleanValue()) {
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
                    a.this.sq(i);
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (a.this.fze != null) {
                String str = null;
                if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                    if (this.fzf.getErrorCode() != 0) {
                        str = this.fzf.getErrorString();
                    }
                    a.this.fze.callback(0, str, false);
                } else {
                    a.this.fze.callback(3, this.mNetWork.getErrorString());
                }
            }
            a.this.ehD = false;
        }
    }

    public void startSync() {
        if (this.fyZ != null) {
            this.fyZ.cancel();
        }
        this.fyZ = new c();
        this.fyZ.setPriority(2);
        this.fyZ.execute(new a[0]);
    }

    /* loaded from: classes3.dex */
    private class c extends BdAsyncTask<a, Integer, Boolean> {
        private com.baidu.tieba.myCollection.baseEditMark.c fzf;
        private x mNetWork;

        private c() {
            this.mNetWork = null;
            this.fzf = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fzf = new com.baidu.tieba.myCollection.baseEditMark.c();
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
                    this.fzf.parserJson(this.mNetWork.Cb());
                    if (!this.mNetWork.Cz().Dx().isRequestSuccess() || this.fzf.getErrorCode() != 0) {
                        break;
                    }
                    aYg -= 20;
                }
                a.this.ss(aYg);
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
            a.this.fyZ = null;
            if (a.this.fze != null) {
                a.this.fze.callback(1, false, null, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            boolean z;
            a.this.fyZ = null;
            if (bool.booleanValue()) {
                str = null;
                z = false;
            } else if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                str = this.fzf.getErrorString();
                z = false;
            } else {
                str = null;
                z = true;
            }
            if (a.this.fze != null) {
                a.this.fze.callback(1, bool, str, Boolean.valueOf(z));
            }
        }
    }

    public boolean sr(int i) {
        if (this.fza != null) {
            this.fza.cancel();
        }
        if (i >= this.fzb.size() || this.fzb.get(i) == null || this.fzb.get(i).getId() == null) {
            return false;
        }
        this.fza = new C0200a(this.fzb.get(i).getId(), i, this.fzb.get(i).getForumId());
        this.fza.setPriority(2);
        this.fza.execute(new Boolean[0]);
        return true;
    }

    /* renamed from: com.baidu.tieba.myCollection.baseEditMark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0200a extends BdAsyncTask<Boolean, Integer, Boolean> {
        private String fid;
        private com.baidu.tieba.myCollection.baseEditMark.c fzf;
        private x mNetWork = null;
        private int pos;
        private String tid;

        public C0200a(String str, int i, String str2) {
            this.tid = null;
            this.fid = null;
            this.pos = 0;
            this.fzf = null;
            this.tid = str;
            this.pos = i;
            this.fid = str2;
            this.fzf = new com.baidu.tieba.myCollection.baseEditMark.c();
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
            this.fzf.parserJson(this.mNetWork.Cb());
            return this.mNetWork.Cz().Dx().isRequestSuccess() && this.fzf.getErrorCode() == 0;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            a.this.fza = null;
            if (a.this.fze != null) {
                a.this.fze.callback(2, false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.fza = null;
            if (bool.booleanValue()) {
                if (this.pos < a.this.fzb.size()) {
                    a.this.fzb.remove(this.pos);
                    a.c(a.this);
                }
            } else if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                str = this.fzf.getErrorString();
            } else {
                str = this.mNetWork.getErrorString();
            }
            if (a.this.fze != null) {
                a.this.fze.callback(2, bool, str);
            }
        }
    }

    public int aYg() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("uploac_mark_offset", 399);
    }

    public void ss(int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("uploac_mark_offset", i);
    }

    public void onDestroy() {
        if (this.fyY != null) {
            this.fyY.cancel();
        }
        if (this.fyZ != null) {
            this.fyZ.cancel();
        }
        if (this.fza != null) {
            this.fza.cancel();
        }
    }

    public void a(d dVar) {
        this.fze = dVar;
    }

    private void aYh() {
        if (this.fzb != null) {
            HashSet hashSet = new HashSet();
            Iterator<MarkData> it = this.fzb.iterator();
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
        if (this.fzb != null && v.D(this.fzb) > 0) {
            Iterator<MarkData> it = this.fzb.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }
}
