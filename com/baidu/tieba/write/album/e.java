package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private List<com.baidu.tbadk.c.a> RG;
    private int aEX;
    private WriteImagesInfo fhe;
    private List<ImageFileInfo> gAC;
    private List<ImageFileInfo> gAD;
    private String gAE;
    private boolean gAF = false;
    private final AlbumActivity gAh;
    private String gAw;

    public e(AlbumActivity albumActivity) {
        this.gAh = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fhe == null) {
            this.fhe = new WriteImagesInfo();
        }
        this.fhe.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fhe != null) {
            this.fhe.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fhe == null) {
            return false;
        }
        return this.fhe.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> byi() {
        if (this.fhe != null) {
            return this.fhe.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fhe;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fhe = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fhe != null) {
            return this.fhe.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fhe == null) {
            this.fhe = new WriteImagesInfo();
        }
        this.fhe.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fhe != null) {
            return this.fhe.getMaxImagesAllowed();
        }
        return 0;
    }

    public String byj() {
        return this.gAw;
    }

    public void sS(String str) {
        this.gAw = str;
    }

    public List<ImageFileInfo> byk() {
        return this.gAC;
    }

    public void dz(List<ImageFileInfo> list) {
        this.gAC = list;
    }

    public int getCurrentIndex() {
        return this.aEX;
    }

    public void ub(int i) {
        this.aEX = i;
    }

    public List<com.baidu.tbadk.c.a> byl() {
        return this.RG;
    }

    public void dA(List<com.baidu.tbadk.c.a> list) {
        this.RG = list;
    }

    public List<ImageFileInfo> bym() {
        return this.gAD;
    }

    public void dB(List<ImageFileInfo> list) {
        this.gAD = list;
    }

    public int size() {
        if (this.fhe == null) {
            return 0;
        }
        return this.fhe.size();
    }

    public String byn() {
        return this.gAE;
    }

    public void sT(String str) {
        this.gAE = str;
    }

    public void setOriginalImg(boolean z) {
        this.fhe.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fhe.isOriginalImg();
    }

    public void na(boolean z) {
        this.gAF = z;
    }

    public List<m> byo() {
        List<ImageFileInfo> list = this.gAC;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            m mVar = new m();
            mVar.setType(0);
            arrayList.add(mVar);
        }
        int u = u.u(list);
        for (int i2 = 0; i2 < u; i2++) {
            m mVar2 = new m();
            mVar2.setType(2);
            mVar2.b(list.get(i2));
            arrayList.add(mVar2);
        }
        int ah = ((((com.baidu.adp.lib.util.k.ah(this.gAh.getPageContext().getPageActivity()) - this.gAh.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.k.ag(this.gAh.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
        if (ah <= 0) {
            ah = u % 3 == 0 ? 0 : 3 - (u % 3);
        }
        int i3 = ah + 3;
        for (int i4 = 0; i4 < i3; i4++) {
            m mVar3 = new m();
            mVar3.setType(1);
            arrayList.add(mVar3);
        }
        return arrayList;
    }
}
