package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, String, Boolean> {
    private ad CU = null;
    String bDY;
    ArrayList<k> caA;
    final /* synthetic */ a cay;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;

    public f(a aVar, String str, String str2, String str3, int i, String str4) {
        this.cay = aVar;
        this.caA = null;
        this.bDY = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bDY = str4;
        this.caA = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        this.CU = new ad(strArr[0]);
        this.CU.o("word", this.mForumName);
        if (this.mType != 6) {
            this.CU.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.CU.o("z", this.mThreadId);
            if (this.mType == 4) {
                this.CU.o("ntn", "set");
            } else if (this.mType == 5) {
                this.CU.o("ntn", "");
            } else if (this.mType == 2) {
                this.CU.o("ntn", "set");
                this.CU.o("cid", this.bDY);
            } else {
                this.CU.o("ntn", "");
            }
        }
        this.CU.oS().pZ().mIsNeedTbs = true;
        String or = this.CU.or();
        if (this.CU.oS().qa().lT()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(or).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        k kVar = new k();
                        kVar.parserJson(optJSONArray.optJSONObject(i));
                        this.caA.add(kVar);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        i iVar;
        i iVar2;
        super.onPostExecute(bool);
        this.cay.caw = null;
        if (this.CU == null) {
            iVar2 = this.cay.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        g gVar = new g(this.cay);
        gVar.qb = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                gVar.caB = this.caA;
            }
        } else {
            gVar.caz = this.CU.getErrorString();
        }
        iVar = this.cay.mLoadDataCallBack;
        iVar.c(gVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.cay.caw = null;
        super.cancel(true);
        iVar = this.cay.mLoadDataCallBack;
        iVar.c(null);
    }
}
