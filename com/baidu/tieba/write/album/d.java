package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo fMU;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void qW(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String bnu() {
        return this.count;
    }

    public void qX(String str) {
        this.count = str;
    }

    public ImageFileInfo bnv() {
        return this.fMU;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.fMU = imageFileInfo;
    }
}
