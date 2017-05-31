package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.ModuleInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class g {
    private boolean beq;
    private ArrayList<v> bvg = new ArrayList<>();
    private ArrayList<l> eGv;
    private int eGw;
    private int eGx;
    private UserData mUserData;

    public g(boolean z) {
        this.beq = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.eGw = moduleInfo.max_module_num.intValue();
            this.eGx = moduleInfo.max_module_thread_num.intValue();
            if (!x.r(moduleInfo.module_list)) {
                this.eGv = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        l lVar = new l();
                        lVar.a(threadModule);
                        lVar.a(this.mUserData);
                        this.eGv.add(lVar);
                    }
                }
            }
        }
    }

    public void aPR() {
        this.bvg.clear();
        if (!x.r(this.eGv)) {
            Iterator<l> it = this.eGv.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next != null) {
                    if (!x.r(next.getThreadList())) {
                        if (next.aPT() == -1) {
                            this.bvg.add(next);
                            this.bvg.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.c(next);
                            this.bvg.add(bVar);
                        } else if (next.mHasMore) {
                            this.bvg.add(next);
                            this.bvg.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.c(next);
                            this.bvg.add(bVar2);
                        } else {
                            this.bvg.add(next);
                            this.bvg.addAll(next.getThreadList());
                        }
                        this.bvg.add(aX(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                    } else if (this.beq) {
                        this.bvg.add(next);
                        c cVar = new c();
                        cVar.eGr = next.aPT();
                        this.bvg.add(cVar);
                        this.bvg.add(aX(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    public void cc(long j) {
        if (!x.r(this.eGv)) {
            Iterator<l> it = this.eGv.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next != null && next.aPT() == j) {
                    this.eGv.remove(next);
                    return;
                }
            }
        }
    }

    private h aX(int i, int i2) {
        h hVar = new h();
        hVar.eDj = i;
        hVar.eGz = i2;
        return hVar;
    }

    public ArrayList<v> getDataList() {
        return this.bvg;
    }

    public ArrayList<l> getThreadList() {
        return this.eGv;
    }

    public void a(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
