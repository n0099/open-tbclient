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
    private int aEn;
    private WriteImagesInfo fij;
    private final AlbumActivity gBF;
    private String gBU;
    private List<ImageFileInfo> gCa;
    private List<ImageFileInfo> gCb;
    private String gCc;
    private boolean gCd = false;

    public e(AlbumActivity albumActivity) {
        this.gBF = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fij == null) {
            this.fij = new WriteImagesInfo();
        }
        this.fij.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fij != null) {
            this.fij.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fij == null) {
            return false;
        }
        return this.fij.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> byj() {
        if (this.fij != null) {
            return this.fij.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fij;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fij = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fij != null) {
            return this.fij.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fij == null) {
            this.fij = new WriteImagesInfo();
        }
        this.fij.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fij != null) {
            return this.fij.getMaxImagesAllowed();
        }
        return 0;
    }

    public String byk() {
        return this.gBU;
    }

    public void sW(String str) {
        this.gBU = str;
    }

    public List<ImageFileInfo> byl() {
        return this.gCa;
    }

    public void dB(List<ImageFileInfo> list) {
        this.gCa = list;
    }

    public int getCurrentIndex() {
        return this.aEn;
    }

    public void setCurrentIndex(int i) {
        this.aEn = i;
    }

    public List<com.baidu.tbadk.c.a> bym() {
        return this.QK;
    }

    public void dC(List<com.baidu.tbadk.c.a> list) {
        this.QK = list;
    }

    public List<ImageFileInfo> byn() {
        return this.gCb;
    }

    public void dD(List<ImageFileInfo> list) {
        this.gCb = list;
    }

    public int size() {
        if (this.fij == null) {
            return 0;
        }
        return this.fij.size();
    }

    public String byo() {
        return this.gCc;
    }

    public void sX(String str) {
        this.gCc = str;
    }

    public void setOriginalImg(boolean z) {
        this.fij.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fij.isOriginalImg();
    }

    public void nk(boolean z) {
        this.gCd = z;
    }

    public List<m> byp() {
        List<ImageFileInfo> list = this.gCa;
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
        int af = ((((com.baidu.adp.lib.util.k.af(this.gBF.getPageContext().getPageActivity()) - this.gBF.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.k.ae(this.gBF.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
        if (af <= 0) {
            af = u % 3 == 0 ? 0 : 3 - (u % 3);
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
