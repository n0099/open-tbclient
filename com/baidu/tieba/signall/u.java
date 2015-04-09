package com.baidu.tieba.signall;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static u ceS;
    private static String userId;
    private w ceO;
    private s ceP;
    private v ceQ;
    private c ceR;
    public boolean pT;

    public static u e(SignAllForumActivity signAllForumActivity) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (ceS == null) {
            ceS = new u(signAllForumActivity);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            ceS = new u(signAllForumActivity);
        }
        return ceS;
    }

    private u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.ceO = null;
        this.ceP = null;
        this.ceQ = null;
        userId = TbadkCoreApplication.getCurrentAccount();
        this.ceP = new s();
    }

    public void a(v vVar) {
        this.ceQ = vVar;
    }

    public void c(c cVar) {
        this.ceR = cVar;
    }

    public c aje() {
        return this.ceR;
    }

    private String ajf() {
        ArrayList<e> aiE = this.ceR.aiE();
        if (aiE == null) {
            return "";
        }
        if (!this.ceR.aiF()) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = aiE.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.aiO() < this.ceR.getLevel()) {
                    arrayList.add(next);
                }
            }
            aiE.removeAll(arrayList);
        }
        int size = aiE.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            e eVar = aiE.get(i);
            if (eVar.aiS()) {
                if (!eVar.aiT()) {
                    eVar.ez(true);
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
        if (this.ceO != null) {
            return false;
        }
        String ajf = ajf();
        this.ceO = new w(this);
        this.ceO.execute(ajf);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.ceO != null) {
            this.ceO.cancel();
            return true;
        }
        return false;
    }
}
