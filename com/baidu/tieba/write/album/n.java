package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private WriteImagesInfo aHL;
    private List<a> ctX;
    private String cub;
    private List<ImageFileInfo> cuh;
    private List<ImageFileInfo> cui;
    private String cuj;
    private int mCurrentIndex;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aHL == null) {
            this.aHL = new WriteImagesInfo();
        }
        this.aHL.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aHL != null) {
            this.aHL.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aHL == null) {
            return false;
        }
        return this.aHL.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> apX() {
        if (this.aHL != null) {
            return this.aHL.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.aHL;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.aHL = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aHL != null) {
            return this.aHL.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aHL == null) {
            this.aHL = new WriteImagesInfo();
        }
        this.aHL.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aHL != null) {
            return this.aHL.getMaxImagesAllowed();
        }
        return 0;
    }

    public String apY() {
        return this.cub;
    }

    public void je(String str) {
        this.cub = str;
    }

    public List<ImageFileInfo> apZ() {
        return this.cuh;
    }

    public void bc(List<ImageFileInfo> list) {
        this.cuh = list;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    public List<a> aqa() {
        return this.ctX;
    }

    public void bd(List<a> list) {
        this.ctX = list;
    }

    public List<ImageFileInfo> aqb() {
        return this.cui;
    }

    public void be(List<ImageFileInfo> list) {
        this.cui = list;
    }

    public int size() {
        if (this.aHL == null) {
            return 0;
        }
        return this.aHL.size();
    }

    public String aqc() {
        return this.cuj;
    }

    public void jf(String str) {
        this.cuj = str;
    }
}
