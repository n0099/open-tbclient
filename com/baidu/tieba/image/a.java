package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bd;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private String aIS;
    private ArrayList<String> bue;
    private String buh;
    private String bui;
    private boolean buo;
    private String bug = null;
    private String aeD = null;
    private boolean buj = false;
    private boolean buk = true;
    private b bul = null;
    private int bum = 0;
    private boolean bun = false;
    private c bup = null;
    private HashMap<String, String> buq = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bue = null;
        this.buh = null;
        this.aIS = null;
        this.bui = null;
        this.buo = false;
        this.bue = arrayList;
        if (this.bue == null) {
            this.bue = new ArrayList<>();
        }
        int size = this.bue.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bue.get(i);
            this.buq.put(hs(str4), str4);
        }
        this.buh = str2;
        this.aIS = str;
        this.bui = str3;
        if (this.bui == null) {
            this.buo = true;
        }
    }

    public void dk(boolean z) {
        this.buk = z;
    }

    public void VX() {
        if (!this.buj && !this.buo) {
            c(this.buh, this.bui, 10, 0);
        }
    }

    public void VY() {
        if (!this.buo) {
            if (!this.buj) {
                VX();
            } else if (this.bug != null && this.bug.length() > 0) {
                this.buk = true;
                c(this.bug, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bul != null) {
            if (str2 == null || !str2.equals(this.bul.getPicId())) {
                this.bul.cancel();
            } else {
                return;
            }
        }
        this.bul = new b(this, str, str2, i, i2);
        this.bul.setPriority(3);
        this.bul.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.bup = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.DM() != null && dVar.DM().length() > 0) {
            return dVar.DM();
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
    public String hs(String str) {
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
