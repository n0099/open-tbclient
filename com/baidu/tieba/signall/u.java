package com.baidu.tieba.signall;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static u bRH;
    private static String userId;
    private w bRD;
    private s bRE;
    private v bRF;
    private b bRG;
    public boolean eB;

    public static u e(SignAllForumActivity signAllForumActivity) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (bRH == null) {
            bRH = new u(signAllForumActivity);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            bRH = new u(signAllForumActivity);
        }
        return bRH;
    }

    private u(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.bRD = null;
        this.bRE = null;
        this.bRF = null;
        userId = TbadkCoreApplication.getCurrentAccount();
        this.bRE = new s();
    }

    public void a(v vVar) {
        this.bRF = vVar;
    }

    public void c(b bVar) {
        this.bRG = bVar;
    }

    public b adY() {
        return this.bRG;
    }

    private String adZ() {
        ArrayList<d> adx = this.bRG.adx();
        if (adx == null) {
            return "";
        }
        if (!this.bRG.ady()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = adx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.adH() < this.bRG.getLevel()) {
                    arrayList.add(next);
                }
            }
            adx.removeAll(arrayList);
        }
        int size = adx.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = adx.get(i);
            if (dVar.adL()) {
                if (!dVar.adM()) {
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
        if (this.bRD != null) {
            return false;
        }
        String adZ = adZ();
        this.bRD = new w(this);
        this.bRD.execute(adZ);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bRD != null) {
            this.bRD.cancel();
            return true;
        }
        return false;
    }
}
