package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private int aru;
    private final AlbumActivity dlE;
    private List<b> dlQ;
    private String dlX;
    private List<ImageFileInfo> dmd;
    private List<ImageFileInfo> dme;
    private String dmf;
    private boolean dmg = false;
    private WriteImagesInfo mWriteImagesInfo;

    public m(AlbumActivity albumActivity) {
        this.dlE = albumActivity;
    }

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

    public List<ImageFileInfo> aCe() {
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

    public String aCf() {
        return this.dlX;
    }

    public void mq(String str) {
        this.dlX = str;
    }

    public List<ImageFileInfo> aCg() {
        return this.dmd;
    }

    public void bK(List<ImageFileInfo> list) {
        this.dmd = list;
    }

    public int getCurrentIndex() {
        return this.aru;
    }

    public void lZ(int i) {
        this.aru = i;
    }

    public List<b> aCh() {
        return this.dlQ;
    }

    public void bL(List<b> list) {
        this.dlQ = list;
    }

    public List<ImageFileInfo> aCi() {
        return this.dme;
    }

    public void bM(List<ImageFileInfo> list) {
        this.dme = list;
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public String aCj() {
        return this.dmf;
    }

    public void mr(String str) {
        this.dmf = str;
    }

    public void setOriginalImg(boolean z) {
        this.mWriteImagesInfo.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.mWriteImagesInfo.isOriginalImg();
    }

    public boolean aCk() {
        return this.dmg;
    }

    public void gT(boolean z) {
        this.dmg = z;
    }
}
