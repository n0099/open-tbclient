package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.b.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements i {
    private String mThreadId = "";
    private String mPostId = "";
    private String bMQ = "";
    private boolean bMR = true;
    private int bMS = 1;

    public void j(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bMQ = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
        this.bMR = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, this.bMR);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_DESC, this.bMQ);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oC() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bMS)).toString());
        hashMap.put("res_num", "20");
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object V(boolean z) {
        return null;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean abI() {
        return this.bMR;
    }

    public void abJ() {
        this.bMS++;
    }

    public int getPageNum() {
        return this.bMS;
    }
}
