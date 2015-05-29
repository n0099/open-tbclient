package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private List<ImageFileInfo> cyA;
    private String cyB;
    private List<a> cym;
    private String cyt;
    private List<ImageFileInfo> cyz;
    private int mCurrentIndex;
    private WriteImagesInfo mWriteImagesInfo;

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

    public List<ImageFileInfo> arN() {
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

    public String arO() {
        return this.cyt;
    }

    public void jX(String str) {
        this.cyt = str;
    }

    public List<ImageFileInfo> arP() {
        return this.cyz;
    }

    public void be(List<ImageFileInfo> list) {
        this.cyz = list;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    public List<a> arQ() {
        return this.cym;
    }

    public void bf(List<a> list) {
        this.cym = list;
    }

    public List<ImageFileInfo> arR() {
        return this.cyA;
    }

    public void bg(List<ImageFileInfo> list) {
        this.cyA = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String arS() {
        return this.cyB;
    }

    public void jY(String str) {
        this.cyB = str;
    }
}
