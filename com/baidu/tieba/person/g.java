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
    private boolean blT;
    private ArrayList<com.baidu.adp.widget.ListView.f> bou = new ArrayList<>();
    private ArrayList<k> ffL;
    private int ffM;
    private int ffN;
    private UserData mUserData;

    public g(boolean z) {
        this.blT = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.ffM = moduleInfo.max_module_num.intValue();
            this.ffN = moduleInfo.max_module_thread_num.intValue();
            if (!u.v(moduleInfo.module_list)) {
                this.ffL = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        k kVar = new k();
                        kVar.a(threadModule);
                        kVar.setUserData(this.mUserData);
                        this.ffL.add(kVar);
                    }
                }
            }
        }
    }

    public void aXA() {
        this.bou.clear();
        if (!u.v(this.ffL)) {
            Iterator<k> it = this.ffL.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next != null) {
                    if (!u.v(next.getThreadList())) {
                        if (next.aXE() == -1) {
                            this.bou.add(next);
                            this.bou.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.bou.add(bVar);
                        } else if (next.mHasMore) {
                            this.bou.add(next);
                            this.bou.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.bou.add(bVar2);
                        } else {
                            this.bou.add(next);
                            this.bou.addAll(next.getThreadList());
                        }
                        this.bou.add(bp(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    } else if (this.blT) {
                        this.bou.add(next);
                        c cVar = new c();
                        cVar.ffH = next.aXE();
                        this.bou.add(cVar);
                        this.bou.add(bp(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bp(int i, int i2) {
        h hVar = new h();
        hVar.fcz = i;
        hVar.ffP = i2;
        return hVar;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.bou;
    }

    public ArrayList<k> getThreadList() {
        return this.ffL;
    }

    public void setUserData(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
