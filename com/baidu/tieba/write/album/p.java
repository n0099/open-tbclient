package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private int aBF;
    private WriteImagesInfo eJC;
    private final AlbumActivity fTN;
    private List<e> fUh;
    private String fUp;
    private List<ImageFileInfo> fUv;
    private List<ImageFileInfo> fUw;
    private String fUx;
    private boolean fUy = false;

    public p(AlbumActivity albumActivity) {
        this.fTN = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eJC == null) {
            this.eJC = new WriteImagesInfo();
        }
        this.eJC.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eJC != null) {
            this.eJC.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eJC == null) {
            return false;
        }
        return this.eJC.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bnN() {
        if (this.eJC != null) {
            return this.eJC.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eJC;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eJC = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eJC != null) {
            return this.eJC.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eJC == null) {
            this.eJC = new WriteImagesInfo();
        }
        this.eJC.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eJC != null) {
            return this.eJC.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bnO() {
        return this.fUp;
    }

    public void rh(String str) {
        this.fUp = str;
    }

    public List<ImageFileInfo> bnP() {
        return this.fUv;
    }

    public void cP(List<ImageFileInfo> list) {
        this.fUv = list;
    }

    public int getCurrentIndex() {
        return this.aBF;
    }

    public void te(int i) {
        this.aBF = i;
    }

    public List<e> bnQ() {
        return this.fUh;
    }

    public void cQ(List<e> list) {
        this.fUh = list;
    }

    public List<ImageFileInfo> bnR() {
        return this.fUw;
    }

    public void cR(List<ImageFileInfo> list) {
        this.fUw = list;
    }

    public int size() {
        if (this.eJC == null) {
            return 0;
        }
        return this.eJC.size();
    }

    public String bnS() {
        return this.fUx;
    }

    public void ri(String str) {
        this.fUx = str;
    }

    public void setOriginalImg(boolean z) {
        this.eJC.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eJC.isOriginalImg();
    }

    public void lT(boolean z) {
        this.fUy = z;
    }

    public List<ay> bnT() {
        List<ImageFileInfo> list = this.fUv;
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
        int ag = ((((com.baidu.adp.lib.util.k.ag(this.fTN.getPageContext().getPageActivity()) - this.fTN.getResources().getDimensionPixelSize(w.f.ds300)) / (com.baidu.adp.lib.util.k.af(this.fTN.getPageContext().getPageActivity()) / 3)) + 1) * 3) - q;
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
