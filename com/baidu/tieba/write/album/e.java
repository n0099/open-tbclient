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
    private int aEe;
    private String crw;
    private WriteImagesInfo flC;
    private List<ImageFileInfo> gQM;
    private List<ImageFileInfo> gQN;
    private String gQO;
    private boolean gQP = false;
    private final AlbumActivity gQv;

    public e(AlbumActivity albumActivity) {
        this.gQv = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.flC == null) {
            this.flC = new WriteImagesInfo();
        }
        this.flC.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.flC != null) {
            this.flC.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.flC == null) {
            return false;
        }
        return this.flC.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bCQ() {
        if (this.flC != null) {
            return this.flC.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.flC;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.flC = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.flC != null) {
            return this.flC.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.flC == null) {
            this.flC = new WriteImagesInfo();
        }
        this.flC.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.flC != null) {
            return this.flC.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bCR() {
        return this.crw;
    }

    public void tM(String str) {
        this.crw = str;
    }

    public List<ImageFileInfo> bCS() {
        return this.gQM;
    }

    public void dG(List<ImageFileInfo> list) {
        this.gQM = list;
    }

    public int getCurrentIndex() {
        return this.aEe;
    }

    public void setCurrentIndex(int i) {
        this.aEe = i;
    }

    public List<com.baidu.tbadk.b.a> bCT() {
        return this.Ra;
    }

    public void dH(List<com.baidu.tbadk.b.a> list) {
        this.Ra = list;
    }

    public List<ImageFileInfo> bCU() {
        return this.gQN;
    }

    public void dI(List<ImageFileInfo> list) {
        this.gQN = list;
    }

    public int size() {
        if (this.flC == null) {
            return 0;
        }
        return this.flC.size();
    }

    public String bCV() {
        return this.gQO;
    }

    public void tN(String str) {
        this.gQO = str;
    }

    public void setOriginalImg(boolean z) {
        this.flC.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.flC.isOriginalImg();
    }

    public void nn(boolean z) {
        this.gQP = z;
    }

    public List<m> bCW() {
        List<ImageFileInfo> list = this.gQM;
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
        int ae = ((((com.baidu.adp.lib.util.l.ae(this.gQv.getPageContext().getPageActivity()) - this.gQv.getResources().getDimensionPixelSize(d.e.ds300)) / (com.baidu.adp.lib.util.l.ac(this.gQv.getPageContext().getPageActivity()) / 3)) + 1) * 3) - u;
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
