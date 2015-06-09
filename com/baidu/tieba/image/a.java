package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bb;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aLc;
    private ArrayList<String> bwO;
    private String bwQ;
    private String bwR;
    private boolean bwX;
    private String bwP = null;
    private String afH = null;
    private boolean bwS = false;
    private boolean bwT = true;
    private b bwU = null;
    private int bwV = 0;
    private boolean bwW = false;
    private c bwY = null;
    private HashMap<String, String> bwZ = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bwO = null;
        this.bwQ = null;
        this.aLc = null;
        this.bwR = null;
        this.bwX = false;
        this.bwO = arrayList;
        if (this.bwO == null) {
            this.bwO = new ArrayList<>();
        }
        int size = this.bwO.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bwO.get(i);
            this.bwZ.put(hV(str4), str4);
        }
        this.bwQ = str2;
        this.aLc = str;
        this.bwR = str3;
        if (this.bwR == null) {
            this.bwX = true;
        }
    }

    public void dw(boolean z) {
        this.bwT = z;
    }

    public void Xq() {
        if (!this.bwS && !this.bwX) {
            c(this.bwQ, this.bwR, 10, 0);
        }
    }

    public void Xr() {
        if (!this.bwX) {
            if (!this.bwS) {
                Xq();
            } else if (this.bwP != null && this.bwP.length() > 0) {
                this.bwT = true;
                c(this.bwP, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bwU != null) {
            if (str2 == null || !str2.equals(this.bwU.getPicId())) {
                this.bwU.cancel();
            } else {
                return;
            }
        }
        this.bwU = new b(this, str, str2, i, i2);
        this.bwU.setPriority(3);
        this.bwU.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.bwY = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.Ex() != null && dVar.Ex().length() > 0) {
            return dVar.Ex();
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
        sb.append(bb.aV(dVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hV(String str) {
        int lastIndexOf;
        int indexOf;
        String aW = bb.aW(str);
        if (aW != null) {
            if (aW.indexOf(".baidu.com") != -1 && (lastIndexOf = aW.lastIndexOf("/")) != -1 && (indexOf = aW.indexOf(".", lastIndexOf)) != -1) {
                return aW.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aW;
    }
}
