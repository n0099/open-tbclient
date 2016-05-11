package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo eXL;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String bbs() {
        return this.count;
    }

    public void pa(String str) {
        this.count = str;
    }

    public ImageFileInfo bbt() {
        return this.eXL;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.eXL = imageFileInfo;
    }
}
