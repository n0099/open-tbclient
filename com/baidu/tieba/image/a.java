package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bf;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aCQ;
    private ArrayList<String> brg;
    private String bri;
    private String brj;
    private boolean brp;
    private String brh = null;
    private String Uv = null;
    private boolean brk = false;
    private boolean brl = true;
    private b brm = null;
    private int brn = 0;
    private boolean bro = false;
    private c brq = null;
    private HashMap<String, String> brr = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.brg = null;
        this.bri = null;
        this.aCQ = null;
        this.brj = null;
        this.brp = false;
        this.brg = arrayList;
        if (this.brg == null) {
            this.brg = new ArrayList<>();
        }
        int size = this.brg.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.brg.get(i);
            this.brr.put(hv(str4), str4);
        }
        this.bri = str2;
        this.aCQ = str;
        this.brj = str3;
        if (this.brj == null) {
            this.brp = true;
        }
    }

    public void dn(boolean z) {
        this.brl = z;
    }

    public void TQ() {
        if (!this.brk && !this.brp) {
            c(this.bri, this.brj, 10, 0);
        }
    }

    public void TR() {
        if (!this.brp) {
            if (!this.brk) {
                TQ();
            } else if (this.brh != null && this.brh.length() > 0) {
                this.brl = true;
                c(this.brh, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.brm != null) {
            if (str2 == null || !str2.equals(this.brm.getPicId())) {
                this.brm.cancel();
            } else {
                return;
            }
        }
        this.brm = new b(this, str, str2, i, i2);
        this.brm.setPriority(3);
        this.brm.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.brq = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.Aq() != null && dVar.Aq().length() > 0) {
            return dVar.Aq();
        }
        StringBuilder sb = new StringBuilder(150);
        if (dVar.getHeight() * dVar.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (dVar.getHeight() * dVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (dVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * dVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(dVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(dVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(bf.aE(dVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hv(String str) {
        int lastIndexOf;
        int indexOf;
        String aF = bf.aF(str);
        if (aF != null) {
            if (aF.indexOf(".baidu.com") != -1 && (lastIndexOf = aF.lastIndexOf("/")) != -1 && (indexOf = aF.indexOf(".", lastIndexOf)) != -1) {
                return aF.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aF;
    }
}
