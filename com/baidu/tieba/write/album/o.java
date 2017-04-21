package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int aBT;
    private WriteImagesInfo eFC;
    private List<d> fPE;
    private String fPM;
    private List<ImageFileInfo> fPS;
    private List<ImageFileInfo> fPT;
    private String fPU;
    private boolean fPV = false;
    private final AlbumActivity fPr;

    public o(AlbumActivity albumActivity) {
        this.fPr = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eFC == null) {
            this.eFC = new WriteImagesInfo();
        }
        this.eFC.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eFC != null) {
            this.eFC.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eFC == null) {
            return false;
        }
        return this.eFC.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> boD() {
        if (this.eFC != null) {
            return this.eFC.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eFC;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eFC = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eFC != null) {
            return this.eFC.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eFC == null) {
            this.eFC = new WriteImagesInfo();
        }
        this.eFC.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eFC != null) {
            return this.eFC.getMaxImagesAllowed();
        }
        return 0;
    }

    public String boE() {
        return this.fPM;
    }

    public void ra(String str) {
        this.fPM = str;
    }

    public List<ImageFileInfo> boF() {
        return this.fPS;
    }

    public void cX(List<ImageFileInfo> list) {
        this.fPS = list;
    }

    public int getCurrentIndex() {
        return this.aBT;
    }

    public void sQ(int i) {
        this.aBT = i;
    }

    public List<d> boG() {
        return this.fPE;
    }

    public void cY(List<d> list) {
        this.fPE = list;
    }

    public List<ImageFileInfo> boH() {
        return this.fPT;
    }

    public void cZ(List<ImageFileInfo> list) {
        this.fPT = list;
    }

    public int size() {
        if (this.eFC == null) {
            return 0;
        }
        return this.eFC.size();
    }

    public String boI() {
        return this.fPU;
    }

    public void rb(String str) {
        this.fPU = str;
    }

    public void setOriginalImg(boolean z) {
        this.eFC.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eFC.isOriginalImg();
    }

    public boolean boJ() {
        return this.fPV;
    }

    public void lS(boolean z) {
        this.fPV = z;
    }
}
