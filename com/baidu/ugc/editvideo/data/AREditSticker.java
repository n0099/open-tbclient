package com.baidu.ugc.editvideo.data;

import com.baidu.minivideo.arface.bean.Sticker;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class AREditSticker implements Serializable {
    public long endTime;
    public long startTime;
    public Sticker sticker;

    public AREditSticker(Sticker sticker, long j, long j2) {
        this.sticker = sticker;
        this.startTime = j;
        this.endTime = j2;
    }
}
