package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int awg;
    private WriteImagesInfo eBN;
    private final AlbumActivity fGS;
    private List<d> fHf;
    private String fHn;
    private List<ImageFileInfo> fHt;
    private List<ImageFileInfo> fHu;
    private String fHv;
    private boolean fHw = false;

    public o(AlbumActivity albumActivity) {
        this.fGS = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eBN == null) {
            this.eBN = new WriteImagesInfo();
        }
        this.eBN.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eBN != null) {
            this.eBN.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eBN == null) {
            return false;
        }
        return this.eBN.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bnf() {
        if (this.eBN != null) {
            return this.eBN.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eBN;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eBN = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eBN != null) {
            return this.eBN.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eBN == null) {
            this.eBN = new WriteImagesInfo();
        }
        this.eBN.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eBN != null) {
            return this.eBN.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bng() {
        return this.fHn;
    }

    public void rx(String str) {
        this.fHn = str;
    }

    public List<ImageFileInfo> bnh() {
        return this.fHt;
    }

    public void dr(List<ImageFileInfo> list) {
        this.fHt = list;
    }

    public int getCurrentIndex() {
        return this.awg;
    }

    public void sN(int i) {
        this.awg = i;
    }

    public List<d> bni() {
        return this.fHf;
    }

    public void ds(List<d> list) {
        this.fHf = list;
    }

    public List<ImageFileInfo> bnj() {
        return this.fHu;
    }

    public void dt(List<ImageFileInfo> list) {
        this.fHu = list;
    }

    public int size() {
        if (this.eBN == null) {
            return 0;
        }
        return this.eBN.size();
    }

    public String bnk() {
        return this.fHv;
    }

    public void ry(String str) {
        this.fHv = str;
    }

    public void setOriginalImg(boolean z) {
        this.eBN.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eBN.isOriginalImg();
    }

    public boolean bnl() {
        return this.fHw;
    }

    public void lG(boolean z) {
        this.fHw = z;
    }
}
