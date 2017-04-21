package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo fPq;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void qX(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String bov() {
        return this.count;
    }

    public void qY(String str) {
        this.count = str;
    }

    public ImageFileInfo bow() {
        return this.fPq;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.fPq = imageFileInfo;
    }
}
