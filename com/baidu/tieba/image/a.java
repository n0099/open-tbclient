package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.data.v;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aAn;
    private ArrayList<String> bkf;
    private String bkh;
    private String bki;
    private boolean bko;
    private String bkg = null;
    private String NZ = null;
    private boolean bkj = false;
    private boolean bkk = true;
    private b bkl = null;
    private int bkm = 0;
    private boolean bkn = false;
    private c bkp = null;
    private HashMap<String, String> bkq = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bkf = null;
        this.bkh = null;
        this.aAn = null;
        this.bki = null;
        this.bko = false;
        this.bkf = arrayList;
        if (this.bkf == null) {
            this.bkf = new ArrayList<>();
        }
        int size = this.bkf.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bkf.get(i);
            this.bkq.put(gJ(str4), str4);
        }
        this.bkh = str2;
        this.aAn = str;
        this.bki = str3;
        if (this.bki == null) {
            this.bko = true;
        }
    }

    public void dv(boolean z) {
        this.bkk = z;
    }

    public void RZ() {
        if (!this.bkj && !this.bko) {
            c(this.bkh, this.bki, 10, 0);
        }
    }

    public void Sa() {
        if (!this.bko) {
            if (!this.bkj) {
                RZ();
            } else if (this.bkg != null && this.bkg.length() > 0) {
                this.bkk = true;
                c(this.bkg, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bkl != null) {
            if (str2 == null || !str2.equals(this.bkl.getPicId())) {
                this.bkl.cancel();
            } else {
                return;
            }
        }
        this.bkl = new b(this, str, str2, i, i2);
        this.bkl.setPriority(3);
        this.bkl.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.bkp = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(v vVar) {
        if (vVar.vJ() != null && vVar.vJ().length() > 0) {
            return vVar.vJ();
        }
        StringBuilder sb = new StringBuilder(150);
        if (vVar.getHeight() * vVar.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (vVar.getHeight() * vVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (vVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * vVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(vVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(vVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(ay.aC(vVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gJ(String str) {
        int lastIndexOf;
        int indexOf;
        String aD = ay.aD(str);
        if (aD != null) {
            if (aD.indexOf(".baidu.com") != -1 && (lastIndexOf = aD.lastIndexOf("/")) != -1 && (indexOf = aD.indexOf(".", lastIndexOf)) != -1) {
                return aD.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aD;
    }
}
