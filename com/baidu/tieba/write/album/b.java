package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class b {
    private String albumId;
    private ImageFileInfo cYA;
    private String count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void lB(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String axX() {
        return this.count;
    }

    public void lC(String str) {
        this.count = str;
    }

    public ImageFileInfo axY() {
        return this.cYA;
    }

    public void e(ImageFileInfo imageFileInfo) {
        this.cYA = imageFileInfo;
    }
}
