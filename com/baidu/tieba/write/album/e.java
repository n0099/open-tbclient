package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private List<com.baidu.tbadk.c.a> Qi;
    private int aDH;
    private WriteImagesInfo ffS;
    private final AlbumActivity gyW;
    private String gzl;
    private List<ImageFileInfo> gzr;
    private List<ImageFileInfo> gzs;
    private String gzt;
    private boolean gzu = false;

    public e(AlbumActivity albumActivity) {
        this.gyW = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ffS == null) {
            this.ffS = new WriteImagesInfo();
        }
        this.ffS.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ffS != null) {
            this.ffS.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.ffS == null) {
            return false;
        }
        return this.ffS.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> byb() {
        if (this.ffS != null) {
            return this.ffS.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.ffS;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.ffS = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.ffS != null) {
            return this.ffS.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.ffS == null) {
            this.ffS = new WriteImagesInfo();
        }
        this.ffS.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.ffS != null) {
            return this.ffS.getMaxImagesAllowed();
        }
        return 0;
    }

    public String byc() {
        return this.gzl;
    }

    public void sN(String str) {
        this.gzl = str;
    }

    public List<ImageFileInfo> byd() {
        return this.gzr;
    }

    public void dz(List<ImageFileInfo> list) {
        this.gzr = list;
    }

    public int getCurrentIndex() {
        return this.aDH;
    }

    public void ub(int i) {
        this.aDH = i;
    }

    public List<com.baidu.tbadk.c.a> bye() {
        return this.Qi;
    }

    public void dA(List<com.baidu.tbadk.c.a> list) {
        this.Qi = list;
    }

    public List<ImageFileInfo> byf() {
        return this.gzs;
    }

    public void dB(List<ImageFileInfo> list) {
        this.gzs = list;
    }

    public int size() {
        if (this.ffS == null) {
            return 0;
        }
        return this.ffS.size();
    }

    public String byg() {
        return this.gzt;
    }

    public void sO(String str) {
        this.gzt = str;
    }

    public void setOriginalImg(boolean z) {
        this.ffS.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.ffS.isOriginalImg();
    }

    public void na(boolean z) {
        this.gzu = z;
    }

    public List<m> byh() {
        List<ImageFileInfo> list = this.gzr;
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
        int ag = ((((com.baidu.adp.lib.util.k.ag(this.gyW.getPageContext().getPageActivity()) - this.gyW.getResources().getDimensionPixelSize(d.f.ds300)) / (com.baidu.adp.lib.util.k.af(this.gyW.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
        if (ag <= 0) {
            ag = u % 3 == 0 ? 0 : 3 - (u % 3);
        }
        int i3 = ag + 3;
        for (int i4 = 0; i4 < i3; i4++) {
            m mVar3 = new m();
            mVar3.setType(1);
            arrayList.add(mVar3);
        }
        return arrayList;
    }
}
