package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int aBB;
    private WriteImagesInfo eFp;
    private String fLH;
    private List<ImageFileInfo> fLN;
    private List<ImageFileInfo> fLO;
    private String fLP;
    private boolean fLQ = false;
    private final AlbumActivity fLm;
    private List<d> fLz;

    public o(AlbumActivity albumActivity) {
        this.fLm = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eFp == null) {
            this.eFp = new WriteImagesInfo();
        }
        this.eFp.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eFp != null) {
            this.eFp.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eFp == null) {
            return false;
        }
        return this.eFp.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bmS() {
        if (this.eFp != null) {
            return this.eFp.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eFp;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eFp = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eFp != null) {
            return this.eFp.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eFp == null) {
            this.eFp = new WriteImagesInfo();
        }
        this.eFp.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eFp != null) {
            return this.eFp.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bmT() {
        return this.fLH;
    }

    public void qF(String str) {
        this.fLH = str;
    }

    public List<ImageFileInfo> bmU() {
        return this.fLN;
    }

    public void cY(List<ImageFileInfo> list) {
        this.fLN = list;
    }

    public int getCurrentIndex() {
        return this.aBB;
    }

    public void sM(int i) {
        this.aBB = i;
    }

    public List<d> bmV() {
        return this.fLz;
    }

    public void cZ(List<d> list) {
        this.fLz = list;
    }

    public List<ImageFileInfo> bmW() {
        return this.fLO;
    }

    public void da(List<ImageFileInfo> list) {
        this.fLO = list;
    }

    public int size() {
        if (this.eFp == null) {
            return 0;
        }
        return this.eFp.size();
    }

    public String bmX() {
        return this.fLP;
    }

    public void qG(String str) {
        this.fLP = str;
    }

    public void setOriginalImg(boolean z) {
        this.eFp.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eFp.isOriginalImg();
    }

    public boolean bmY() {
        return this.fLQ;
    }

    public void lF(boolean z) {
        this.fLQ = z;
    }
}
