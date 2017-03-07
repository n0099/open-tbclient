package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo fLl;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void qC(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String bmK() {
        return this.count;
    }

    public void qD(String str) {
        this.count = str;
    }

    public ImageFileInfo bmL() {
        return this.fLl;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.fLl = imageFileInfo;
    }
}
