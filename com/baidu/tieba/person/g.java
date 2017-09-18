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
    private boolean bmn;
    private ArrayList<com.baidu.adp.widget.ListView.f> bpe = new ArrayList<>();
    private ArrayList<k> feV;
    private int feW;
    private int feX;
    private UserData mUserData;

    public g(boolean z) {
        this.bmn = z;
    }

    public void a(ModuleInfo moduleInfo) {
        if (moduleInfo != null) {
            this.feW = moduleInfo.max_module_num.intValue();
            this.feX = moduleInfo.max_module_thread_num.intValue();
            if (!v.v(moduleInfo.module_list)) {
                this.feV = new ArrayList<>();
                for (ThreadModule threadModule : moduleInfo.module_list) {
                    if (threadModule != null) {
                        k kVar = new k();
                        kVar.a(threadModule);
                        kVar.setUserData(this.mUserData);
                        this.feV.add(kVar);
                    }
                }
            }
        }
    }

    public void aWX() {
        this.bpe.clear();
        if (!v.v(this.feV)) {
            Iterator<k> it = this.feV.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next != null) {
                    if (!v.v(next.getThreadList())) {
                        if (next.aXb() == -1) {
                            this.bpe.add(next);
                            this.bpe.addAll(next.getThreadList());
                            b bVar = new b();
                            bVar.b(next);
                            this.bpe.add(bVar);
                        } else if (next.mHasMore) {
                            this.bpe.add(next);
                            this.bpe.addAll(next.getThreadList().subList(0, 3));
                            b bVar2 = new b();
                            bVar2.b(next);
                            this.bpe.add(bVar2);
                        } else {
                            this.bpe.add(next);
                            this.bpe.addAll(next.getThreadList());
                        }
                        this.bpe.add(bs(com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    } else if (this.bmn) {
                        this.bpe.add(next);
                        c cVar = new c();
                        cVar.feR = next.aXb();
                        this.bpe.add(cVar);
                        this.bpe.add(bs(com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds20), d.e.cp_bg_line_c));
                    }
                }
            }
        }
    }

    private h bs(int i, int i2) {
        h hVar = new h();
        hVar.fbK = i;
        hVar.aGX = i2;
        return hVar;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.bpe;
    }

    public ArrayList<k> getThreadList() {
        return this.feV;
    }

    public void setUserData(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
        }
    }
}
