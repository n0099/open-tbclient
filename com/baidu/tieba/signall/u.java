package com.baidu.tieba.signall;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private w ciU;
    private s ciV;
    private v ciW;
    private c ciX;
    public boolean pY;

    public u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.ciU = null;
        this.ciV = null;
        this.ciW = null;
        this.ciV = new s();
    }

    public void a(v vVar) {
        this.ciW = vVar;
    }

    public void c(c cVar) {
        this.ciX = cVar;
    }

    public c akP() {
        return this.ciX;
    }

    private String akQ() {
        ArrayList<e> akp = this.ciX.akp();
        if (akp == null) {
            return "";
        }
        if (!this.ciX.akq()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = akp.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.akz() < this.ciX.getLevel()) {
                    arrayList.add(next);
                }
            }
            akp.removeAll(arrayList);
        }
        int size = akp.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = akp.get(i);
            if (eVar.akD()) {
                if (!eVar.akE()) {
                    eVar.eT(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(eVar.getForumId());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.ciU != null) {
            return false;
        }
        String akQ = akQ();
        this.ciU = new w(this);
        this.ciU.execute(akQ);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.ciU != null) {
            this.ciU.cancel();
            return true;
        }
        return false;
    }
}
