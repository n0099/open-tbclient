package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.b.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f implements i {
    private String mThreadId = "";
    private String mPostId = "";
    private String bPe = "";
    private boolean bPf = true;
    private int bPg = 1;

    public void j(Bundle bundle) {
        this.mThreadId = bundle.getString("thread_id");
        this.mPostId = bundle.getString("post_id");
        this.bPe = bundle.getString(com.baidu.tbadk.core.frameworkData.c.POST_DESC);
        this.bPf = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.IS_FROM_PB, true);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.c.IS_FROM_PB, this.bPf);
        bundle.putString("thread_id", this.mThreadId);
        bundle.putString("post_id", this.mPostId);
        bundle.putString(com.baidu.tbadk.core.frameworkData.c.POST_DESC, this.bPe);
        return bundle;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oS() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        hashMap.put("page_num", new StringBuilder(String.valueOf(this.bPg)).toString());
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

    public boolean acP() {
        return this.bPf;
    }

    public void acQ() {
        this.bPg++;
    }

    public int getPageNum() {
        return this.bPg;
    }
}
