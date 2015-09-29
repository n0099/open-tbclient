package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private int apY;
    private List<a> djI;
    private String djP;
    private List<ImageFileInfo> djV;
    private List<ImageFileInfo> djW;
    private String djX;
    private boolean djY = false;
    private final AlbumActivity djw;
    private WriteImagesInfo mWriteImagesInfo;

    public l(AlbumActivity albumActivity) {
        this.djw = albumActivity;
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

    public List<ImageFileInfo> aBi() {
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

    public String aBj() {
        return this.djP;
    }

    public void mj(String str) {
        this.djP = str;
    }

    public List<ImageFileInfo> aBk() {
        return this.djV;
    }

    public void bF(List<ImageFileInfo> list) {
        this.djV = list;
    }

    public int getCurrentIndex() {
        return this.apY;
    }

    public void lJ(int i) {
        this.apY = i;
    }

    public List<a> aBl() {
        return this.djI;
    }

    public void bG(List<a> list) {
        this.djI = list;
    }

    public List<ImageFileInfo> aBm() {
        return this.djW;
    }

    public void bH(List<ImageFileInfo> list) {
        this.djW = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String aBn() {
        return this.djX;
    }

    public void mk(String str) {
        this.djX = str;
    }

    public void setOriginalImg(boolean z) {
        this.mWriteImagesInfo.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.mWriteImagesInfo.isOriginalImg();
    }

    public boolean aBo() {
        return this.djY;
    }

    public void gQ(boolean z) {
        this.djY = z;
    }
}
