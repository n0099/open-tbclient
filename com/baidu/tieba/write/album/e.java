package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class e {
    private String albumId;
    private String count;
    private ImageFileInfo fTS;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void re(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String bnF() {
        return this.count;
    }

    public void rf(String str) {
        this.count = str;
    }

    public ImageFileInfo bnG() {
        return this.fTS;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.fTS = imageFileInfo;
    }
}
