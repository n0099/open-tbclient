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
    private WriteImagesInfo fdB;
    private final AlbumActivity gGN;
    private List<ImageFileInfo> gHe;
    private List<ImageFileInfo> gHf;
    private String gHg;
    private boolean gHh = false;

    public e(AlbumActivity albumActivity) {
        this.gGN = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fdB == null) {
            this.fdB = new WriteImagesInfo();
        }
        this.fdB.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fdB != null) {
            this.fdB.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fdB == null) {
            return false;
        }
        return this.fdB.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bzz() {
        if (this.fdB != null) {
            return this.fdB.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fdB;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fdB = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fdB != null) {
            return this.fdB.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fdB == null) {
            this.fdB = new WriteImagesInfo();
        }
        this.fdB.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fdB != null) {
            return this.fdB.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bzA() {
        return this.ckn;
    }

    public void ta(String str) {
        this.ckn = str;
    }

    public List<ImageFileInfo> bzB() {
        return this.gHe;
    }

    public void dE(List<ImageFileInfo> list) {
        this.gHe = list;
    }

    public int getCurrentIndex() {
        return this.aDG;
    }

    public void setCurrentIndex(int i) {
        this.aDG = i;
    }

    public List<com.baidu.tbadk.b.a> bzC() {
        return this.QX;
    }

    public void dF(List<com.baidu.tbadk.b.a> list) {
        this.QX = list;
    }

    public List<ImageFileInfo> bzD() {
        return this.gHf;
    }

    public void dG(List<ImageFileInfo> list) {
        this.gHf = list;
    }

    public int size() {
        if (this.fdB == null) {
            return 0;
        }
        return this.fdB.size();
    }

    public String bzE() {
        return this.gHg;
    }

    public void tb(String str) {
        this.gHg = str;
    }

    public void setOriginalImg(boolean z) {
        this.fdB.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fdB.isOriginalImg();
    }

    public void nq(boolean z) {
        this.gHh = z;
    }

    public List<m> bzF() {
        List<ImageFileInfo> list = this.gHe;
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
        int af = ((((com.baidu.adp.lib.util.l.af(this.gGN.getPageContext().getPageActivity()) - this.gGN.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.l.ad(this.gGN.getPageContext().getPageActivity()) / 3)) + 1) * 3) - t;
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
