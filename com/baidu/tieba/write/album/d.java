package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo fyn;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void rb(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String blz() {
        return this.count;
    }

    public void rc(String str) {
        this.count = str;
    }

    public ImageFileInfo blA() {
        return this.fyn;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.fyn = imageFileInfo;
    }
}
