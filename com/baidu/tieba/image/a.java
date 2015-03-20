package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bd;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aIK;
    private ArrayList<String> btO;
    private String btQ;
    private String btR;
    private boolean btX;
    private String btP = null;
    private String aev = null;
    private boolean btS = false;
    private boolean btT = true;
    private b btU = null;
    private int btV = 0;
    private boolean btW = false;
    private c btY = null;
    private HashMap<String, String> btZ = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.btO = null;
        this.btQ = null;
        this.aIK = null;
        this.btR = null;
        this.btX = false;
        this.btO = arrayList;
        if (this.btO == null) {
            this.btO = new ArrayList<>();
        }
        int size = this.btO.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.btO.get(i);
            this.btZ.put(hp(str4), str4);
        }
        this.btQ = str2;
        this.aIK = str;
        this.btR = str3;
        if (this.btR == null) {
            this.btX = true;
        }
    }

    public void dm(boolean z) {
        this.btT = z;
    }

    public void VK() {
        if (!this.btS && !this.btX) {
            c(this.btQ, this.btR, 10, 0);
        }
    }

    public void VL() {
        if (!this.btX) {
            if (!this.btS) {
                VK();
            } else if (this.btP != null && this.btP.length() > 0) {
                this.btT = true;
                c(this.btP, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.btU != null) {
            if (str2 == null || !str2.equals(this.btU.getPicId())) {
                this.btU.cancel();
            } else {
                return;
            }
        }
        this.btU = new b(this, str, str2, i, i2);
        this.btU.setPriority(3);
        this.btU.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.btY = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.DG() != null && dVar.DG().length() > 0) {
            return dVar.DG();
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
        sb.append(bd.aM(dVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hp(String str) {
        int lastIndexOf;
        int indexOf;
        String aN = bd.aN(str);
        if (aN != null) {
            if (aN.indexOf(".baidu.com") != -1 && (lastIndexOf = aN.lastIndexOf("/")) != -1 && (indexOf = aN.indexOf(".", lastIndexOf)) != -1) {
                return aN.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aN;
    }
}
