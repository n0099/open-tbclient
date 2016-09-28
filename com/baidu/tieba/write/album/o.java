package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int awO;
    private WriteImagesInfo eHU;
    private String fHZ;
    private List<ImageFileInfo> fIa;
    private List<d> fIb;
    private List<ImageFileInfo> gcJ;
    private String gcK;
    private boolean gcL = false;
    private final AlbumActivity gco;

    public o(AlbumActivity albumActivity) {
        this.gco = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eHU == null) {
            this.eHU = new WriteImagesInfo();
        }
        this.eHU.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eHU != null) {
            this.eHU.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eHU == null) {
            return false;
        }
        return this.eHU.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bss() {
        if (this.eHU != null) {
            return this.eHU.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eHU;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eHU = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eHU != null) {
            return this.eHU.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eHU == null) {
            this.eHU = new WriteImagesInfo();
        }
        this.eHU.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eHU != null) {
            return this.eHU.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bst() {
        return this.fHZ;
    }

    public void sv(String str) {
        this.fHZ = str;
    }

    public List<ImageFileInfo> bsu() {
        return this.fIa;
    }

    public void dv(List<ImageFileInfo> list) {
        this.fIa = list;
    }

    public int getCurrentIndex() {
        return this.awO;
    }

    public void th(int i) {
        this.awO = i;
    }

    public List<d> bnn() {
        return this.fIb;
    }

    public void dw(List<d> list) {
        this.fIb = list;
    }

    public List<ImageFileInfo> bsv() {
        return this.gcJ;
    }

    public void dx(List<ImageFileInfo> list) {
        this.gcJ = list;
    }

    public int size() {
        if (this.eHU == null) {
            return 0;
        }
        return this.eHU.size();
    }

    public String bsw() {
        return this.gcK;
    }

    public void sw(String str) {
        this.gcK = str;
    }

    public void setOriginalImg(boolean z) {
        this.eHU.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eHU.isOriginalImg();
    }

    public boolean bsx() {
        return this.gcL;
    }

    public void lJ(boolean z) {
        this.gcL = z;
    }
}
