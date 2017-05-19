package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class e {
    private String albumId;
    private String count;
    private ImageFileInfo fMl;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void qR(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String bmi() {
        return this.count;
    }

    public void qS(String str) {
        this.count = str;
    }

    public ImageFileInfo bmj() {
        return this.fMl;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.fMl = imageFileInfo;
    }
}
