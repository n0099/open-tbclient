package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int awy;
    private WriteImagesInfo dsL;
    private final AlbumActivity eGS;
    private List<ImageFileInfo> eHl;
    private String eHm;
    private boolean eHn = false;
    private String ezC;
    private List<ImageFileInfo> ezD;
    private List<d> ezE;

    public o(AlbumActivity albumActivity) {
        this.eGS = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.dsL == null) {
            this.dsL = new WriteImagesInfo();
        }
        this.dsL.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.dsL != null) {
            this.dsL.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.dsL == null) {
            return false;
        }
        return this.dsL.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> aZi() {
        if (this.dsL != null) {
            return this.dsL.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.dsL;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.dsL = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.dsL != null) {
            return this.dsL.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.dsL == null) {
            this.dsL = new WriteImagesInfo();
        }
        this.dsL.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.dsL != null) {
            return this.dsL.getMaxImagesAllowed();
        }
        return 0;
    }

    public String aZj() {
        return this.ezC;
    }

    public void oM(String str) {
        this.ezC = str;
    }

    public List<ImageFileInfo> aZk() {
        return this.ezD;
    }

    public void cE(List<ImageFileInfo> list) {
        this.ezD = list;
    }

    public int getCurrentIndex() {
        return this.awy;
    }

    public void qr(int i) {
        this.awy = i;
    }

    public List<d> aWv() {
        return this.ezE;
    }

    public void cF(List<d> list) {
        this.ezE = list;
    }

    public List<ImageFileInfo> aZl() {
        return this.eHl;
    }

    public void cG(List<ImageFileInfo> list) {
        this.eHl = list;
    }

    public int size() {
        if (this.dsL == null) {
            return 0;
        }
        return this.dsL.size();
    }

    public String aZm() {
        return this.eHm;
    }

    public void oN(String str) {
        this.eHm = str;
    }

    public void setOriginalImg(boolean z) {
        this.dsL.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.dsL.isOriginalImg();
    }

    public boolean aZn() {
        return this.eHn;
    }

    public void jm(boolean z) {
        this.eHn = z;
    }
}
