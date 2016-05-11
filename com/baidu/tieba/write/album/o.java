package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private int asz;
    private WriteImagesInfo dwh;
    private String eFl;
    private List<ImageFileInfo> eFm;
    private List<d> eFn;
    private final AlbumActivity eXM;
    private List<ImageFileInfo> eYf;
    private String eYg;
    private boolean eYh = false;

    public o(AlbumActivity albumActivity) {
        this.eXM = albumActivity;
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

    public List<ImageFileInfo> bbx() {
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

    public String bby() {
        return this.eFl;
    }

    public void pb(String str) {
        this.eFl = str;
    }

    public List<ImageFileInfo> bbz() {
        return this.eFm;
    }

    public void cM(List<ImageFileInfo> list) {
        this.eFm = list;
    }

    public int getCurrentIndex() {
        return this.asz;
    }

    public void qH(int i) {
        this.asz = i;
    }

    public List<d> aXo() {
        return this.eFn;
    }

    public void cN(List<d> list) {
        this.eFn = list;
    }

    public List<ImageFileInfo> bbA() {
        return this.eYf;
    }

    public void cO(List<ImageFileInfo> list) {
        this.eYf = list;
    }

    public int size() {
        if (this.dwh == null) {
            return 0;
        }
        return this.dwh.size();
    }

    public String bbB() {
        return this.eYg;
    }

    public void pc(String str) {
        this.eYg = str;
    }

    public void setOriginalImg(boolean z) {
        this.dwh.setOriginalImg(z);
    }

    public boolean isOriginalImg() {
        return this.dwh.isOriginalImg();
    }

    public boolean bbC() {
        return this.eYh;
    }

    public void ks(boolean z) {
        this.eYh = z;
    }
}
