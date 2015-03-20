package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String albumId;
    private String count;
    private ImageFileInfo ctt;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void iX(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String apB() {
        return this.count;
    }

    public void iY(String str) {
        this.count = str;
    }

    public ImageFileInfo apC() {
        return this.ctt;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.ctt = imageFileInfo;
    }
}
