package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int atp;
    private WriteImagesInfo eez;
    private final AlbumActivity fCP;
    private List<ImageFileInfo> fDi;
    private String fDj;
    private boolean fDk = false;
    private String fke;
    private List<ImageFileInfo> fkf;
    private List<d> fkg;

    public o(AlbumActivity albumActivity) {
        this.fCP = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eez == null) {
            this.eez = new WriteImagesInfo();
        }
        this.eez.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.eez != null) {
            this.eez.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.eez == null) {
            return false;
        }
        return this.eez.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bka() {
        if (this.eez != null) {
            return this.eez.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.eez;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.eez = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.eez != null) {
            return this.eez.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.eez == null) {
            this.eez = new WriteImagesInfo();
        }
        this.eez.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.eez != null) {
            return this.eez.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bkb() {
        return this.fke;
    }

    public void qL(String str) {
        this.fke = str;
    }

    public List<ImageFileInfo> bkc() {
        return this.fkf;
    }

    public void dd(List<ImageFileInfo> list) {
        this.fkf = list;
    }

    public int getCurrentIndex() {
        return this.atp;
    }

    public void rX(int i) {
        this.atp = i;
    }

    public List<d> bfE() {
        return this.fkg;
    }

    public void de(List<d> list) {
        this.fkg = list;
    }

    public List<ImageFileInfo> bkd() {
        return this.fDi;
    }

    public void df(List<ImageFileInfo> list) {
        this.fDi = list;
    }

    public int size() {
        if (this.eez == null) {
            return 0;
        }
        return this.eez.size();
    }

    public String bke() {
        return this.fDj;
    }

    public void qM(String str) {
        this.fDj = str;
    }

    public void setOriginalImg(boolean z) {
        this.eez.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.eez.isOriginalImg();
    }

    public boolean bkf() {
        return this.fDk;
    }

    public void lc(boolean z) {
        this.fDk = z;
    }
}
