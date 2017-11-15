package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private List<com.baidu.tbadk.b.a> Ra;
    private int aEm;
    private String crP;
    private WriteImagesInfo flZ;
    private final AlbumActivity gRD;
    private List<ImageFileInfo> gRU;
    private List<ImageFileInfo> gRV;
    private String gRW;
    private boolean gRX = false;

    public e(AlbumActivity albumActivity) {
        this.gRD = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.flZ == null) {
            this.flZ = new WriteImagesInfo();
        }
        this.flZ.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.flZ != null) {
            this.flZ.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.flZ == null) {
            return false;
        }
        return this.flZ.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bDc() {
        if (this.flZ != null) {
            return this.flZ.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.flZ;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.flZ = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.flZ != null) {
            return this.flZ.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.flZ == null) {
            this.flZ = new WriteImagesInfo();
        }
        this.flZ.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.flZ != null) {
            return this.flZ.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bDd() {
        return this.crP;
    }

    public void tS(String str) {
        this.crP = str;
    }

    public List<ImageFileInfo> bDe() {
        return this.gRU;
    }

    public void dH(List<ImageFileInfo> list) {
        this.gRU = list;
    }

    public int getCurrentIndex() {
        return this.aEm;
    }

    public void setCurrentIndex(int i) {
        this.aEm = i;
    }

    public List<com.baidu.tbadk.b.a> bDf() {
        return this.Ra;
    }

    public void dI(List<com.baidu.tbadk.b.a> list) {
        this.Ra = list;
    }

    public List<ImageFileInfo> bDg() {
        return this.gRV;
    }

    public void dJ(List<ImageFileInfo> list) {
        this.gRV = list;
    }

    public int size() {
        if (this.flZ == null) {
            return 0;
        }
        return this.flZ.size();
    }

    public String bDh() {
        return this.gRW;
    }

    public void tT(String str) {
        this.gRW = str;
    }

    public void setOriginalImg(boolean z) {
        this.flZ.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.flZ.isOriginalImg();
    }

    public void nv(boolean z) {
        this.gRX = z;
    }

    public List<m> bDi() {
        List<ImageFileInfo> list = this.gRU;
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
            mVar2.h(list.get(i2));
            arrayList.add(mVar2);
        }
        int ae = ((((com.baidu.adp.lib.util.l.ae(this.gRD.getPageContext().getPageActivity()) - this.gRD.getResources().getDimensionPixelSize(d.e.ds300)) / (com.baidu.adp.lib.util.l.ac(this.gRD.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
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
