package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int aBR;
    private WriteImagesInfo eDm;
    private final AlbumActivity fMV;
    private List<d> fNi;
    private String fNq;
    private List<ImageFileInfo> fNw;
    private List<ImageFileInfo> fNx;
    private String fNy;
    private boolean fNz = false;

    public o(AlbumActivity albumActivity) {
        this.fMV = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eDm == null) {
            this.eDm = new WriteImagesInfo();
        }
        this.eDm.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eDm != null) {
            this.eDm.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eDm == null) {
            return false;
        }
        return this.eDm.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bnC() {
        if (this.eDm != null) {
            return this.eDm.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eDm;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eDm = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eDm != null) {
            return this.eDm.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eDm == null) {
            this.eDm = new WriteImagesInfo();
        }
        this.eDm.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eDm != null) {
            return this.eDm.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bnD() {
        return this.fNq;
    }

    public void qZ(String str) {
        this.fNq = str;
    }

    public List<ImageFileInfo> bnE() {
        return this.fNw;
    }

    public void cX(List<ImageFileInfo> list) {
        this.fNw = list;
    }

    public int getCurrentIndex() {
        return this.aBR;
    }

    public void sK(int i) {
        this.aBR = i;
    }

    public List<d> bnF() {
        return this.fNi;
    }

    public void cY(List<d> list) {
        this.fNi = list;
    }

    public List<ImageFileInfo> bnG() {
        return this.fNx;
    }

    public void cZ(List<ImageFileInfo> list) {
        this.fNx = list;
    }

    public int size() {
        if (this.eDm == null) {
            return 0;
        }
        return this.eDm.size();
    }

    public String bnH() {
        return this.fNy;
    }

    public void ra(String str) {
        this.fNy = str;
    }

    public void setOriginalImg(boolean z) {
        this.eDm.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eDm.isOriginalImg();
    }

    public boolean bnI() {
        return this.fNz;
    }

    public void lI(boolean z) {
        this.fNz = z;
    }
}
