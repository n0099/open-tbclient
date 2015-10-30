package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private int apZ;
    private final AlbumActivity djW;
    private List<a> dki;
    private String dkp;
    private List<ImageFileInfo> dkv;
    private List<ImageFileInfo> dkw;
    private String dkx;
    private boolean dky = false;
    private WriteImagesInfo mWriteImagesInfo;

    public l(AlbumActivity albumActivity) {
        this.djW = albumActivity;
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

    public List<ImageFileInfo> aBo() {
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

    public String aBp() {
        return this.dkp;
    }

    public void mm(String str) {
        this.dkp = str;
    }

    public List<ImageFileInfo> aBq() {
        return this.dkv;
    }

    public void bG(List<ImageFileInfo> list) {
        this.dkv = list;
    }

    public int getCurrentIndex() {
        return this.apZ;
    }

    public void lL(int i) {
        this.apZ = i;
    }

    public List<a> aBr() {
        return this.dki;
    }

    public void bH(List<a> list) {
        this.dki = list;
    }

    public List<ImageFileInfo> aBs() {
        return this.dkw;
    }

    public void bI(List<ImageFileInfo> list) {
        this.dkw = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String aBt() {
        return this.dkx;
    }

    public void mn(String str) {
        this.dkx = str;
    }

    public void setOriginalImg(boolean z) {
        this.mWriteImagesInfo.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.mWriteImagesInfo.isOriginalImg();
    }

    public boolean aBu() {
        return this.dky;
    }

    public void gQ(boolean z) {
        this.dky = z;
    }
}
