package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int axl;
    private WriteImagesInfo eFQ;
    private String fFC;
    private List<ImageFileInfo> fFD;
    private List<d> fFE;
    private List<ImageFileInfo> gaA;
    private String gaB;
    private boolean gaC = false;
    private final AlbumActivity gaf;

    public o(AlbumActivity albumActivity) {
        this.gaf = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eFQ == null) {
            this.eFQ = new WriteImagesInfo();
        }
        this.eFQ.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eFQ != null) {
            this.eFQ.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eFQ == null) {
            return false;
        }
        return this.eFQ.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> brM() {
        if (this.eFQ != null) {
            return this.eFQ.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eFQ;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eFQ = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eFQ != null) {
            return this.eFQ.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eFQ == null) {
            this.eFQ = new WriteImagesInfo();
        }
        this.eFQ.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eFQ != null) {
            return this.eFQ.getMaxImagesAllowed();
        }
        return 0;
    }

    public String brN() {
        return this.fFC;
    }

    public void sg(String str) {
        this.fFC = str;
    }

    public List<ImageFileInfo> brO() {
        return this.fFD;
    }

    public void du(List<ImageFileInfo> list) {
        this.fFD = list;
    }

    public int getCurrentIndex() {
        return this.axl;
    }

    public void sT(int i) {
        this.axl = i;
    }

    public List<d> bmF() {
        return this.fFE;
    }

    public void dv(List<d> list) {
        this.fFE = list;
    }

    public List<ImageFileInfo> brP() {
        return this.gaA;
    }

    public void dw(List<ImageFileInfo> list) {
        this.gaA = list;
    }

    public int size() {
        if (this.eFQ == null) {
            return 0;
        }
        return this.eFQ.size();
    }

    public String brQ() {
        return this.gaB;
    }

    public void sh(String str) {
        this.gaB = str;
    }

    public void setOriginalImg(boolean z) {
        this.eFQ.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eFQ.isOriginalImg();
    }

    public boolean brR() {
        return this.gaC;
    }

    public void lH(boolean z) {
        this.gaC = z;
    }
}
