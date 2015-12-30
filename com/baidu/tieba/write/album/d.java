package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo dSi;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void ng(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aJO() {
        return this.count;
    }

    public void nh(String str) {
        this.count = str;
    }

    public ImageFileInfo aJP() {
        return this.dSi;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.dSi = imageFileInfo;
    }
}
