package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ffW = BdUniqueId.gen();
    private long bEY;
    private String bEZ;
    private long ffX;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.bEY = threadModule.module_id.longValue();
            this.bEZ = threadModule.module_name;
            if (!u.v(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.ffF = this.bEY;
                        eVar.ffI = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!u.v(this.mThreadList)) {
                this.mThreadList.get(0).ffI = true;
            }
            this.mHasMore = u.u(this.mThreadList) > 3 || this.bEY == -1;
            this.ffX = threadModule.show_num.longValue();
        }
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aXJ() {
        return this.bEY;
    }

    public String getModuleName() {
        return this.bEZ;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ffW;
    }

    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
