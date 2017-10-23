package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private List<com.baidu.tbadk.b.a> QK;
    private int aDt;
    private String ckb;
    private WriteImagesInfo fdm;
    private List<ImageFileInfo> gGO;
    private List<ImageFileInfo> gGP;
    private String gGQ;
    private boolean gGR = false;
    private final AlbumActivity gGx;

    public e(AlbumActivity albumActivity) {
        this.gGx = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fdm == null) {
            this.fdm = new WriteImagesInfo();
        }
        this.fdm.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.fdm != null) {
            this.fdm.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.fdm == null) {
            return false;
        }
        return this.fdm.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bzs() {
        if (this.fdm != null) {
            return this.fdm.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.fdm;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.fdm = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.fdm != null) {
            return this.fdm.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.fdm == null) {
            this.fdm = new WriteImagesInfo();
        }
        this.fdm.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.fdm != null) {
            return this.fdm.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bzt() {
        return this.ckb;
    }

    public void sZ(String str) {
        this.ckb = str;
    }

    public List<ImageFileInfo> bzu() {
        return this.gGO;
    }

    public void dE(List<ImageFileInfo> list) {
        this.gGO = list;
    }

    public int getCurrentIndex() {
        return this.aDt;
    }

    public void setCurrentIndex(int i) {
        this.aDt = i;
    }

    public List<com.baidu.tbadk.b.a> bzv() {
        return this.QK;
    }

    public void dF(List<com.baidu.tbadk.b.a> list) {
        this.QK = list;
    }

    public List<ImageFileInfo> bzw() {
        return this.gGP;
    }

    public void dG(List<ImageFileInfo> list) {
        this.gGP = list;
    }

    public int size() {
        if (this.fdm == null) {
            return 0;
        }
        return this.fdm.size();
    }

    public String bzx() {
        return this.gGQ;
    }

    public void ta(String str) {
        this.gGQ = str;
    }

    public void setOriginalImg(boolean z) {
        this.fdm.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.fdm.isOriginalImg();
    }

    public void np(boolean z) {
        this.gGR = z;
    }

    public List<m> bzy() {
        List<ImageFileInfo> list = this.gGO;
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
        int af = ((((com.baidu.adp.lib.util.l.af(this.gGx.getPageContext().getPageActivity()) - this.gGx.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.l.ad(this.gGx.getPageContext().getPageActivity()) / 3)) + 1) * 3) - t;
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
