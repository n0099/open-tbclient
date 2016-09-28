package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo gcn;
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

    public String bsn() {
        return this.count;
    }

    public void su(String str) {
        this.count = str;
    }

    public ImageFileInfo bso() {
        return this.gcn;
    }

    public void g(ImageFileInfo imageFileInfo) {
        this.gcn = imageFileInfo;
    }
}
