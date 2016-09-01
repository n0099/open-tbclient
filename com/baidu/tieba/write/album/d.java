package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo gae;
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

    public String brH() {
        return this.count;
    }

    public void sf(String str) {
        this.count = str;
    }

    public ImageFileInfo brI() {
        return this.gae;
    }

    public void g(ImageFileInfo imageFileInfo) {
        this.gae = imageFileInfo;
    }
}
