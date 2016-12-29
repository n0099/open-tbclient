package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int axc;
    private WriteImagesInfo erP;
    private List<d> fyB;
    private String fyJ;
    private List<ImageFileInfo> fyP;
    private List<ImageFileInfo> fyQ;
    private String fyR;
    private boolean fyS = false;
    private final AlbumActivity fyo;

    public o(AlbumActivity albumActivity) {
        this.fyo = albumActivity;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.erP == null) {
            this.erP = new WriteImagesInfo();
        }
        this.erP.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.erP != null) {
            this.erP.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.erP == null) {
            return false;
        }
        return this.erP.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> blH() {
        if (this.erP != null) {
            return this.erP.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.erP;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.erP = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.erP != null) {
            return this.erP.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.erP == null) {
            this.erP = new WriteImagesInfo();
        }
        this.erP.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.erP != null) {
            return this.erP.getMaxImagesAllowed();
        }
        return 0;
    }

    public String blI() {
        return this.fyJ;
    }

    public void re(String str) {
        this.fyJ = str;
    }

    public List<ImageFileInfo> blJ() {
        return this.fyP;
    }

    public void dm(List<ImageFileInfo> list) {
        this.fyP = list;
    }

    public int getCurrentIndex() {
        return this.axc;
    }

    public void sc(int i) {
        this.axc = i;
    }

    public List<d> blK() {
        return this.fyB;
    }

    public void dn(List<d> list) {
        this.fyB = list;
    }

    public List<ImageFileInfo> blL() {
        return this.fyQ;
    }

    /* renamed from: do  reason: not valid java name */
    public void m25do(List<ImageFileInfo> list) {
        this.fyQ = list;
    }

    public int size() {
        if (this.erP == null) {
            return 0;
        }
        return this.erP.size();
    }

    public String blM() {
        return this.fyR;
    }

    public void rf(String str) {
        this.fyR = str;
    }

    public void setOriginalImg(boolean z) {
        this.erP.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.erP.isOriginalImg();
    }

    public boolean blN() {
        return this.fyS;
    }

    public void lw(boolean z) {
        this.fyS = z;
    }
}
