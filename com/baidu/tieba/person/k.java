package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fed = BdUniqueId.gen();
    private long bEp;
    private String bEq;
    private long fee;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.bEp = threadModule.module_id.longValue();
            this.bEq = threadModule.module_name;
            if (!u.v(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.fdM = this.bEp;
                        eVar.fdP = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!u.v(this.mThreadList)) {
                this.mThreadList.get(0).fdP = true;
            }
            this.mHasMore = u.u(this.mThreadList) > 3 || this.bEp == -1;
            this.fee = threadModule.show_num.longValue();
        }
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aXc() {
        return this.bEp;
    }

    public String getModuleName() {
        return this.bEq;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fed;
    }

    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
