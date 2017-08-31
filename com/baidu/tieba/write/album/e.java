package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private List<com.baidu.tbadk.c.a> QK;
    private int aEq;
    private WriteImagesInfo fhp;
    private final AlbumActivity gAM;
    private String gBb;
    private List<ImageFileInfo> gBh;
    private List<ImageFileInfo> gBi;
    private String gBj;
    private boolean gBk = false;

    public e(AlbumActivity albumActivity) {
        this.gAM = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fhp == null) {
            this.fhp = new WriteImagesInfo();
        }
        this.fhp.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fhp != null) {
            this.fhp.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fhp == null) {
            return false;
        }
        return this.fhp.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bxY() {
        if (this.fhp != null) {
            return this.fhp.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fhp;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fhp = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fhp != null) {
            return this.fhp.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fhp == null) {
            this.fhp = new WriteImagesInfo();
        }
        this.fhp.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fhp != null) {
            return this.fhp.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bxZ() {
        return this.gBb;
    }

    public void sU(String str) {
        this.gBb = str;
    }

    public List<ImageFileInfo> bya() {
        return this.gBh;
    }

    public void dA(List<ImageFileInfo> list) {
        this.gBh = list;
    }

    public int getCurrentIndex() {
        return this.aEq;
    }

    public void setCurrentIndex(int i) {
        this.aEq = i;
    }

    public List<com.baidu.tbadk.c.a> byb() {
        return this.QK;
    }

    public void dB(List<com.baidu.tbadk.c.a> list) {
        this.QK = list;
    }

    public List<ImageFileInfo> byc() {
        return this.gBi;
    }

    public void dC(List<ImageFileInfo> list) {
        this.gBi = list;
    }

    public int size() {
        if (this.fhp == null) {
            return 0;
        }
        return this.fhp.size();
    }

    public String byd() {
        return this.gBj;
    }

    public void sV(String str) {
        this.gBj = str;
    }

    public void setOriginalImg(boolean z) {
        this.fhp.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fhp.isOriginalImg();
    }

    public void nj(boolean z) {
        this.gBk = z;
    }

    public List<m> bye() {
        List<ImageFileInfo> list = this.gBh;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            m mVar = new m();
            mVar.setType(0);
            arrayList.add(mVar);
        }
        int u = v.u(list);
        for (int i2 = 0; i2 < u; i2++) {
            m mVar2 = new m();
            mVar2.setType(2);
            mVar2.b(list.get(i2));
            arrayList.add(mVar2);
        }
        int ae = ((((com.baidu.adp.lib.util.k.ae(this.gAM.getPageContext().getPageActivity()) - this.gAM.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.k.ad(this.gAM.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
        if (ae <= 0) {
            ae = u % 3 == 0 ? 0 : 3 - (u % 3);
        }
        int i3 = ae + 3;
        for (int i4 = 0; i4 < i3; i4++) {
            m mVar3 = new m();
            mVar3.setType(1);
            arrayList.add(mVar3);
        }
        return arrayList;
    }
}
