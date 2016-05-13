package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ax;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class l {
    private int cIw;
    private final TagInfo eac;
    private DataRes ead;
    private com.baidu.tieba.card.a.b eaf;
    private boolean hasMore;
    private int pn;
    private List<Object> avW = new ArrayList();
    private boolean bKq = false;
    private boolean cIx = false;
    private boolean cIy = false;
    private int dataType = 1;
    private long eae = 0;

    public l(TagInfo tagInfo) {
        this.eac = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.ead = dataRes;
    }

    public void kr(int i) {
        this.cIw = i;
    }

    public int aoc() {
        return this.cIw;
    }

    public boolean aod() {
        return this.cIx;
    }

    public boolean aoe() {
        return this.cIy;
    }

    public TagInfo aMt() {
        return this.eac;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, n nVar, boolean z2) {
        if (z) {
            this.cIy = true;
        } else {
            this.cIx = true;
        }
        if (nVar != null) {
            this.pn = nVar.getPn();
            this.hasMore = nVar.getHasMore();
            if (nVar instanceof r) {
                this.eae = ((r) nVar).aMv();
            }
            List<Object> a = a(z2, nVar);
            if (z2) {
                this.avW.addAll(a);
            } else {
                this.avW = a;
            }
        }
    }

    private List<Object> a(boolean z, n nVar) {
        ArrayList arrayList = new ArrayList();
        if (nVar != null && nVar.getThreadList() != null && nVar.getThreadList().size() != 0) {
            if (nVar.getThreadList().get(0) instanceof ExcellentThreadInfo) {
                a(arrayList, nVar, z);
            } else if (nVar.getThreadList().get(0) instanceof ThreadInfo) {
                b(arrayList, nVar, z);
            }
        }
        return arrayList;
    }

    private void a(List<Object> list, n nVar, boolean z) {
        if (list != null && nVar != null && nVar.getThreadList() != null && nVar.getThreadList().size() != 0) {
            this.dataType = 1;
            for (Object obj : nVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    p pVar = new p();
                    pVar.b((ExcellentThreadInfo) obj);
                    pVar.setShowImage(nVar.aMx());
                    if (pVar.aME() != 33) {
                        list.add(pVar);
                    } else if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        list.add(pVar);
                    }
                }
            }
        }
    }

    private void b(List<Object> list, n nVar, boolean z) {
        if (list != null && nVar != null && nVar.getThreadList() != null && nVar.getThreadList().size() != 0) {
            if (!z) {
                this.eaf = null;
            }
            this.dataType = 2;
            for (Object obj : nVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !b((ThreadInfo) obj))) {
                    ax axVar = new ax();
                    axVar.a((ThreadInfo) obj);
                    com.baidu.tieba.card.a.f fVar = new com.baidu.tieba.card.a.f();
                    fVar.aRG = axVar;
                    if (axVar.Ql == 1) {
                        com.baidu.tieba.card.a.g gVar = new com.baidu.tieba.card.a.g();
                        gVar.aRH = fVar;
                        a(gVar);
                        this.eaf = gVar;
                    } else {
                        a(fVar);
                        this.eaf = fVar;
                    }
                    list.add(this.eaf);
                }
            }
            if (nVar instanceof r) {
                r rVar = (r) nVar;
                if (this.pn == 1 && rVar.aMH() == 0) {
                    list.add(0, new g());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.a.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.eaf == null) {
                bVar.aRx = false;
            } else if (this.eaf.getType() == null) {
                bVar.aRx = false;
            } else if (this.eaf instanceof com.baidu.tieba.card.a.f) {
                if (bVar instanceof com.baidu.tieba.card.a.f) {
                    bVar.aRx = false;
                } else {
                    bVar.aRx = true;
                }
            } else {
                bVar.aRx = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.avW.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.avW.get(i);
                if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid == ((ExcellentThreadInfo) obj).excid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean b(ThreadInfo threadInfo) {
        int size;
        if (threadInfo != null && (size = this.avW.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.avW.get(i);
                if ((obj instanceof ThreadInfo) && threadInfo.id == ((ThreadInfo) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> aMu() {
        return this.avW;
    }

    public void cm(List<Object> list) {
        this.avW = list;
    }

    public void fs(boolean z) {
        this.bKq = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public long aMv() {
        return this.eae;
    }
}
