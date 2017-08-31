package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.ModuleInfo;
import tbclient.ThreadModule;
/* loaded from: classes.dex */
public class g {
    private boolean bmo;
    private ArrayList<com.baidu.adp.widget.ListView.f> boR = new ArrayList<>();
    private ArrayList<k> fec;
    private int fed;
    private int fee;
    private UserData mUserData;

    public g(boolean z) {
        this.bmo = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.fed = moduleInfo.max_module_num.intValue();
            this.fee = moduleInfo.max_module_thread_num.intValue();
            if (!v.v(moduleInfo.module_list)) {
                this.fec = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        k kVar = new k();
                        kVar.a(threadModule);
                        kVar.setUserData(this.mUserData);
                        this.fec.add(kVar);
                    }
                }
            }
        }
    }

    public void aWM() {
        this.boR.clear();
        if (!v.v(this.fec)) {
            Iterator<k> it = this.fec.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next != null) {
                    if (!v.v(next.getThreadList())) {
                        if (next.aWQ() == -1) {
                            this.boR.add(next);
                            this.boR.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.boR.add(bVar);
                        } else if (next.mHasMore) {
                            this.boR.add(next);
                            this.boR.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.boR.add(bVar2);
                        } else {
                            this.boR.add(next);
                            this.boR.addAll(next.getThreadList());
                        }
                        this.boR.add(bo(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    } else if (this.bmo) {
                        this.boR.add(next);
                        c cVar = new c();
                        cVar.fdY = next.aWQ();
                        this.boR.add(cVar);
                        this.boR.add(bo(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bo(int i, int i2) {
        h hVar = new h();
        hVar.faQ = i;
        hVar.aHa = i2;
        return hVar;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.boR;
    }

    public ArrayList<k> getThreadList() {
        return this.fec;
    }

    public void setUserData(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
