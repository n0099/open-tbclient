package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b {
    private String albumId;
    private String count;
    private ImageFileInfo dlD;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void mn(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aBW() {
        return this.count;
    }

    public void mo(String str) {
        this.count = str;
    }

    public ImageFileInfo aBX() {
        return this.dlD;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.dlD = imageFileInfo;
    }
}
