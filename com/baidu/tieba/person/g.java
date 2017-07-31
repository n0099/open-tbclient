package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.ModuleInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class g {
    private boolean blJ;
    private ArrayList<com.baidu.adp.widget.ListView.f> bnT = new ArrayList<>();
    private ArrayList<k> fdQ;
    private int fdR;
    private int fdS;
    private UserData mUserData;

    public g(boolean z) {
        this.blJ = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.fdR = moduleInfo.max_module_num.intValue();
            this.fdS = moduleInfo.max_module_thread_num.intValue();
            if (!u.v(moduleInfo.module_list)) {
                this.fdQ = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        k kVar = new k();
                        kVar.a(threadModule);
                        kVar.setUserData(this.mUserData);
                        this.fdQ.add(kVar);
                    }
                }
            }
        }
    }

    public void aWY() {
        this.bnT.clear();
        if (!u.v(this.fdQ)) {
            Iterator<k> it = this.fdQ.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next != null) {
                    if (!u.v(next.getThreadList())) {
                        if (next.aXc() == -1) {
                            this.bnT.add(next);
                            this.bnT.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.bnT.add(bVar);
                        } else if (next.mHasMore) {
                            this.bnT.add(next);
                            this.bnT.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.bnT.add(bVar2);
                        } else {
                            this.bnT.add(next);
                            this.bnT.addAll(next.getThreadList());
                        }
                        this.bnT.add(bh(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    } else if (this.blJ) {
                        this.bnT.add(next);
                        c cVar = new c();
                        cVar.fdM = next.aXc();
                        this.bnT.add(cVar);
                        this.bnT.add(bh(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bh(int i, int i2) {
        h hVar = new h();
        hVar.faE = i;
        hVar.fdU = i2;
        return hVar;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.bnT;
    }

    public ArrayList<k> getThreadList() {
        return this.fdQ;
    }

    public void setUserData(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
