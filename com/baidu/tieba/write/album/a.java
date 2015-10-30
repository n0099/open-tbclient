package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private String count;
    private ImageFileInfo djV;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void mj(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aBg() {
        return this.count;
    }

    public void mk(String str) {
        this.count = str;
    }

    public ImageFileInfo aBh() {
        return this.djV;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.djV = imageFileInfo;
    }
}
