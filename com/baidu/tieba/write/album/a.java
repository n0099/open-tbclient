package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private String count;
    private ImageFileInfo ctJ;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void ja(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String apQ() {
        return this.count;
    }

    public void jb(String str) {
        this.count = str;
    }

    public ImageFileInfo apR() {
        return this.ctJ;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.ctJ = imageFileInfo;
    }
}
