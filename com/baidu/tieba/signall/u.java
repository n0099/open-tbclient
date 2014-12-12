package com.baidu.tieba.signall;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static u bPY;
    private static String userId;
    private w bPU;
    private s bPV;
    private v bPW;
    private b bPX;
    public boolean ez;

    public static u e(SignAllForumActivity signAllForumActivity) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (bPY == null) {
            bPY = new u(signAllForumActivity);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            bPY = new u(signAllForumActivity);
        }
        return bPY;
    }

    private u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.bPU = null;
        this.bPV = null;
        this.bPW = null;
        userId = TbadkCoreApplication.getCurrentAccount();
        this.bPV = new s();
    }

    public void a(v vVar) {
        this.bPW = vVar;
    }

    public void c(b bVar) {
        this.bPX = bVar;
    }

    public b adz() {
        return this.bPX;
    }

    private String adA() {
        ArrayList<d> acY = this.bPX.acY();
        if (acY == null) {
            return "";
        }
        if (!this.bPX.acZ()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = acY.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.adi() < this.bPX.getLevel()) {
                    arrayList.add(next);
                }
            }
            acY.removeAll(arrayList);
        }
        int size = acY.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = acY.get(i);
            if (dVar.adm()) {
                if (!dVar.adn()) {
                    dVar.em(true);
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
        if (this.bPU != null) {
            return false;
        }
        String adA = adA();
        this.bPU = new w(this);
        this.bPU.execute(adA);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bPU != null) {
            this.bPU.cancel();
            return true;
        }
        return false;
    }
}
