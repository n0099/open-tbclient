package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int avR;
    private WriteImagesInfo cYj;
    private String efE;
    private List<ImageFileInfo> efF;
    private List<d> efG;
    private final AlbumActivity emU;
    private List<ImageFileInfo> eno;
    private String enp;
    private boolean enq = false;

    public o(AlbumActivity albumActivity) {
        this.emU = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.cYj == null) {
            this.cYj = new WriteImagesInfo();
        }
        this.cYj.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.cYj != null) {
            this.cYj.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.cYj == null) {
            return false;
        }
        return this.cYj.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> aSI() {
        if (this.cYj != null) {
            return this.cYj.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.cYj;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.cYj = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.cYj != null) {
            return this.cYj.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.cYj == null) {
            this.cYj = new WriteImagesInfo();
        }
        this.cYj.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.cYj != null) {
            return this.cYj.getMaxImagesAllowed();
        }
        return 0;
    }

    public String aSJ() {
        return this.efE;
    }

    public void nz(String str) {
        this.efE = str;
    }

    public List<ImageFileInfo> aSK() {
        return this.efF;
    }

    public void co(List<ImageFileInfo> list) {
        this.efF = list;
    }

    public int getCurrentIndex() {
        return this.avR;
    }

    public void py(int i) {
        this.avR = i;
    }

    public List<d> aPn() {
        return this.efG;
    }

    public void cp(List<d> list) {
        this.efG = list;
    }

    public List<ImageFileInfo> aSL() {
        return this.eno;
    }

    public void cq(List<ImageFileInfo> list) {
        this.eno = list;
    }

    public int size() {
        if (this.cYj == null) {
            return 0;
        }
        return this.cYj.size();
    }

    public String aSM() {
        return this.enp;
    }

    public void nA(String str) {
        this.enp = str;
    }

    public void setOriginalImg(boolean z) {
        this.cYj.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.cYj.isOriginalImg();
    }

    public boolean aSN() {
        return this.enq;
    }

    public void iw(boolean z) {
        this.enq = z;
    }
}
