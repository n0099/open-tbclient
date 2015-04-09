package com.baidu.tieba.tbadkCore.h;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, String, Boolean> {
    private aa ZF = null;
    String bLZ;
    final /* synthetic */ a cpR;
    ArrayList<l> cpT;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;

    public f(a aVar, String str, String str2, String str3, int i, String str4) {
        this.cpR = aVar;
        this.cpT = null;
        this.bLZ = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bLZ = str4;
        this.cpT = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        this.ZF = new aa(strArr[0]);
        this.ZF.o("word", this.mForumName);
        if (this.mType != 6) {
            this.ZF.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.ZF.o("z", this.mThreadId);
            if (this.mType == 4) {
                this.ZF.o("ntn", "set");
            } else if (this.mType == 5) {
                this.ZF.o("ntn", "");
            } else if (this.mType == 2) {
                this.ZF.o("ntn", "set");
                this.ZF.o("cid", this.bLZ);
            } else {
                this.ZF.o("ntn", "");
            }
        }
        this.ZF.sp().tp().mIsNeedTbs = true;
        String rO = this.ZF.rO();
        if (this.ZF.sp().tq().pv()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(rO).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        l lVar = new l();
                        lVar.parserJson(optJSONArray.optJSONObject(i));
                        this.cpT.add(lVar);
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
        this.cpR.cpP = null;
        if (this.ZF == null) {
            iVar2 = this.cpR.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        g gVar = new g(this.cpR);
        gVar.AM = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                gVar.cpU = this.cpT;
            }
        } else {
            gVar.cpS = this.ZF.getErrorString();
        }
        iVar = this.cpR.mLoadDataCallBack;
        iVar.c(gVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.ZF != null) {
            this.ZF.hh();
        }
        this.cpR.cpP = null;
        super.cancel(true);
        iVar = this.cpR.mLoadDataCallBack;
        iVar.c(null);
    }
}
