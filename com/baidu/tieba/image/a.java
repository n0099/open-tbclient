package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aBP;
    private ArrayList<String> bpI;
    private String bpK;
    private String bpL;
    private boolean bpR;
    private String bpJ = null;
    private String TQ = null;
    private boolean bpM = false;
    private boolean bpN = true;
    private b bpO = null;
    private int bpP = 0;
    private boolean bpQ = false;
    private c bpS = null;
    private HashMap<String, String> bpT = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bpI = null;
        this.bpK = null;
        this.aBP = null;
        this.bpL = null;
        this.bpR = false;
        this.bpI = arrayList;
        if (this.bpI == null) {
            this.bpI = new ArrayList<>();
        }
        int size = this.bpI.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bpI.get(i);
            this.bpT.put(ho(str4), str4);
        }
        this.bpK = str2;
        this.aBP = str;
        this.bpL = str3;
        if (this.bpL == null) {
            this.bpR = true;
        }
    }

    public void di(boolean z) {
        this.bpN = z;
    }

    public void Tu() {
        if (!this.bpM && !this.bpR) {
            c(this.bpK, this.bpL, 10, 0);
        }
    }

    public void Tv() {
        if (!this.bpR) {
            if (!this.bpM) {
                Tu();
            } else if (this.bpJ != null && this.bpJ.length() > 0) {
                this.bpN = true;
                c(this.bpJ, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bpO != null) {
            if (str2 == null || !str2.equals(this.bpO.getPicId())) {
                this.bpO.cancel();
            } else {
                return;
            }
        }
        this.bpO = new b(this, str, str2, i, i2);
        this.bpO.setPriority(3);
        this.bpO.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.bpS = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.zW() != null && dVar.zW().length() > 0) {
            return dVar.zW();
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
        sb.append(ba.aE(dVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ho(String str) {
        int lastIndexOf;
        int indexOf;
        String aF = ba.aF(str);
        if (aF != null) {
            if (aF.indexOf(".baidu.com") != -1 && (lastIndexOf = aF.lastIndexOf("/")) != -1 && (indexOf = aF.indexOf(".", lastIndexOf)) != -1) {
                return aF.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aF;
    }
}
