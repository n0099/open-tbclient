package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eGA = BdUniqueId.gen();
    private long bvn;
    private String bvo;
    private long eGB;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.bvn = threadModule.module_id.longValue();
            this.bvo = threadModule.module_name;
            if (!x.r(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.eGr = this.bvn;
                        eVar.eGu = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!x.r(this.mThreadList)) {
                this.mThreadList.get(0).eGu = true;
            }
            this.mHasMore = x.q(this.mThreadList) > 3 || this.bvn == -1;
            this.eGB = threadModule.show_num.longValue();
        }
    }

    public boolean aPS() {
        return this.bvn == -1;
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aPT() {
        return this.bvn;
    }

    public String getModuleName() {
        return this.bvo;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eGA;
    }

    public void a(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
