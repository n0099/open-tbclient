package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, String, Boolean> {
    final /* synthetic */ v bpb;
    ArrayList<com.baidu.tbadk.core.data.h> bpd;
    String bpe;
    private String mForumId;
    private String mForumName;
    private String mThreadId;
    private int mType;
    private com.baidu.tbadk.core.util.ac yV = null;

    public aa(v vVar, String str, String str2, String str3, int i, String str4) {
        this.bpb = vVar;
        this.bpd = null;
        this.bpe = null;
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.mType = i;
        this.bpe = str4;
        this.bpd = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        this.yV = new com.baidu.tbadk.core.util.ac(strArr[0]);
        this.yV.k("word", this.mForumName);
        if (this.mType != 6) {
            this.yV.k(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.yV.k("z", this.mThreadId);
            if (this.mType == 4) {
                this.yV.k("ntn", "set");
            } else if (this.mType == 5) {
                this.yV.k("ntn", "");
            } else if (this.mType == 2) {
                this.yV.k("ntn", "set");
                this.yV.k("cid", this.bpe);
            } else {
                this.yV.k("ntn", "");
            }
        }
        this.yV.mc().na().mIsNeedTbs = true;
        String lA = this.yV.lA();
        if (this.yV.mc().nb().jq()) {
            if (this.mType == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(lA).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                        hVar.parserJson(optJSONArray.optJSONObject(i));
                        this.bpd.add(hVar);
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
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(bool);
        this.bpb.boX = null;
        if (this.yV == null) {
            hVar2 = this.bpb.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        ab abVar = new ab(this.bpb);
        abVar.qa = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.mType == 6) {
                abVar.bpf = this.bpd;
            }
        } else {
            abVar.bpc = this.yV.getErrorString();
        }
        hVar = this.bpb.mLoadDataCallBack;
        hVar.a(abVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        if (this.yV != null) {
            this.yV.dM();
        }
        this.bpb.boX = null;
        super.cancel(true);
        hVar = this.bpb.mLoadDataCallBack;
        hVar.a(null);
    }
}
