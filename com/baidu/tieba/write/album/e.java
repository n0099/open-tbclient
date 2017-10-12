package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private List<com.baidu.tbadk.b.a> QX;
    private int aDG;
    private String ckn;
    private WriteImagesInfo fdA;
    private final AlbumActivity gGM;
    private List<ImageFileInfo> gHd;
    private List<ImageFileInfo> gHe;
    private String gHf;
    private boolean gHg = false;

    public e(AlbumActivity albumActivity) {
        this.gGM = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fdA == null) {
            this.fdA = new WriteImagesInfo();
        }
        this.fdA.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fdA != null) {
            this.fdA.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fdA == null) {
            return false;
        }
        return this.fdA.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bzy() {
        if (this.fdA != null) {
            return this.fdA.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fdA;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fdA = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fdA != null) {
            return this.fdA.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fdA == null) {
            this.fdA = new WriteImagesInfo();
        }
        this.fdA.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fdA != null) {
            return this.fdA.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bzz() {
        return this.ckn;
    }

    public void ta(String str) {
        this.ckn = str;
    }

    public List<ImageFileInfo> bzA() {
        return this.gHd;
    }

    public void dE(List<ImageFileInfo> list) {
        this.gHd = list;
    }

    public int getCurrentIndex() {
        return this.aDG;
    }

    public void setCurrentIndex(int i) {
        this.aDG = i;
    }

    public List<com.baidu.tbadk.b.a> bzB() {
        return this.QX;
    }

    public void dF(List<com.baidu.tbadk.b.a> list) {
        this.QX = list;
    }

    public List<ImageFileInfo> bzC() {
        return this.gHe;
    }

    public void dG(List<ImageFileInfo> list) {
        this.gHe = list;
    }

    public int size() {
        if (this.fdA == null) {
            return 0;
        }
        return this.fdA.size();
    }

    public String bzD() {
        return this.gHf;
    }

    public void tb(String str) {
        this.gHf = str;
    }

    public void setOriginalImg(boolean z) {
        this.fdA.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fdA.isOriginalImg();
    }

    public void nq(boolean z) {
        this.gHg = z;
    }

    public List<m> bzE() {
        List<ImageFileInfo> list = this.gHd;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            m mVar = new m();
            mVar.setType(0);
            arrayList.add(mVar);
        }
        int t = v.t(list);
        for (int i2 = 0; i2 < t; i2++) {
            m mVar2 = new m();
            mVar2.setType(2);
            mVar2.h(list.get(i2));
            arrayList.add(mVar2);
        }
        int af = ((((com.baidu.adp.lib.util.l.af(this.gGM.getPageContext().getPageActivity()) - this.gGM.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.l.ad(this.gGM.getPageContext().getPageActivity()) / 3)) + 1) * 3) - t;
        if (af <= 0) {
            af = t % 3 == 0 ? 0 : 3 - (t % 3);
        }
        int i3 = af + 3;
        for (int i4 = 0; i4 < i3; i4++) {
            m mVar3 = new m();
            mVar3.setType(1);
            arrayList.add(mVar3);
        }
        return arrayList;
    }
}
