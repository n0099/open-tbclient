package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private int apO;
    private List<b> cQc;
    private String cQj;
    private List<ImageFileInfo> cQp;
    private List<ImageFileInfo> cQq;
    private String cQr;
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

    public List<ImageFileInfo> atL() {
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

    public String atM() {
        return this.cQj;
    }

    public void kX(String str) {
        this.cQj = str;
    }

    public List<ImageFileInfo> atN() {
        return this.cQp;
    }

    public void bn(List<ImageFileInfo> list) {
        this.cQp = list;
    }

    public int getCurrentIndex() {
        return this.apO;
    }

    public void kj(int i) {
        this.apO = i;
    }

    public List<b> atO() {
        return this.cQc;
    }

    public void bo(List<b> list) {
        this.cQc = list;
    }

    public List<ImageFileInfo> atP() {
        return this.cQq;
    }

    public void bp(List<ImageFileInfo> list) {
        this.cQq = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String atQ() {
        return this.cQr;
    }

    public void kY(String str) {
        this.cQr = str;
    }
}
