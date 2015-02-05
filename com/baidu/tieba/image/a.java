package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bf;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aCN;
    private ArrayList<String> brf;
    private String brh;
    private String bri;
    private boolean bro;
    private String brg = null;
    private String Us = null;
    private boolean brj = false;
    private boolean brk = true;
    private b brl = null;
    private int brm = 0;
    private boolean brn = false;
    private c brp = null;
    private HashMap<String, String> brq = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.brf = null;
        this.brh = null;
        this.aCN = null;
        this.bri = null;
        this.bro = false;
        this.brf = arrayList;
        if (this.brf == null) {
            this.brf = new ArrayList<>();
        }
        int size = this.brf.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.brf.get(i);
            this.brq.put(hs(str4), str4);
        }
        this.brh = str2;
        this.aCN = str;
        this.bri = str3;
        if (this.bri == null) {
            this.bro = true;
        }
    }

    public void dn(boolean z) {
        this.brk = z;
    }

    public void TL() {
        if (!this.brj && !this.bro) {
            c(this.brh, this.bri, 10, 0);
        }
    }

    public void TM() {
        if (!this.bro) {
            if (!this.brj) {
                TL();
            } else if (this.brg != null && this.brg.length() > 0) {
                this.brk = true;
                c(this.brg, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.brl != null) {
            if (str2 == null || !str2.equals(this.brl.getPicId())) {
                this.brl.cancel();
            } else {
                return;
            }
        }
        this.brl = new b(this, str, str2, i, i2);
        this.brl.setPriority(3);
        this.brl.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.brp = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.Ak() != null && dVar.Ak().length() > 0) {
            return dVar.Ak();
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
    public String hs(String str) {
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
