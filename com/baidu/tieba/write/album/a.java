package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private String count;
    private ImageFileInfo cxY;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void jU(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String arG() {
        return this.count;
    }

    public void jV(String str) {
        this.count = str;
    }

    public ImageFileInfo arH() {
        return this.cxY;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.cxY = imageFileInfo;
    }
}
