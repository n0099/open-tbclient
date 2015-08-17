package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b {
    private String albumId;
    private ImageFileInfo cPP;
    private String count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void kU(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String atE() {
        return this.count;
    }

    public void kV(String str) {
        this.count = str;
    }

    public ImageFileInfo atF() {
        return this.cPP;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.cPP = imageFileInfo;
    }
}
