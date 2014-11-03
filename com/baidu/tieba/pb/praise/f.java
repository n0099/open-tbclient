package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.g {
    private String mThreadId = "";
    private String mPostId = "";
    private String bzH = "";
    private boolean bzI = true;
    private int bzJ = 1;

    public void l(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bzH = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
        this.bzI = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, this.bzI);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_DESC, this.bzH);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public HashMap<String, Object> tq() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bzJ)).toString());
        hashMap.put("res_num", "20");
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public Object ay(boolean z) {
        return null;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean YC() {
        return this.bzI;
    }

    public void YD() {
        this.bzJ++;
    }

    public int getPageNum() {
        return this.bzJ;
    }
}
