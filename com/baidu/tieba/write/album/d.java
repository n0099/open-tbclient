package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class d {
    private String albumId;
    private String count;
    private ImageFileInfo eGR;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void oA(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aZc() {
        return this.count;
    }

    public void oL(String str) {
        this.count = str;
    }

    public ImageFileInfo aZd() {
        return this.eGR;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.eGR = imageFileInfo;
    }
}
