package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fcR = BdUniqueId.gen();
    private long bDf;
    private String bDg;
    private long fcS;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.bDf = threadModule.module_id.longValue();
            this.bDg = threadModule.module_name;
            if (!u.v(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.fcA = this.bDf;
                        eVar.fcD = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!u.v(this.mThreadList)) {
                this.mThreadList.get(0).fcD = true;
            }
            this.mHasMore = u.u(this.mThreadList) > 3 || this.bDf == -1;
            this.fcS = threadModule.show_num.longValue();
        }
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aWR() {
        return this.bDf;
    }

    public String getModuleName() {
        return this.bDg;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fcR;
    }

    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
