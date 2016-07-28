package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int aue;
    private WriteImagesInfo ezo;
    private final AlbumActivity fQb;
    private List<ImageFileInfo> fQv;
    private String fQw;
    private boolean fQx = false;
    private String fxg;
    private List<ImageFileInfo> fxh;
    private List<d> fxi;

    public o(AlbumActivity albumActivity) {
        this.fQb = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ezo == null) {
            this.ezo = new WriteImagesInfo();
        }
        this.ezo.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ezo != null) {
            this.ezo.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.ezo == null) {
            return false;
        }
        return this.ezo.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bnw() {
        if (this.ezo != null) {
            return this.ezo.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.ezo;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.ezo = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.ezo != null) {
            return this.ezo.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.ezo == null) {
            this.ezo = new WriteImagesInfo();
        }
        this.ezo.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.ezo != null) {
            return this.ezo.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bnx() {
        return this.fxg;
    }

    public void rw(String str) {
        this.fxg = str;
    }

    public List<ImageFileInfo> bny() {
        return this.fxh;
    }

    public void dp(List<ImageFileInfo> list) {
        this.fxh = list;
    }

    public int getCurrentIndex() {
        return this.aue;
    }

    public void ss(int i) {
        this.aue = i;
    }

    public List<d> biV() {
        return this.fxi;
    }

    public void dq(List<d> list) {
        this.fxi = list;
    }

    public List<ImageFileInfo> bnz() {
        return this.fQv;
    }

    public void dr(List<ImageFileInfo> list) {
        this.fQv = list;
    }

    public int size() {
        if (this.ezo == null) {
            return 0;
        }
        return this.ezo.size();
    }

    public String bnA() {
        return this.fQw;
    }

    public void rx(String str) {
        this.fQw = str;
    }

    public void setOriginalImg(boolean z) {
        this.ezo.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.ezo.isOriginalImg();
    }

    public boolean bnB() {
        return this.fQx;
    }

    public void lr(boolean z) {
        this.fQx = z;
    }
}
