package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int axF;
    private WriteImagesInfo eOt;
    private String fPB;
    private List<ImageFileInfo> fPC;
    private List<d> fPD;
    private final AlbumActivity gjT;
    private List<ImageFileInfo> gko;
    private String gkp;
    private boolean gkq = false;

    public o(AlbumActivity albumActivity) {
        this.gjT = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eOt == null) {
            this.eOt = new WriteImagesInfo();
        }
        this.eOt.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eOt != null) {
            this.eOt.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eOt == null) {
            return false;
        }
        return this.eOt.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> buN() {
        if (this.eOt != null) {
            return this.eOt.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eOt;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eOt = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eOt != null) {
            return this.eOt.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eOt == null) {
            this.eOt = new WriteImagesInfo();
        }
        this.eOt.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eOt != null) {
            return this.eOt.getMaxImagesAllowed();
        }
        return 0;
    }

    public String buO() {
        return this.fPB;
    }

    public void sR(String str) {
        this.fPB = str;
    }

    public List<ImageFileInfo> buP() {
        return this.fPC;
    }

    public void dB(List<ImageFileInfo> list) {
        this.fPC = list;
    }

    public int getCurrentIndex() {
        return this.axF;
    }

    public void tD(int i) {
        this.axF = i;
    }

    public List<d> bpH() {
        return this.fPD;
    }

    public void dC(List<d> list) {
        this.fPD = list;
    }

    public List<ImageFileInfo> buQ() {
        return this.gko;
    }

    public void dD(List<ImageFileInfo> list) {
        this.gko = list;
    }

    public int size() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    public String buR() {
        return this.gkp;
    }

    public void sS(String str) {
        this.gkp = str;
    }

    public void setOriginalImg(boolean z) {
        this.eOt.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eOt.isOriginalImg();
    }

    public boolean buS() {
        return this.gkq;
    }

    public void mi(boolean z) {
        this.gkq = z;
    }
}
