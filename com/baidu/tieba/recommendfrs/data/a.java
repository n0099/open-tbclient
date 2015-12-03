package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentTagInfo;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final ExcellentTagInfo diH;
    private int diI;
    private boolean hasMore;
    private int pn;
    private List<Object> awS = new ArrayList();
    private boolean diJ = false;
    private boolean diK = false;

    public a(ExcellentTagInfo excellentTagInfo) {
        this.diH = excellentTagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void lN(int i) {
        this.diI = i;
    }

    public int awe() {
        return this.diI;
    }

    public boolean awf() {
        return this.diJ;
    }

    public boolean awg() {
        return this.diK;
    }

    public ExcellentTagInfo awh() {
        return this.diH;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.diK = true;
        } else {
            this.diJ = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.awS.addAll(a);
            } else {
                this.awS = a;
            }
        }
    }

    private List<Object> a(boolean z, c cVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar == null || cVar.getThreadList() == null) {
            return arrayList;
        }
        if (cVar.getThreadList() != null) {
            for (ExcellentThreadInfo excellentThreadInfo : cVar.getThreadList()) {
                if (excellentThreadInfo != null && (!z || !a(excellentThreadInfo))) {
                    e eVar = new e();
                    eVar.b(excellentThreadInfo);
                    eVar.setShowImage(cVar.awl());
                    if (eVar.awt() != 33) {
                        arrayList.add(eVar);
                    } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        arrayList.add(eVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.awS.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.awS.get(i);
                if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid == ((ExcellentThreadInfo) obj).excid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> awi() {
        return this.awS;
    }
}
