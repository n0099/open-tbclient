package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import tbclient.ThreadInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eQq = BdUniqueId.gen();
    private long byZ;
    private String bza;
    private long eQr;
    public boolean mHasMore;
    private ArrayList<e> mThreadList;
    private UserData mUserData;

    public void a(ThreadModule threadModule) {
        if (threadModule != null) {
            this.byZ = threadModule.module_id.longValue();
            this.bza = threadModule.module_name;
            if (!z.t(threadModule.thread_info)) {
                this.mThreadList = new ArrayList<>();
                for (ThreadInfo threadInfo : threadModule.thread_info) {
                    if (threadInfo != null) {
                        e eVar = new e();
                        eVar.a(threadInfo);
                        eVar.ePZ = this.byZ;
                        eVar.eQc = false;
                        this.mThreadList.add(eVar);
                    }
                }
            }
            if (!z.t(this.mThreadList)) {
                this.mThreadList.get(0).eQc = true;
            }
            this.mHasMore = z.s(this.mThreadList) > 3 || this.byZ == -1;
            this.eQr = threadModule.show_num.longValue();
        }
    }

    public ArrayList<e> getThreadList() {
        return this.mThreadList;
    }

    public long aTU() {
        return this.byZ;
    }

    public String getModuleName() {
        return this.bza;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQq;
    }

    public void d(UserData userData) {
        this.mUserData = userData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }
}
