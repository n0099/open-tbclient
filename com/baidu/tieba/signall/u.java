package com.baidu.tieba.signall;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e {
    private static u bLs;
    private static String userId;
    private w bLo;
    private s bLp;
    private v bLq;
    private b bLr;
    public boolean cs;

    public static u ai(Context context) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (bLs == null) {
            bLs = new u(context);
        } else if (!TextUtils.isEmpty(userId) && !TextUtils.equals(userId, currentAccount)) {
            bLs = new u(context);
        }
        return bLs;
    }

    private u(Context context) {
        super(context);
        this.bLo = null;
        this.bLp = null;
        this.bLq = null;
        userId = TbadkApplication.getCurrentAccount();
        this.bLp = new s();
    }

    public void a(v vVar) {
        this.bLq = vVar;
    }

    public void c(b bVar) {
        this.bLr = bVar;
    }

    public b ada() {
        return this.bLr;
    }

    private String adb() {
        ArrayList<d> acA = this.bLr.acA();
        if (acA == null) {
            return "";
        }
        if (!this.bLr.acB()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = acA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.zz() < this.bLr.getLevel()) {
                    arrayList.add(next);
                }
            }
            acA.removeAll(arrayList);
        }
        int size = acA.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = acA.get(i);
            if (dVar.acN()) {
                if (!dVar.acO()) {
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
        if (this.bLo != null) {
            return false;
        }
        String adb = adb();
        this.bLo = new w(this);
        this.bLo.execute(adb);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bLo != null) {
            this.bLo.cancel();
            return true;
        }
        return false;
    }
}
