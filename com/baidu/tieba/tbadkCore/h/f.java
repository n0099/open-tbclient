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
    private aa ZD = null;
    String bLJ;
    final /* synthetic */ a cpB;
    ArrayList<l> cpD;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;

    public f(a aVar, String str, String str2, String str3, int i, String str4) {
        this.cpB = aVar;
        this.cpD = null;
        this.bLJ = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bLJ = str4;
        this.cpD = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        this.ZD = new aa(strArr[0]);
        this.ZD.o("word", this.mForumName);
        if (this.mType != 6) {
            this.ZD.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.ZD.o("z", this.mThreadId);
            if (this.mType == 4) {
                this.ZD.o("ntn", "set");
            } else if (this.mType == 5) {
                this.ZD.o("ntn", "");
            } else if (this.mType == 2) {
                this.ZD.o("ntn", "set");
                this.ZD.o("cid", this.bLJ);
            } else {
                this.ZD.o("ntn", "");
            }
        }
        this.ZD.sp().tp().mIsNeedTbs = true;
        String rO = this.ZD.rO();
        if (this.ZD.sp().tq().pv()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(rO).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        l lVar = new l();
                        lVar.parserJson(optJSONArray.optJSONObject(i));
                        this.cpD.add(lVar);
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
        this.cpB.cpz = null;
        if (this.ZD == null) {
            iVar2 = this.cpB.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        g gVar = new g(this.cpB);
        gVar.AM = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                gVar.cpE = this.cpD;
            }
        } else {
            gVar.cpC = this.ZD.getErrorString();
        }
        iVar = this.cpB.mLoadDataCallBack;
        iVar.c(gVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.ZD != null) {
            this.ZD.hh();
        }
        this.cpB.cpz = null;
        super.cancel(true);
        iVar = this.cpB.mLoadDataCallBack;
        iVar.c(null);
    }
}
