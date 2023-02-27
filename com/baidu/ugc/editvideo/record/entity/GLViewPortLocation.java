package com.baidu.ugc.editvideo.record.entity;
/* loaded from: classes7.dex */
public class GLViewPortLocation {
    public int defaultHeight;
    public int defaultWidth;
    public int height;
    public int width;
    public int x;
    public int y;

    public GLViewPortLocation(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
        this.defaultWidth = i3;
        this.defaultHeight = i4;
    }

    public void reset() {
        this.x = 0;
        this.y = 0;
        this.width = this.defaultWidth;
        this.height = this.defaultHeight;
    }
}
