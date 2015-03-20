package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private WriteImagesInfo aHD;
    private List<a> ctH;
    private String ctL;
    private List<ImageFileInfo> ctR;
    private List<ImageFileInfo> ctS;
    private String ctT;
    private int mCurrentIndex;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aHD == null) {
            this.aHD = new WriteImagesInfo();
        }
        this.aHD.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aHD != null) {
            this.aHD.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aHD == null) {
            return false;
        }
        return this.aHD.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> apI() {
        if (this.aHD != null) {
            return this.aHD.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.aHD;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.aHD = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aHD != null) {
            return this.aHD.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aHD == null) {
            this.aHD = new WriteImagesInfo();
        }
        this.aHD.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aHD != null) {
            return this.aHD.getMaxImagesAllowed();
        }
        return 0;
    }

    public String apJ() {
        return this.ctL;
    }

    public void jb(String str) {
        this.ctL = str;
    }

    public List<ImageFileInfo> apK() {
        return this.ctR;
    }

    public void aY(List<ImageFileInfo> list) {
        this.ctR = list;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    public List<a> apL() {
        return this.ctH;
    }

    public void aZ(List<a> list) {
        this.ctH = list;
    }

    public List<ImageFileInfo> apM() {
        return this.ctS;
    }

    public void ba(List<ImageFileInfo> list) {
        this.ctS = list;
    }

    public int size() {
        if (this.aHD == null) {
            return 0;
        }
        return this.aHD.size();
    }

    public String apN() {
        return this.ctT;
    }

    public void jc(String str) {
        this.ctT = str;
    }
}
