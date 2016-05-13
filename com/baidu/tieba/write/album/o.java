package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int asz;
    private WriteImagesInfo dwh;
    private String eFk;
    private List<ImageFileInfo> eFl;
    private List<d> eFm;
    private final AlbumActivity eXL;
    private List<ImageFileInfo> eYe;
    private String eYf;
    private boolean eYg = false;

    public o(AlbumActivity albumActivity) {
        this.eXL = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.dwh == null) {
            this.dwh = new WriteImagesInfo();
        }
        this.dwh.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.dwh != null) {
            this.dwh.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.dwh == null) {
            return false;
        }
        return this.dwh.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> bbE() {
        if (this.dwh != null) {
            return this.dwh.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.dwh;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.dwh = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.dwh != null) {
            return this.dwh.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.dwh == null) {
            this.dwh = new WriteImagesInfo();
        }
        this.dwh.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.dwh != null) {
            return this.dwh.getMaxImagesAllowed();
        }
        return 0;
    }

    public String bbF() {
        return this.eFk;
    }

    public void pb(String str) {
        this.eFk = str;
    }

    public List<ImageFileInfo> bbG() {
        return this.eFl;
    }

    public void cM(List<ImageFileInfo> list) {
        this.eFl = list;
    }

    public int getCurrentIndex() {
        return this.asz;
    }

    public void qG(int i) {
        this.asz = i;
    }

    public List<d> aXu() {
        return this.eFm;
    }

    public void cN(List<d> list) {
        this.eFm = list;
    }

    public List<ImageFileInfo> bbH() {
        return this.eYe;
    }

    public void cO(List<ImageFileInfo> list) {
        this.eYe = list;
    }

    public int size() {
        if (this.dwh == null) {
            return 0;
        }
        return this.dwh.size();
    }

    public String bbI() {
        return this.eYf;
    }

    public void pc(String str) {
        this.eYf = str;
    }

    public void setOriginalImg(boolean z) {
        this.dwh.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.dwh.isOriginalImg();
    }

    public boolean bbJ() {
        return this.eYg;
    }

    public void ks(boolean z) {
        this.eYg = z;
    }
}
