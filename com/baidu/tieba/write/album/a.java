package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private String count;
    private ImageFileInfo djv;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void mg(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aBa() {
        return this.count;
    }

    public void mh(String str) {
        this.count = str;
    }

    public ImageFileInfo aBb() {
        return this.djv;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.djv = imageFileInfo;
    }
}
