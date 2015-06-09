package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.b.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements i {
    private String mThreadId = "";
    private String mPostId = "";
    private String bPf = "";
    private boolean bPg = true;
    private int bPh = 1;

    public void j(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bPf = bundle.getString(com.baidu.tbadk.core.frameworkData.c.POST_DESC);
        this.bPg = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.c.IS_FROM_PB, this.bPg);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.c.POST_DESC, this.bPf);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oS() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bPh)).toString());
        hashMap.put("res_num", "20");
        return hashMap;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object Y(boolean z) {
        return null;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean acQ() {
        return this.bPg;
    }

    public void acR() {
        this.bPh++;
    }

    public int getPageNum() {
        return this.bPh;
    }
}
