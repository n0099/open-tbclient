package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private List<com.baidu.tbadk.c.a> RJ;
    private int aEZ;
    private WriteImagesInfo fjb;
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
        if (this.fjb == null) {
            this.fjb = new WriteImagesInfo();
        }
        this.fjb.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fjb != null) {
            this.fjb.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fjb == null) {
            return false;
        }
        return this.fjb.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> byH() {
        if (this.fjb != null) {
            return this.fjb.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fjb;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fjb = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fjb != null) {
            return this.fjb.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fjb == null) {
            this.fjb = new WriteImagesInfo();
        }
        this.fjb.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fjb != null) {
            return this.fjb.getMaxImagesAllowed();
        }
        return 0;
    }

    public String byI() {
        return this.gCo;
    }

    public void sZ(String str) {
        this.gCo = str;
    }

    public List<ImageFileInfo> byJ() {
        return this.gCu;
    }

    public void dC(List<ImageFileInfo> list) {
        this.gCu = list;
    }

    public int getCurrentIndex() {
        return this.aEZ;
    }

    public void setCurrentIndex(int i) {
        this.aEZ = i;
    }

    public List<com.baidu.tbadk.c.a> byK() {
        return this.RJ;
    }

    public void dD(List<com.baidu.tbadk.c.a> list) {
        this.RJ = list;
    }

    public List<ImageFileInfo> byL() {
        return this.gCv;
    }

    public void dE(List<ImageFileInfo> list) {
        this.gCv = list;
    }

    public int size() {
        if (this.fjb == null) {
            return 0;
        }
        return this.fjb.size();
    }

    public String byM() {
        return this.gCw;
    }

    public void ta(String str) {
        this.gCw = str;
    }

    public void setOriginalImg(boolean z) {
        this.fjb.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fjb.isOriginalImg();
    }

    public void nd(boolean z) {
        this.gCx = z;
    }

    public List<m> byN() {
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
