package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.ModuleInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class g {
    private boolean bhl;
    private ArrayList<v> byq = new ArrayList<>();
    private ArrayList<n> eQd;
    private int eQe;
    private int eQf;
    private UserData mUserData;

    public g(boolean z) {
        this.bhl = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.eQe = moduleInfo.max_module_num.intValue();
            this.eQf = moduleInfo.max_module_thread_num.intValue();
            if (!z.t(moduleInfo.module_list)) {
                this.eQd = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        n nVar = new n();
                        nVar.a(threadModule);
                        nVar.d(this.mUserData);
                        this.eQd.add(nVar);
                    }
                }
            }
        }
    }

    public void aTQ() {
        this.byq.clear();
        if (!z.t(this.eQd)) {
            Iterator<n> it = this.eQd.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null) {
                    if (!z.t(next.getThreadList())) {
                        if (next.aTU() == -1) {
                            this.byq.add(next);
                            this.byq.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.byq.add(bVar);
                        } else if (next.mHasMore) {
                            this.byq.add(next);
                            this.byq.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.byq.add(bVar2);
                        } else {
                            this.byq.add(next);
                            this.byq.addAll(next.getThreadList());
                        }
                        this.byq.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                    } else if (this.bhl) {
                        this.byq.add(next);
                        c cVar = new c();
                        cVar.ePZ = next.aTU();
                        this.byq.add(cVar);
                        this.byq.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bg(int i, int i2) {
        h hVar = new h();
        hVar.eMR = i;
        hVar.eQh = i2;
        return hVar;
    }

    public ArrayList<v> getDataList() {
        return this.byq;
    }

    public ArrayList<n> getThreadList() {
        return this.eQd;
    }

    public void d(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
