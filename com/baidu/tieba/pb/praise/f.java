package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.h {
    private String mThreadId = "";
    private String mPostId = "";
    private String bDz = "";
    private boolean bDA = true;
    private int bDB = 1;

    public void l(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bDz = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
        this.bDA = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, this.bDA);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_DESC, this.bDz);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> kQ() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bDB)).toString());
        hashMap.put("res_num", "20");
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object X(boolean z) {
        return null;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean Za() {
        return this.bDA;
    }

    public void Zb() {
        this.bDB++;
    }

    public int getPageNum() {
        return this.bDB;
    }
}
