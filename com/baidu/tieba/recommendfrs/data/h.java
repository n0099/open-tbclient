package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ah;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class h {
    private final TagInfo dEM;
    private DataRes dEN;
    private int dEP;
    private com.baidu.tieba.card.a.b dEU;
    private boolean hasMore;
    private int pn;
    private List<Object> azm = new ArrayList();
    private boolean dEO = false;
    private boolean dEQ = false;
    private boolean dER = false;
    private int dES = 1;
    private long dET = 0;

    public h(TagInfo tagInfo) {
        this.dEM = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.dEN = dataRes;
    }

    public void nz(int i) {
        this.dEP = i;
    }

    public int aFo() {
        return this.dEP;
    }

    public boolean aFp() {
        return this.dEQ;
    }

    public boolean aFq() {
        return this.dER;
    }

    public TagInfo aFr() {
        return this.dEM;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, j jVar, boolean z2) {
        if (z) {
            this.dER = true;
        } else {
            this.dEQ = true;
        }
        if (jVar != null) {
            this.pn = jVar.getPn();
            this.hasMore = jVar.getHasMore();
            if (jVar instanceof n) {
                this.dET = ((n) jVar).aFt();
            }
            List<Object> a = a(z2, jVar);
            if (z2) {
                this.azm.addAll(a);
            } else {
                this.azm = a;
            }
        }
    }

    private List<Object> a(boolean z, j jVar) {
        ArrayList arrayList = new ArrayList();
        if (jVar != null && jVar.getThreadList() != null && jVar.getThreadList().size() != 0) {
            if (jVar.getThreadList().get(0) instanceof ExcellentThreadInfo) {
                a(arrayList, jVar, z);
            } else if (jVar.getThreadList().get(0) instanceof ThreadInfo) {
                b(arrayList, jVar, z);
            }
        }
        return arrayList;
    }

    private void a(List<Object> list, j jVar, boolean z) {
        if (list != null && jVar != null && jVar.getThreadList() != null && jVar.getThreadList().size() != 0) {
            this.dES = 1;
            for (Object obj : jVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    l lVar = new l();
                    lVar.b((ExcellentThreadInfo) obj);
                    lVar.setShowImage(jVar.aFv());
                    if (lVar.aFC() != 33) {
                        list.add(lVar);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        list.add(lVar);
                    }
                }
            }
        }
    }

    private void b(List<Object> list, j jVar, boolean z) {
        if (list != null && jVar != null && jVar.getThreadList() != null && jVar.getThreadList().size() != 0) {
            if (!z) {
                this.dEU = null;
            }
            this.dES = 2;
            for (Object obj : jVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !b((ThreadInfo) obj))) {
                    ah ahVar = new ah();
                    ahVar.a((ThreadInfo) obj);
                    com.baidu.tieba.card.a.i iVar = new com.baidu.tieba.card.a.i();
                    iVar.aSc = ahVar;
                    if (ahVar.WV == 1) {
                        com.baidu.tieba.card.a.j jVar2 = new com.baidu.tieba.card.a.j();
                        jVar2.aSd = iVar;
                        a(jVar2);
                        this.dEU = jVar2;
                    } else {
                        a(iVar);
                        this.dEU = iVar;
                    }
                    list.add(this.dEU);
                }
            }
            if (jVar instanceof n) {
                n nVar = (n) jVar;
                if (this.pn == 1 && nVar.aFF() == 0) {
                    list.add(0, new g());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.a.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.dEU == null) {
                bVar.aRK = false;
            } else if (this.dEU.getType() == null) {
                bVar.aRK = false;
            } else if (this.dEU instanceof com.baidu.tieba.card.a.i) {
                if (bVar instanceof com.baidu.tieba.card.a.i) {
                    bVar.aRK = false;
                } else {
                    bVar.aRK = true;
                }
            } else {
                bVar.aRK = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.azm.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.azm.get(i);
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
        if (threadInfo != null && (size = this.azm.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.azm.get(i);
                if ((obj instanceof ThreadInfo) && threadInfo.id == ((ThreadInfo) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> aFs() {
        return this.azm;
    }

    public void bS(List<Object> list) {
        this.azm = list;
    }

    public void ho(boolean z) {
        this.dEO = z;
    }

    public int getDataType() {
        return this.dES;
    }

    public long aFt() {
        return this.dET;
    }
}
