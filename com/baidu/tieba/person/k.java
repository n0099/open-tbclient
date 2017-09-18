package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ffh = BdUniqueId.gen();
    private long bIK;
    private String bIL;
    private long ffi;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.bIK = threadModule.module_id.longValue();
            this.bIL = threadModule.module_name;
            if (!v.v(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.feR = this.bIK;
                        eVar.feU = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!v.v(this.mThreadList)) {
                this.mThreadList.get(0).feU = true;
            }
            this.mHasMore = v.u(this.mThreadList) > 3 || this.bIK == -1;
            this.ffi = threadModule.show_num.longValue();
        }
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aXb() {
        return this.bIK;
    }

    public String getModuleName() {
        return this.bIL;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ffh;
    }

    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
