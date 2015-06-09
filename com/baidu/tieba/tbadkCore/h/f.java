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
    private aa aaG = null;
    String bOd;
    final /* synthetic */ a ctT;
    ArrayList<l> ctV;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;

    public f(a aVar, String str, String str2, String str3, int i, String str4) {
        this.ctT = aVar;
        this.ctV = null;
        this.bOd = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bOd = str4;
        this.ctV = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        this.aaG = new aa(strArr[0]);
        this.aaG.o("word", this.mForumName);
        if (this.mType != 6) {
            this.aaG.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.aaG.o("z", this.mThreadId);
            if (this.mType == 4) {
                this.aaG.o("ntn", "set");
            } else if (this.mType == 5) {
                this.aaG.o("ntn", "");
            } else if (this.mType == 2) {
                this.aaG.o("ntn", "set");
                this.aaG.o("cid", this.bOd);
            } else {
                this.aaG.o("ntn", "");
            }
        }
        this.aaG.sX().tS().mIsNeedTbs = true;
        String sw = this.aaG.sw();
        if (this.aaG.sX().tT().qa()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(sw).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        l lVar = new l();
                        lVar.parserJson(optJSONArray.optJSONObject(i));
                        this.ctV.add(lVar);
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
        this.ctT.ctR = null;
        if (this.aaG == null) {
            iVar2 = this.ctT.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        g gVar = new g(this.ctT);
        gVar.AA = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                gVar.ctW = this.ctV;
            }
        } else {
            gVar.ctU = this.aaG.getErrorString();
        }
        iVar = this.ctT.mLoadDataCallBack;
        iVar.c(gVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        this.ctT.ctR = null;
        super.cancel(true);
        iVar = this.ctT.mLoadDataCallBack;
        iVar.c(null);
    }
}
