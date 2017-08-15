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
    private boolean blR;
    private ArrayList<com.baidu.adp.widget.ListView.f> bos = new ArrayList<>();
    private ArrayList<k> ffJ;
    private int ffK;
    private int ffL;
    private UserData mUserData;

    public g(boolean z) {
        this.blR = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.ffK = moduleInfo.max_module_num.intValue();
            this.ffL = moduleInfo.max_module_thread_num.intValue();
            if (!u.v(moduleInfo.module_list)) {
                this.ffJ = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        k kVar = new k();
                        kVar.a(threadModule);
                        kVar.setUserData(this.mUserData);
                        this.ffJ.add(kVar);
                    }
                }
            }
        }
    }

    public void aXF() {
        this.bos.clear();
        if (!u.v(this.ffJ)) {
            Iterator<k> it = this.ffJ.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next != null) {
                    if (!u.v(next.getThreadList())) {
                        if (next.aXJ() == -1) {
                            this.bos.add(next);
                            this.bos.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.bos.add(bVar);
                        } else if (next.mHasMore) {
                            this.bos.add(next);
                            this.bos.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.bos.add(bVar2);
                        } else {
                            this.bos.add(next);
                            this.bos.addAll(next.getThreadList());
                        }
                        this.bos.add(bp(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    } else if (this.blR) {
                        this.bos.add(next);
                        c cVar = new c();
                        cVar.ffF = next.aXJ();
                        this.bos.add(cVar);
                        this.bos.add(bp(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bp(int i, int i2) {
        h hVar = new h();
        hVar.fcx = i;
        hVar.ffN = i2;
        return hVar;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.bos;
    }

    public ArrayList<k> getThreadList() {
        return this.ffJ;
    }

    public void setUserData(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
