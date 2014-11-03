package com.baidu.tieba.signall;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e {
    private static u bLH;
    private static String userId;
    private w bLD;
    private s bLE;
    private v bLF;
    private b bLG;
    public boolean cs;

    public static u ai(Context context) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (bLH == null) {
            bLH = new u(context);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            bLH = new u(context);
        }
        return bLH;
    }

    private u(Context context) {
        super(context);
        this.bLD = null;
        this.bLE = null;
        this.bLF = null;
        userId = TbadkApplication.getCurrentAccount();
        this.bLE = new s();
    }

    public void a(v vVar) {
        this.bLF = vVar;
    }

    public void c(b bVar) {
        this.bLG = bVar;
    }

    public b add() {
        return this.bLG;
    }

    private String ade() {
        ArrayList<d> acD = this.bLG.acD();
        if (acD == null) {
            return "";
        }
        if (!this.bLG.acE()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = acD.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.zB() < this.bLG.getLevel()) {
                    arrayList.add(next);
                }
            }
            acD.removeAll(arrayList);
        }
        int size = acD.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = acD.get(i);
            if (dVar.acQ()) {
                if (!dVar.acR()) {
                    dVar.eF(true);
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
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.bLD != null) {
            return false;
        }
        String ade = ade();
        this.bLD = new w(this);
        this.bLD.execute(ade);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bLD != null) {
            this.bLD.cancel();
            return true;
        }
        return false;
    }
}
