package com.baidu.tieba.signall;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static u bRI;
    private static String userId;
    private w bRE;
    private s bRF;
    private v bRG;
    private b bRH;
    public boolean eB;

    public static u e(SignAllForumActivity signAllForumActivity) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (bRI == null) {
            bRI = new u(signAllForumActivity);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            bRI = new u(signAllForumActivity);
        }
        return bRI;
    }

    private u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.bRE = null;
        this.bRF = null;
        this.bRG = null;
        userId = TbadkCoreApplication.getCurrentAccount();
        this.bRF = new s();
    }

    public void a(v vVar) {
        this.bRG = vVar;
    }

    public void c(b bVar) {
        this.bRH = bVar;
    }

    public b aed() {
        return this.bRH;
    }

    private String aee() {
        ArrayList<d> adC = this.bRH.adC();
        if (adC == null) {
            return "";
        }
        if (!this.bRH.adD()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = adC.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.adM() < this.bRH.getLevel()) {
                    arrayList.add(next);
                }
            }
            adC.removeAll(arrayList);
        }
        int size = adC.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = adC.get(i);
            if (dVar.adQ()) {
                if (!dVar.adR()) {
                    dVar.et(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(dVar.getForumId());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bRE != null) {
            return false;
        }
        String aee = aee();
        this.bRE = new w(this);
        this.bRE.execute(aee);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bRE != null) {
            this.bRE.cancel();
            return true;
        }
        return false;
    }
}
