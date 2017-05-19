package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private int aBS;
    private WriteImagesInfo eAQ;
    private List<e> fMA;
    private String fMI;
    private List<ImageFileInfo> fMO;
    private List<ImageFileInfo> fMP;
    private String fMQ;
    private boolean fMR = false;
    private final AlbumActivity fMg;

    public p(AlbumActivity albumActivity) {
        this.fMg = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eAQ == null) {
            this.eAQ = new WriteImagesInfo();
        }
        this.eAQ.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eAQ != null) {
            this.eAQ.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eAQ == null) {
            return false;
        }
        return this.eAQ.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bmq() {
        if (this.eAQ != null) {
            return this.eAQ.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eAQ;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eAQ = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eAQ != null) {
            return this.eAQ.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eAQ == null) {
            this.eAQ = new WriteImagesInfo();
        }
        this.eAQ.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eAQ != null) {
            return this.eAQ.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bmr() {
        return this.fMI;
    }

    public void qU(String str) {
        this.fMI = str;
    }

    public List<ImageFileInfo> bms() {
        return this.fMO;
    }

    public void cN(List<ImageFileInfo> list) {
        this.fMO = list;
    }

    public int getCurrentIndex() {
        return this.aBS;
    }

    public void sJ(int i) {
        this.aBS = i;
    }

    public List<e> bmt() {
        return this.fMA;
    }

    public void cO(List<e> list) {
        this.fMA = list;
    }

    public List<ImageFileInfo> bmu() {
        return this.fMP;
    }

    public void cP(List<ImageFileInfo> list) {
        this.fMP = list;
    }

    public int size() {
        if (this.eAQ == null) {
            return 0;
        }
        return this.eAQ.size();
    }

    public String bmv() {
        return this.fMQ;
    }

    public void qV(String str) {
        this.fMQ = str;
    }

    public void setOriginalImg(boolean z) {
        this.eAQ.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eAQ.isOriginalImg();
    }

    public void lA(boolean z) {
        this.fMR = z;
    }

    public List<ay> bmw() {
        List<ImageFileInfo> list = this.fMO;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            ay ayVar = new ay();
            ayVar.setType(0);
            arrayList.add(ayVar);
        }
        int q = com.baidu.tbadk.core.util.x.q(list);
        for (int i2 = 0; i2 < q; i2++) {
            ay ayVar2 = new ay();
            ayVar2.setType(2);
            ayVar2.a(list.get(i2));
            arrayList.add(ayVar2);
        }
        int ag = ((((com.baidu.adp.lib.util.k.ag(this.fMg.getPageContext().getPageActivity()) - this.fMg.getResources().getDimensionPixelSize(w.f.ds300)) / (com.baidu.adp.lib.util.k.af(this.fMg.getPageContext().getPageActivity()) / 3)) + 1) * 3) - q;
        if (ag < 0) {
            ag = q % 3 == 0 ? 0 : 3 - (q % 3);
        }
        for (int i3 = 0; i3 < ag; i3++) {
            ay ayVar3 = new ay();
            ayVar3.setType(1);
            arrayList.add(ayVar3);
        }
        return arrayList;
    }
}
