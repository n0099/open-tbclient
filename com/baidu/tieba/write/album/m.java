package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private int ary;
    private List<b> cYN;
    private String cYU;
    private List<ImageFileInfo> cZa;
    private List<ImageFileInfo> cZb;
    private String cZc;
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

    public List<ImageFileInfo> aye() {
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

    public String ayf() {
        return this.cYU;
    }

    public void lE(String str) {
        this.cYU = str;
    }

    public List<ImageFileInfo> ayg() {
        return this.cZa;
    }

    public void bw(List<ImageFileInfo> list) {
        this.cZa = list;
    }

    public int getCurrentIndex() {
        return this.ary;
    }

    public void kU(int i) {
        this.ary = i;
    }

    public List<b> ayh() {
        return this.cYN;
    }

    public void bx(List<b> list) {
        this.cYN = list;
    }

    public List<ImageFileInfo> ayi() {
        return this.cZb;
    }

    public void by(List<ImageFileInfo> list) {
        this.cZb = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String ayj() {
        return this.cZc;
    }

    public void lF(String str) {
        this.cZc = str;
    }
}
