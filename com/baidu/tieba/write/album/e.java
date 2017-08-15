package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private List<com.baidu.tbadk.c.a> RI;
    private int aEY;
    private WriteImagesInfo fiZ;
    private final AlbumActivity gBZ;
    private String gCo;
    private List<ImageFileInfo> gCu;
    private List<ImageFileInfo> gCv;
    private String gCw;
    private boolean gCx = false;

    public e(AlbumActivity albumActivity) {
        this.gBZ = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fiZ == null) {
            this.fiZ = new WriteImagesInfo();
        }
        this.fiZ.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fiZ != null) {
            this.fiZ.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fiZ == null) {
            return false;
        }
        return this.fiZ.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> byP() {
        if (this.fiZ != null) {
            return this.fiZ.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fiZ;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fiZ = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fiZ != null) {
            return this.fiZ.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fiZ == null) {
            this.fiZ = new WriteImagesInfo();
        }
        this.fiZ.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fiZ != null) {
            return this.fiZ.getMaxImagesAllowed();
        }
        return 0;
    }

    public String byQ() {
        return this.gCo;
    }

    public void sU(String str) {
        this.gCo = str;
    }

    public List<ImageFileInfo> byR() {
        return this.gCu;
    }

    public void dC(List<ImageFileInfo> list) {
        this.gCu = list;
    }

    public int getCurrentIndex() {
        return this.aEY;
    }

    public void setCurrentIndex(int i) {
        this.aEY = i;
    }

    public List<com.baidu.tbadk.c.a> byS() {
        return this.RI;
    }

    public void dD(List<com.baidu.tbadk.c.a> list) {
        this.RI = list;
    }

    public List<ImageFileInfo> byT() {
        return this.gCv;
    }

    public void dE(List<ImageFileInfo> list) {
        this.gCv = list;
    }

    public int size() {
        if (this.fiZ == null) {
            return 0;
        }
        return this.fiZ.size();
    }

    public String byU() {
        return this.gCw;
    }

    public void sV(String str) {
        this.gCw = str;
    }

    public void setOriginalImg(boolean z) {
        this.fiZ.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fiZ.isOriginalImg();
    }

    public void nd(boolean z) {
        this.gCx = z;
    }

    public List<m> byV() {
        List<ImageFileInfo> list = this.gCu;
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
        int ah = ((((com.baidu.adp.lib.util.k.ah(this.gBZ.getPageContext().getPageActivity()) - this.gBZ.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.k.ag(this.gBZ.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
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
