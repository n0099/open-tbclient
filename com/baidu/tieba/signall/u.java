package com.baidu.tieba.signall;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private w ciT;
    private s ciU;
    private v ciV;
    private c ciW;
    public boolean pY;

    public u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.ciT = null;
        this.ciU = null;
        this.ciV = null;
        this.ciU = new s();
    }

    public void a(v vVar) {
        this.ciV = vVar;
    }

    public void c(c cVar) {
        this.ciW = cVar;
    }

    public c akO() {
        return this.ciW;
    }

    private String akP() {
        ArrayList<e> ako = this.ciW.ako();
        if (ako == null) {
            return "";
        }
        if (!this.ciW.akp()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = ako.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.aky() < this.ciW.getLevel()) {
                    arrayList.add(next);
                }
            }
            ako.removeAll(arrayList);
        }
        int size = ako.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = ako.get(i);
            if (eVar.akC()) {
                if (!eVar.akD()) {
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
        if (this.ciT != null) {
            return false;
        }
        String akP = akP();
        this.ciT = new w(this);
        this.ciT.execute(akP);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.ciT != null) {
            this.ciT.cancel();
            return true;
        }
        return false;
    }
}
