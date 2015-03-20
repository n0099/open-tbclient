package com.baidu.tieba.signall;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static u ceD;
    private static String userId;
    private s ceA;
    private v ceB;
    private c ceC;
    private w cez;
    public boolean pT;

    public static u e(SignAllForumActivity signAllForumActivity) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (ceD == null) {
            ceD = new u(signAllForumActivity);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            ceD = new u(signAllForumActivity);
        }
        return ceD;
    }

    private u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cez = null;
        this.ceA = null;
        this.ceB = null;
        userId = TbadkCoreApplication.getCurrentAccount();
        this.ceA = new s();
    }

    public void a(v vVar) {
        this.ceB = vVar;
    }

    public void c(c cVar) {
        this.ceC = cVar;
    }

    public c aiP() {
        return this.ceC;
    }

    private String aiQ() {
        ArrayList<e> aip = this.ceC.aip();
        if (aip == null) {
            return "";
        }
        if (!this.ceC.aiq()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aip.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.aiz() < this.ceC.getLevel()) {
                    arrayList.add(next);
                }
            }
            aip.removeAll(arrayList);
        }
        int size = aip.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aip.get(i);
            if (eVar.aiD()) {
                if (!eVar.aiE()) {
                    eVar.eB(true);
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
        if (this.cez != null) {
            return false;
        }
        String aiQ = aiQ();
        this.cez = new w(this);
        this.cez.execute(aiQ);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cez != null) {
            this.cez.cancel();
            return true;
        }
        return false;
    }
}
