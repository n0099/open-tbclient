package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, String, Boolean> {
    private ad CV = null;
    String bCo;
    final /* synthetic */ a bYG;
    ArrayList<j> bYI;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;

    public f(a aVar, String str, String str2, String str3, int i, String str4) {
        this.bYG = aVar;
        this.bYI = null;
        this.bCo = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bCo = str4;
        this.bYI = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        this.CV = new ad(strArr[0]);
        this.CV.o("word", this.mForumName);
        if (this.mType != 6) {
            this.CV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.CV.o("z", this.mThreadId);
            if (this.mType == 4) {
                this.CV.o("ntn", "set");
            } else if (this.mType == 5) {
                this.CV.o("ntn", "");
            } else if (this.mType == 2) {
                this.CV.o("ntn", "set");
                this.CV.o("cid", this.bCo);
            } else {
                this.CV.o("ntn", "");
            }
        }
        this.CV.oW().pV().mIsNeedTbs = true;
        String ov = this.CV.ov();
        if (this.CV.oW().pW().ma()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(ov).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        j jVar = new j();
                        jVar.parserJson(optJSONArray.optJSONObject(i));
                        this.bYI.add(jVar);
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
        this.bYG.bYE = null;
        if (this.CV == null) {
            iVar2 = this.bYG.mLoadDataCallBack;
            iVar2.c(null);
            return;
        }
        g gVar = new g(this.bYG);
        gVar.pW = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                gVar.bYJ = this.bYI;
            }
        } else {
            gVar.bYH = this.CV.getErrorString();
        }
        iVar = this.bYG.mLoadDataCallBack;
        iVar.c(gVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        if (this.CV != null) {
            this.CV.dL();
        }
        this.bYG.bYE = null;
        super.cancel(true);
        iVar = this.bYG.mLoadDataCallBack;
        iVar.c(null);
    }
}
