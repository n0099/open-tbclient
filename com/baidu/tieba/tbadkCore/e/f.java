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
    private ad CX = null;
    String bDZ;
    ArrayList<k> caB;
    final /* synthetic */ a caz;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;

    public f(a aVar, String str, String str2, String str3, int i, String str4) {
        this.caz = aVar;
        this.caB = null;
        this.bDZ = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bDZ = str4;
        this.caB = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        this.CX = new ad(strArr[0]);
        this.CX.o("word", this.mForumName);
        if (this.mType != 6) {
            this.CX.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.CX.o("z", this.mThreadId);
            if (this.mType == 4) {
                this.CX.o("ntn", "set");
            } else if (this.mType == 5) {
                this.CX.o("ntn", "");
            } else if (this.mType == 2) {
                this.CX.o("ntn", "set");
                this.CX.o("cid", this.bDZ);
            } else {
                this.CX.o("ntn", "");
            }
        }
        this.CX.oZ().qg().mIsNeedTbs = true;
        String oy = this.CX.oy();
        if (this.CX.oZ().qh().ma()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(oy).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        k kVar = new k();
                        kVar.parserJson(optJSONArray.optJSONObject(i));
                        this.caB.add(kVar);
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
        this.caz.cax = null;
        if (this.CX == null) {
            iVar2 = this.caz.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        g gVar = new g(this.caz);
        gVar.qb = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                gVar.caC = this.caB;
            }
        } else {
            gVar.caA = this.CX.getErrorString();
        }
        iVar = this.caz.mLoadDataCallBack;
        iVar.c(gVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CX != null) {
            this.CX.dJ();
        }
        this.caz.cax = null;
        super.cancel(true);
        iVar = this.caz.mLoadDataCallBack;
        iVar.c(null);
    }
}
