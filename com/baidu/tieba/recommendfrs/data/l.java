package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class l {
    private int cHR;
    private final TagInfo dWS;
    private DataRes dWT;
    private com.baidu.tieba.card.a.b dWW;
    private boolean hasMore;
    private int pn;
    private List<Object> azT = new ArrayList();
    private boolean bKl = false;
    private boolean cHS = false;
    private boolean cHT = false;
    private int dWU = 1;
    private long dWV = 0;

    public l(TagInfo tagInfo) {
        this.dWS = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.dWT = dataRes;
    }

    public void kL(int i) {
        this.cHR = i;
    }

    public int anW() {
        return this.cHR;
    }

    public boolean anX() {
        return this.cHS;
    }

    public boolean anY() {
        return this.cHT;
    }

    public TagInfo aMf() {
        return this.dWS;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, n nVar, boolean z2) {
        if (z) {
            this.cHT = true;
        } else {
            this.cHS = true;
        }
        if (nVar != null) {
            this.pn = nVar.getPn();
            this.hasMore = nVar.getHasMore();
            if (nVar instanceof r) {
                this.dWV = ((r) nVar).aMh();
            }
            List<Object> a = a(z2, nVar);
            if (z2) {
                this.azT.addAll(a);
            } else {
                this.azT = a;
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
            this.dWU = 1;
            for (Object obj : nVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    p pVar = new p();
                    pVar.b((ExcellentThreadInfo) obj);
                    pVar.setShowImage(nVar.aMj());
                    if (pVar.aMq() != 33) {
                        list.add(pVar);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        list.add(pVar);
                    }
                }
            }
        }
    }

    private void b(List<Object> list, n nVar, boolean z) {
        if (list != null && nVar != null && nVar.getThreadList() != null && nVar.getThreadList().size() != 0) {
            if (!z) {
                this.dWW = null;
            }
            this.dWU = 2;
            for (Object obj : nVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !b((ThreadInfo) obj))) {
                    as asVar = new as();
                    asVar.a((ThreadInfo) obj);
                    com.baidu.tieba.card.a.i iVar = new com.baidu.tieba.card.a.i();
                    iVar.aVJ = asVar;
                    if (asVar.Vl == 1) {
                        com.baidu.tieba.card.a.j jVar = new com.baidu.tieba.card.a.j();
                        jVar.aVK = iVar;
                        a(jVar);
                        this.dWW = jVar;
                    } else {
                        a(iVar);
                        this.dWW = iVar;
                    }
                    list.add(this.dWW);
                }
            }
            if (nVar instanceof r) {
                r rVar = (r) nVar;
                if (this.pn == 1 && rVar.aMt() == 0) {
                    list.add(0, new g());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.a.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.dWW == null) {
                bVar.aVs = false;
            } else if (this.dWW.getType() == null) {
                bVar.aVs = false;
            } else if (this.dWW instanceof com.baidu.tieba.card.a.i) {
                if (bVar instanceof com.baidu.tieba.card.a.i) {
                    bVar.aVs = false;
                } else {
                    bVar.aVs = true;
                }
            } else {
                bVar.aVs = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.azT.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.azT.get(i);
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
        if (threadInfo != null && (size = this.azT.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.azT.get(i);
                if ((obj instanceof ThreadInfo) && threadInfo.id == ((ThreadInfo) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> aMg() {
        return this.azT;
    }

    public void ck(List<Object> list) {
        this.azT = list;
    }

    public void eU(boolean z) {
        this.bKl = z;
    }

    public int getDataType() {
        return this.dWU;
    }

    public long aMh() {
        return this.dWV;
    }
}
