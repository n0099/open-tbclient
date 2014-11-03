package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.data.v;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aAx;
    private boolean bkC;
    private ArrayList<String> bkt;
    private String bkv;
    private String bkw;
    private String bku = null;
    private String Od = null;
    private boolean bkx = false;
    private boolean bky = true;
    private b bkz = null;
    private int bkA = 0;
    private boolean bkB = false;
    private c bkD = null;
    private HashMap<String, String> bkE = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bkt = null;
        this.bkv = null;
        this.aAx = null;
        this.bkw = null;
        this.bkC = false;
        this.bkt = arrayList;
        if (this.bkt == null) {
            this.bkt = new ArrayList<>();
        }
        int size = this.bkt.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bkt.get(i);
            this.bkE.put(gJ(str4), str4);
        }
        this.bkv = str2;
        this.aAx = str;
        this.bkw = str3;
        if (this.bkw == null) {
            this.bkC = true;
        }
    }

    public void dv(boolean z) {
        this.bky = z;
    }

    public void Sc() {
        if (!this.bkx && !this.bkC) {
            c(this.bkv, this.bkw, 10, 0);
        }
    }

    public void Sd() {
        if (!this.bkC) {
            if (!this.bkx) {
                Sc();
            } else if (this.bku != null && this.bku.length() > 0) {
                this.bky = true;
                c(this.bku, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bkz != null) {
            if (str2 == null || !str2.equals(this.bkz.getPicId())) {
                this.bkz.cancel();
            } else {
                return;
            }
        }
        this.bkz = new b(this, str, str2, i, i2);
        this.bkz.setPriority(3);
        this.bkz.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.bkD = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(v vVar) {
        if (vVar.vL() != null && vVar.vL().length() > 0) {
            return vVar.vL();
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
        sb.append(az.aC(vVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gJ(String str) {
        int lastIndexOf;
        int indexOf;
        String aD = az.aD(str);
        if (aD != null) {
            if (aD.indexOf(".baidu.com") != -1 && (lastIndexOf = aD.lastIndexOf("/")) != -1 && (indexOf = aD.indexOf(".", lastIndexOf)) != -1) {
                return aD.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aD;
    }
}
