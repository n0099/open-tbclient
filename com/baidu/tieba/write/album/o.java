package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int atv;
    private final AlbumActivity dKK;
    private List<d> dKW;
    private String dLd;
    private List<ImageFileInfo> dLj;
    private List<ImageFileInfo> dLk;
    private String dLl;
    private boolean dLm = false;
    private WriteImagesInfo mWriteImagesInfo;

    public o(AlbumActivity albumActivity) {
        this.dKK = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
        this.mWriteImagesInfo.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.mWriteImagesInfo != null) {
            this.mWriteImagesInfo.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.mWriteImagesInfo == null) {
            return false;
        }
        return this.mWriteImagesInfo.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> aHB() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.mWriteImagesInfo;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.mWriteImagesInfo = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo();
        }
        this.mWriteImagesInfo.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.getMaxImagesAllowed();
        }
        return 0;
    }

    public String aHC() {
        return this.dLd;
    }

    public void nl(String str) {
        this.dLd = str;
    }

    public List<ImageFileInfo> aHD() {
        return this.dLj;
    }

    public void bY(List<ImageFileInfo> list) {
        this.dLj = list;
    }

    public int getCurrentIndex() {
        return this.atv;
    }

    public void nl(int i) {
        this.atv = i;
    }

    public List<d> aHE() {
        return this.dKW;
    }

    public void bZ(List<d> list) {
        this.dKW = list;
    }

    public List<ImageFileInfo> aHF() {
        return this.dLk;
    }

    public void ca(List<ImageFileInfo> list) {
        this.dLk = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String aHG() {
        return this.dLl;
    }

    public void nm(String str) {
        this.dLl = str;
    }

    public void setOriginalImg(boolean z) {
        this.mWriteImagesInfo.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.mWriteImagesInfo.isOriginalImg();
    }

    public boolean aHH() {
        return this.dLm;
    }

    public void hB(boolean z) {
        this.dLm = z;
    }
}
