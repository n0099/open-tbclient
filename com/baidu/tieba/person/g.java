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
    private boolean bkz;
    private ArrayList<com.baidu.adp.widget.ListView.f> bmJ = new ArrayList<>();
    private ArrayList<k> fcE;
    private int fcF;
    private int fcG;
    private UserData mUserData;

    public g(boolean z) {
        this.bkz = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.fcF = moduleInfo.max_module_num.intValue();
            this.fcG = moduleInfo.max_module_thread_num.intValue();
            if (!u.v(moduleInfo.module_list)) {
                this.fcE = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        k kVar = new k();
                        kVar.a(threadModule);
                        kVar.setUserData(this.mUserData);
                        this.fcE.add(kVar);
                    }
                }
            }
        }
    }

    public void aWN() {
        this.bmJ.clear();
        if (!u.v(this.fcE)) {
            Iterator<k> it = this.fcE.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next != null) {
                    if (!u.v(next.getThreadList())) {
                        if (next.aWR() == -1) {
                            this.bmJ.add(next);
                            this.bmJ.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.bmJ.add(bVar);
                        } else if (next.mHasMore) {
                            this.bmJ.add(next);
                            this.bmJ.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.bmJ.add(bVar2);
                        } else {
                            this.bmJ.add(next);
                            this.bmJ.addAll(next.getThreadList());
                        }
                        this.bmJ.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    } else if (this.bkz) {
                        this.bmJ.add(next);
                        c cVar = new c();
                        cVar.fcA = next.aWR();
                        this.bmJ.add(cVar);
                        this.bmJ.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bg(int i, int i2) {
        h hVar = new h();
        hVar.eZs = i;
        hVar.fcI = i2;
        return hVar;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.bmJ;
    }

    public ArrayList<k> getThreadList() {
        return this.fcE;
    }

    public void setUserData(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
