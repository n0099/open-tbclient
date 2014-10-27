package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.mvc.b.g {
    private String mThreadId = "";
    private String mPostId = "";
    private String bzt = "";
    private boolean bzu = true;
    private int bzv = 1;

    public void l(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bzt = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
        this.bzu = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, this.bzu);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_DESC, this.bzt);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.f
    public HashMap<String, Object> to() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bzv)).toString());
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

    public boolean Yz() {
        return this.bzu;
    }

    public void YA() {
        this.bzv++;
    }

    public int getPageNum() {
        return this.bzv;
    }
}
