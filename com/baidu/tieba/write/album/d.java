package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo dKJ;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void ni(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aHt() {
        return this.count;
    }

    public void nj(String str) {
        this.count = str;
    }

    public ImageFileInfo aHu() {
        return this.dKJ;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.dKJ = imageFileInfo;
    }
}
