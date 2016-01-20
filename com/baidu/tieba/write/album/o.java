package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int auZ;
    private String dSC;
    private List<ImageFileInfo> dSI;
    private List<ImageFileInfo> dSJ;
    private String dSK;
    private boolean dSL = false;
    private final AlbumActivity dSj;
    private List<d> dSv;
    private WriteImagesInfo mWriteImagesInfo;

    public o(AlbumActivity albumActivity) {
        this.dSj = albumActivity;
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

    public List<ImageFileInfo> aJW() {
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

    public String aJX() {
        return this.dSC;
    }

    public void nk(String str) {
        this.dSC = str;
    }

    public List<ImageFileInfo> aJY() {
        return this.dSI;
    }

    public void cb(List<ImageFileInfo> list) {
        this.dSI = list;
    }

    public int getCurrentIndex() {
        return this.auZ;
    }

    public void od(int i) {
        this.auZ = i;
    }

    public List<d> aJZ() {
        return this.dSv;
    }

    public void cc(List<d> list) {
        this.dSv = list;
    }

    public List<ImageFileInfo> aKa() {
        return this.dSJ;
    }

    public void cd(List<ImageFileInfo> list) {
        this.dSJ = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String aKb() {
        return this.dSK;
    }

    public void nl(String str) {
        this.dSK = str;
    }

    public void setOriginalImg(boolean z) {
        this.mWriteImagesInfo.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.mWriteImagesInfo.isOriginalImg();
    }

    public boolean aKc() {
        return this.dSL;
    }

    public void hK(boolean z) {
        this.dSL = z;
    }
}
