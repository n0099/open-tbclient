package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.b.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements i {
    private String mThreadId = "";
    private String mPostId = "";
    private String bNg = "";
    private boolean bNh = true;
    private int bNi = 1;

    public void j(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bNg = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
        this.bNh = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, this.bNh);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_DESC, this.bNg);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oC() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bNi)).toString());
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

    public boolean abX() {
        return this.bNh;
    }

    public void abY() {
        this.bNi++;
    }

    public int getPageNum() {
        return this.bNi;
    }
}
