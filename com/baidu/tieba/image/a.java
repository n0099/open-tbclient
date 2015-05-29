package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bb;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aLb;
    private ArrayList<String> bwN;
    private String bwP;
    private String bwQ;
    private boolean bwW;
    private String bwO = null;
    private String afH = null;
    private boolean bwR = false;
    private boolean bwS = true;
    private b bwT = null;
    private int bwU = 0;
    private boolean bwV = false;
    private c bwX = null;
    private HashMap<String, String> bwY = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bwN = null;
        this.bwP = null;
        this.aLb = null;
        this.bwQ = null;
        this.bwW = false;
        this.bwN = arrayList;
        if (this.bwN == null) {
            this.bwN = new ArrayList<>();
        }
        int size = this.bwN.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bwN.get(i);
            this.bwY.put(hV(str4), str4);
        }
        this.bwP = str2;
        this.aLb = str;
        this.bwQ = str3;
        if (this.bwQ == null) {
            this.bwW = true;
        }
    }

    public void dw(boolean z) {
        this.bwS = z;
    }

    public void Xp() {
        if (!this.bwR && !this.bwW) {
            c(this.bwP, this.bwQ, 10, 0);
        }
    }

    public void Xq() {
        if (!this.bwW) {
            if (!this.bwR) {
                Xp();
            } else if (this.bwO != null && this.bwO.length() > 0) {
                this.bwS = true;
                c(this.bwO, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bwT != null) {
            if (str2 == null || !str2.equals(this.bwT.getPicId())) {
                this.bwT.cancel();
            } else {
                return;
            }
        }
        this.bwT = new b(this, str, str2, i, i2);
        this.bwT.setPriority(3);
        this.bwT.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.bwX = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.Ew() != null && dVar.Ew().length() > 0) {
            return dVar.Ew();
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
