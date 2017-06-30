package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private int aCI;
    private WriteImagesInfo eTt;
    private List<e> geR;
    private String geZ;
    private final AlbumActivity gex;
    private List<ImageFileInfo> gff;
    private List<ImageFileInfo> gfg;
    private String gfh;
    private boolean gfi = false;

    public p(AlbumActivity albumActivity) {
        this.gex = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eTt == null) {
            this.eTt = new WriteImagesInfo();
        }
        this.eTt.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eTt != null) {
            this.eTt.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eTt == null) {
            return false;
        }
        return this.eTt.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bsk() {
        if (this.eTt != null) {
            return this.eTt.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eTt;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eTt = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eTt != null) {
            return this.eTt.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eTt == null) {
            this.eTt = new WriteImagesInfo();
        }
        this.eTt.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eTt != null) {
            return this.eTt.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bsl() {
        return this.geZ;
    }

    public void sg(String str) {
        this.geZ = str;
    }

    public List<ImageFileInfo> bsm() {
        return this.gff;
    }

    public void de(List<ImageFileInfo> list) {
        this.gff = list;
    }

    public int getCurrentIndex() {
        return this.aCI;
    }

    public void tz(int i) {
        this.aCI = i;
    }

    public List<e> bsn() {
        return this.geR;
    }

    public void df(List<e> list) {
        this.geR = list;
    }

    public List<ImageFileInfo> bso() {
        return this.gfg;
    }

    public void dg(List<ImageFileInfo> list) {
        this.gfg = list;
    }

    public int size() {
        if (this.eTt == null) {
            return 0;
        }
        return this.eTt.size();
    }

    public String bsp() {
        return this.gfh;
    }

    public void sh(String str) {
        this.gfh = str;
    }

    public void setOriginalImg(boolean z) {
        this.eTt.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eTt.isOriginalImg();
    }

    public void mu(boolean z) {
        this.gfi = z;
    }

    public List<ay> bsq() {
        List<ImageFileInfo> list = this.gff;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            ay ayVar = new ay();
            ayVar.setType(0);
            arrayList.add(ayVar);
        }
        int s = com.baidu.tbadk.core.util.z.s(list);
        for (int i2 = 0; i2 < s; i2++) {
            ay ayVar2 = new ay();
            ayVar2.setType(2);
            ayVar2.a(list.get(i2));
            arrayList.add(ayVar2);
        }
        int ag = ((((com.baidu.adp.lib.util.k.ag(this.gex.getPageContext().getPageActivity()) - this.gex.getResources().getDimensionPixelSize(w.f.ds300)) / (com.baidu.adp.lib.util.k.af(this.gex.getPageContext().getPageActivity()) / 3)) + 1) * 3) - s;
        if (ag <= 0) {
            ag = s % 3 == 0 ? 0 : 3 - (s % 3);
        }
        int i3 = ag + 3;
        for (int i4 = 0; i4 < i3; i4++) {
            ay ayVar3 = new ay();
            ayVar3.setType(1);
            arrayList.add(ayVar3);
        }
        return arrayList;
    }
}
