package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId feo = BdUniqueId.gen();
    private long bHT;
    private String bHU;
    private long fep;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.bHT = threadModule.module_id.longValue();
            this.bHU = threadModule.module_name;
            if (!v.v(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.fdY = this.bHT;
                        eVar.feb = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!v.v(this.mThreadList)) {
                this.mThreadList.get(0).feb = true;
            }
            this.mHasMore = v.u(this.mThreadList) > 3 || this.bHT == -1;
            this.fep = threadModule.show_num.longValue();
        }
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aWQ() {
        return this.bHT;
    }

    public String getModuleName() {
        return this.bHU;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return feo;
    }

    public void setUserData(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
